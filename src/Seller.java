public class Seller extends Person {

	Seller(String name, int cat) {
		super(name,1, cat);
	}

	public void showMenu() {
		System.out.println("Inside Seller's show menu...");
		this.theProductMenu.showMenu();
    }

	public ProductMenu CreateProductMenu() {
		return null;
	}

}
