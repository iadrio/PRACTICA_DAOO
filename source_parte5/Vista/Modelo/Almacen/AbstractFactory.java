package Modelo.Almacen;


/**
 * Interfaz que define el método factoría que deben implementar las subclases concretas
 * 
 * @author Ivan Adrio Muñiz 
 * @version 2019.03.31
 */

public interface AbstractFactory
{
    public Electrodomestico factoryMethod(String tipo,String codigoDeProducto,String marca, String modelo,String color, double precio, int cantidad) throws Exception;
}
