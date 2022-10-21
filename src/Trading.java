import java.io.*;

public class Trading {

	private OfferingList offers;

	private Product product;

	private int userType;

	private boolean isAContemporary(String userProd) {
		BufferedReader br = null;
		String path = null;
		if(this.userType==0)
			path = "C://Users//sballip1//Documents//Fall '22//515//assignDP.sballip1//src//SellerInfo.txt";
		else
			path = "C://Users//sballip1//Documents//Fall '22//515//assignDP.sballip1//src//BuyerInfo.txt";
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
		System.out.println("populating trading info...");
		this.product = theSelectedProduct;
		this.userType = userType;
		offers = new OfferingList();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("C://Users//sballip1//Documents//Fall '22//515//assignDP.sballip1//src//UserProduct.txt"));
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
		OfferingIterator iterator = (OfferingIterator) offers.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next().username);
		}
	}

	public void addTrading(Person thePerson, Product theSelectedProduct){
		System.out.println("Adding a trade..");
		FileWriter fw = null;
		try {
			fw = new FileWriter("C://Users//sballip1//Documents//Fall '22//515//assignDP.sballip1//src//UserProduct.txt", true);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		BufferedWriter bw = new BufferedWriter(fw);
		try {
			System.out.println(thePerson.username+":"+theSelectedProduct.name);
			bw.write(thePerson.username+":"+theSelectedProduct.name);
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
		System.out.println("Visited Trading...");
		visitor.visitTrading(this);
	}

}
