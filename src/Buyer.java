public class Buyer extends Person {

	Buyer(String name, int cat) {
		super(name,0,cat);
	}

	public void showMenu() {
		System.out.println("Calling show menu in Buyer..");
		this.theProductMenu.showMenu();
    }

	public ProductMenu CreateProductMenu() {
		return null;
	}

}
