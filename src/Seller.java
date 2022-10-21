import java.util.ArrayList;

public class Seller extends Person {

	Seller(String name, int cat) {
		super(name,1, cat);
	}

	public Product showMenu() {
		System.out.println("Calling show menu in Seller..");
		ArrayList<String> list = this.theProductMenu.showMenu();
		System.out.println(list.get(0));
		GUIHelper gu = new GUIHelper();
		gu.populateRadioButtons(list,"Seller");
		gu.waitForPlay();
		return new Product(gu.productName,this.cat);
    }

	public ProductMenu CreateProductMenu(Trading trade) {
		System.out.println("Creating product menu for Seller..");
		trade.addTrading(this);
		return null;
	}

}
