/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.feria;

import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sierr
 */
public class Comentario {
    private String nombreVisitante;
    private int calificacion;
    private String comentarioVisitante;
    private LocalDate Fecha;
    
    private static List<Stand> datosStand = new ArrayList<>();
    //constructor

    public Comentario(String nombreVisitante, int calificacion, String comentarioVisitante, LocalDate Fecha) {
        this.nombreVisitante = nombreVisitante;
        this.calificacion = calificacion;
        this.comentarioVisitante = comentarioVisitante;
        this.Fecha = Fecha;
    }
    
        
   private static Scanner scanner = new Scanner(System.in);
   
   
        // Getters

    public String getNombreVisitante()  { return nombreVisitante;
}

    public String getComentarioVisitante() {
        return comentarioVisitante;
    }

    
    
    public int getCalificacion() {   
        return calificacion;
    }

    public LocalDate getFecha() {    
        return Fecha;
    }
          // Setters

    public void setComentarioVisitante(String comentarioVisitante) {
        this.comentarioVisitante = comentarioVisitante;
    }
    
    
    
    public void setNombreVisitante(String nombreVisitante) {
        this.nombreVisitante = nombreVisitante;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public void setFecha(LocalDate Fecha) {
        this.Fecha = Fecha;
    }
    
    // METODOS
    
    public static String dejarComentario()
        
        
                {System.out.println("\n Nombre del visitante: "); 
                String setNombreVisitante = scanner.nextLine();

                System.out.println("\n Coloque una calificación de 1 a 5:  ");
                int setCalificacion = scanner.nextInt();
                scanner.nextLine();

                System.out.println("\n Coloque fecha de la visita (año-mes-dia):  ");
                String fechaTexto = scanner.nextLine(); 
                LocalDate setFecha = LocalDate.parse(fechaTexto, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                
                System.out.println("\n Deje su comentario sobre su experiencia en el Stand:  ");
                String setComentarioVisitante = scanner.nextLine();
               

                return  "\nNombre : " + setNombreVisitante +
                        "\nCalificación : " + setCalificacion +
                        "\nFecha de la visita (año-mes-día): " + setFecha +
                         "\nComentario: " + setComentarioVisitante;
                     }

    
    public static void registrarVisitaYComentario() {
                System.out.println("\n--- Registro de Visita y Comentario ---");
                                        
                 
                
                 // Mostrar los stands disponibles
                    Stand.listarStandsDisponibles();

                    // Verificar si hay stands disponibles
                    if (Stand.obtenerStandsDisponibles().isEmpty()) {
                        System.out.println("No hay stands disponibles para comentar.");
                        return;
                    }

                    // Pedir al usuario que seleccione un stand
                    System.out.print("\nIngrese la ubicación del stand que desea comentar: ");
                    String standUbicacion = scanner.nextLine();

                    // Buscar el stand por ubicación
                    Stand standSeleccionado = Stand.buscarStandPorUbicacion(standUbicacion);

                    // Validar si el stand fue encontrado
                    if (standSeleccionado == null) {
                        System.out.println("Stand no encontrado. Intente nuevamente.");
                        return;
                    }
                
                
                
                

                System.out.println("\n Nombre del visitante: "); 
                String setNombreVisitante = scanner.nextLine();

                System.out.println("\n Coloque una calificación de 1 a 5:  ");
                int setCalificacion = scanner.nextInt();
                scanner.nextLine();

                System.out.println("\n Coloque fecha de la visita (año-mes-dia):  ");
                String fechaTexto = scanner.nextLine(); 
                LocalDate setFecha = LocalDate.parse(fechaTexto, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                
                System.out.println("\n Deje su comentario sobre su experiencia en el Stand:  ");
                String setComentarioVisitante = scanner.nextLine();

                
                Comentario nuevoComentario = new Comentario(setNombreVisitante, setCalificacion, setComentarioVisitante, setFecha);
                standSeleccionado.getComentarios().add(nuevoComentario);

                System.out.println("\nComentario registrado en el stand exitosamente.");
            }
    
    public static void verComentariosDeStands() {
                System.out.println("\n--- Comentarios de los Stands ---");

                // Verificar si hay stands con comentarios
                boolean hayComentarios = false;

                for (Stand stand : Stand.getDatosStand()) { // Método para obtener todos los stands
                    if (!stand.getComentarios().isEmpty()) {
                        hayComentarios = true;
                        System.out.println("\nStand: " + stand.getUbicacion());

                        for (Comentario comentario : stand.getComentarios()) {
                            System.out.println("  - Visitante: " + comentario.getNombreVisitante());
                            System.out.println("    Calificación: " + comentario.getCalificacion() + "/5");
                            System.out.println("    Fecha: " + comentario.getFecha());
                            System.out.println("    Comentario: " + comentario.getComentarioVisitante());
                            System.out.println("--------------------------------------");
                        }
                    }
                }

                // Si no hay comentarios registrados
                if (!hayComentarios) {
                    System.out.println("No hay comentarios registrados para ningún stand.");
                }
}
    
    public static List<Stand> obtenerTodosLosStands() {
    return datosStand; 
}
    
    public static void reporteVisitasPorTodosLosVisitantes() {
    System.out.println("\n--- Reporte de Stands Visitados por Cada Visitante ---");

    // Lista para evitar nombres repetidos
    List<String> visitantesRegistrados = new ArrayList<>();

    for (Stand stand : Feria.getDatosStand()) { // Obtener la lista de stands
        for (Comentario comentario : stand.getComentarios()) {
            String nombreVisitante = comentario.getNombreVisitante();
            
            if (!visitantesRegistrados.contains(nombreVisitante)) {
                visitantesRegistrados.add(nombreVisitante);
                System.out.println("\nVisitante: " + nombreVisitante);
            }
            
            System.out.println(" - Visitó el Stand en ubicación: " + stand.getUbicacion());
        }
    }

    if (visitantesRegistrados.isEmpty()) {
        System.out.println("No hay registros de visitas.");
    }
}
    
     public static void promedioo() {
            System.out.println("\n--- Reporte: Calificación promedio de cada Stand ---");

            for (Stand stand : Feria.getDatosStand()) {  // Accedemos a la lista desde la clase Feria
                List<Comentario> comentarios = stand.getComentarios();

                if (comentarios.isEmpty()) {
                    System.out.println("Stand en ubicación " + stand.getUbicacion() + " no tiene calificaciones.");
                    continue;
                }

                double sumaCalificaciones = 0;
                for (Comentario comentario : comentarios) {
                    sumaCalificaciones += comentario.getCalificacion();
                }

                double promedio = sumaCalificaciones / comentarios.size();
                System.out.println("Stand en ubicación " + stand.getUbicacion() + " tiene una calificación promedio de: " + promedio);
            }
        }
   
            
    }
