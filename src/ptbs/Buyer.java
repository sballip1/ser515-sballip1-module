package ptbs;
import java.util.ArrayList;


public class Buyer extends Person {

	Buyer(String name, int cat) {
		super(name,0,cat);
	}

	public Product showMenu() {
		System.out.println("Calling show menu in Buyer..");
		ArrayList<String> list = this.theProductMenu.showMenu();
		System.out.println(list.get(0));
		GUIHelper gu = new GUIHelper();
		gu.populateRadioButtons(list,"Buyer");
		gu.waitForPlay();
		return new Product(gu.productName,this.cat);
    }

	public ProductMenu CreateProductMenu(Trading trade) {
		System.out.println("Creating product menu for Buyer..");
		trade.addTrading(this);
		return null;
	}

}
