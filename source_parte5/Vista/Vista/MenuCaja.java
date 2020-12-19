package Vista;


/**
 * Crea un objecto del tipo sección con las opciones que debe contener el menu de caja.
 * 
 * @author Iván Adrio Muñiz 
 * @version 2019.03.31
 */
public class MenuCaja extends Seccion
{
    public MenuCaja(){
        super("MENU DE CAJA");
        add("(1)  Vender");
        add("(2)  Historial");
        add("(3)  Historial compras de cliente");
        add("(4)  Consultar ficha");
        add("(5)  Atras");
        add("(6)  Salir");
    }           
}