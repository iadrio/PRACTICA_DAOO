package Modelo.Modulos;

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
/**
 * Clase abstracta que define las características genéricas de un documento de la tienda
 * @author Iván Adrio Muñiz
 * @version 05.05.2018
 */
public abstract class Documentos implements Serializable
{
    private String idCliente,idEmpleado, tipo;
    private Date fecha;
    private int precio,numeroDocumento;
    private HashMap<String,Integer> listaProductos;
    private ArrayList<String> comunicacionesCliente;
    private SimpleDateFormat formatoFecha;
    
    /**
     * Crea un documento de tipo genérico
     * @param idCliente DNI del cliente relacionado con el documento
     * @param idEmpleado DNI del empleado relacionado con el documento
     * @param fecha fecha de creación del documento
     */
    public Documentos(String idCliente,String idEmpleado,Date fecha)
    {
        formatoFecha = new SimpleDateFormat("dd-MMM-yyyy");
        this.idCliente=idCliente;
        this.idEmpleado=idEmpleado;
        this.fecha=fecha;
        this.precio=precio;
        listaProductos = new HashMap<String,Integer>();
        comunicacionesCliente = new ArrayList<String>();
    }
    
    /**
     * Crea un documento de tipo genérico sin asociarlo a un cliente
     * @param idEmpleado DNI del empleado relacionado con el documento
     * @param fecha fecha de creación del documento
     */
    public Documentos(String idEmpleado,Date fecha)
    {
        formatoFecha = new SimpleDateFormat("dd-MMM-yyyy");
        this.idEmpleado=idEmpleado;
        this.fecha=fecha;
        this.precio=precio;
        listaProductos = new HashMap<String,Integer>();
        comunicacionesCliente = new ArrayList<String>();
    }
    
    /**
     * Ofrece una breve descripción del documento
     * @return descripción del documento
     */
    public String documentData()
    {

        return (tipo+" "+numeroDocumento+" "+"cliente: "+idCliente+" Empleado: "+idEmpleado+" "+formatoFecha.format(fecha));

    }
    
    /**
     * Modifica el número del documento
     * @param numero número nuevo
     */
    public void setNumeroDocumento(int numero)
    {
        numeroDocumento=numero;
    }
    
    /**
     * Consulta el número del documento
     * @return número actual del documento
     */
    public int getNumeroDocumento()
    {
        return numeroDocumento;
    }
    
    /**
     * Consulta el cliente al que está asociado el documento
     * @return DNI del cliente
     */
    public String getIdCliente()
    {
        return idCliente;
    }
    
    /**
     * Consulta el usuario al que está asociado el documento
     * @return DNI del usuario
     */
    public String getIdEmpleado()
    {
        return idEmpleado;
    }
    
    /**
     * Modifica el tipo del documento
     * @param tipo tipo de documento (ficha de reparación, ficha de copmra...)
     * 
     */
    public void setTipo(String tipo)
    {
        this.tipo=tipo;
    }
    
    /**
     * Devuelve el tipo del documento
     * @return tipo del documento
     */
    public String getTipo()
    {
        return tipo;
    }    
    
    /**
     * Modifica el empleado al que está asociado el documento
     * @param idEmpleado DNI del empleado
     */
    public void setEmpleado(String idEmpleado)
    {
        this.idEmpleado=idEmpleado;
    }
    
    
    /**
     * Consulta la fecha de creación del documento
     * @return fecha de creación del documento
     */
    public Date getFecha()
    {
        return fecha;
    }
    
    /**
     * Devuelve el formato para las fechas
     * @return formato para las fechas
     */
    public SimpleDateFormat getFormatoFecha()
    {
        return formatoFecha;
    }
    
    /**
     * Modifica el precio del documento
     * @param nuevo precio 
     */
    public void setPrecio(int precio)
    {
        this.precio = precio;
    }
    
    /**
     * Añade productos a la lista de productos que tiene asociada el documento
     * @param producto código de producto
     * @param cant número de unidades del producto
     */
    public void añadirProducto(String producto,int cant)
    {

        if(listaProductos==null)
        {
            listaProductos.put(producto,cant);
        }
        else
        {
            if(!listaProductos.containsKey(producto))
            {
                listaProductos.put(producto,cant);
            }
            else
            {
                int cantidadActual=listaProductos.get(producto);
                cant = cantidadActual+cant;
                listaProductos.put(producto,cant);
            }           
        }
    }
    
    /**
     * Comprueba si un producto existe en la lista de productos asociados
     * @param idProducto código de producto
     * @return true si el producto existe en la lista
     * 
     */
    public boolean getExisteProducto(String idProducto)
    {
        if(listaProductos.get(idProducto)==null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    /**
     * Consulta el número de unidades de un producto que hay en la lista
     * @param idProducto codigo de producto
     * @return número de unidades de un producto que hay en la lista
     */
    public int getCantidadProducto(String idProducto)
    {
        if(listaProductos.get(idProducto)==null)
        {
            return 0;
        }
        else
        {
            return listaProductos.get(idProducto);
        }
    }
    
    /**
     * Quita un producto de la lista de productos asociada al documento
     * @param producto código de producto 
     * @param cantidad número de unidades del producto
     */
    public String quitarProducto(String producto,int cantidad)
    {
        if(!listaProductos.containsKey(producto))
        {
            return ("No se ha encontrado el producto en el documento");
        }
        else
        {
            int cantidadActual=listaProductos.get(producto);
            
            if(cantidadActual<cantidad)
            {
                return ("La cantidad indicada es demasiado alta");
            }            
            else if(cantidadActual==cantidad)
            {
                listaProductos.remove(producto);
                return "";
            }            
            else
            {
               cantidad=cantidadActual-cantidad;
               listaProductos.put(producto,cantidad);
               return "";
            }
            
        }
        
    }
    
    /**
     * Consulta la lista de productos asociada al documento
     * @return conjunto de productos asociado al documento
     */
    public HashMap<String,Integer> getListaProductos()
    {
        return listaProductos;
    }
    
    /**
     * Añade a la lista de comentarios una comunicación con el cliente
     * @param mensaje mensaje enviado al cliente
     */
    public void comunicarCliente(String mensaje)
    {
        comunicacionesCliente.add(mensaje);
    }
    
    /**
     * Consulta las comunicaciones realizadas al cliente
     * @return lista de mensajes enviados al cliente
     */
    public ArrayList<String> getComunicaciones()
    {
        return comunicacionesCliente;
    }
    
    /**
     * Da formato a un texto indicando cuanto debe ocupar y rellenando el espacio sobrante con espacios.
     * @param string texto a formatear
     * @param espacio espacio que debe ocupar el texto
     * @return texto formateado
     */
    public String formatea(String string,int espacio)
    {
        return String.format("%-"+espacio+"s",string);
    }
}
