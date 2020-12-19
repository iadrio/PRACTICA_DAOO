package Modelo.Almacen;

import java.util.*;
import java.io.*;

/**
 * Almacena y gestiona todo lo relativo a los productos. 
 * 
 * @author Iván Adrio Muñiz 
 * @version 2018.04.18
 */
public class Almacen
{
    
    private HashMap<String,Electrodomestico>  almacen;
    private final int longitudCp = 4; //Longitud que debe tener un codigo de producto
    private String ruta;
    private AbstractFactory factory;
    /**
     * Crea un objeto almacén y establece la ruta en la que se guardará el objeto
     */
    public Almacen(String ruta)
    {
      factory=new ConcreteFactory();
      almacen=new HashMap<String,Electrodomestico>();
      this.ruta=ruta+"/almacen.txt";
    }
    
    /**
     * Crea un Electrodomestico y lo añade al almacen
     * @param codigoDeProducto número de identificación del producto
     * @param marca fabricante del producto
     * @param modelo  
     * @param color
     * @param precio
     * @param cantidad cantidad de productos en el almacen
     * @return true si el producto se añade correctamente
     */
    public boolean añadirProducto(String tipo,String codigoDeProducto,String marca, String modelo,String color, double precio, int cantidad)
    {
        if(!getExiste(codigoDeProducto)){
            try{
                Electrodomestico producto = factory.factoryMethod(tipo,codigoDeProducto,marca,modelo,color,precio,cantidad);
                almacen.put(codigoDeProducto,producto);
                return true;
            }catch(Exception e){
                return false;
            }
        }else{
            return false;
        }
    }   
    
    public void addCaracteristica(Electrodomestico elec,String caracteristica){
        elec.addCaracteristica(caracteristica);
    }
    
    /**
     * Busca un producto en el almacén usando el codigo de producto
     * @param codigoProducto codigo de producto
     * @return un objeto tipo Electrodomestico
     */
    public Electrodomestico getProductoPorCp(String codigoProducto)
    {
        return almacen.get(codigoProducto);     
    }
    
    /**
     * Comprueba si un producto existe en el almacen
     * @param cp codigo de producto
     * @return true si el producto existe
     */
    public boolean getExiste(String cp)
    {
        boolean exists;

        if(getProductoPorCp(cp)==null){
            exists=false;
        }
        else{
            exists=true;
        }
        return exists;        
    }
    
    /**
     * Comprueba si un string tiene formato valido para ser un codigo de producto
     * @param cp codigo de producto
     * @return true si el formato es valido
     */
    public boolean getCpValido(String cp)
    {
        if(cp.length()!=longitudCp)
        {
            return false;
        }
        else
        {
            return true;
        }  
    }
    
    /**
     * Indica la longitud que debe tener un codigo de producto
     * @return longitud del codigo de producto
     */
    public int getLongitudCodigoProducto()
    {
        return longitudCp;
    }
    
    /**
     * Elimina un producto del almacen
     * @param cp codigo de producto
     * @return true si el producto se ha eliminado correctamente
     */
    public boolean eliminaProducto(String cp)
    {
        if(getExiste(cp))
        {
            almacen.remove(cp);
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Devuelve una lista de los productos almacenados en el almacen
     * @return lista de productos
     */
    public ArrayList<String> getListaDeProductos()
    {    
        ArrayList<String> lista = new ArrayList<String>();
        
        for(HashMap.Entry<String,Electrodomestico> producto:almacen.entrySet())
        {
            lista.add(((Electrodomestico)producto.getValue()).toString()+"\n"+"unidades en stock:"+producto.getValue().formatea(Integer.toString(producto.getValue().getCantidad()),3));
        }
        
        return lista;
    }
    
    /**
     * cuenta el número de artículos en el almacen
     * @return numero de articulos en el almacen
     */
    public int getContarArticulos()
    {
        int cantidadNueva=0;
        Set<Map.Entry<String,Electrodomestico>> entradas = almacen.entrySet();
        for(Map.Entry<String,Electrodomestico> entrada:entradas)
        {
            Electrodomestico producto = entrada.getValue();
            cantidadNueva = cantidadNueva + producto.getCantidad();
        }
        
        return cantidadNueva;
    }
    
    /**
     * Describe un producto
     * @param cp codigo de productos
     * @return descripcion del producto
     */
    public String getDescribeProducto(String cp)
    {
        if(getExiste(cp)){
            Electrodomestico producto = getProductoPorCp(cp);
            return producto.toString()+" unidades en stock:"+producto.formatea(Integer.toString(producto.getCantidad()),3);
        }else{
            return ("El producto no existe");
        }
    }
    
    /**
     * Describe un producto brevemente
     * @param cp codigo de productos
     * @return descripcion del producto
     */
    public String getDescripcionCorta(String cp)
    {
        if(getExiste(cp)){
            Electrodomestico producto = getProductoPorCp(cp);
            return (producto.toShortString());
        }else{
            return ("El producto no existe");
        }
    }
    
    /**
     * Incrementa el numero de unidades de un producto
     * @param cp codigo de producto
     * @param cantidad numero de articulos
     * @return true si la operacion se completa correctamente
     */
    public boolean setRecepcionDePedidos(String cp, int cantidad)
    {    
        if(getExiste(cp)==true){
            
            if(cantidad>=0){
                Electrodomestico producto=almacen.get(cp);
                producto.setCantidad(producto.getCantidad()+cantidad);
                return true;
            }else{
                return false;
            }     
             
        }else{
            return false;        
        }          
    }    
    
    /**
     * Disminuye el numero de articulos en una determinada cantidad
     * @param cp codigo de producto
     * @param cantidad numero de articulos a restar
     */
    public void setQuitaArticulos(String cp,int cantidad)
    {
        
        if(getExiste(cp)==true)
        {
            Electrodomestico producto=almacen.get(cp);
            int cantidadActual=producto.getCantidad();
            cantidadActual=cantidadActual-cantidad;
            producto.setCantidad(cantidadActual);
        }
    } 
    
    /**
     * Comprueba si para un articulo existen al menos un determinado numero de unidades
     * @param idProducto codigo de producto
     * @param cantidad numero de unidades del producto
     * @return true si existen unidades suficientes
     */
    public boolean comprobarStockSuficiente(String idProducto,int cantidad)
    {
        Electrodomestico producto = getProductoPorCp(idProducto);
        if(getExiste(idProducto))
        {
            if(producto.getCantidad()>=cantidad)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Guarda los datos en un archivo
     */
    public void escribeArchivo()
    {
      try{
          FileOutputStream file = new FileOutputStream(ruta);
          ObjectOutputStream oos = new ObjectOutputStream(file);
          oos.writeObject(almacen);
          oos.close();
         }catch(IOException e){
             e.printStackTrace();
         }
            
    }
    
    /**
     * Lee los datos de un archivo
     */
    public void leeArchivo()
    {
      File fichero = new File(ruta);
      if(fichero.exists())
      {
          try{
              FileInputStream file = new FileInputStream(fichero);
              ObjectInputStream oos = new ObjectInputStream(file);
              almacen = (HashMap<String,Electrodomestico>) oos.readObject();
              oos.close();
             }catch(Exception e){
                 e.printStackTrace();
             }
      }
      else
      {
          try{
          fichero.createNewFile();
        }catch(IOException e){
            e.printStackTrace();
        }
          escribeArchivo();
          leeArchivo();
      }
    }
}
