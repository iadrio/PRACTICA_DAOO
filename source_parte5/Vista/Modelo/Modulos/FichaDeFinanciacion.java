package Modelo.Modulos;

import java.util.*;
/**
 * Almacena datos relacionados con una financiación
 * 
 * @author Iván Adrio Muñiz 
 * @version 2018.04.21
 */
public class FichaDeFinanciacion extends Documentos
{
    private double ultimaNomina;
    private int plazos, idFichaDeCompra;
    private EstadoFichaFinanciacion estado,pendienteAnalizar,rechazada,aprobada;
    /**
     * Crea una ficha de financiación
     * @param idCliente DNI del cliente
     * @param idEmpleado DNI del empleado que tramita la financiación
     * @param fecha fecha de la financiación
     * @param numeroDeFicha numero de ficha de financiación
     * @param estado estado del tramite
     * @param idFichaDeCompra número de ficha de compra
     */
    public FichaDeFinanciacion(String idCliente,String idEmpleado,Date fecha,int numeroDeFicha,int idFichaDeCompra)
    {
        super(idCliente,idEmpleado,fecha);
        setNumeroDocumento(numeroDeFicha);
        setTipo("FichaDeFinanciacion");
        this.idFichaDeCompra=idFichaDeCompra ;
        pendienteAnalizar= new PendienteAnalizar(this);
        rechazada = new Rechazada(this);
        aprobada = new Aprobada(this); 
        estado=pendienteAnalizar;
    }
    
    /**
     * Devuelve uno de los estados posibles de la ficha
     * @param estado estado que se desea devolver
     * @return devuelve uno de los estados posibles de la ficha
     */
    public EstadoFichaFinanciacion getEstadoFicha(String estado){
        switch(estado){
            case "pendiente":
            return pendienteAnalizar;
            
            case "rechazada":
            return rechazada;
            
            case "aprobada":
            return aprobada;
            
            default:
            return this.estado;
        }
        
    }
    
    /**
     * Fija el número de plazos en los que se desea financiar la compra
     * @param plazos número de plazos en los que se desea financiar la compra
     */
    public void setPlazos(int plazos){
        this.plazos=plazos;
    }
    
    /**
     * Fija el valor de la última nómina mensual del cliente
     * @param ultimaNomina valor de la última nómina mensual del cliente
     */
    public void setUltimaNomina(double ultimaNomina){
        this.ultimaNomina=ultimaNomina;
    }
    
    /**
     * Cambia la ficha de estado
     * @param estado estado al que se desea mover la ficha
     */
    public void setEstado(EstadoFichaFinanciacion estado){
        this.estado=estado;
    }
    
    /**
     * Analiza la ficha de financiacion
     * @param nomina sueldo del cliente
     * @param plazo numero de plazos en los que se quiere financiar la compra
     * @param totalCompra valor total de los productos añadidos a la ficha de compra relacionada con la financiacion
     * @return true si la financiacion ha sido aprobada y false si es rechazada
     */
    public boolean analiza(double totalCompra, double ultimaNomina, int plazos){
        return estado.analiza(ultimaNomina,plazos,totalCompra);
    }
    
    /**
     * Devuelve una descripción del estado en el que está la ficha
     * @return descripción del estado 
     */
    public String getEstado(){
        return estado.getEstado();
    }
    
    /**
     * Consulta número de ficha de compra asociado a la financiación
     * @return número de ficha de compra asociado a la financiación
     */
    public int getIdFichaDeCompra()
    {
        return idFichaDeCompra;
    }
    
    /**
     * Consulta el valor de la última nómina mensual del cliente
     * @return valor de la última nómina mensual del cliente
     */
    public double getUltimaNomina()
    {
        return ultimaNomina;
    }
    
    /**
     * Indica el número de plazos en los que se desea financiar la compra
     * @return número de plazos en los que se desea financiar la compra
     */
    public int getPlazos()
    {
        return plazos;
    }    
    
    /**
     * Devuelve una descripción de la ficha
     * @return  devuelve una descripción de la ficha
     */
    public String toString()
    {
        return estado.toString();
    }
}
