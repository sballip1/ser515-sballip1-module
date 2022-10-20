import java.io.IOException;

/**
 * The interface class between the GUI and the underlining system, the
 * control logic and many of the operating functions are included in this class
 */
public class PTBSFacade {

    /**
     * The type of the user.
     * Buyer: 0, Seller 1
     */
    private int UserType;


    /**
     * The object that holds the currently selected product.
     */
    private Product theSelectedProduct;

    /**
     * The selected product category: 0: Meat, 1: Produce
     */
    private int nProductCategory;

    /**
     * The list of products of the entire system
     */
    private ClassProductList theProductList;

    /**
     * The current user
     */
    private Person thePerson;

    private Login loginHelper;

    /**
     * Show login GUI and return the login result.
     * @return boolean
     */
    public boolean login() throws IOException {
        loginHelper = new Login();
        return true;
    }

    /**
     * When clicking the add button of the ProductMenu, call this
     * function. This function will add a new trade and fill in the
     * required information. This function will be called
     * SellerTradingMenu or BuyerTradingMenu based on the type of
     * the user. It will not update the product menu. The product menu
     * needs to be refreshed outside the function
     */
    public void addTrading() {

    }

    /**
     * When clicking the view button of the ProductMenu, call this
     * function and pass the pointer of the Trading and the person
     * pointer to this function.
     * This function will view the trading information.
     * This function will call SellerTradingMenu or BuyerTradingMenu
     * according to the type of the user.
     */
    public void viewTrading() {

    }

    /**
     * This function will view the given offering
     */
    public void decideBidding() {

    }

    /**
     * Set the deal flag of the given offering.
     */
    public void discussBidding() {

    }

    public void submitBidding() {

    }

    public void remind() {

    }

    /**
     *
     * @param userinfoitem
     */
    public void createUser(UserInfoItem userinfoitem) {

    }

    public void createProductList() {

    }

    public void AttachProductToUser() {

    }

    public Product SelectProduct() {
        return null;
    }

    public void productOperation() {

    }

    public boolean startApp() {
        loginHelper.waitForCreds();
        return loginHelper.getValidity();
    }
}
