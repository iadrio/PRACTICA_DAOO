/**
 * Controlador que se activa cuando la vista muestra el menu de gestión de almacén
 * @author Iván Adrio Muñiz
 * @version 2018.04.17
 */
public class ControllerAlmacen implements Controlador
{
    private View view;   
    private SistemaGestion model;
    
    /**
     * Crea un controlador para un modelo y un vista dada
     * @param view vista que será la encargada de interactuar con el usuario
     * @param model modelo que contendrá la implementación de las funciones instanciadas por la vista
     */
    public ControllerAlmacen(View view,SistemaGestion model){
        this.model=model;
        this.view=view;
    }
    
    /**
     * Gestiona los eventos que se producen en la vista
     * @param command orden que debe gestionar el controlaor
     */
    public void receiveCommand(String command) throws Exception{
        if(command.equals("pedido")){
            pedido();
        }else if(command.equals("eliminar producto")){
            eliminarProducto();
        }else if(command.equals("añadir producto")){
            añadirProducto();
        }else if(command.equals("buscar producto")){
            buscarProducto();
        }else if(command.equals("modificar producto")){
            eliminarProducto();
            añadirProducto();
        }else if(command.equals("stock")){
            stock();
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
     * Pide al modelo el stock y gestiona con la vista la salida de datos
     */
    public void stock(){
        view.clear();
        view.addToView("STOCK");
        view.addToView(model.getStock());
        view.refresh();
    }
    
    /**
     * Pide al modelo que elimine un producto y gestiona con la vista la entrada y  salida de datos
     */
    public void eliminarProducto(){
        model.eliminarProducto(view.requestString("Indica el código de producto"));
        view.refresh();
    }
    
    /**
     * Pide al modelo que añada un producto y gestiona con la vista la entrada y  salida de datos
     */
    public void añadirProducto(){
        String tipo=view.requestString("Introduzca el tipo de producto:  tv, camara, reproductor, altavoces, sistemasonido, reproductormusica, ordenador, smartphone, pequeñoElectrodomestico, vitroceramica, lavadora, horno o nevera");
    
        String codigoDeProducto=view.requestString("Introduzca el codigo de producto");
        if(!model.comprobarCodigoProductoValido(codigoDeProducto))
        {
            boolean valido = false;
            while(!valido)
            {
                codigoDeProducto=view.requestString("El codigo de producto debe tener "+model.getLongitudCodigoProducto()+" digitos");
                valido=model.comprobarCodigoProductoValido(codigoDeProducto);
            }
            
        }
        String marca=view.requestString("Introduzca la marca del producto");
        String modelo=view.requestString("Introduzca el modelo del producto");
        String color=view.requestString("Introduzca el color del producto");
        Double precio=view.requestDouble("Introduzca el precio del producto");         
        int cantidad=view.requestEntero("Introduzca el numero de articulos inicial");
        
        if(!model.añadirProducto(tipo,codigoDeProducto,marca,modelo,color,precio,cantidad)){
            view.addToView("El tipo de producto elegido no existe");
            añadirProducto();
        }
        
        int continuar=0;
        while(continuar==0){
            continuar=view.requestEntero("Si desea introducir una característica adicional, pulse 0");
            
            if(continuar==0){
                model.addCaracteristica(view.requestString("Indique la caracteristica"),codigoDeProducto);
            }
        }
        view.refresh();
    }
    
    /**
     * Pide al modelo que busque un producto y gestiona con la vista la entrada y  salida de datos
     */
    public void buscarProducto(){
        view.clear();
        view.addToView(model.describirProducto(view.requestString("Indique el codigo del producto")).toString());
        view.refresh();
    }
    
    /**
     * Añade al almacen varios productos en una sola operación
     */
    public void pedido(){
        if(model.recepcionPedidos(view.requestString("Indique el código del producto"),view.requestEntero("Indique la cantidad de productos que desea añadir al almacen")))
        {
            view.addToView("Pedido registrado correctamente");
        }
        else
        {
            view.addToView("El codigo de producto no existe o la cantidad introducida es menor que 0");
        }
        view.refresh();
    }
}
