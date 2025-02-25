/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.feria;
import java.util.ArrayList;




import java.util.List;
import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import static org.junit.Assert.assertFalse;





/**
 *
 * @author sierr
 */
public class EmpresaTest {
     private static ArrayList<Empresa> datosEmpresa = new ArrayList<>();
    
   

    @Test
    public void testElegirSector() {
        System.out.println("ElegirSector");
        String resultado = Empresa.elegirSectorPruebaUnitaria(2); 
        assertEquals("Sector salud", resultado);
        
}

    
    @Test
    
    public void testRegistrarEmpresa() {
        
        System.out.println("registrarEmpresa");
        
        Empresa nuevaEmpresa = new Empresa("Asic", "Sector salud", "sierratoro789@gmail.com", null);
        datosEmpresa.add(nuevaEmpresa);
        assertEquals("Asic", nuevaEmpresa.getNombre());
        assertEquals("Sector salud", nuevaEmpresa.getSector());
        assertEquals("sierratoro789@gmail.com", nuevaEmpresa.getCorreo());

    }


    
    

    @Test
    
    public void testEliminacion() {
        
        List<Empresa> listaEmpresas = new ArrayList<>();
        listaEmpresas.add(new Empresa("Asic", "Sector salud", "sierratoro789@gmail.com", null));
        listaEmpresas.add(new Empresa("Nike", "Sector salud", "sierratoro7@gmail.com", null));
        listaEmpresas.add(new Empresa("Adida", "Sector salud", "sierratoro79@gmail.com", null));
        
        
        
           String nombreEliminar = "Asic";
    
         Empresa.eliminacion(nombreEliminar, listaEmpresas);

    
        boolean empresaEncontrada = listaEmpresas.stream()
                .anyMatch(e -> e.getNombre().equalsIgnoreCase(nombreEliminar));
        

    }

    @Test
    
    public void testMostrarEmpresasConStands() {
        System.out.println("mostrarEmpresasConStands");
        
        List<Empresa> listaEmpresas = new ArrayList<>();
        Stand stand1 = new Stand("Pabellon A", "Stand 01", 01);
        
        Empresa empresa1 = new Empresa("Nike", "Sector salud", "nike@gmail.com", stand1);
        listaEmpresas.add(empresa1);
        
        Stand stand2 = new Stand("Pabellon B", "Stand 02", 02);
        
        Empresa empresa2 = new Empresa("Asic", "Sector salud", "salud@gmail.com", stand2);
        listaEmpresas.add(empresa1);

        Empresa.mostrarEmpresasConStands(listaEmpresas);
        
      
    }
    
   

}
