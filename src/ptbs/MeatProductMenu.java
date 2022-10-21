package ptbs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MeatProductMenu implements ProductMenu {

	MeatProductMenu(){
		System.out.println("Initialised Meat product Menu..");
	}

	@Override
	public ArrayList<String> showMenu() {
		System.out.println("Inside person Meat show menu..");
		ArrayList<String> ps = new ArrayList<String>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("src//ProductInfo.txt"));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		String line;
		System.out.println("Meat menu :");
		while(true)
		{
			try {
				if (!((line = br.readLine())!=null)) break;
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			String [] prod = line.split(":");
			if(prod[0].equalsIgnoreCase("Meat")) {
				ps.add(prod[1]);
				//System.out.println(prod[1]);
			}
		}
		return ps;
    }

	public void showAddButton() {

	}

	public void showViewButton() {

	}

	public void showRadioButton() {

	}

	public void showLabels() {

	}

	public void showComboxes() {

	}

}
