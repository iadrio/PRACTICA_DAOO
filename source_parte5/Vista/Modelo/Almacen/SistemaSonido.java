package Modelo.Almacen;

/**
 * Define las características de un sistema de sonido
 * 
 * @author Iván Adrio Muñiz 
 * @version 2018.04.22
 */
public class SistemaSonido extends Sonido
{
    /**
     * Crea productos tipo sistema de sonido
     * @param codigoDeProducto número de identificación del producto
     * @param marca fabricante del producto
     * @param modelo  
     * @param color
     * @param precio
     * @param cantidad cantidad de productos en el almacen
     */
    public SistemaSonido(String codigoDeProducto,String marca, String modelo,String color, double precio, int cantidad)
    {
        super(codigoDeProducto,marca,modelo,color,precio,cantidad);
        setTipo("Sistema de sonido");
    }
}
