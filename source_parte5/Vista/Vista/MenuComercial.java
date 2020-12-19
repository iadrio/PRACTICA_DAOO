package Vista;


/**
 * Crea un objecto del tipo sección con las opciones que debe contener el menu de gestion comercial.
 * 
 * @author Iván Adrio Muñiz 
 * @version 2019.03.31
 */
public class MenuComercial extends Seccion
{
    public MenuComercial(){
        super("MENU DE GESTION COMERCIAL");
        add("(1)  Añadir promoción");
        add("(2)  Activar promoción");
        add("(3)  Desactivar promoción");
        add("(4)  Ver promociones");
        add("(5)  Consultar promoción");
        add("(6)  Añadir producto");
        add("(7)  Quitar producto");
        add("(8)  Ver clientes objetivo");
        add("(9)  Enviar promoción");
        add("(10)  Lista de correos");
        add("(11)  Consultar correo");
        add("(12)  Consultar stock");
        add("(13)  Atras");
        add("(14)  Salir");
    }           
}