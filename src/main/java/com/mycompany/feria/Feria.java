/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.feria;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



/**
 *
 * @author Jeisson Johan Sierra Toro
 */
public class Feria {
    private static List<Empresa> datosEmpresa = new ArrayList<>();
    private static List<Stand> datosStand = new ArrayList<>();
    private static List<Visitante> listaVisitantes = new ArrayList<>();
    private static List<Empresa> listaEmpresas = new ArrayList<>(); 
    
    //Getters

    public static List<Stand> getDatosStand() {
        return datosStand;
    }

    public static List<Empresa> getListaEmpresas() {
        return listaEmpresas;
    }

    public static List<Empresa> getDatosEmpresa() {
        return datosEmpresa;
    }

    
    public static List<Visitante> getListaVisitantes() {
        return listaVisitantes;
    }

   //main
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean state_menu = true; // Variable que permite la repetición del menú.
        
        System.out.println("Proyecto de Ferial Empresarial: ");

        do {
            System.out.println("Seleccione una opcion\n\n" +
                    
                   
                    "[1] Registrar Empresa\n" +
                    "[2] Editar Empresa\n" +
                    "[3] Eliminar Empresa\n" +
                    "[4] Registrar Stand\n" +
                    "[5] Registrar mi Empresa a un Stand\n" +
                    "[6] Listar Stands (Ocupados y Disponibles)\n" +
                    "[7] Registrar Visitante\n" +
                    "[8] Editar Visitante\n" +
                    "[9] Eliminar Visitante\n" +
                    "[10] Ver Empresas con sus Stands asignados\n" +
                    "[11] Ver Visitantes registrados\n" +
                    "[12] Registrar Visita y Comentario\n" +
                    "[13] Ver comentarios de los stands\n" +
                    "[14] Reporte: Stands visitados por cada visitante\n" +
                    "[15] Reporte: Calificacion promedio de cada stand\n" +
                    "[16] Finalizar programa.\n");

            int option = scanner.nextInt();
            scanner.nextLine();

            
           switch (option) {
        
            case 1:
                   System.out.println("Escriba el nombre de la empresa:");
                    String nombre = scanner.nextLine();                   
                    String sector = Empresa.elegirSector();
                    System.out.println("Digite un correo:");
                    String correo = scanner.nextLine();

                    Empresa.registrarEmpresa(nombre, sector, correo, datosEmpresa);
                    break;

            case 2:
                Empresa.editarEmpresa(datosEmpresa);
                break;
                
            case 3: 
                System.out.println("Ingrese el nombre de la empresa que desea eliminar: ");
                    String nombreEliminar = scanner.nextLine(); 
                    Empresa.eliminacion(nombreEliminar, Feria.getDatosEmpresa());   
               break;
                
            case 4:
                
                Stand.registrarStand();
              
               break;
                
            case 5:
                 Stand.asignarEmpresaAStand(scanner, datosEmpresa, datosStand);
                    break;

            case 6:
                
               Stand.listaStand();
                break;
                
            case 7:
                
                Visitante.registrarVisitante();
                break;
                
            case 8:
                
               Visitante.editarVisitante();
                break;
                
            case 9:
               
                
                Visitante.eliminarVisitante();
                break;
                
                
             case 10:
                System.out.println("Empresas con sus Stands asignados:");
                Empresa.mostrarEmpresasConStands(datosEmpresa);

                break;  
                
                
             case 11:
                 
                Visitante.verVisitantesRegistrados();
                break;
                
                
             case 12:
                 
                 Comentario.registrarVisitaYComentario();
                 break;
                 
                 
            case 13:
                Comentario.verComentariosDeStands();
                break;
                
            case 14:
                
                Comentario.reporteVisitasPorTodosLosVisitantes();
                
                break;
            case 15:

                   Comentario.promedioo();

                   break;}
               
           if (option == 16){

                state_menu = false;}}

        while (state_menu);

        System.out.println("programa finalizado");}}

            

