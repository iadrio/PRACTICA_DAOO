package Vista;


/**
 * Define las opciones que debe tener un componente de la vista.
 * 
 * @author Iván Adrio Muñiz 
 * @version 2019.03.31
 */
public interface Component
{
    public void print();
    
    public void add(Component comp);
    
    public void remove(Component comp);    
    
    public void enable();
    
    public void disable();

    public String getTitle();
    
    public Component getChild(int i);
}
