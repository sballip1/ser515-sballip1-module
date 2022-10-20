public class Product {

    public String name;

    Product(String name) {
        System.out.println("Adding product : "+name+ "to the system");
        this.name = name;
    }
    public void accept(NodeVisitor visitor) {
        //print accept in product
        visitor.visitProduct(this);
    }

}
