public class Buyer extends Person {

	Buyer(String name, int cat) {
		super(name,0,cat);
	}

	public void showMenu() {
		System.out.println("Calling show menu in Buyer..");
		this.theProductMenu.showMenu();
    }

	public ProductMenu CreateProductMenu(Trading trade) {
		System.out.println("Creating product menu for Buyer..");
		trade.addTrading(this);
		return null;
	}

}
