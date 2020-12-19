package Modelo.Modulos;

import java.util.*;
/**
 * Almacena los datos relacionados con una compra
 * 
 * @author Iván Adrio Muñiz
 * @version 2018.04.21
 */
public class FichaDeCompra extends Documentos
{
    private double total;
    private String estado;
    /**
     * Crea la ficha de compra
     * @param idCliente DNI del cliente
     * @param idEmpleado DNI del empleado que realiza la venta
     * @param fecha fecha de compra
     * @param numeroDeFicha número de ficha de compra
     */
    public FichaDeCompra(String idCliente,String idEmpleado,Date fecha,int numeroDeFicha)
    {
        super(idCliente,idEmpleado,fecha);
        setEstado("pendiente");
        setNumeroDocumento(numeroDeFicha);
        setTipo("FichaDeCompra");
    }
    
    /**
     * Añade el valor total a la ficha. Representa el precio de la compra
     * @param total precio de la compra
     */
    public void setTotal(double total)
    {
        this.total=total;
    }
    
    /**
     * Consulta el precio total de la compra
     * @return precio total de la compra
     */
    public double getTotal()
    {
        return total;
    }
    
    public String toString()
    {
        return (documentData()+"\n"+"Total a pagar: "+formatea(Double.toString(total)+"€",13)+"  "+estado);
    }
    
        /**
     * Fija el estado de una ficha
     * @param estado estado al que se cambiará la ficha
     */
    public void setEstado(String estado){
        this.estado=estado;
    }
    
    /**
     * Devuelve el estado en el que está la ficha
     * @return estado en el que se encuentra la ficha
     */
    public String getEstado(){
        return estado;
    }
}
