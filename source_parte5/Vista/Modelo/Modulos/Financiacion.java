package Modelo.Modulos;

import java.util.*;
import java.io.*;
/**
 * Gestiona las financiaciones de la tienda. Incluye métodos para crear una ficha de financiación, analizar una ficha de financiación
 * y realizar consultas de históricos.
 * 
 * @author Iván Adrio Muñiz 
 * @version 18.04.2018
 */
public class Financiacion
{
    private HashMap<Integer,FichaDeFinanciacion> historialFinanciaciones;
    private Date date;
    private int numeroFicha;
    private String ruta;
    private final String ARCHIVODATOS="/historialFinanciaciones.txt";
    
    /**
     * Crea el historial de devoluciones y fija el archivo en el que se guardará.
     * @param ruta archivo en el que se guardará el historial
     */
    public Financiacion(String ruta)
    {
        historialFinanciaciones = new HashMap<Integer,FichaDeFinanciacion>();
        numeroFicha=0;
        this.ruta=ruta+ARCHIVODATOS;
    }
    
    /**
     * Busca una ficha de financiación usando el número de ficha
     * @param numeroFicha número de ficha de financiación. 
     * @return objeto clase ficha de financiación
     */
    public FichaDeFinanciacion getFicha(int numeroFicha)
    {
        return historialFinanciaciones.get(numeroFicha);
    }
        
    /**
     * Crea una ficha de financiacion
     * @param idcliente numero de identificación del cliente
     * @param idUsuarioActual número de identificación del usuario
     * @param numeroDeFichaDeCompra identificador único de la ficha de compra relacionada
     * @return identificador único de la ficha de financiacion
     */
    public int crearFicha(String idCliente,String idUsuarioActual,int numeroDeFichaDeCompra){
        numeroFicha++;
        date = new Date();
        FichaDeFinanciacion fichaDeFinanciacion = new FichaDeFinanciacion(idCliente,idUsuarioActual,date,numeroFicha,numeroDeFichaDeCompra);
        historialFinanciaciones.put(fichaDeFinanciacion.getNumeroDocumento(),fichaDeFinanciacion);
        return numeroFicha;
    }    
    
    /**
     * Analiza si una ficha de financiación debe aprobarse o no
     * @param numeroFicha número de ficha de financiacion
     * @param nomina sueldo del cliente
     * @param plazo número de meses en los que el cliente quiere financiar la compra
     * @param totalCompra coste total de la compra
     * @return true si la financiación es aprobada
     */
    public boolean analizarFinanciacion(int numeroFicha,double nomina,int plazo, double totalCompra)
    {        
        FichaDeFinanciacion fichaDeFinanciacion=historialFinanciaciones.get(numeroFicha);
        return fichaDeFinanciacion.analiza(totalCompra,nomina,plazo);     
    }
    
    /**
     * Devuelve el historial de financiaciones de un cliente
     * @param idCliente DNI del cliente
     * @return historial de financiaciones de un cliente
     */
    public ArrayList<String> getHistorialCliente(String idCliente)
    {
        ArrayList<String> historial = new ArrayList<String>();
        
        for(HashMap.Entry<Integer,FichaDeFinanciacion> ficha:historialFinanciaciones.entrySet())
        {
           if(ficha.getValue().getIdCliente().equals(idCliente))
           {
               historial.add(ficha.getValue().toString());
            }
        } 
        
        return historial;
    }
    
    /**
     * Comprueba si una ficha de financiación existe
     * @param numeroFicha número de ficha de financiación
     * @return true si la ficha existe
     */
    public boolean getExisteFicha(int numeroFicha)
    {
        if(historialFinanciaciones.get(numeroFicha)==null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }    
    
    /**
     * Indica el número de la última ficha de financiacion
     * @return número de la última ficha de financiación
     */
    public int getNumeroUltimaFicha()
    {
        return numeroFicha;
    }   
    
    /**
     * Guarda el historial de devolucionese en un archivo
     */
    public void escribeArchivo()
    {
      try{
          FileOutputStream file = new FileOutputStream(ruta);
          ObjectOutputStream oos = new ObjectOutputStream(file);
          oos.writeObject(historialFinanciaciones);
          oos.close();
         }catch(IOException e){
             e.printStackTrace();
         }
            
    }
    
    /**
     * Lee el historial de devoluciones guardado previamente en un archivo
     */
    public void leeArchivo()
    {
      File fichero = new File(ruta);
      if(fichero.exists())
      {
          try{
              FileInputStream file = new FileInputStream(fichero);
              ObjectInputStream oos = new ObjectInputStream(file);
              historialFinanciaciones = (HashMap<Integer,FichaDeFinanciacion>) oos.readObject();
              oos.close();
             }catch(Exception e){
                 e.printStackTrace();
             }
      }
      else
      {
          try{
          fichero.createNewFile();
        }catch(IOException e){
            e.printStackTrace();
        }
          escribeArchivo();
          leeArchivo();
      }
    }
}
