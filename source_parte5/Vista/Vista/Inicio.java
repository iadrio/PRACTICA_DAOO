package Vista;


/**
 * Crea un objecto del tipo sección con las opciones que debe contener el menu de inicio.
 * 
 * @author Iván Adrio Muñiz 
 * @version 2019.03.31
 */
public class Inicio extends Seccion
{
    public Inicio(){
        super("MENU DE INICIO");
        add("(1)  Caja");
        add("(2)  Financiacion");
        add("(3)  Servicio tecnico");
        add("(4)  Comercial");
        add("(5)  Servicio posventa");
        add("(6)  Gestion de usuarios");
        add("(7)  Gestion de almacen");
        add("(8)  Cambiar de usuario");
        add("(9)  Historial de Cliente");
        add("(10) Atras");
        add("(11) Salir");
    }           
}
