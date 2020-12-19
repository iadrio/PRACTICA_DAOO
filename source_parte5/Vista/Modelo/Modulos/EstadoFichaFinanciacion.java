package Modelo.Modulos;


/**
 * Interfaz que define los métodos que debe implementar cada uno de los estados.
 * 
 * @author Ivan Adrio Muñiz 
 * @version 31.03.2019
 */

public interface EstadoFichaFinanciacion 
{
    public boolean analiza(double nomina,int plazo,double totalCompra);   
    public String toString();
    public String getEstado();
}

