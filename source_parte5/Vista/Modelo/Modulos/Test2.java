package Modelo.Modulos;

import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
/**
 * Clase test del patrón estado
 * 
 * @author Ivan Adrio Muñiz 
 * @version 31.03.2019
 */
public class Test2
{
    public static void testFinanciacion(){
        Financiacion financiacion=new Financiacion("test");
        int numeroFicha=financiacion.crearFicha("cliente","empleado",0);
        FichaDeFinanciacion ficha=financiacion.getFicha(numeroFicha);
        System.out.println("Abrimos una ficha de financiacion");
        System.out.println(ficha);
        System.out.println();
        System.out.println("La analizamos con datos para que salga aprobada");
        financiacion.analizarFinanciacion(numeroFicha,1000,12,100);
        System.out.println(ficha);
    }
    
    public static void testDevolucion(){
        PosVenta posventa=new PosVenta(new SimpleDateFormat("dd-MMM-yyyy"),"test");
        int numeroFicha=posventa.crearFicha(0,"motivo de devolucion","empleado","cliente");
        System.out.println("Abrimos una ficha de devolucion");
        FichaDeDevolucion ficha = posventa.getFicha(numeroFicha);
        System.out.println(ficha);
        System.out.println("Completamos la devolucion");
        posventa.completarDevolucion(numeroFicha);
        System.out.println(ficha);
    }
    
    public static void testReparacion(){
        ServicioTecnico servicioTecnico = new ServicioTecnico("test");
        int numeroFicha=servicioTecnico.crearFicha(0,"cliente","pruducto","empleado");
        FichaReparacion ficha= servicioTecnico.getFicha(numeroFicha);
        System.out.println("Abrimos una ficha de reparacion");
        System.out.println(ficha);
        System.out.println("Completamos la reparacion");
        servicioTecnico.completarReparacion(numeroFicha);
        System.out.println(ficha);
    }
}
