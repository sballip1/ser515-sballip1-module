public class Seller extends Person {

	Seller(String name, int cat) {
		super(name,1, cat);
	}

	public void showMenu() {
		System.out.println("Inside Seller's show menu...");
		this.theProductMenu.showMenu();
    }

	public ProductMenu CreateProductMenu(Trading trade) {
		System.out.println("Creating product menu for Seller..");
		trade.addTrading(this);
		return null;
	}

}
