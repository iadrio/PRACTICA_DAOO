package Modelo.Modulos;
import java.io.*;
import java.util.*;
/**
 * Estado en el que se encuentra una ficha que está en curso
 * 
 * @author Ivan Adrio Muñiz 
 * @version 31.03.2019
 */
public class ReparacionEnCurso implements EstadoFichaReparacion,Serializable
{
    FichaReparacion ficha;
    /**
     * Crea un estado que se podrá asignar a una ficha de reparación. En este estado la reparación  está en curso,
     * @param ficha referencia a la ficha sobre la que se aplicará el estado
     */
    public ReparacionEnCurso(FichaReparacion ficha)
    {
        this.ficha=ficha;
    }

    /**
     * Ofrece una breve descripción del documento
     * @return descripción del documento
     */
    public String toString()
    {
        return (ficha.documentData()+"\n"+"Numero de ficha de compra:"+ficha.getNumeroFichaDeCompra()+" Reparación pendiente");
    }
    
    /**
     * Devuelve una descripción de este estado
     * @return descripción del estado 
     */
    public String getEstado(){
        return "pendiente";
    }
    
    /**
     * Marca una ficha de reparación como completada
     */
    public void completar(){
        ficha.notifyObservers();
        ficha.setEstado(ficha.getEstadoFicha("completada"));
    }
}
