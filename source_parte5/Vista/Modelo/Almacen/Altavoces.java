package Modelo.Almacen;


/**
 * Define las características de un altavoz
 * 
 * @author Iván Adrio Muñiz  
 * @version 2018.04.22
 */
public  class Altavoces extends Sonido
{
    /**
     * Crea productos tipo altavoces
     * @param codigoDeProducto número de identificación del producto
     * @param marca fabricante del producto
     * @param modelo  
     * @param color
     * @param precio
     * @param cantidad cantidad de productos en el almacen
     */
    public Altavoces(String codigoDeProducto,String marca, String modelo,String color, double precio, int cantidad)
    {
        super(codigoDeProducto,marca,modelo,color,precio,cantidad);
        setTipo("Altavoces");
    }
}
