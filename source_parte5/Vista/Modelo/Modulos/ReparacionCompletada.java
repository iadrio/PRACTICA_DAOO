package Modelo.Modulos;
import java.io.*;
import java.util.*;
/**
 * Estado en el que se encuentra una ficha que está completada
 * 
 * @author Ivan Adrio Muñiz 
 * @version 31.03.2019
 */
public class ReparacionCompletada implements EstadoFichaReparacion,Serializable
{
    FichaReparacion ficha;
    /**
     * Crea un estado que se podrá asignar a una ficha de reparación. En este estado la reparación  está completa,
     * @param ficha referencia a la ficha sobre la que se aplicará el estado
     */
    public ReparacionCompletada(FichaReparacion ficha)
    {
        this.ficha=ficha;
    }

    /**
     * Devuelve una descripción de la ficha
     * @return  devuelve una descripción de la ficha indicando que está completada
     */
    public String toString()
    {
         return (ficha.documentData()+"\n"+"Numero de ficha de compra:"+ficha.getNumeroFichaDeCompra()+" Reparación completada");
    }
    
    /**
     * Devuelve una descripción de este estado
     * @return descripción del estado 
     */
    public String getEstado(){
        return "completada";
    }
    
    /**
     * No hace nada. La ficha ya está completada.
     */
    public void completar(){
    }
}
