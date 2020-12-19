package Modelo.Almacen;



/**
 * Define las características de un objeto de tipo televisión
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tv extends Imagen
{  
    /** 
     * Crea productos tipo televisión
     * @param codigoDeProducto número de identificación del producto
     * @param marca fabricante del producto
     * @param modelo  
     * @param color
     * @param precio
     * @param cantidad cantidad de productos en el almacen
     */
    public Tv(String codigoDeProducto,String marca, String modelo,String color, double precio, int cantidad)
    {
        super(codigoDeProducto,marca,modelo,color,precio,cantidad);
        setTipo("Tv");
    }    
}
