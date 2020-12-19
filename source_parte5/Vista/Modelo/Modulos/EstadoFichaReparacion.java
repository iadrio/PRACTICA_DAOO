package Modelo.Modulos;

/**
 * Interfaz que define los métodos que debe implementar cada uno de los estados.
 * 
 * @author Ivan Adrio Muñiz 
 * @version 31.03.2019
 */
public interface EstadoFichaReparacion
{
    public String toString();
    public String getEstado();
    public void completar();
}
