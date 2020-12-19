package Modelo.Almacen;


/**
 * Define las características de una lavadora
 * 
 * @author Iván Adrio Muñiz
 * @version 22.04.2018
 */
public class Lavadora extends GranElectrodomestico
{
    /**
     * Crea productos tipo lavadora
     * @param codigoDeProducto número de identificación del producto
     * @param marca fabricante del producto
     * @param modelo  
     * @param color
     * @param precio
     * @param cantidad cantidad de productos en el almacen
     */
    public Lavadora(String codigoDeProducto,String marca, String modelo,String color, double precio, int cantidad)
    {
        super(codigoDeProducto,marca,modelo,color,precio,cantidad);
        setTipo("lavadora");
    }

}