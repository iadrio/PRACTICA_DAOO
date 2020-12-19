
/**
 * Controlador que se activa cuando la vista muestra el menu de gestión de usuarios
 * @author Iván Adrio Muñiz
 * @version 2018.04.17
 */
public class ControllerGestionUsuarios implements Controlador
{
    private View view;   
    private SistemaGestion model;
    
    /**
     * Crea un controlador para un modelo y un vista dada
     * @param view vista que será la encargada de interactuar con el usuario
     * @param model modelo que contendrá la implementación de las funciones instanciadas por la vista
     */
    public ControllerGestionUsuarios(View view,SistemaGestion model){
        this.model=model;
        this.view=view;
    }
    
    /**
     * Gestiona los eventos que se producen en la vista
     * @param command orden que debe gestionar el controlaor
     */
    public void receiveCommand(String command) throws Exception{
        if(command.equals("añadir empleado")){
            añadirEmpleado();
        }else if(command.equals("añadir cliente")){
            añadirCliente();
        }else if(command.equals("quitar cliente")){
            quitarCliente();
        }else if(command.equals("lista de empleados")){
            listaEmpleados();
        }else if(command.equals("lista de clientes")){
            listaClientes();
        }else if(command.equals("ver ficha de empleado")){
            fichaEmpleado();
        }else if(command.equals("ver ficha de cliente")){
            fichaCliente();
        }else if(command.equals("buscar empleado por nombre")){
            buscarEmpleado();
        }else if(command.equals("buscar cliente por nombre")){
            buscarCliente();
        }else if(command.equals("añadir permisos a usuario")){
            añadirPermisos();
        }else if(command.equals("retirar permisos a usuario")){
            retirarPermisos();
        }else if(command.equals("modificar cliente")){
           modificarCliente();        
        }else if(command.equals("modificar empleado")){
            modificarEmpleado();
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
     * Pide al modelo que añada un cliente y gestiona con la vista la entrada de datos
     */
    public void añadirCliente(){
        String nombre=view.requestString("Introduzca el nombre del usuario");
        String apellidos=view.requestString("Introduzca los apellidos del usuario");
        String correoElectronico=view.requestString("Introduzca el correo electronico del usuario");
        String telefono=view.requestString("Introduzca el numero de telefono del usuario");
        String identificacion=view.requestString("Introduzca el DNI. Se usara como identifificador");
        
        
        if(identificacion.equals("")){
            view.addToView("El codigo de cliente no es correcto");
        }else if(model.añadirCliente(identificacion,nombre,apellidos,correoElectronico,telefono))
        {
            view.addToView("Cliente añadido correctamente");
        }
        else
        {
            view.addToView("El cliente ya existe");   
        }            
        view.refresh();
    }
    
    /**
     * Pide al modelo que busque un empleado y gestiona con la vista la entrada y salida de datos
     */
    public void buscarEmpleado(){
        String identificacion=view.requestString("Escriba el nombre del empleado/s");
        view.addToView("LISTA DE COINCIDENCIAS");
        view.addToView(model.getEmpleadoNombre(identificacion));
        view.refresh();
    }
    
    /**
     * Pide al modelo que busque un cliente y gestiona con la vista la entrada y salida de datos
     */
    public void buscarCliente(){
        String identificacion=view.requestString("Escriba el nombre del cliente/s");
        view.addToView("LISTA DE COINCIDENCIAS");
        view.addToView(model.getClienteNombre(identificacion));
        view.refresh();
    }
    
    /**
     * Pide al modelo que añada permisos a un empleado y gestiona con la vista la entrada y salida de datos
     */
    public void añadirPermisos(){
        String identificacion = view.requestString("Introducza el codigo de empleado");
        String permiso= view.requestString("Escriba el permiso a añadir: "+ model.getPermisosEmpleadoValidos());
        
        if(model.añadirPermiso(identificacion,permiso))
        {
            view.addToView("El cambio se hara efectivo en el siguiente login");    
        }
        else
        {
            view.addToView("Los datos introducidos no son correctos"); 
        }
        view.refresh();
    }
    
    /**
     * Pide al modelo que retire permisos a un empleado y gestiona con la vista la entrada y salida de datos
     */
    public void retirarPermisos(){
        String identificacion = view.requestString("Introducza el codigo de empleado");
        String permiso= view.requestString("Escriba el permiso a retirar: "+ model.getPermisosEmpleadoValidos());
        if(model.quitarPermiso(identificacion,permiso))
        {
            view.addToView("El cambio se hara efectivo en el siguiente login");    
        }
        else
        {
            view.addToView("Los datos introducidos no son corrrectos"); 
        }
        view.refresh();
    }
    
    /**
     * Pide al modelo que modique los datos de un cliente y gestiona con la vista la entrada y salida de datos
     */
    public void modificarCliente(){
        String identificacion,nombre,apellidos,correoElectronico,telefono;
        identificacion = view.requestString("Introducza el codigo de cliente");
        nombre = view.requestString("Introduzca el nuevo nombre del cliente");
        apellidos = view.requestString("Introduzca los nuevos apellidos del cliente");
        correoElectronico = view.requestString("Introduzca el nuevo correo del cliente");
        telefono = view.requestString("Introduzca el nuevo telefono del cliente");
        
        if(model.modificarCliente(identificacion,nombre,apellidos,correoElectronico,telefono))
        {
            view.addToView("Cliente modificado correctamente");
        }
        else
        {
            view.addToView("El cliente no existe");
        }                        
        view.refresh();
    }
    
    /**
     * Pide al modelo que añada un empleado y gestiona con la vista la entrada y salida de datos
     */
    public void añadirEmpleado(){
        String nombre=view.requestString("Introduzca el nombre del usuario");
        String apellidos=view.requestString("Introduzca los apellidos del usuario");
        String correoElectronico=view.requestString("Introduzca el correo electronico del usuario");
        String telefono=view.requestString("Introduzca el numero de telefono del usuario");
        String identificacion=view.requestString("Introduzca el DNI. Se usara como identifificador");
        String rol=new String();
        String clave =new String();
        boolean valido =false;
        while(!valido){
            rol=view.requestString("Indique el rol del empleado: "+model.listaRolesEmpleado());
            if(model.comprobarRolEmpleadoValido(rol)){
                valido=true;
            }
            else{
                view.addToView("El rol no es valido");
                view.refresh();
            }
        }
        
        valido=false;
        while(!valido){
            clave=view.requestString("Introduzca su clave. Debera recordarla para acceder al sistema. Debe contener "+model.longitudClaveEmpleado()+" digitos");
            if(clave.length()==model.longitudClaveEmpleado()){
                valido=true;
            }
            else{   
                view.clear();
                view.addToView("Longitud de clave no valida, debe contener "+model.longitudClaveEmpleado()+" digitos");
                view.refresh();
            }
        }
        
        if(model.añadirEmpleado(identificacion,nombre,apellidos,correoElectronico,telefono,clave,rol))
        {
            view.addToView("Empleado añadido correctamente");
        }
        else
        {
            view.addToView("El empleado ya existe");   
        }
        
        view.refresh();
    }
    
    /**
     * Pide al modelo que elimine un cliente y gestiona con la vista la entrada y salida de datos
     */
    public void quitarCliente(){
        if(model.quitarCliente(view.requestString("Introduzca el DNI del cliente"))){
            view.addToView("El cliente se ha eliminado correctamente");
        }else{
            view.addToView("El cliente no existe");
        }
        view.refresh();
    }
    
    /**
     * Pide al modelo que muestre la lista de clientes y gestiona con la vista la entrada y salida de datos
     */
    public void listaClientes(){
        view.addToView("LISTA DE CLIENTES");
        view.addToView(model.getListaClientes());
        view.refresh();
    }
    
    /**
     * Pide al modelo que muestre la lista de empleados y gestiona con la vista la entrada y salida de datos
     */
    public void listaEmpleados(){
        System.out.println("llega");
        view.addToView("LISTA DE EMPLEADOS");
        view.addToView(model.getListaEmpleados());
        view.refresh();
    }
    
    /**
     * Pide al modelo que muestre una ficha de empleado y gestiona con la vista la entrada y salida de datos
     */
    public void fichaEmpleado(){
        view.addToView("DATOS DEL EMPLEADO");
        view.addToView(model.describeEmpleado(view.requestString("Introduzca el codigo de empleado")));
        view.refresh();
    }
    
    /**
     * Pide al modelo que muestre una ficha de cliente y gestiona con la vista la entrada y salida de datos
     */
    public void fichaCliente(){
        String identificacion = view.requestString("Introduzca el codigo de cliente");
        view.addToView("DATOS DEL CLIENTE");
        view.addToView(model.describeEmpleado(identificacion));
        view.addToView("HISTORIAL DEL CLIENTE");
        view.addToView(model.getHistorialCliente(identificacion));
        view.refresh();
    }
    
    /**
     * Pide al modelo que modifique una ficha de empleado y gestiona con la vista la entrada y salida de datos
     */
    public void modificarEmpleado()
    {
        String identificacion,clave,rol,nombre,apellidos,correoElectronico,telefono;
        clave=null;
        rol=null;
        identificacion = view.requestString("Introducza el codigo de empleado");
        boolean valido = false;
        while(!valido)
        {
            rol=view.requestString("Indique el rol del empleado: "+model.listaRolesEmpleado());
            if(model.comprobarRolEmpleadoValido(rol))
            {
                valido=true;
            }
            else
            {
                view.addToView("El rol no es valido");
            }
        }
        valido=false;
        while(!valido)
            {
            clave=view.requestString("Introduzca la nueva clave");
            if(clave.length()==model.longitudClaveEmpleado())
            {
                valido=true;
            }
            else
            {
                view.addToView("Longitud de clave no valida, debe contener "+model.longitudClaveEmpleado()+" digitos");
            }
        }
        
        nombre=view.requestString("Indique el nombre del empleado");
        apellidos=view.requestString("Introduzca los apellidos del empleado");
        correoElectronico=view.requestString("Introduzca el correo electrónico");
        telefono=view.requestString("Introduzcal el número de telefono");            
    
        if(model.modificarEmpleado(identificacion,nombre,apellidos,correoElectronico,telefono,clave,rol))
        {
            view.addToView("Empleado modificado correctamente");
        }
        else
        {
            view.addToView("El empleado no existe");
        }
        view.refresh();
    }
}
