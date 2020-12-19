package Vista;


/**
 * Crea un objecto del tipo sección con las opciones que debe contener el menu de servicio tecnico.
 * 
 * @author Iván Adrio Muñiz 
 * @version 2019.03.31
 */
public class MenuServicioTecnico extends Seccion
{
    public MenuServicioTecnico(){
        super("MENU DE SERVICIO TECNICO");
        add("(1)  Abrir ficha de reparacion");
        add("(2)  Gestionar ficha de reparacion");
        add("(3)  Consultar ficha de reparacion");
        add("(4)  Historial de reparaciones");
        add("(5)  Historial de reparaciones del cliente");
        add("(6)  Historial de reparaciones del empleado");
        add("(7)  Asignar ficha de reparacion");
        add("(8)  Historial del producto");
        add("(9)  Mis fichas asignadas");
        add("(10)  Reparaciones pendientes");
        add("(11)  Piezas pendientes");
        add("(12)  Atras");
        add("(13)  Salir");
    }           
}