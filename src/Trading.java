public class Trading {



	/**
	 *  
	 */
	public void accept(NodeVisitor visitor) {
		System.out.println("Visited Trading...");
		visitor.visitTrading(this);
	}

}
