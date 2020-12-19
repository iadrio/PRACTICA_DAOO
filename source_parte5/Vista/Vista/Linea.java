package Vista;


/**
 * Crea un objecto del tipo linea, que será una sección con una sola linea
 * 
 * @author Iván Adrio Muñiz 
 * @version 2019.03.31
 */
public class Linea implements Component
{
    private String contenido;
    private boolean enabled;
    
    /**
     * Almacena un string en una linea
     * @param contenido string a almacenar
     */
    public Linea (String contenido){
        this.contenido=contenido;
        enabled=true;
    }
    
    /**
     * Imprime en pantalla la linea
     */
    public void print(){
        System.out.println(contenido);
    }
    
    /**
     * No hace nada
     */
    public void add(Component comp){
    }
    
    /**
     * No hace nada
     */
    public void remove(Component comp){
    }

    /**
     * Devuelve el contenido de la linea
     */
    public String getTitle(){
        return contenido;
    }      
    
    /**
     * Devuelve la propia linea. Una linea no tiene hijos
     */
    public Component getChild(int i){
        return this;
    }
    
    public void enable(){
        enabled=true;
    }
    
    public void disable(){
        enabled=false;
    }
    
    /**
     * Devuelve el contenido en un string
     * @return contenido
     */
    public String toString(){
        return contenido;
    }
}
