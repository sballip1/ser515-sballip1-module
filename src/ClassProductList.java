import java.util.ArrayList;
import java.util.Iterator;

public class ClassProductList extends ArrayList<Product> {

	public ClassProductList(){

	}

	@Override
	public Iterator<Product> iterator() {
		return (Iterator<Product>) new ProductIterator(this);
	}

	public void accept(NodeVisitor visitor) {
		System.out.println("Visited Class ProductList. Now iterating visitProduct on the Product list...");
		for(int i = 0;i<this.size();i++) {
			visitor.visitProduct(this.get(i));
		}
	}

}
