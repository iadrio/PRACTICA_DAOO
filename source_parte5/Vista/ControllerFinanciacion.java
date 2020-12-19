/**
 * Controlador que se activa cuando la vista muestra el menu de gestión de caja
 * @author Iván Adrio Muñiz
 * @version 2018.04.17
 */
public class ControllerFinanciacion implements Controlador
{
    private View view;   
    private SistemaGestion model;
    
    /**
     * Crea un controlador para un modelo y un vista dada
     * @param view vista que será la encargada de interactuar con el usuario
     * @param model modelo que contendrá la implementación de las funciones instanciadas por la vista
     */
    public ControllerFinanciacion(View view,SistemaGestion model){
        this.model=model;
        this.view=view;
    }
    
    /**
     * Gestiona los eventos que se producen en la vista
     * @param command orden que debe gestionar el controlaor
     */
    public void receiveCommand(String command) throws Exception{
        if(command.equals("financiaciones pendientes")){
            financiacionesPendientes();
        }else if(command.equals("pendientes por cliente")){
            financiacionesPendientesCliente();
        }else if(command.equals("historial financiaciones cliente")){
            historialFinanciacionesCliente();
        }else if(command.equals("consultar ficha de financiacion")){
            consultarFinanciacion();
        }else if(command.equals("gestionar ficha de financiacion")){
            gestionarFinanciacion();
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
     * Muestra las fichas de financiacion pendientes de analizar
     */
    public void financiacionesPendientes(){
        view.addToView("FICHAS PENDIENTES DE FINANCIAR");
        view.addToView(model.getFichasCompraEstado("pendiente financiar"));
        view.refresh();
    }
    
    /**
     * Muestra las fichas de financiacion pendientes de analizar de un cliente
     */
    public void financiacionesPendientesCliente(){
        String identificacion = view.requestString("Introduzca el codigo de cliente");
        view.addToView("FICHAS PENDIENTES DE FINANCIAR DEL CLIENTE: "+identificacion);
        view.addToView(model.getFichasCompraClienteEstado(identificacion,"pendiente financiar"));
        view.refresh();
    }
    
    /**
     * Muestra el historial de financiaciones de un cliente
     */
    public void historialFinanciacionesCliente(){
        String identificacion=view.requestString("Introduzca el codigo de cliente");
        view.addToView("HISTORIAL DE FINANCIACION DEL CLIENTE");
        view.addToView(model.getHistorialFinanciacionCliente(identificacion));
        view.refresh();
    }
    
    /**
     * Muestra los datos de una ficha de financiacion
     */
    public void consultarFinanciacion(){
        int numeroFicha = view.requestEntero("Introduzca el numero de ficha");
        view.addToView("FICHA DE FINANCIACION");
        if(model.getExisteFichaFinanciacion(numeroFicha))
        {
            view.addToView(model.fichaFinanciacion(numeroFicha));
        }else{
            view.addToView("La ficha no existe");
        }
        view.refresh();
    }
    
    /**
     * Permite realizar acciones sobre una ficha de financiacion
     */
    public void gestionarFinanciacion(){
        int numeroDeFicha = view.requestEntero("Introduzca el numero de ficha que desea analizar");;
        double nomina = view.requestDouble("Introduzca el valor de la ultima nomina del cliente en €");
        int plazo = view.requestEntero("Introduzca el numero de plazos en los que desea financiar la compra en meses");
        boolean continuar = false;
        
        if(!model.getExisteFichaCompra(numeroDeFicha))
        {
            view.addToView("La ficha no existe");
            continuar=false;
        }
        
        else if(!model.comprobarEstadoFichaCompra(numeroDeFicha).equals("pendiente financiar"))
        {
            view.addToView("La ficha ya ha sido gestionada");
            continuar=false;
        }
        else if(0>nomina)
        {
            view.addToView("La nomina debe ser mayor que 0");
            continuar=false;
        }
        else if(0>plazo||plazo>60)
        {
            view.addToView("El plazo para financiar debe estar entre 0 y 60 meses");
            continuar=false;
        }
        else
        {
            continuar=true;
        }
        
        if(continuar)
        {
            model.analizarFinanciacion(numeroDeFicha,nomina,plazo);
            view.addToView(model.fichaFinanciacion(model.getNumeroUltimaFichaFinanciacion()));
        }
        view.refresh();
    }

}
