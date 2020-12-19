package Modelo.Almacen;

/**
 * Define las características de un gran electrodoméstico
 * 
 * @author Iván Adrio Muñiz 
 * @version 22.04.2018
 */
public abstract class GranElectrodomestico extends Hogar
{
    private String subSeccion = "GranElectrodomestico";   
    
    /**
     * Crea un producto de la seccion gran electrodomestico
     * @param codigoDeProducto número de identificación del producto
     * @param marca fabricante del producto
     * @param modelo  
     * @param color
     * @param precio
     * @param cantidad cantidad de productos en el almacen
     */
    public GranElectrodomestico(String codigoDeProducto,String marca, String modelo,String color, double precio, int cantidad)
    {
        super(codigoDeProducto,marca,modelo,color,precio,cantidad);
    }

}