package Modelo.Modulos;
import java.io.*;
import java.util.*;
/**
 * Estado en el que se encuentra una ficha que ha sido rechazada
 * 
 * @author Ivan Adrio Muñiz 
 * @version 31.03.2019
 */
public class Rechazada implements EstadoFichaFinanciacion,Serializable
{
    FichaDeFinanciacion ficha;
    /**
     * Crea un estado que se podrá asignar a una ficha de financiacion. En este estado la ficha ha sido rechazada.
     * @param ficha referencia a la ficha sobre la que se aplicará el estado
     */
    public Rechazada(FichaDeFinanciacion ficha)
    {
        this.ficha=ficha;
    }
    
    /**
     * Analiza una ficha de financiacion
     * @param nomina sueldo del cliente
     * @param plazo numero de plazos en los que se quiere financiar la compra
     * @param totalCompra valor total de los productos añadidos a la ficha de compra relacionada con la financiacion
     * @return devuelve siempre falso, ya que la ficha ya sido rechazada antes
     */
    public boolean analiza(double nomina,int plazo,double totalCompra){
        return false;
    }
    
    /**
     * Devuelve una descripción de este estado
     * @return descripción del estado 
     */
    public String getEstado(){
        return "rechazada";
    }
    
    /**
     * Devuelve una descripción de la ficha
     * @return  devuelve una descripción de la ficha indicando que está rechazada
     */
    public String toString(){
        return ficha.documentData()+"\n"+"Numero de ficha de compra:"+ficha.getIdFichaDeCompra()+" Financiacion rechazada";
    }
}
