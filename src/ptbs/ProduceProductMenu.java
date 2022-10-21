package ptbs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProduceProductMenu implements ProductMenu {

	ProduceProductMenu(){
		System.out.println("Initialised Produce product Menu..");
	}

	public ArrayList<String> showMenu() {
		System.out.println("Inside person Produce show menu..");
		ArrayList<String> ps = new ArrayList<String>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("src//ProductInfo.txt"));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		String line;
		System.out.println("Produce menu :");
		while(true)
		{
			try {
				if (!((line = br.readLine())!=null)) break;
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			String [] prod = line.split(":");
			if(prod[0].equalsIgnoreCase("Produce")) {
				ps.add(prod[1]);
				//System.out.println(prod[1]);
			}
		}
		return ps;
	}

	public void showAddButton() {

	}

	public void showRadioButton() {

	}

	public void showLabels() {

	}

	public void showViewButton() {

	}

	public void showComboxes() {

	}

}
