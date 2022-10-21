import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ProduceProductMenu implements ProductMenu {

	ProduceProductMenu(){
		System.out.println("Initialised Produce product Menu..");
	}

	public void showMenu() {
		System.out.println("Inside person Produce show menu..");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("C://Users//sballip1//Documents//Fall '22//515//assignDP.sballip1//src//ProductInfo.txt"));
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
				System.out.println(prod[1]);
			}
		}
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
