package Modelo.Almacen;

/**
 * Define las caracteristicas de un reproductor de música
 * 
 * @author Iván Adrio Muñiz 
 * @version 2018.04.22
 */
public class ReproductorMusica extends Sonido
{
    /**
     * Crea productos tipo reproductor de musica
     * @param codigoDeProducto número de identificación del producto
     * @param marca fabricante del producto
     * @param modelo  
     * @param color
     * @param precio
     * @param cantidad cantidad de productos en el almacen
     */
    public ReproductorMusica(String codigoDeProducto,String marca, String modelo,String color, double precio, int cantidad)
    {
        super(codigoDeProducto,marca,modelo,color,precio,cantidad);
        setTipo("Reproductor de musica");
    }
}

