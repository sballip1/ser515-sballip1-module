import java.util.ArrayList;

public class ClassProductList extends ArrayList<Product> {

	public ClassProductList(){

	}

	private ProductIterator productIterator;

	public void accept(NodeVisitor visitor) {
		System.out.println("Visited Class ProductList. Now iterating visitProduct on the Product list...");
		for(int i = 0;i<this.size();i++) {
			visitor.visitProduct(this.get(i));
		}
	}

}
