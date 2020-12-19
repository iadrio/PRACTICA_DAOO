package Vista;


/**
 * Crea un objecto del tipo sección con las opciones que debe contener el menu de usuarios.
 * 
 * @author Iván Adrio Muñiz 
 * @version 2019.03.31
 */
public class MenuUsuarios extends Seccion
{
    public MenuUsuarios(){
        super("MENU DE GESTION DE USUARIOS");
        add("(1)  Añadir Empleado");
        add("(2)  Añadir Cliente");
        add("(3)  Quitar Cliente");
        add("(4)  Lista de empleados");
        add("(5)  Lista de clientes");
        add("(6)  Ver ficha de empleado");
        add("(7)  Ver ficha de cliente");
        add("(8)  Buscar empleado por nombre");
        add("(9)  Buscar cliente por nombre");
        add("(10) Añadir permisos a usuario");
        add("(11) Retirar permisos a usuario");
        add("(12) Modificar cliente");
        add("(13) Modificar empleado");
        add("(14) Atras");
        add("(15) Salir");
    }           
}