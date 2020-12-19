package Modelo.Modulos;

import java.util.*;
/**
 * Almacena datos relacionados con una devolución
 * 
 * @author Iván Adrio Muñiz 
 * @version 2018.04.21
 */
public class FichaDeDevolucion extends Documentos
{
    private String motivo;
    private int numeroFichaDeCompra;
    private EstadoFichaDevolucion estado,pendiente,cancelada,completada;
    /**
     * Crea una ficha de devolución
     * @param idCliente DNI del cliente
     * @param idEmpleado DNI del empleado que tramita la devolución
     * @param fecha fecha de la devolución
     * @param numeroDeFicha numero de ficha de devolución
     * @param numeroFichaDeCompra numero de ficha de compra
     * @param motivo razón de la devolución
     */
    public FichaDeDevolucion(String idCliente,String idEmpleado,Date fecha,int numeroDeFicha,int numeroFichaDeCompra,String motivo)
    {
        super(idCliente,idEmpleado,fecha);
        setTipo("FichaDeDevolucion");
        this.numeroFichaDeCompra=numeroFichaDeCompra;
        setNumeroDocumento(numeroDeFicha);
        this.motivo=motivo;
        pendiente=new PendienteDevolucion(this);
        completada=new Completada(this);
        cancelada=new DevolucionCancelada(this);
        setEstado(pendiente);
    }
    
    /**
     * Devuelve uno de los estados posibles de la ficha
     * @param estado estado que se desea devolver
     * @return devuelve uno de los estados posibles de la ficha
     */
    public EstadoFichaDevolucion getEstadoDevolucion(String estado){
        switch (estado){
            case "pendiente" :
            return pendiente;
            case "cancelada" :
            return cancelada;
            case "completada":
            return completada;
            
            default:
            return pendiente;
        }
    }
    
    /**
     * Cambia la ficha de estado
     * @param estado estado al que se desea mover la ficha
     */
    public void setEstado(EstadoFichaDevolucion estado){
        this.estado=estado;
    }
    
    /**
     * Devuelve una descripción del estado en el que está la ficha
     * @return descripción del estado 
     */
    public String getEstado(){
        return estado.getEstado();
    }
    
    /**
     * Cancela la devolución
     */
    public void cancelar(){
        estado.cancelar();
    }
    
    /**
     * Marca la devolución como completada
     */
    public void completar(){
        estado.completar();
    }
    
    /**
     * Nos indica el número de la ficha
     * @return numero de la ficha de devolución
     */
    public int getNumeroFichaDeCompra()
    {
        return numeroFichaDeCompra;
    }
    
    /**
     * Nos indica los motivos de la devolución
     * @return motivo de la devolución
     */
    public String getMotivo()
    {
        return motivo;
    }
    
    /**
     * Ofrece una breve descripción del documento
     * @return descripción del documento
     */
    public String toString()
    {
        return estado.toString();
    }
}
