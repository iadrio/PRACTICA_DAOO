package Modelo.Modulos;


/**
 * Interfaz que define a un sujeto. Son las clases que serán observadas.
 * 
 * @author Iván Adrio Muñiz 
 * @version 31.03.2019
 */
public interface Sujeto
{
    public void addObserver(Observador obs);    
    public void removeObserver(Observador obs);    
    public void notifyObservers();
}
