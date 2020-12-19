import java.util.*;
import java.io.*;
/**
 * Controlador que se activa cuando la vista muestra el menu de gestión postventa
 * @author Iván Adrio Muñiz
 * @version 2018.04.17
 */
public class ControllerPosventa implements Controlador
{
    private View view;   
    private SistemaGestion model;
    
    /**
     * Crea un controlador para un modelo y un vista dada
     * @param view vista que será la encargada de interactuar con el usuario
     * @param model modelo que contendrá la implementación de las funciones instanciadas por la vista
     */
    public ControllerPosventa(View view,SistemaGestion model){
        this.model=model;
        this.view=view;
    }
    
    /**
     * Gestiona los eventos que se producen en la vista
     * @param command orden que debe gestionar el controlaor
     */
    public void receiveCommand(String command) throws Exception{
        if(command.equals("tramitar devolucion")){
            tramitarDevolucion();
        }else if(command.equals("historial por cliente")){
            historialCliente();
        }else if(command.equals("historial")){
            historial();
        }else if(command.equals("salir")){
            model.guardarDatos();
            return;
        }else if(command.equals("atras")){ 
            view.setController(new Controller(view,model));
            view.refresh("inicio");            
        }else{
            throw new Exception("La opción no está implementada todavía");
        }  
        view.getCommand();
    }
    
    /**
     * Gestiona la devolución de un producto
     */
    public void tramitarDevolucion(){
        int numeroFichaDeCompra = view.requestEntero("Introduzca el numero de ficha de compra sobre el que desea realizar la devolucion");
        String idCliente = view.requestString("Introduzca el DNI del cliente");
        int numeroFichaDevolucion=0,cantidad;
        String idProducto;
        boolean finalizado=false;
        if(model.getExisteFichaCompra(numeroFichaDeCompra))
        {
            if(model.comprobarClienteFichaCompra(numeroFichaDeCompra).equals(idCliente))
            {
                if(model.comprobarEstadoFichaCompra(numeroFichaDeCompra).equals("pagado")||model.comprobarEstadoFichaCompra(numeroFichaDeCompra).equals("financiacion aprobada"))
                {
                    Date fechaActual = new Date();
                    long plazo =fechaActual.getTime()-model.comprobarFechaDeCompra(numeroFichaDeCompra);
                    System.out.println(fechaActual.getTime());
                    System.out.println(model.comprobarFechaDeCompra(numeroFichaDeCompra));
                    
                    plazo=plazo/(24*60*60*1000);
                    System.out.println(plazo);
                    if(plazo<=3)
                    {
                        numeroFichaDevolucion = model.crearFichaDevolucion(numeroFichaDeCompra,view.requestString("¿Cual es el motivo de la devolucion?"));                       
                    }
                    else
                    {
                        view.addToView("El plazo de devolucion ha expirado (3 días)");
                        finalizado=true;
                    }
                }
                else
                {
                    view.addToView("La ficha de compra corresponde con una compra que no se ha finalizado");
                    finalizado=true;
                }
            }
            else
            {
                view.addToView("La ficha introducida no es propiedad de este cliente");
                finalizado=true;   
            }
        }
        else
        {
            view.addToView("La ficha introducida no existe");
            finalizado=true;
        }
        
        view.setMenu("menudevolucion");
        while(!finalizado){
            view.addToView(model.getFichaCompra(numeroFichaDeCompra));
            view.refresh();
            String orden = view.requestString("Escoja una opcion");
            switch (orden){
                case "1": 
                    idProducto=view.requestString("Introduzca el codigo del producto a devolver");
                    cantidad = view.requestEntero("Introduzca la cantidad");
                    if(model.compruebaProductoComprado(numeroFichaDeCompra,idProducto))
                    {
                        if(!model.devolverProducto(numeroFichaDevolucion,idProducto,cantidad,numeroFichaDeCompra))
                        {
                            view.addToView("El cliente no dispone de tantos articulos en su ficha de compra");
                        }else{
                            view.addToView("Producto añadido correctamente");
                        }
                    }
                    else
                    {
                        view.addToView("El producto no existe");
                    }
                    view.refresh();
                    break;
                    
                case "2":
                    idProducto=view.requestString("Introduzca el codigo del producto a cancelar");
                    cantidad = view.requestEntero("Introduzca la cantidad");
                    if(!model.cancelarDevolucionProducto(numeroFichaDevolucion,idProducto,cantidad,numeroFichaDeCompra))
                    {
                        view.addToView("El producto no se encuentra en la ficha de compra");
                    }
                    view.refresh();
                    break;
                
                case "3":
                    model.completarDevolucion(numeroFichaDevolucion);
                    finalizado=true;
                    view.refresh();
                    break;
                    
                case "4":
                    model.cancelarDevolucion(numeroFichaDevolucion);
                    finalizado=true;
                    break;
                
                default: 
                    view.addToView("No es una orden valida");
                    break;
            }            
        } 
        view.refresh("menuposventa");
    }
    
    /**
     * Pide al modelo que muestre el historial de un cliente y gestiona con la vista la entrada y salida de datos
     */
    public void historialCliente(){
        view.addToView(model.getHistorialPostVentaCliente(view.requestString("Introduzca el codigo del cliente")));
        view.refresh();
    }
    
    /**
     * Pide al modelo que muestre el historial en el departamento de posventa y gestiona con la vista la entrada y salida de datos
     */
    public void historial(){
        view.addToView(model.getHistorialPostVentaCompleto());
        view.refresh();
    }
    
    
    
}
