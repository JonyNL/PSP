import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedServer {

    public static void main (String[] args) {
        try {

            // 1.- Creamos un socket esperando clientes
            ServerSocket serverSocket = new ServerSocket(9090);
            boolean stop = false;
            while(!stop) {
                System.out.println("Esperando clientes...");

                // cliente intenta conectar con el servidor
                Socket clientSocket = serverSocket.accept();
                System.out.println("El cliente se ha conectado");
                //Usamos la clase ClientThread
                ClientThread clientThread = new ClientThread(clientSocket);
                clientThread.start();
            }
        } catch (IOException e){
            System.out.println(e);
        }

    }
}
