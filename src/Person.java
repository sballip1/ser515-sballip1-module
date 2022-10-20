public class Person {

	public String username;

	public int role;

	private ClassProductList attachedProducts;

	Person(String name,int role) {
		username = name;
		this.role = role;
		attachedProducts = new ClassProductList();
	}

	public String getUsername(){
		return  username;
	}

	private ProductMenu theProductMenu;

	public void showMenu() {

	}

	/**
	 *  
	 */
	public void showAddButton() {

	}

	public void showViewButton() {

	}

	public void showRadioButton() {

	}

	public void showLabels() {

	}

	public ProductMenu CreateProductMenu() {
		return null;
	}

	public void addProduct(Product product) {
		attachedProducts.add(product);
	}
}
