public abstract class ProductFactory {
    public abstract Product createDigital(String id, String name,double price, double size) ;
    public abstract Product createPhysical(String id, String name,double price, double weight) ;
}