package Vista;


/**
 * Crea un objecto del tipo sección con las opciones que debe contener el menu de reparacion.
 * 
 * @author Iván Adrio Muñiz 
 * @version 2019.03.31
 */
public class MenuReparacion extends Seccion
{
    public MenuReparacion(){
        super("MENU DE GESTION DE REPARACIONES");
        add("(1) Añadir un comentario o trabajo a la ficha");
        add("(2) Añadir una comunicacion con el cliente");
        add("(3) Añadir pieza necesaria");
        add("(4) Quitar pieza de la ficha de reparacion");
        add("(5) Recepcion pieza necesaria");
        add("(6) Resolver ficha");
        add("(7) Consultar ficha");
        add("(8) Calcular presupuesto");
        add("(9) Atras");
    }           
}
