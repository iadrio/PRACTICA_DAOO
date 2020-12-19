import java.util.*;
/**
 * Interfaz que define a un sujeto. Son las clases que serán observadas.
 * 
 * @author Iván Adrio Muñiz 
 * @version 31.03.2019
 */
public interface Sujeto
{
    public void addObserver(Observador obs,List<Observador> lista);    
    public void removeObserver(Observador obs,List<Observador> lista);    
    public void notifyObservers(List<Observador> obs); //se modifica el método notify observers para poder adaptarlo a la existencia de diferentes listas de observadores, según la parte de la apl                                                       //icacion que se esté modificando
}
