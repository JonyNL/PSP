package com.jonyn;

import java.io.Serializable;
import java.util.ArrayList;

public class Alumno implements Serializable {
    public static ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

    private String nombre;
    private String NIA;


    public Alumno(String nombre, String NIA) {
        this.nombre = nombre;
        this.NIA = NIA;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNIA() {
        return NIA;
    }

    @Override
    public String toString() {
        return "\nNombre: " + nombre + "\nNIA: " + NIA;
    }

    public static int buscarAlumno(String NIA){
        int pos = -1;
        for (Alumno alumno : alumnos ) {
            if (alumno.getNIA().equalsIgnoreCase(NIA)) {
                pos = alumnos.indexOf(alumno);
                break;
            }
        }
        return pos;
    }

    public static boolean addAlumno(Alumno a){
        if (alumnos.add(a)){
            return true;
        } else return false;
    }

    public static boolean borrarAlumno(int pos) {
        if (alumnos.remove(alumnos.get(pos)))
            return true;
         else return false;

    }

}
