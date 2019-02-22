package com.jonyn;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientThread extends Thread {

    private Socket socket = null;

    public ClientThread (Socket socket){
        this.socket = socket;
    }

    public void run() {
        try {
            // 2.- OUT -> Cliente
            // Necesitamos un stream para enviar datos al cliente
            // Vamos a enviar un mensaje al cliente con PrintWriter
            ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
            PrintWriter out = null;
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hola cliente");
            out.println("Selecciona una opción: \n" +
                        "--------------------------");
            out.println("1.-Buscar alumno por NIA.");
            out.println("2.-Añadir nuevo alumno.");
            out.println("3.-Eliminar alumno por NIA.");
            out.println("4.-Listado de alumnos.");
            out.println("==========================");

            // 3.- IN <- Cliente
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //boolean connected = true;
            int pos, opc = Integer.parseInt(input.readLine());

            switch (opc){
                case 1:
                    out.println("Indica el NIA\n" +
                                "=============");
                    pos = Alumno.buscarAlumno(input.readLine());
                    if (pos != -1){
                        out.println("Alumno encontrado");
                        os.writeObject(Alumno.alumnos.get(pos));
                    }
                    else
                        out.println("No se ha encontrado el alumno.");
                    break;
                case 2:
                    Alumno a = (Alumno) is.readObject();
                    if (Alumno.addAlumno(a))
                        out.println("Alumno añadido.");
                    else out.println("No se pudo añadir el alumno.");
                    break;
                case 3:
                    out.println("Indica el NIA\n" +
                                "=============");
                    pos = Alumno.buscarAlumno(input.readLine());
                    if (pos != -1)
                        if (Alumno.borrarAlumno(pos)){
                            out.println("Alumno borrado correctamente.");
                        } else out.println("El alumno no ha sido borrado.");
                    else out.println("Alumno no encontrado.");
                    break;
                case 4:
                    ArrayList<Alumno> alumnos = Alumno.alumnos;
                    os.writeObject(alumnos);
                    break;
                    default:
                        out.println("Opción incorrecta.");
            }

            String clientInput = input.readLine();
            System.out.println(clientInput);
                /*if (clientInput.length() <1) {
                    connected=false;
                }*/

            //4.- Cerrar stream socket
            input.close();
            out.close();
            socket.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
