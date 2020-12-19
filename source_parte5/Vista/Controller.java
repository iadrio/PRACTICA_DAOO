    import java.util.*;
/**
 * Controlador que se activa cuando la vista muestra el menu de gestión de caja
 * @author Iván Adrio Muñiz
 * @version 2018.04.17
 */
public class Controller implements Controlador
{
    private View view;
    private SistemaGestion model;
    private Exception sinPermisos,noImplementada;
    private ControllerFinanciacion controllerFinanciacion;
    private ControllerServicioTecnico controllerServicioTecnico;
    private ControllerComercial controllerComercial;
    private ControllerPosventa controllerPosventa;
    private ControllerAlmacen controllerAlmacen;
    
    /**
     * Crea un controlador creando la vista y el modelo necesario
     */
    public Controller(){
        model =new SistemaGestion();
        this.view=new View(this,model);
        controllerFinanciacion= new ControllerFinanciacion(view,model);
        controllerServicioTecnico= new ControllerServicioTecnico(view,model);
        controllerComercial= new ControllerComercial(view,model);
        controllerPosventa= new ControllerPosventa(view,model);
        controllerAlmacen = new ControllerAlmacen(view,model);
        view.setMenu("login");
        view.createView();
        view.refresh();
        view.getCommand();
    }
    
    /**
     * Crea un controlador para un modelo y un vista dada
     * @param view vista que será la encargada de interactuar con el usuario
     * @param model modelo que contendrá la implementación de las funciones instanciadas por la vista
     */
    public Controller(View view,SistemaGestion model){
        this.model=model;
        this.view=view;
    }
    
    /**
     * Gestiona los eventos que se producen en la vista
     * @param command orden que debe gestionar el controlaor
     */
    public void receiveCommand(String command) throws Exception{
        if(command.equals("login")){
            login();
        }
        else if(command.equals("salir")){
            model.guardarDatos();
            return;
        }else if(command.equals("atras")){ 
            view.refresh("inicio");
        }else if(command.equals("caja")){                
            if(model.comprobarPermisoUsuarioActual("cajero")){
                view.setController(new ControllerCaja(view,model));
                view.refresh("menucaja");
            }                
        }else if(command.equals("financiacion")){                     
            if(model.comprobarPermisoUsuarioActual("financiero")){
                view.setController(new ControllerFinanciacion(view,model));
                view.refresh("menufinanciacion");
            }               
        }else if(command.equals("servicio tecnico")){                   
            if(model.comprobarPermisoUsuarioActual("tecnico")){
                view.setController(new ControllerServicioTecnico(view,model));
                view.refresh("menuserviciotecnico");
            }                            
        }else if(command.equals("comercial")){               
            if(model.comprobarPermisoUsuarioActual("comercial")){
                view.setController(new ControllerComercial(view,model));
                view.refresh("menucomercial");
            }               
        }else if(command.equals("servicio posventa")){               
            if(model.comprobarPermisoUsuarioActual("postventa")){
                view.setController(new ControllerPosventa(view,model));
                view.refresh("menuposventa");
            }                
        }else if(command.equals("gestion de usuarios")){                
            if(model.comprobarPermisoUsuarioActual("administrador")){
                view.setController(new ControllerGestionUsuarios(view,model));
                view.refresh("menusuarios");
            }               
        }else if(command.equals("gestion de almacen")){                
            if(model.comprobarPermisoUsuarioActual("administrador")){
                view.setController(new ControllerAlmacen(view,model));
                view.refresh("menualmacen");
            }                    
        }else if(command.equals("cambiar de usuario")){
            login();
        }else if(command.equals("historial de cliente")){
            historialCliente();
        }else{
              throw new Exception("La opción no está implementada todavía");
        }      
        view.getCommand();
    }
            
    /**
     * Loguea a un usuario en la aplicación
     */
    public void login()
    {
        String id = view.requestString("Introduzca su codigo de usuario");
        String clave = view.requestString("Introduzca su clave de acceso");
        if(model.login(id,clave)){
            view.refresh("inicio");            
        }
    }
    
    /**
     * Muestra el historial completo de un cliente en la aplicación
     */
    public void historialCliente()
    {
        String idCliente = view.requestString("Introduzca el DNI del cliente");
        ArrayList<String> historial=model.getHistorialCliente(idCliente);
        view.addToView("HISTORIAL DE CLIENTE");
        view.addToView(historial);
        view.refresh();
    }
                        
}
