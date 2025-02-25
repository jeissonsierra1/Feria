/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.feria;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author sierr
 */
public class Empresa {
    private String nombre;
    private String sector;
    private String correo;
    private Stand stand;
    
    
    private static ArrayList<Empresa> datosEmpresa = new ArrayList<>();
    
    private static Scanner scanner = new Scanner(System.in);
    
    //contructor

    public Empresa(String nombre, String sector, String correo, Stand stand) {
        this.nombre = nombre;
        this.sector = sector;
        this.correo = correo;
        this.stand = stand;
    }

   
     
    // Getters
    
    public String getNombre()    {return nombre;}
    
    public String getSector()    {return sector;}
    
    public String getCorreo()    {return correo; }
    
        
    public Stand getStand()    {return stand; }

    public static ArrayList<Empresa> getDatosEmpresa() {
        return datosEmpresa;
    }
    
    
    
     // Setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setSector(String sector) { this.sector = sector; }

    public static String elegirSector() 
    {System.out.println("Escoja un sector: "); 
    System.out.println("\n {1}. Sector tecnología  ");
    System.out.println("\n {2}. Sector salud ");
    System.out.println("\n {3}. Sector educación "); 
    
    int opcionSector = scanner.nextInt();
    scanner.nextLine();
    
    switch (opcionSector){

        case 1:
            return "Sector tecnología";
            
        case 2:
            return "Sector salud";
            
        case 3:
            return "Sector educación";
            
        default:
            System.out.println("Ópción no válida");
            return "Sin definir";   
        
}
    

    }
    
    /// se crea este metodo para la prueba unitaria ya que el metodo normal, requiere ingreso de datos del usuario.
    
     public static String elegirSectorPruebaUnitaria(int opcionSectorPrueba) 
    {
    System.out.println("Escoja un sector: "); 
    System.out.println("\n {1}. Sector tecnología  ");
    System.out.println("\n {2}. Sector salud ");
    System.out.println("\n {3}. Sector educación "); 
    
  
    
    switch (opcionSectorPrueba){

        case 1:
            return "Sector tecnología";
            
        case 2:
            return "Sector salud";
            
        case 3:
            return "Sector educación";
            
        default:
            System.out.println("Ópción no válida");
            return "Sin definir";   
        
}
    

    }
    
    public void setCorreo(String correo) { this.correo = correo; }
    public void setStand(Stand stand) { this.stand = stand; }
    
    
      // METODOS

    public String datosEmpresa(){
    return "nombre: " + nombre + "|sector: " + sector + "|correo: " + correo + "Stand: " + stand.getUbicacion();
    }
    
    
    
    
           // Método principal

    
     public static void registrarEmpresa(Scanner scanner, List<Empresa> datosEmpresa) {
        System.out.println("Escriba el nombre de la empresa");
        String nombre = scanner.nextLine();
        String sector = elegirSector();
        System.out.println("Digite un correo: ");
        String correo = scanner.nextLine();

        Empresa nuevaEmpresa = new Empresa(nombre, sector, correo, null);
        datosEmpresa.add(nuevaEmpresa);
        System.out.println("Empresa registrada con éxito.");
    }
    
    
    // método para editar empresa
    
    public static void editarEmpresa(List<Empresa> listaEmpresas){
        Scanner scanner = new Scanner(System.in);
        
    
        System.out.println("Ingrese el nombre de la empresa que desea editar: ");
        String nombreBuscar = scanner.nextLine();
        
        Empresa empresaEncontrada = null;
        
        for (Empresa e : listaEmpresas){
            if (e.getNombre().equalsIgnoreCase(nombreBuscar)){
            
            empresaEncontrada = e;
            break;
            }
        
        }
    
    
        if (empresaEncontrada == null){
            System.out.println("Empresa no encontrada.");
            return;
        
        }
        
        System.out.println("Empresa encontrada: " + empresaEncontrada.getNombre());
        System.out.println("Seleccione qué desea editar: \n");
        System.out.println("[1] Nombre");
        System.out.println("[2] Sector");
        System.out.println("[3] Correo");
        
        int opcion1 = scanner.nextInt();
        scanner.nextLine();
        
        switch (opcion1){
        
            case 1:
                System.out.println("Ingrese el nuevo nombre:");
                empresaEncontrada.setNombre(scanner.nextLine());
                break;
            case 2:
                System.out.println("Ingrese el nuevo sector:");
                empresaEncontrada.setSector(scanner.nextLine());
                break;
            case 3:
                System.out.println("Ingrese el nuevo correo:");
                empresaEncontrada.setCorreo(scanner.nextLine());
                break;
            default:
                System.out.println("Opción no válida.");
                return;
                
        }
        
         System.out.println("¡Empresa editada con éxito!");
    }
    
     // método para eliminar empresa

    public static void eliminacion (List<Empresa> listaEmpresas){
        
        System.out.println("Ingrese el nombre de la empresa que desea eliminar: ");
         String nombreEliminar = scanner.nextLine();
    
        Empresa empresaEliminar = null;
    
        for (Empresa e : listaEmpresas) {
            if (e.getNombre().equalsIgnoreCase(nombreEliminar)) {
            empresaEliminar = e;
            break;
        }
    }
    
        if (empresaEliminar != null) {
            listaEmpresas.remove(empresaEliminar);
            System.out.println("¡Empresa eliminada con éxito!");
        } else {
            System.out.println("Empresa no encontrada.");
    }
     
   
    
    }
    
    // método para mostrar empresa con stands
    
    public static void mostrarEmpresasConStands(List<Empresa> listaEmpresas) {
    boolean hayAsignaciones = false;

    for (Empresa empresa : listaEmpresas) {
        if (empresa.getStand() != null) { // Verifica si tiene un stand asignado
            System.out.println("\nLa empresa: " + empresa.getNombre() +
                               "\n Esta registrada en el Stand"+
                               " \n - Tamaño Stand : " + empresa.getStand().getSize() +
                               " \n - Número : " + empresa.getStand().getNumeroUnico() +
                               " \n - Ubicación: " + empresa.getStand().getUbicacion());
            hayAsignaciones = true;
        }
    }

    if (!hayAsignaciones) {
        System.out.println("No hay empresas con stands asignados.");
    }
}
    
}
