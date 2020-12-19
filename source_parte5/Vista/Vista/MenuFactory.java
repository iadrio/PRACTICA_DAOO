package Vista;

/**
 * Crea una factoria de menus.
 * 
 * @author Iván Adrio Muñiz 
 * @version 2019.03.31
 */
public class MenuFactory
{
    private Seccion menu;
    
    public Seccion getMenu(String title) throws Exception{        
        if(title.equals("login")){
            return new Login();
        }
        if(title.equals("inicio")){            
            return new Inicio();
        }
        if(title.equals("menucaja")){            
            return new MenuCaja();
        }
        if(title.equals("menufinanciacion")){            
            return new MenuFinanciacion();
        }
        if(title.equals("menuposventa")){            
            return new MenuPosventa();
        }
        if(title.equals("menusuarios")){            
            return new MenuUsuarios();
        }
        if(title.equals("menualmacen")){            
            return new MenuAlmacen();
        }
        if(title.equals("menuserviciotecnico")){            
            return new MenuServicioTecnico();
        }
        if(title.equals("menucomercial")){            
            return new MenuComercial();
        }
        if(title.equals("menuventa")){            
            return new MenuVenta();
        }
        if(title.equals("menureparacion")){            
            return new MenuReparacion();
        }
        if(title.equals("menudevolucion")){            
            return new MenuDevolucion();
        }
        throw new Exception("El menu no existe");
    }
}
