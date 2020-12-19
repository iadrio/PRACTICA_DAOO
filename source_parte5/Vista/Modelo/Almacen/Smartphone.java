package Modelo.Almacen;

/**
 * Define las características de un smartphone
 * 
 * @author Iván Adrio Muñiz 
 * @version 2018.04.22
 */
public  class Smartphone extends Informatica
{
    /**
     * Crea productos tipo smartphone
     * @param codigoDeProducto número de identificación del producto
     * @param marca fabricante del producto
     * @param modelo  
     * @param color
     * @param precio
     * @param cantidad cantidad de productos en el almacen
     */
    public Smartphone(String codigoDeProducto,String marca, String modelo,String color, double precio, int cantidad)
    {
        super(codigoDeProducto,marca,modelo,color,precio,cantidad);
        setTipo("Smartphone");
    }
}