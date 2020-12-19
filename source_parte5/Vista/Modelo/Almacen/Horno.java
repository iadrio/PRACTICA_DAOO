package Modelo.Almacen;


/**
 * Define las características de un horno
 * 
 * @author Iván Adrio Muñiz 
 * @version 22.04.2018
 */
public class Horno extends GranElectrodomestico
{
    /**
     * Crea productos tipo horno
     * @param codigoDeProducto número de identificación del producto
     * @param marca fabricante del producto
     * @param modelo  
     * @param color
     * @param precio
     * @param cantidad cantidad de productos en el almacen
     */
    public Horno(String codigoDeProducto,String marca, String modelo,String color, double precio, int cantidad)
    {
        super(codigoDeProducto,marca,modelo,color,precio,cantidad);
        setTipo("horno");
    }
}
