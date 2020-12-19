package Modelo.Almacen;

/**
 * Clase que implementa el método factoría
 * 
 * @author Ivan Adrio Muñiz 
 * @version 2019.03.31
 */
public class ConcreteFactory implements AbstractFactory
{
    /**
     * Crea un producto de tipo genérico
     * @param tipo tipo de producto que se va a crear
     * @param codigoDeProducto identificador único del producto
     * @param marca  marca del producto
     * @param modelo modelo del producto
     * @param color color del producto
     * @param precio precio del producto
     * @param cantidad numero de unidades que se van a crear
     */
    public Electrodomestico factoryMethod(String tipo,String codigoDeProducto,String marca, String modelo,String color, double precio, int cantidad) throws Exception{
        switch(tipo)
        {
            case "tv":
            return new Tv( codigoDeProducto, marca,  modelo, color,  precio,  cantidad);
            
            case "camara":
            return new Camara( codigoDeProducto, marca,  modelo, color,  precio,  cantidad);
            
            case "reproductor":
            return new Reproductor( codigoDeProducto, marca,  modelo, color,  precio,  cantidad);
            
            case "altavoces":
            return new Altavoces( codigoDeProducto, marca,  modelo, color,  precio,  cantidad);
            
            case "sistemasonido":
            return new SistemaSonido( codigoDeProducto, marca,  modelo, color,  precio,  cantidad);
            
            case "reproductormusica":
            return new ReproductorMusica( codigoDeProducto, marca,  modelo, color,  precio,  cantidad);
            
            case "ordenador":
            return new Ordenador( codigoDeProducto, marca,  modelo, color,  precio,  cantidad);
            
            case "smartphone":
            return new Smartphone( codigoDeProducto, marca,  modelo, color,  precio,  cantidad);
            
            case "pequeñoElectrodomestico":
            return new PequeñoElectrodomestico( codigoDeProducto, marca,  modelo, color,  precio,  cantidad);
            
            case "vitroceramica":
            return new Vitroceramica( codigoDeProducto, marca,  modelo, color,  precio,  cantidad);
            
            case "lavadora":
            return new Lavadora( codigoDeProducto, marca,  modelo, color,  precio,  cantidad);
            
            case "horno":
            return new Horno( codigoDeProducto, marca,  modelo, color,  precio,  cantidad);
            
            case "nevera":
            return new Nevera( codigoDeProducto, marca,  modelo, color,  precio,  cantidad);
            
            default:
            throw new Exception("El tipo de electrodoméstico elegido no existe");
        }
        
    }
    
}
