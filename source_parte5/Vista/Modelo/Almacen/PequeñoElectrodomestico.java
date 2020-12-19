package Modelo.Almacen;

/**
 * Define las características de un electrodoméstico pequeño
 * 
 * @author: Iván Adrio Muñiz
 * Date: 22.04.2018
 */
public class PequeñoElectrodomestico extends Hogar
{

    /**
     * Crea un producto de la seccion pequeño electrodomestico
     * @param codigoDeProducto número de identificación del producto
     * @param marca fabricante del producto
     * @param modelo  
     * @param color
     * @param precio
     * @param cantidad cantidad de productos en el almacen
     */
    public PequeñoElectrodomestico(String codigoDeProducto,String marca, String modelo,String color, double precio, int cantidad)
    {
        super(codigoDeProducto,marca,modelo,color,precio,cantidad);
        setTipo("pequeño electrodomestico");
    }   
    
}
