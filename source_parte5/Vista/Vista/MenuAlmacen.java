package Vista;


/**
 * Crea un objecto del tipo sección con las opciones que debe contener el menu de almacen.
 * 
 * @author Iván Adrio Muñiz 
 * @version 2019.03.31
 */
public class MenuAlmacen extends Seccion
{
    public MenuAlmacen(){
        super("MENU DE GESTION DE ALMACEN");
        add("(1)  Stock");
        add("(2)  Pedido");
        add("(3)  Eliminar producto");
        add("(4)  Añadir producto");
        add("(5)  Buscar producto");
        add("(6)  Modificar producto");
        add("(7)  Atras");
        add("(8)  Salir");
    }           
}
