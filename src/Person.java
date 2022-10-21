public abstract class Person {

	public String username;

	public int role;

	private ClassProductList attachedProducts;

	Person(String name, int role, int cat) {
		System.out.println("inside Person constructor.."+cat);
		username = name;
		this.role = role;
		attachedProducts = new ClassProductList();
		if(cat==0) theProductMenu = new MeatProductMenu();
		else theProductMenu = new ProduceProductMenu();
	}

	public String getUsername(){
		return  username;
	}

	protected ProductMenu theProductMenu;

	public abstract void showMenu() ;

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

	public abstract ProductMenu CreateProductMenu(Trading trade) ;

	public void addProduct(Product product) {
		attachedProducts.add(product);
	}
}
