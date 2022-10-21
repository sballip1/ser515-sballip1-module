import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MeatProductMenu implements ProductMenu {

	MeatProductMenu(){
		System.out.println("Initialised Meat product Menu..");
	}

	@Override
	public void showMenu() {
		System.out.println("Inside person Produce show menu..");
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
				System.out.println(prod[1]);
			}
		}
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
