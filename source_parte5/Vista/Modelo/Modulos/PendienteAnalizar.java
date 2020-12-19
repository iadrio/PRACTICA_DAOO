package Modelo.Modulos;
import java.io.*;
import java.util.*;
/**
 * Estado en el que se encuentra una ficha que no ha sido analizada todavía
 * 
 * @author Ivan Adrio Muñiz 
 * @version 31.03.2019
 */
public class PendienteAnalizar implements EstadoFichaFinanciacion,Serializable
{
    FichaDeFinanciacion ficha;
    /**
     * Crea un estado que se podrá asignar a una ficha de financiacion. En este estado la ficha no ha sido analizada todavía.
     * @param ficha referencia a la ficha sobre la que se aplicará el estado
     */
    public PendienteAnalizar(FichaDeFinanciacion ficha)
    {
        this.ficha=ficha;
    }

    /**
     * Analiza una ficha de financiacion
     * @param nomina sueldo del cliente
     * @param plazo numero de plazos en los que se quiere financiar la compra
     * @param totalCompra valor total de los productos añadidos a la ficha de compra relacionada con la financiacion
     * @return true si la financiacion ha sido aprobada y false si es rechazada
     */
    public boolean analiza(double nomina,int plazo,double totalCompra){
        double comprobacion=0;
        ficha.setPlazos(plazo);
        ficha.setUltimaNomina(nomina);
        comprobacion = plazo*nomina*3 - totalCompra*20;
        if(comprobacion>=0)
        {
            ficha.setEstado(ficha.getEstadoFicha("aprobada"));
            return true;
        }
        else
        {
            ficha.setEstado(ficha.getEstadoFicha("rechazada"));
            return false;
        }
    }
    
    /**
     * Devuelve una descripción de este estado
     * @return descripción del estado 
     */
    public String getEstado(){
        return "pendiente";
    }
    
    /**
     * Devuelve una descripción de la ficha
     * @return  devuelve una descripción de la ficha indicando que está pendiente de analizar
     */
    public String toString(){
        return ficha.documentData()+"\n"+"Numero de ficha de compra:"+ficha.getIdFichaDeCompra()+" Analisis pendiente";
    }
}
