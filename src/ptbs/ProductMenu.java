package ptbs;

import java.util.ArrayList;

public interface ProductMenu {

	public abstract ArrayList<String> showMenu();

	/**
	 *  
	 */
	public abstract void showAddButton();

	public abstract void showViewButton();

	public abstract void showRadioButton();

	public abstract void showLabels();

	public abstract void showComboxes();

}
