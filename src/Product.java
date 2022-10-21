public class Product {

    public String name;

    public Trading trade;

    public int type;

    Product(String name,int type) {
        this.name = name;
    }
    public void accept(NodeVisitor visitor) {
        //print accept in product
        visitor.visitProduct(this);
    }

}
