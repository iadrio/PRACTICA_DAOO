package Modelo.Modulos;
import java.io.*;
import java.util.*;
/**
 * Estado en el que se encuentra una ficha que está en curso
 * 
 * @author Ivan Adrio Muñiz 
 * @version 31.03.2019
 */
public class PendienteDevolucion implements EstadoFichaDevolucion,Serializable
{
    FichaDeDevolucion ficha;
    /**
     * Crea un estado que se podrá asignar a una ficha de devolución. En este estado la devolución está en curso.
     * @param ficha referencia a la ficha sobre la que se aplicará el estado
     */
    public PendienteDevolucion(FichaDeDevolucion ficha)
    {
        this.ficha=ficha;
    }
    
    /**
     * Devuelve una descripción de la ficha
     * @return  devuelve una descripción de la ficha indicando que está en curso
     */
    public String toString(){
        return (ficha.documentData()+"\n"+"Devolución en curso");
    }
    
    /**
     * Devuelve una descripción de este estado
     * @return descripción del estado 
     */
    public String getEstado(){
        return "pendiente";
    }
    
    /**
     * Cancela la devolución
     */
    public void cancelar(){
        ficha.setEstado(ficha.getEstadoDevolucion("cancelada"));
    }
    
    /**
     * Marca la devolución como completada
     */
    public void completar(){
        ficha.setEstado(ficha.getEstadoDevolucion("completada"));
    }
}
