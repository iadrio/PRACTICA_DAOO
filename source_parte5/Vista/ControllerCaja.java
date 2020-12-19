import java.util.*;
/**
 * Controlador que se activa cuando la vista muestra el menu de gestión de caja
 * @author Iván Adrio Muñiz
 * @version 2018.04.17
 */
public class ControllerCaja implements Controlador
{
    private View view;   
    private SistemaGestion model;
    
    /**
     * Crea un controlador para un modelo y un vista dada
     * @param view vista que será la encargada de interactuar con el usuario
     * @param model modelo que contendrá la implementación de las funciones instanciadas por la vista
     */
    public ControllerCaja(View view,SistemaGestion model){
        this.model=model;
        this.view=view;
    }
    
    /**
     * Gestiona los eventos que se producen en la vista
     * @param command orden que debe gestionar el controlaor
     */
    public void receiveCommand(String command) throws Exception{
        if(command.equals("historial compras de cliente")){
            historialCajaCliente();
        }else if(command.equals("consultar ficha")){
            consultarFichaCompra();
        }else if(command.equals("vender")){
            vender();
        }else if(command.equals("historial")){
            historialVentas();
        }else if(command.equals("salir")){
            model.guardarDatos();
            return;
        }else if(command.equals("atras")){ 
            view.setController(new Controller(view,model));
            view.refresh("inicio");            
        }
        
        view.getCommand();
    }
    
    /**
     * Gestiona las funciones de venta 
     */
    public void vender()
    {
        String idProducto,nombre,apellidos,correoElectronico,telefono;
        int numeroDeFicha,cantidad;
        boolean finalizado=false;
        String identificacion = view.requestString("Introduzca el número de identificación del cliente");
        if(!model.existeCliente(identificacion))
        {
            nombre=view.requestString("Debe abrirse una ficha de cliente nueva. El cliente no existe en la base de datos"+"\n"+"Introduzca el nombre del usuario");
            apellidos = view.requestString("Introduzca los apellidos del usuario");
            correoElectronico = view.requestString("Introduzca el correo electronico del usuario");
            telefono = view.requestString("Introduzca el numero de telefono del usuario");
            model.añadirCliente(identificacion,nombre,apellidos,correoElectronico,telefono); 
        }
        numeroDeFicha=model.crearFichaDeCompra(identificacion);
        view.refresh("menuventa"); 
        while(!finalizado){
            
            String opcion = view.requestString("Escoja una opción");
            
            switch (opcion){
                case "1": 
                    idProducto=view.requestString("Introduzca el codigo del producto");
                    cantidad = view.requestEntero("Introduzca la cantidad");
                    if(model.comprarProducto(numeroDeFicha,idProducto,cantidad))
                    {
                        view.clear();
                        view.addToView(model.getFichaCompra(numeroDeFicha));
                        view.refresh();
                    }
                    else
                    {
                        view.addToView("ese producto no existe");
                        view.refresh("menuventa");
                    }
                    break;
                
                case "2":
                    idProducto=view.requestString("Introduzca el codigo del producto");
                    cantidad = view.requestEntero("Introduzca la cantidad");
                    model.quitarProductoDeCompra(numeroDeFicha,idProducto,cantidad);
                    view.clear();
                    view.addToView(model.getFichaCompra(numeroDeFicha));
                    view.refresh();
                    break;
                
                case "3":
                    model.pagarEfectivo(numeroDeFicha);
                    finalizado=true;
                    break;
                
                case "4":
                    model.financiarCompra(numeroDeFicha);
                    System.out.println("El cliente debe hablar con un financiero para finalizar su compra");
                    finalizado=true;
                    break;
                
                case "5":
                    model.cancelarCompra(numeroDeFicha);
                    finalizado=true;
                    break;
                
                default: 
                    view.addToView("No es una orden valida");
                    break;
            }
        }
        
        view.refresh("menucaja");
    }
    
    /**
     * Imprime el historial de ventas de la tienda
     */
    public void historialVentas()
    {
        ArrayList<String> historial=model.getHistorialVentas();
        view.addToView("HISTORIAL DE VENTAS");
        view.addToView(historial);
        view.refresh();
    }
    
    /**
     * Pide al modelo una ficha de compra y gestiona con la vista mostrar los datos
     */
    public void consultarFichaCompra(){
    int numeroDeFicha = view.requestEntero("Introduzca el numero de ficha");
    view.addToView("FICHA DE COMPRA");
    if(model.getExisteFichaCompra(numeroDeFicha))
    {
        view.addToView(model.getFichaCompra(numeroDeFicha));
    }else{
        view.addToView("No existe la ficha");
    }
    view.refresh();
    }
    
    /**
     * Pide al modelo el historial de caja de un cliente y gestiona con la vista que se muestren los datos
     */
    public void historialCajaCliente(){
        String identificacion = view.requestString("Introduzca el codigo del cliente");
        view.addToView("HISTORIAL DE VENTAS DE: "+identificacion);
        view.addToView(model.getFichasCompraCliente(identificacion));
        view.refresh();
    }
}
