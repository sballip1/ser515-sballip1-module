package ptbs;

import java.io.*;
import java.util.ArrayList;

public class Trading {

	private OfferingList offers;

	private Product product;

	private int userType;

	private boolean isAContemporary(String userProd) {
		BufferedReader br = null;
		String path = null;
		if(this.userType==0)
			path = "src//SellerInfo.txt";
		else
			path = "src//BuyerInfo.txt";
		try {
			br = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		String line;
		while(true)
		{
			try {
				if (!((line = br.readLine())!=null)) break;
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			String [] user_auth = line.split(":");
			if(userProd.equalsIgnoreCase(user_auth[0])) return true;
		}
		return false;
	}

	public Trading(Product theSelectedProduct, int userType) {
		this.product = theSelectedProduct;
		this.userType = userType;
		offers = new OfferingList();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("src//UserProduct.txt"));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		String line;
		while(true)
		{
			try {
				if (!((line = br.readLine())!=null)) break;
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			String [] userProds = line.split(":");
			if(userProds[1].equals(theSelectedProduct.name)) {
				if(isAContemporary(userProds[0])){
					offers.add(new Offering(userProds[0],theSelectedProduct.name));
				}
			}
		}
	}

	public void viewTrading(){
		System.out.println("viewing trading info..");
		ArrayList<String> stakeholders = new ArrayList<String>();
		System.out.println("------------------Fetching offers using iterator pattern------------------");
		OfferingIterator iterator = (OfferingIterator) offers.iterator();
		while(iterator.hasNext()) {
			stakeholders.add(iterator.next().username);
		}
		GUIHelper gu = new GUIHelper();
		gu.populateRadioButtons2(stakeholders,(userType==0)?"List of Sellers":"List of Buyers");
		gu.waitForPlay();
	}

	public void addTrading(Person thePerson){
		System.out.println("Adding a trade..");
		FileWriter fw = null;
		try {
			fw = new FileWriter("src//UserProduct.txt", true);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		BufferedWriter bw = new BufferedWriter(fw);
		try {
			System.out.println(thePerson.username+":"+product.name);
			bw.write(thePerson.username+":"+product.name);
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 *  
	 */
	public void accept(NodeVisitor visitor) {
		System.out.println("Visited ptTrading...");
		visitor.visitTrading(this);
	}

}
