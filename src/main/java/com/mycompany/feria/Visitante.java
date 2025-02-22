/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.feria;

/**
 *
 * @author sierr
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Visitante {
        private String nombreVisitante;
        private String identificacion;
        private String correoVisitante;
    private static Scanner scanner = new Scanner(System.in); 
    private static List<Visitante> listaVisitantes = new ArrayList<>();

    public String listaVisitantes(){return "Nombre: " + nombreVisitante + "|Identificacion: " + identificacion + "|Correo: " + correoVisitante;}
    
    
    //constructor

    public Visitante(String nombreVisitante, String identificacion, String correoVisitante) {
        this.nombreVisitante = nombreVisitante;
        this.identificacion = identificacion;
        this.correoVisitante = correoVisitante;
    }
    
    
    
    // Getters
    public String getNombreVisitante() {
        return nombreVisitante;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getCorreoVisitante() {
        return correoVisitante;
    }

    // Setters

    public void setNombreVisitante(String nombreVisitante) {
        this.nombreVisitante = nombreVisitante;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setCorreoVisitante(String correoVisitante) {
        this.correoVisitante = correoVisitante;
    }
    
    
    /// METODOS
    
   public static void editarVisitantePorNombre(List<Visitante> listaVisitantes, String nombre) {
    boolean encontrado = false;
                
        for (Visitante v : listaVisitantes) {
        if (v.getNombreVisitante().equalsIgnoreCase(nombre)) {
            Scanner scanner = new Scanner(System.in);
            
            System.out.println("Visitante encontrado. Ingrese los nuevos datos:");

            System.out.print("Nuevo nombre: ");
            v.setNombreVisitante(scanner.nextLine());

            System.out.print("Nueva identificación: ");
            v.setIdentificacion(scanner.nextLine());

            System.out.print("Nuevo correo: ");
            v.setCorreoVisitante(scanner.nextLine());

            System.out.println("Datos actualizados con éxito.");
            encontrado = true;
            
            
            break;
        }
    }
    
    if (!encontrado) {
        System.out.println("El visitante con nombre '" + nombre + "' no existe en el registro.");
    }
    
    
   
}
   
   
   public static boolean eliminarVisitantePorNombre(List<Visitante> listaVisitantes, String nombre) {
    for (int i = 0; i < listaVisitantes.size(); i++) { // Recorremos la lista con un for normal
        if (listaVisitantes.get(i).getNombreVisitante().equalsIgnoreCase(nombre)) {
            listaVisitantes.remove(i); // Eliminamos el visitante cuando lo encontramos
            return true; 
        }
    }
    return false; // Si no se encontró el visitante, devuelve falso
}
    
   
   
   
   
  public static void registrarVisitante(){
  
  
                System.out.println("\nEscriba su nombre: ");
                String setNombreVisitante = scanner.nextLine();
                
                System.out.println("\nEscriba su documento de identificación: ");
                String setIdentificacion = scanner.nextLine();
                
                System.out.println("\nEscriba su correo: ");
                
                String setCorreoVisitante = scanner.nextLine();
                
                Visitante nuevoVisitante = new Visitante(setNombreVisitante, setIdentificacion, setCorreoVisitante);
                Feria.getListaVisitantes().add(nuevoVisitante);
                System.out.print("Visitante registrado con exito! ");
  
  
  
  }
  
  
  public static void editarVisitante(){
  
                System.out.print("Ingrese el nombre del visitante que desea editar: ");
                String nombre = scanner.nextLine(); 

                Visitante.editarVisitantePorNombre(Feria.getListaVisitantes(), nombre);
  
  
  
  }
   
  
  
  public static void eliminarVisitante(){
  
  
                 System.out.print("Ingrese el nombre del visitante que desea eliminar: ");
                String nombreEliminar = scanner.nextLine();

                boolean eliminado = Visitante.eliminarVisitantePorNombre(Feria.getListaVisitantes(), nombreEliminar);

                if (eliminado) {
                    System.out.println("Visitante eliminado con éxito.");
                } else {
                    System.out.println("No se encontró un visitante con ese nombre.");
                }
  
  
  
  }
   
  
  
  public static void verVisitantesRegistrados(){
  
  
                System.out.println("Visitantes registrados:");
                int contador = 0; // Contador para saber si hay visitantes

                for (Visitante visitante : Feria.getListaVisitantes()) {
                    System.out.println(" \nNombre: " + visitante.getNombreVisitante() + " \nIdenticifación del visitante: " + visitante.getIdentificacion() + " \nCorreo: " + visitante.getCorreoVisitante());
                    contador++; // Aumenta el contador por cada visitante encontrado
                }

             
                if (contador == 0) {
                    System.out.println("No hay visitantes registrados.");
                }

  
  }
  
}
