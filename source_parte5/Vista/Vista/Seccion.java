package Vista;


import java.util.*;
import java.io.*;
/**
 * Write a description of class Seccion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Seccion implements Component
{
    private String title;
    private ArrayList<Component> components;
    private boolean enabled;
    
    public Seccion(String title){
        this.title=title;
        components=new ArrayList();
        enabled=true;
    }
    
    public void print(){
        System.out.println(getTitle());
        System.out.println("---------------------------------------------------------------------------------------------------------");
        Iterator seccionIterator = components.iterator();
        while(seccionIterator.hasNext()){
            Component comp=(Component) seccionIterator.next();
            comp.print();
        }
    }    
    
    public void add(Component comp){
        components.add(comp);
    }
    
    public void add(String linea){
        components.add( new Linea(linea));
    }
    
    public void remove(Component comp){
        components.remove(comp);
    }
    
    public String getTitle(){
        return title;
    }
    
    public Component getChild(int i){
        return (Component) components.get(i-1);
    }
    
    public String getCommand(int i) throws Exception{
        try{
            String command=getChild(i).toString();
            return command.toLowerCase().substring(5).trim();
        } catch (Exception e){
            throw new Exception("Orden no valida");
        }
    }    
    
    public void enable(){
        enabled=true;
    }
    
    public void disable(){
        enabled=false;
    }

}
