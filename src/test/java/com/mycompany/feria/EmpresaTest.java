/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.feria;
import org.junit.Test;


import java.util.List;
import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sierr
 */
public class EmpresaTest {
    
   

    @Test
    public void testElegirSector() {
        
        String resultado = Empresa.elegirSectorPruebaUnitaria(2); 
        assertEquals("Sector salud", resultado);
}



    

    @Test
    
    public void testRegistrarEmpresa() {
        System.out.println("registrarEmpresa");
        Scanner scanner = null;
        List<Empresa> datosEmpresa = null;
        Empresa.registrarEmpresa(scanner, datosEmpresa);
        
    }

    @Test
    
    public void testEditarEmpresa() {
        System.out.println("editarEmpresa");
        List<Empresa> listaEmpresas = null;
        Empresa.editarEmpresa(listaEmpresas);
     
    }

    @Test
    
    public void testEliminacion() {
        System.out.println("eliminacion");
        List<Empresa> listaEmpresas = null;
        Empresa.eliminacion(listaEmpresas);
      
    }

    @Test
    
    public void testMostrarEmpresasConStands() {
        System.out.println("mostrarEmpresasConStands");
        List<Empresa> listaEmpresas = null;
        Empresa.mostrarEmpresasConStands(listaEmpresas);
      
    }
    
   

}
