package Modelo.Modulos;

import java.util.*;
/**
 * Contiene los métodos de prueba para patrón observer
 * 
 * @author Iván Adrio Muñiz 
 * @version 31.03.2019
 */
public class Test
{
    public static void main(){
        ServicioTecnico servicio=new ServicioTecnico("/historialReparaciones.txt");
        int numeroFicha = servicio.crearFicha(0,"cliente","000","empleado");
        
        System.out.println("Creamos una ficha de reparación");
        print(servicio.getHistorialReparaciones());
        System.out.println("Imprimirmos la lista de comunicaciones al cliente. Debería estar vacía");
        print(servicio.getFicha(numeroFicha).getComunicaciones());
        servicio.completarReparacion(numeroFicha);
        System.out.println("Marcamos la reparacion como completa e imprimimos la ficha");
        print(servicio.getHistorialReparaciones());
        System.out.println("Imprimirmos la lista de comunicaciones al cliente. Debería estar con un mensaje");
        print(servicio.getFicha(numeroFicha).getComunicaciones());
    }
    
    public static void print(ArrayList<String> array)
    {
        for(String string:array)
        {
            System.out.println(string);
        }
    }
}
