package Vista;


/**
 * Crea un objecto del tipo sección con las opciones que debe contener el menu de financiacion.
 * 
 * @author Iván Adrio Muñiz 
 * @version 2019.03.31
 */
public class MenuFinanciacion extends Seccion
{
    public MenuFinanciacion(){
        super("MENU DE FINANCIACION");
        add("(1)  Financiaciones pendientes");
        add("(2)  Pendientes por cliente");
        add("(3)  Historial Financiaciones Cliente");
        add("(4)  Consultar ficha de financiacion");
        add("(5)  Gestionar ficha de financiacion");
        add("(6)  Atras");
        add("(7)  Salir");
    }           
}
