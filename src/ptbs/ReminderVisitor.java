package ptbs;

public class ReminderVisitor extends NodeVisitor {

	private Reminder m_Reminder;

	public void visitProduct(Product product) {
		System.out.println("......Visiting Product via visitor design pattern on product "+product.name);
	}

	public void visitTrading(Trading trading) {
		System.out.println("......Visiting trading via visitor design pattern....");
	}

	public void visitFacade(PTBSFacade facade) {
		System.out.println("......Visiting Facade via visitor design pattern....");
		facade.theProductList.accept(this);
		facade.trade.accept(this);
	}

}
