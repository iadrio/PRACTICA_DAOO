/**
 * Controlador que se activa cuando la vista muestra el menu de gestión de caja
 * @author Iván Adrio Muñiz
 * @version 2018.04.17
 */
public class ControllerComercial implements Controlador
{
    private View view;   
    private SistemaGestion model;
    
    /**
     * Crea un controlador para un modelo y un vista dada
     * @param view vista que será la encargada de interactuar con el usuario
     * @param model modelo que contendrá la implementación de las funciones instanciadas por la vista
     */
    public ControllerComercial(View view,SistemaGestion model){
        this.model=model;
        this.view=view;
    }
    
    /**
     * Gestiona los eventos que se producen en la vista
     * @param command orden que debe gestionar el controlaor
     */
    public void receiveCommand(String command) throws Exception{
        if(command.equals("añadir promoción")){
            añadirPromocion();
        }else if(command.equals("activar promoción")){
            activarPromocion();
        }else if(command.equals("desactivar promoción")){
            desactivarPromocion();
        }else if(command.equals("ver promociones")){
            verPromociones();
        }else if(command.equals("consultar promocion")){
            consultarPromociones();
        }else if(command.equals("añadir producto")){
            añadirProducto();
        }else if(command.equals("quitar producto")){
            quitarProducto();
        }else if(command.equals("ver clientes objetivo")){
            verClientesObjectivo();
        }else if(command.equals("enviar promocion")){
            enviarPromocion();
        }else if(command.equals("lista de correos")){
            listaCorreos();
        }else if(command.equals("consultar correo")){
            consultarCorreo();
        }else if(command.equals("consultar stock")){
            consultarStock();
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
     * Añade una promoción 
     */
    public void añadirPromocion(){
        String nombre = view.requestString("Introduzca el nombre de la promoción");
        String descripcion = view.requestString("Introduzca la descripcion de la promoción. Será la descripción que reciban los clientes en su correo");
        model.crearFichaPromocion(nombre,descripcion);
        view.refresh();
    }
    
    /**
     * Activa una promoción que ya está añadida en el modelo
     */
    public void activarPromocion(){
        int numeroFicha = view.requestEntero("Introduzca el numero de ficha de de la promoción");
        if(model.triggerPromocion(true,numeroFicha))
        {
            view.addToView("Promocion activada correctamente");
        }
        else
        {
            view.addToView("La promocion no se ha activado correctamente");
        }  
        view.refresh();
    }
    
    /**
     * Desactiva una promoción que ya está añadida en el modelo
     */
    public void desactivarPromocion(){
        int numeroFicha = view.requestEntero("Introduzca el numero de ficha de de la promoción");
        if(model.triggerPromocion(false,numeroFicha))
        {
            view.addToView("Promocion desactivada correctamente");
        }
        else
        {
            view.addToView("La promocion no se ha desactivado correctamente");
        }
        view.refresh();
    }
    
    /**
     * Muestra una lista de promociones
     */
    public void verPromociones(){
        view.addToView(model.getPromociones());
        view.refresh();
    }
    
    /**
     * Mustra una ficha de promoción
     */
    public void consultarPromociones(){
        view.addToView(model.getFichaPromocion(view.requestEntero("Introduzca el numero de ficha de de la promoción")));
        view.refresh();
    }
    
    /**
     * Añade un producto a una promoción 
     */
    public void añadirProducto(){
        int numeroFicha = view.requestEntero("Introduzca el numero de ficha de de la promoción");
        String codigoProducto = view.requestString("Introduzca el codigo de producto que desea añadir"); 
        int descuento = view.requestEntero("Introduzca el descuento a aplicar. Introduzca el valor en tanto por cien");
        if(model.añadirProductoPromocion(codigoProducto,descuento,numeroFicha))
        {
            view.addToView("Producto añadido correctamente");
        }
        else
        {
            view.addToView("La ficha de promoción indicada no existe");
        }
        view.refresh();
    }
    
    /**
     * Elimina una promoción
     */
    public void quitarProducto(){
        int numeroFicha = view.requestEntero("Introduzca el numero de ficha de de la promoción");
        String codigoProducto = view.requestString("Introduzca el codigo de producto que desea quitar"); 
        if(model.quitarProductoPromocion(codigoProducto,numeroFicha))
        {
            view.addToView("Producto retirado correctamente");
        }
        else
        {
            view.addToView("Producto no encontrado en la promoción");
        }
        view.refresh();
    }
    
    /**
     * Muestra un a lista con los clientes a los que se le puede enviar una promoción
     */
    public void verClientesObjectivo(){
        int numeroFicha = view.requestEntero("Introduzca el numero de ficha de de la promoción");
        view.addToView("***CLIENTES OBJETIVO***");
        view.addToView(model.getClientesObjetivo(numeroFicha));
        view.refresh();
    }
    
    /**
     * Envia una promoción a un cliente
     */
    public void enviarPromocion(){
        int numeroFicha = view.requestEntero("Introduzca el numero de ficha de de la promoción");
        String idCliente = view.requestString("Introduzca el identificador del cliente");
        if(model.enviarPromocion(idCliente,numeroFicha))
        {
            view.addToView("Promoción enviada correctamente");
        }
        else
        {
            view.addToView("La promoción no se ha enviado. Compruebe que existen clientes objetivo y que la promoción existe");
        }
        view.refresh();
    }
    
    /**
     * Pide al modelo una lista de correos y gestiona con la vista que se muestren los datos
     */
    public void listaCorreos(){
        view.addToView("***HISTORIAL DE CORREOS***");
        view.addToView(model.historialCorreos());
        view.refresh();
    }
    
    /**
     * Pide al modelo un correo y gestiona con la vista que se muestren los datos
     */
    public void consultarCorreo(){
        int numeroFicha = view.requestEntero("Introduzca el numero de correo que desea consultar");
        view.addToView(model.consultaCorreo(numeroFicha));
        view.refresh();
    }
    
    /**
     * Pide al modelo el stock y gestiona con la vista la salida de datos
     */
    public void consultarStock(){
        view.addToView("***STOCK EN EL ALMACEN***");
        view.addToView(model.getStock());
        view.refresh();
    }
}
