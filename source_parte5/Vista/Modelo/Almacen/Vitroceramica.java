package Modelo.Almacen;


/**
 * Define las características de una vitrocerámica
 * 
 * @author Iván Adrio Muñiz 
 * @version 22.04.2018
 */
public class Vitroceramica extends GranElectrodomestico
{
    /**
     * Crea productos tipo vitroceramica
     * @param codigoDeProducto número de identificación del producto
     * @param marca fabricante del producto
     * @param modelo  
     * @param color
     * @param precio
     * @param cantidad cantidad de productos en el almacen
     */
    public Vitroceramica(String codigoDeProducto,String marca, String modelo,String color, double precio, int cantidad)
    {
        super(codigoDeProducto,marca,modelo,color,precio,cantidad);
        setTipo("vitroceramica");
    }

    
}
