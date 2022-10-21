import java.io.*;

/**
 * The interface class between the GUI and the underlining system, the
 * control logic and many of the operating functions are included in this class
 */
public class PTBSFacade {

    PTBSFacade(){
        theProductList = new ClassProductList();
        createProductList();
    }

    /**
     * The type of the user.
     * Buyer: 0, Seller 1
     */
    private int UserType;

    private String username;


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

    private Trading trade;

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
        loginHelper.waitForCreds();
        if(loginHelper.getValidity()) {
            UserType = loginHelper.getRole();
        }
        return loginHelper.getValidity();
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
        trade.addTrading(thePerson,theSelectedProduct);
        /*System.out.println("Adding a trade..");
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
*/
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
        trade.viewTrading();
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
     * @param userinfoitem
     * @param
     */
    public void createUser(UserInformation userinfoitem) {
        System.out.println("creating user.." + userinfoitem.getName());
        if(this.UserType == 0) {
            thePerson = new Buyer(userinfoitem.getName(),nProductCategory);
        }
        else thePerson = new Seller(userinfoitem.getName(),nProductCategory);
    }

    public void createProductList() {
        theProductList = new ClassProductList();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C://Users//sballip1//Documents//Fall '22//515//assignDP.sballip1//src//ProductInfo.txt"));
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
            String [] prod = line.split(":");
            theProductList.add(new Product(prod[1],(prod[0].equalsIgnoreCase("meat"))?0:1));
        }
    }

    public void AttachProductToUser() {
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
            if(userProds.equals(this.thePerson.getUsername())) {
                if(matchProdName(userProds[1]))
                    thePerson.addProduct(new Product(userProds[1],(userProds[0].equalsIgnoreCase("meat"))?0:1));
            }
        }
    }

    private boolean matchProdName(String userProd) {
        for(Product p:theProductList) {
            if(userProd.equalsIgnoreCase(p.name)) return true;
            if(userProd.equalsIgnoreCase(p.name)) return true;
        }
        return false;
    }

    public Product SelectProduct() {
        System.out.println("Select a product :");
        thePerson.showMenu();
        return new Product("Onion",nProductCategory);
    }

    public void productOperation() {

    }

    public void startapp() {
        System.out.println("Select type");
        nProductCategory = 0;
        createUser(new UserInformation(loginHelper.username,UserType));
        AttachProductToUser();
        theSelectedProduct = SelectProduct();
        fetchTrades();
        trade = new Trading(theSelectedProduct,UserType);
        viewTrading();
        addTrading();
    }

    private void fetchTrades() {
        trade = new Trading(theSelectedProduct,UserType);
    }

    public void accept(NodeVisitor visitor) {
        System.out.println("Visited Facade...");
        visitor.visitFacade(this);
    }
}
