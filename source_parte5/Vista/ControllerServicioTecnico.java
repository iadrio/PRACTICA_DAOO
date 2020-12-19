/**
 * Controlador que se activa cuando la vista muestra el menu de gestión de caja
 * @author Iván Adrio Muñiz
 * @version 2018.04.17
 */
public class ControllerServicioTecnico implements Controlador
{
    private View view;   
    private SistemaGestion model;
    
    /**
     * Crea un controlador para un modelo y un vista dada
     * @param view vista que será la encargada de interactuar con el usuario
     * @param model modelo que contendrá la implementación de las funciones instanciadas por la vista
     */
    public ControllerServicioTecnico(View view,SistemaGestion model){
        this.model=model;
        this.view=view;
    }
    
    /**
     * Gestiona los eventos que se producen en la vista
     * @param command orden que debe gestionar el controlaor
     */
    public void receiveCommand(String command) throws Exception{
        if(command.equals("abrir ficha de reparacion")){
            abrirFicha();
        }else if(command.equals("gestionar ficha de reparacion")){
            gestionarFicha();
        }else if(command.equals("consultar ficha de reparacion")){
            consultarFicha();
        }else if(command.equals("historial de reparaciones")){
            historialReparaciones();
        }else if(command.equals("historial de reparaciones del cliente")){
            historialReparacionesCliente();
        }else if(command.equals("historial de reparaciones del empleado")){
            historialReparacionesEmpleado();
        }else if(command.equals("asignar ficha de reparacion")){
            asignarFicha();
        }else if(command.equals("historial del producto")){
            historialReparacionesProducto();
        }else if(command.equals("mis fichas asignadas")){
            misFichas();
        }else if(command.equals("reparaciones pendientes")){
            reparacionesPendientes();
        }else if(command.equals("piezas pendientes")){
            piezasPendientes();
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
     * Gestiona los eventos que se producen en la vista
     */
    public void abrirFicha(){
        int numeroFichaDeCompra = view.requestEntero("Introduzca el numero de ficha de compra a la que pertenece el producto. Debe solicitarle al cliente el ticket de compra.");
        view.addToView(model.getFichaCompra(numeroFichaDeCompra));
        view.refresh();
        String idProducto = view.requestString("Introduzca el codigo del producto averiado");
        int numeroFichaReparacion = model.crearFichaReparacion(numeroFichaDeCompra,idProducto);
        if(numeroFichaReparacion>=0){         
            String comentario = view.requestString("¿Que es lo que le pasa?");
            model.añadirComentarioReparacion(numeroFichaReparacion,comentario);
            view.addToView("Se ha creado la ficha correctamente");
        }
        else if(numeroFichaReparacion==-1){
            view.addToView("El producto no existe en esa ficha de compra");
        }
        else if(numeroFichaReparacion==-2){
            view.addToView("Este producto ha sido devuelto anteriormente");
        }
        else if(numeroFichaReparacion==-3){
            view.addToView("Ya se esta gestionando una reparacion para este producto");
        }        
        view.refresh();
    }
    
    /**
     * Gestiona las acciones que se pueden realizar con una ficha de reparacion 
     */
    public void gestionarFicha(){
               
        String descripcion,estado, proveedor,idPieza,precio, cantidad, numeroPieza;
        int numeroFicha = view.requestEntero("Introduzca el número de la ficha de reparacion");
        String idCliente = model.compruebaClienteReparacion(numeroFicha);
        boolean finalizado;
        if(idCliente!=null)
        {
            finalizado = false;
        }
        else
        {
            view.addToView("La ficha de reparacion indicada no es correcta");
            finalizado = true;
        }
        view.refresh("menureparacion"); 
        while(!finalizado)
        {
        
        String orden = view.requestString("Escoja una opción");
            
            switch (orden)
            {
                case "1": 
                    model.añadirComentarioReparacion(numeroFicha,view.requestString("Escriba el comentario"));
                    int opcion = view.requestEntero("¿Quiere añadir horas de mano de obra a la ficha?"+"\n"+"Pulse 1 para añadir horas de mano de obra a la ficha, introduzca cualquier otro dato para continuar");
                    if(opcion==1)
                    {
                        int horas = view.requestEntero("Introduzca el numero de horas");
                        model.añadirManoDeObra(numeroFicha,horas);
                    }
                    view.refresh();
                    break;
                
                case "2":
                    String mensaje = view.requestString("Escriba los detalles de la comunicacion con el cliente");
                    model.comunicarAlClienteReparacion(mensaje,numeroFicha);
                    view.refresh();
                    break;
                    
                case "3":
                    descripcion=view.requestString("Introduzca una breve descripcion del a pieza");
                    cantidad=view.requestString("Introduzca el numero de piezas");
                    proveedor=view.requestString("Introduzca el nombre del proveedor");
                    idPieza=view.requestString("Introduzca el codigo de identificacion de la pieza");
                    precio=view.requestString("Introduzca el precio de la pieza en €");
                    model.añadirPiezaNecesaria(numeroFicha,idPieza,descripcion,precio,proveedor,cantidad);
                    view.refresh();
                    break;
                    
                case "4":
                    idPieza = view.requestString("Introduzca el codigo de la pieza");
                    model.quitarPiezaNecesaria(idPieza,numeroFicha);
                    view.refresh();
                    break;
                    
                case "5":
                    numeroPieza = view.requestString("Introduzca el codigo de la pieza");
                    if(model.comprobarPiezaNecesaria(numeroFicha,numeroPieza))
                    {
                        model.recepcionPieza(numeroFicha,numeroPieza);
                        
                    }
                    else
                    {
                        System.out.println("La pieza no existe");
                    }
                    view.refresh();
                    break;
                    
                case "6":
                    model.añadirComentarioReparacion(numeroFicha,view.requestString("Introduzca el comentario de resolucion"));
                    model.finalizarReparacion(numeroFicha);
                    finalizado=true;
                    break;
                    
                case "7":
                    view.addToView(model.getFichaReparacion(numeroFicha));
                    view.refresh();
                    break;
                    
                case "8":
                    view.addToView(model.presupuestoReparacion(numeroFicha,view.requestDouble("Introduzca el precio de la mano de obra")));
                    view.refresh();
                    break;
                    
                case "9":
                    finalizado=true;
                    break;
  
                default: 
                    view.addToView("No es una orden valida");
                    break;
            }
        }
        view.refresh("menuserviciotecnico");
    }
    
    /**
     * Pide al modelo los datos de una ficha de reparación y gestiona con la vista que se muestren los datos
     */
    public void consultarFicha(){
        int numeroFicha = view.requestEntero("Introduzca el numero de ficha de reparacion");
        if(model.existeFichaReparacion(numeroFicha))
        {
            view.addToView("FICHA DE REPARACION");
            view.addToView(model.getFichaReparacion(numeroFicha));
        }
        else
        {
            view.addToView("La ficha no existe");
        }
        view.refresh();
    }
    
    /**
     * Pide al modelo la lista de reparaciones y gestiona con la vista que se muestren los datos
     */
    public void historialReparaciones(){
        view.addToView(model.getHistorialReparaciones());
        view.refresh();
    }
    
    /**
     * Pide al modelo la lista de reparaciones de un cliente y gestiona con la vista que se muestren los datos
     */
    public void historialReparacionesCliente(){
        view.addToView(model.getHistorialReparacionesCliente(view.requestString("Introduzca el codigo de cliente")));
        view.refresh();
    }
    
    /**
     * Pide al modelo la lista de reparaciones de un empleado y gestiona con la vista que se muestren los datos
     *
     */
    public void historialReparacionesEmpleado(){
         view.addToView(model.getHistorialReparacionesEmpleadoActual());
         view.refresh();
    }
    
    /**
     * Pide al modelo que asigne una ficha a un empleado
     */
    public void asignarFicha(){
        int numeroFichaReparacion = view.requestEntero("Introduzca el numero de ficha que desea asignarse");
        if(model.asignarseFichaReparacion(numeroFichaReparacion))
        {
            view.addToView("Ficha asignada correctamente");
        }
        else
        {
            view.addToView("La ficha no existe");
        }
        view.refresh();
    }
    
    /**
     * Muestra el historial de reparaciones de un electrodomestico
     */
    public void historialReparacionesProducto(){
        String idProducto=view.requestString("Introduzca el codigo de producto");
        int numeroFichaDeCompra=view.requestEntero("Introduzca el numero de ficha de compra");
        view.addToView(model.historialElectrodomestico(idProducto,numeroFichaDeCompra));
        view.refresh();
    }
    
    /**
     * Muestra las fichas asignadas al usuario logueado
     */
    public void misFichas(){
        view.addToView("TUS FICHAS ASIGNADAS");
        view.addToView(model.fichasAsignadas());
        view.refresh();
    }
    
    /**
     * Muestra las reparaciones pendientes de finalizar
     */
    public void reparacionesPendientes(){
        view.addToView("FICHAS PENDINTES DE RESOLVER");
        view.addToView(model.getReparacionesPendientes());
        view.refresh();
    }
    
    /**
     * Muestra las piezas pendientes de recibir
     */
    public void piezasPendientes(){
        view.addToView("PIEZAS PENDIENTES DE RECIBIR");
        view.addToView(model.getPiezasPendientes());
        view.refresh();
    }
}
