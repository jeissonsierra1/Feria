/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.feria;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

/**
 *
 * @author sierr
 */
public class Stand {
    private int id;
    private String ubicacion;
    private String size;
    private int    numeroUnico;
    private boolean disponibilidad;
     private List<Comentario> comentarios;// 
    
    private static List<Stand> datosStand = new ArrayList<>();

    
      
     // Constructor

    public Stand(String ubicacion, String size, int numeroUnico) {
        this.ubicacion = ubicacion;
        this.size = size;
        this.numeroUnico = numeroUnico;
        this.disponibilidad = true; // Inicialmente disponible
        this.comentarios = new ArrayList<>();
        datosStand.add(this); // Agregamos el stand a la lista estática
    }
    
    
    
    // Getters

    public int getId() {
    return id;
}
    public String getUbicacion() {
        return ubicacion;
    }

    public String getSize() {
        return size;
    }

    public int getNumeroUnico() {
        return numeroUnico;
    }

    public boolean isDisponible() {
        return disponibilidad;
    }

      public List<Comentario> getComentarios() {
        return comentarios;
    }
    // Setters

    public void setDisponible(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
     
   
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setSize(String tamaño) {
        this.size = tamaño;
    }

    public void setNumeroUnico(int numeroUnico) {
        this.numeroUnico = numeroUnico;
    }

   

    public void setComentarios(ArrayList<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
    
    // METODOS
    

    public String datosStand(){
    return "ubicación: " + ubicacion + "|Tamaño: " + size + "|Numero: " + numeroUnico;
    }

    private static Scanner scanner = new Scanner(System.in);
    
    
    public static List<Stand> getDatosStand() {
    return datosStand;
}
    
    
    
    
     public static void asignarEmpresaAStand(Scanner scanner, List<Empresa> datosEmpresa, List<Stand> datosStand) {
           System.out.println("Ingrese la ubicación del stand que desea ocupar: ");
                String ubicacionStand = scanner.nextLine();

                System.out.println("Ingrese el nombre de su empresa: ");
                String nombreEmpresa = scanner.nextLine();
                System.out.println("Ingrese el sector de su empresa: ");
                String sectorrEmpresa = scanner.nextLine();
                System.out.println("Ingrese el correo de su empresa: ");
                String CorreooEmpresa = scanner.nextLine();

                // Buscar el stand con la ubicación ingresada
                Stand standSeleccionado = null;
                for (Stand s : Stand.getDatosStand()) { 
                    if (s.getUbicacion().equalsIgnoreCase(ubicacionStand)) {
                        standSeleccionado = s;
                        break;
                    }
                }

                if (standSeleccionado == null) {
                    System.out.println("Error: No existe un stand con esa ubicación.");
                } else if (!standSeleccionado.isDisponible()) {
                    System.out.println("Error: El stand ya está ocupado.");
                } else {
                    standSeleccionado.setDisponible(false);

                  
                     Empresa nuevaEmpresa = new Empresa(nombreEmpresa, sectorrEmpresa, CorreooEmpresa, standSeleccionado);
                     datosEmpresa.add(nuevaEmpresa); 

                    System.out.println("La empresa " + nombreEmpresa + " ha sido registrada en el Stand de ubicación: " + ubicacionStand);
                }
     }
    
    public static List<Stand> obtenerStandsDisponibles() {
            List<Stand> disponibles = new ArrayList<>();
            for (Stand stand : datosStand) {
                if (stand.isDisponible()) {
                    disponibles.add(stand);
                }
            }
            return disponibles;
        }
    
    public static void listarStandsDisponibles() {
            List<Stand> disponibles = obtenerStandsDisponibles();
            if (disponibles.isEmpty()) {
                System.out.println("No hay stands disponibles.");
            } else {
                for (Stand stand : disponibles) {
                    System.out.println("Stand en ubicación: " + stand.getUbicacion() +
                            ", Tamaño: " + stand.getSize() +
                            ", Número: " + stand.getNumeroUnico());
                }
            }
            
        
            
            
}
    
    public static Stand buscarStandPorUbicacion(String ubicacion) {
            for (Stand stand : datosStand) {
                if (stand.getUbicacion().equalsIgnoreCase(ubicacion)) {
                    return stand; // Retorna el stand si coincide la ubicación
                }
            }
            return null; // Retorna null si no se encuentra el stand
        }

    
    public static void registrarStand() {
    
                String setUbicacion = Stand.ubicacionEscogida();                
                System.out.println("\nSu ubicación es: " + setUbicacion);
                
                String setTamaño = Stand.tamanoEscogido();                
                System.out.println("\nEl tamaño de su Stand es : " + setTamaño);
                
                int setNumeroUnico = Stand.numeroEscogido();                
                System.out.println("\nEscogio el: " + setNumeroUnico);
                
                    
                
                Stand nuevoStand = new Stand(setUbicacion, setTamaño, setNumeroUnico);
                Feria.getDatosStand().add(nuevoStand);

                       
               System.out.println("Stand registrado con éxito");
    
    
    
    
    }
    
    
    public static void listaStand(){
    
    
                 System.out.println("\nListado de Stands:");

                System.out.println("\nStands Disponibles:");
                for (Stand s : Feria.getDatosStand()) {
                    if (s.isDisponible()) {
                        System.out.println("Numero: " + s.getNumeroUnico() + ", Ubicación: " + s.getUbicacion() + ", Tamaño: " + s.getSize());
                    }
                }

                System.out.println("\nStands Ocupados:");
                for (Stand s : Feria.getDatosStand()) {
                    if (!s.isDisponible()) {
                        System.out.println("Numero: " + s.getNumeroUnico() + ", Ubicación: " + s.getUbicacion() + ", Tamaño: " + s.getSize());
                    }
                }
    
    
    
    }
    
    
    public static String ubicacionEscogida(){
    
        System.out.println("\nEscoja una ubicacion para su Stand: ");
        System.out.println("\n {1}. Pabellon A  ");
        System.out.println("\n {2}. Pabellon B  ");
        System.out.println("\n {3}. Pabellon C  ");
        System.out.println("\n {4}. Pabellon D  ");
        System.out.println("\n {5}. Pabellon E  ");
        System.out.println("\n {6}. Pabellon F  ");
        System.out.println("\n {7}. Pabellon G  ");
        System.out.println("\n {8}. Pabellon H  ");
        System.out.println("\n {9}. Pabellon I  ");
        System.out.println("\n {10}. Pabellon J  ");
        System.out.println("\n {11}. Pabellon K  ");
        System.out.println("\n {12}. Pabellon L  ");
        System.out.println("\n {13}. Pabellon M  ");
        System.out.println("\n {14}. Pabellon N  ");
        System.out.println("\n {15}. Pabellon O  ");
        System.out.println("\n {16}. Pabellon P  ");
        System.out.println("\n {17}. Pabellon Q  ");
        System.out.println("\n {18}. Pabellon R  ");
        System.out.println("\n {19}. Pabellon S  ");
        System.out.println("\n {20}. Pabellon T  ");
        System.out.println("\n {21}. Pabellon U  ");
        System.out.println("\n {22}. Pabellon V  ");
        System.out.println("\n {23}. Pabellon W  ");
        System.out.println("\n {24}. Pabellon X  ");
        System.out.println("\n {25}. Pabellon Y  ");
        System.out.println("\n {26}. Pabellon Z  ");

        int ubicacionElejida = scanner.nextInt();
        scanner.nextLine();
        
        
        switch (ubicacionElejida) {
        
            case 1:
            return "Pabellon A";
            
            case 2:
            return "Pabellon B";
            
            case 3:
            return "Pabellon C";
            
            case 4:
            return "Pabellon D";
            case 5:
            return "Pabellon E";
            
            case 6:
            return "Pabellon F";
            case 7:
            return "Pabellon G";
            case 8:
            return "Pabellon H";
            case 9:
            return "Pabellon I";
            case 10:
            return "Pabellon J";
            case 11:
            return "Pabellon K";
            case 12:
            return "Pabellon L";
            case 13:
            return "Pabellon M";
            case 14:
            return "Pabellon N";
            case 15:
            return "Pabellon O";
            case 16:
            return "Pabellon P";
            case 17:
            return "Pabellon Q";
            case 18:
            return "Pabellon R";
            case 19:
            return "Pabellon S";
            case 20:
            return "Pabellon T";
            case 21:
            return "Pabellon U";
            case 22:
            return "Pabellon V";
            case 23:
            return "Pabellon W";
            case 24:
            return "Pabellon X";
            case 25:
            return "Pabellon Y";
            case 26:
            return "Pabellon Z";
            
            default:
            System.out.println("Ópción no válida");
            return "Sin definir";   
                
        
        }

    }
    
    
    public static int  numeroEscogido(){
    
        System.out.println("\nEscoja el numero para su Stand: ");
        System.out.println("\n {1}. Stand 01  ");
        System.out.println("\n {2}. Stand 02  ");
        System.out.println("\n {3}. Stand 03  ");
        System.out.println("\n {4}. Stand 04  ");
        System.out.println("\n {5}. Stand 05  ");
        System.out.println("\n {6}. Stand 06  ");
        System.out.println("\n {7}. Stand 07  ");
        System.out.println("\n {8}. Stand 08  ");
        System.out.println("\n {9}. Stand 09  ");
        System.out.println("\n {10}. Stand 10  ");
        System.out.println("\n {11}. Stand 11  ");
        System.out.println("\n {12}. Stand 12  ");
        System.out.println("\n {13}. Stand 13  ");
        System.out.println("\n {14}. Stand 14  ");
        System.out.println("\n {15}. Stand 15  ");
        System.out.println("\n {16}. Stand 16  ");
        System.out.println("\n {17}. Stand 17  ");
        System.out.println("\n {18}. Stand 18  ");
        System.out.println("\n {19}. Stand 19  ");
        System.out.println("\n {20}. Stand 20  ");
        System.out.println("\n {21}. Stand 21  ");
        System.out.println("\n {22}. Stand 22  ");
        System.out.println("\n {23}. Stand 23  ");
        System.out.println("\n {24}. Stand 24  ");
        System.out.println("\n {25}. Stand 25  ");
        System.out.println("\n {26}. Stand 26  ");

        int numeroElejido = scanner.nextInt();
        scanner.nextLine();
        
        
        switch (numeroElejido) {
        
            case 1:
            return 01;
            
            case 2:
            return 02;
            
            case 3:
            return 03;
            
            case 4:
            return 04;
            case 5:
            return 05;
            
            case 6:
            return  06;
            case 7:
            return  07;
            case 8:
            return  8;
            case 9:
            return 9;
            case 10:
            return  10;
            case 11:
            return  11;
            case 12:
            return  12;
            case 13:
            return  13;
            case 14:
            return  14;
            case 15:
            return  15;
            case 16:
            return  16;
            case 17:
            return  17;
            case 18:
            return  18;
            case 19:
            return  19;
            case 20:
            return  20;
            case 21:
            return  21;
            case 22:
            return  22;
            case 23:
            return  23;
            case 24:
            return  24;
            case 25:
            return  25;
            case 26:
            return  26;
            
            default:
            System.out.println("Ópción no válida");
            return -1;   
                
        
        }

    }
    
    
    public static String tamanoEscogido(){
    
        System.out.println("\nEscoja el tamano para su Stand: ");
        System.out.println("\n {1}. Pequeno ");
        System.out.println("\n {2}. Mediano ");
        System.out.println("\n {3}. Grande ");
      
    
        int tamanoElejido = scanner.nextInt();
        scanner.nextLine();
        
          switch (tamanoElejido) {
        
            case 1:
            return "Pequeno";
            
            case 2:
            return "Mediano";
            
            case 3:
            return "Grande";
        
       default:
            System.out.println("Ópción no válida");
            return "Sin definir";   
                
        
        }
    }
    
    
   
    
    
    
    
    
    
    
    
    
}
    
