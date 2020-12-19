package Modelo.Almacen;

/**
 * Clase de prueba del método factoría
 * 
 * @author Ivan Adrio Muñiz 
 * @version 2019.03.31
 */
public class Test {

    public static void main(String[] args) {
        ConcreteFactory factory=new ConcreteFactory();
        System.out.println("Creamos una tv y le añadimos características");
        try{
            Electrodomestico tv=factory.factoryMethod("tv","00001","samsung","modelo","rojo",100,10);
            tv.addCaracteristica("100 pugadas");
            tv.addCaracteristica("panel led");
            tv.addCaracteristica("full hd");
            tv.addCaracteristica("conexión wifi");
            tv.addCaracteristica("android TV");
            tv.addCaracteristica("200hz de frecuencia");
            System.out.println(tv.toString());
        }catch(Exception e){
            System.out.println(e);
        }              
    }

}
