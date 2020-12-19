package Modelo.Modulos;
import java.io.*;
import java.util.*;
/**
 * Estado en el que se encuentra una ficha que ha sido aprobada
 * 
 * @author Ivan Adrio Muñiz 
 * @version 31.03.2019
 */
public class Aprobada implements EstadoFichaFinanciacion,Serializable
{
    FichaDeFinanciacion ficha;
    /**
     * Crea un estado que se podrá asignar a una ficha de financiacion. En este estado la ficha ha sido aprobada.
     * @param ficha referencia a la ficha sobre la que se aplicará el estado
     */
    public Aprobada(FichaDeFinanciacion ficha)
    {
        this.ficha=ficha;
    }
    
    /**
     * Analiza una ficha de financiacion
     * @param nomina sueldo del cliente
     * @param plazo numero de plazos en los que se quiere financiar la compra
     * @param totalCompra valor total de los productos añadidos a la ficha de compra relacionada con la financiacion
     * @return devuelve siempre verdadero, ya que la ficha ya sido aprobada antes
     */
    public boolean analiza(double nomina,int plazo,double totalCompra){
        return true;
    }
    
    /**
     * Devuelve una descripción de este estado
     * @return descripción del estado 
     */
    public String getEstado(){
        return "aprobada";
    }
    
    /**
     * Devuelve una descripción de la ficha
     * @return  devuelve una descripción de la ficha indicando que está rechazada
     */
    public String toString(){
        return ficha.documentData()+"\n"+"Numero de ficha de compra:"+ficha.getIdFichaDeCompra()+" Financiacion aprobada";
    }
}
