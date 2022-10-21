package ptbs;

public abstract class Person {

	public String username;

	public int role;

	public int cat;

	public ClassProductList attachedProducts;

	Person(String name, int role, int cat) {
		this.cat = cat;
		System.out.println("inside ptbs.Person constructor.."+cat);
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

	public abstract Product showMenu() ;

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
