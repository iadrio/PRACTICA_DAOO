package Vista;


/**
 * Crea un objecto del tipo sección con las opciones que debe contener el menu de gestion de devoluciones.
 * 
 * @author Iván Adrio Muñiz 
 * @version 2019.03.31
 */
public class MenuDevolucion extends Seccion
{

    public MenuDevolucion()
    {
        super("MENU DE POSVENTA");
        add("(1) Devolver producto");
        add("(2) Cancelar devolucion de un producto");
        add("(3) Confirmar la devolucion");
        add("(4) Cancelar y volver al menu anterior");
    } 
}
