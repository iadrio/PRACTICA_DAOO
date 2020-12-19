package Modelo.Almacen;



/**
 * Define las características de un objeto de tipo reproductor
 * 
 * @author Iván Adrio Muñiz 
 * @version 2018.04.21
 */
public class Reproductor extends Imagen
{
    private String formato;
          
    /**
     * Crea productos tipo reproductor
     * @param codigoDeProducto número de identificación del producto
     * @param marca fabricante del producto
     * @param modelo  
     * @param color
     * @param precio
     * @param cantidad cantidad de productos en el almacen
     * @param formato formatos reproducibles 
     */
    public Reproductor(String codigoDeProducto,String marca, String modelo,String color, double precio, int cantidad)
    {
        super(codigoDeProducto,marca,modelo,color,precio,cantidad);
        this.formato=formato;
        setTipo("reproductor");
    }        
}
