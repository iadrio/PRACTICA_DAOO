package Vista;


/**
 * Crea un objecto del tipo sección con las opciones que debe contener la pantalla de login
 * 
 * @author Iván Adrio Muñiz 
 * @version 2019.03.31
 */
public class Login extends Seccion
{
  
    public Login(){                
        super("BIENVENIDO AL SISTEMA DE GESTION DE TIENDA");
        add("(1)  Login");
        add("(2)  Salir");
    }
}
