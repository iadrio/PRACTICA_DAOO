package Vista;


/**
 * Crea un objecto del tipo sección con las opciones que debe contener el menu de venta.
 * 
 * @author Iván Adrio Muñiz 
 * @version 2019.03.31
 */
public class MenuVenta extends Seccion
{
    public MenuVenta(){
        super("MENU DE GESTION DE VENTAS");
        add("(1)  Añadir producto");
        add("(2)  Quitar producto");
        add("(3)  Pagar en efectivo");
        add("(4)  Financiar la compra");
        add("(5)  Cancelar y volver al menu anterior");
    }           
}
