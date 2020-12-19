package Vista;


/**
 * Crea un objecto del tipo sección con las opciones que debe contener el menu de posventa.
 * 
 * @author Iván Adrio Muñiz 
 * @version 2019.03.31
 */
public class MenuPosventa extends Seccion
{
    public MenuPosventa(){
        super("MENU DE POSVENTA");
        add("(1)  Tramitar devolucion");
        add("(2)  Historial por cliente");
        add("(3)  Historial");
        add("(4)  Atras");
        add("(5)  Salir"); 
    }           
}