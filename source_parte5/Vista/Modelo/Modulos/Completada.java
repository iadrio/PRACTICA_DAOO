package Modelo.Modulos;
import java.io.*;
import java.util.*;
/**
 * Estado en el que se encuentra una ficha que está completada
 * 
 * @author Ivan Adrio Muñiz 
 * @version 31.03.2019
 */
public class Completada implements EstadoFichaDevolucion,Serializable
{
    FichaDeDevolucion ficha;
    /**
     * Crea un estado que se podrá asignar a una ficha de devolución. En este estado la compra está devuelta y con el proceso completado.
     * @param ficha referencia a la ficha sobre la que se aplicará el estado
     */
    public Completada(FichaDeDevolucion ficha)
    {
        this.ficha=ficha;
    }

    /**
     * Devuelve una descripción de la ficha
     * @return  devuelve una descripción de la ficha indicando que está completada
     */
    public String toString()
    {
        return (ficha.documentData()+"\n"+"motivo: "+ficha.getMotivo()+" Devolucion completada");
    }
    
    /**
     * Devuelve una descripción de este estado
     * @return descripción del estado 
     */
    public String getEstado(){
        return "completada";
    }
    
    /**
     * No hace nada. La ficha no puede cancelarse
     */
    public void cancelar(){
    }
    
    /**
     * No hace nada. La ficha ya está completada.
     */
    public void completar(){
    }
}
