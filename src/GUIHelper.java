
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class GUIHelper extends JFrame {

    public int menuType;

    static final Object lock = new Object();
    public int choice;

    ArrayList<JRadioButton> buttons;

    // Declaration of object of JRadioButton class.
    JRadioButton jRadioButton1;

    // Declaration of object of JRadioButton class.
    JRadioButton jRadioButton2;

    // Declaration of object of JButton class.
    JButton jButton;

    // Declaration of object of ButtonGroup class.
    ButtonGroup G1;

    // Declaration of object of  JLabel  class.
    JLabel L1;

    public String productName;

    public void populateRadioButtonsM(int type)
    {

        // Setting layout as null of JFrame.
        this.setLayout(null);

        // Initialization of object of "JRadioButton" class.
        jRadioButton1 = new JRadioButton();

        // Initialization of object of "JRadioButton" class.
        jRadioButton2 = new JRadioButton();

        // Initialization of object of "JButton" class.
        jButton = new JButton("Click");

        // Initialization of object of "ButtonGroup" class.
        G1 = new ButtonGroup();

        // Initialization of object of " JLabel" class.
        L1 = new JLabel("Select an option");

        // setText(...) function is used to set text of radio button.
        // Setting text of "jRadioButton2".
        jRadioButton1.setText((type==1)?"Open auction for this product":"Bid for this product");

        // Setting text of "jRadioButton4".
        jRadioButton2.setText((type==1)?"View buyers for this product":"View on sellers for this product");

        // Setting Bounds of "jRadioButton2".
        jRadioButton1.setBounds(120, 30, 500, 50);

        // Setting Bounds of "jRadioButton4".
        jRadioButton2.setBounds(120, 80, 500, 50);

        // Setting Bounds of "jButton".
        jButton.setBounds(125, 140, 80, 30);

        // Setting Bounds of JLabel "L2".
        L1.setBounds(20, 30, 150, 50);

        // "this" keyword in java refers to current object.
        // Adding "jRadioButton2" on JFrame.
        this.add(jRadioButton1);

        // Adding "jRadioButton4" on JFrame.
        this.add(jRadioButton2);

        // Adding "jButton" on JFrame.
        this.add(jButton);

        // Adding JLabel "L2" on JFrame.
        this.add(L1);

        // Adding "jRadioButton1" and "jRadioButton3" in a Button Group "G2".
        G1.add(jRadioButton1);
        G1.add(jRadioButton2);

        this.setBounds(100, 100, 400, 300);

        // Setting Title of frame.
        this.setTitle((type==0)?"Buyer":"Seller" + "menu");

        // Setting Visible status of frame as true.
        this.setVisible(true);

        // Adding Listener to JButton.
        jButton.addActionListener(new ActionListener() {

            // Anonymous class.

            public void actionPerformed(ActionEvent e)
            {
                // Override Method

                // Declaration of String class Objects.
                String qual = " ";

                // If condition to check if jRadioButton2 is selected.
                if (jRadioButton1.isSelected()) {
                    choice = 0;
                }

                else if (jRadioButton2.isSelected()) {

                    choice = 1;
                }
                else {

                    qual = "NO Button selected";
                }

                System.out.println(qual);
                synchronized (lock) {
                    lock.notify();
                }

            }
        });
    }

    // Constructor of Demo class.
    public void populateRadioButtons(int buy)
    {

        // Setting layout as null of JFrame.
        this.setLayout(null);

        // Initialization of object of "JRadioButton" class.
        jRadioButton1 = new JRadioButton();

        // Initialization of object of "JRadioButton" class.
        jRadioButton2 = new JRadioButton();

        // Initialization of object of "JButton" class.
        jButton = new JButton("Click");

        // Initialization of object of "ButtonGroup" class.
        G1 = new ButtonGroup();

        // Initialization of object of " JLabel" class.
        L1 = new JLabel("Menu type");

        // setText(...) function is used to set text of radio button.
        // Setting text of "jRadioButton2".
        jRadioButton1.setText("Meat");

        // Setting text of "jRadioButton4".
        jRadioButton2.setText("Produce");

        // Setting Bounds of "jRadioButton2".
        jRadioButton1.setBounds(120, 30, 120, 50);

        // Setting Bounds of "jRadioButton4".
        jRadioButton2.setBounds(250, 30, 80, 50);

        // Setting Bounds of "jButton".
        jButton.setBounds(125, 90, 80, 30);

        // Setting Bounds of JLabel "L2".
        L1.setBounds(20, 30, 150, 50);

        // "this" keyword in java refers to current object.
        // Adding "jRadioButton2" on JFrame.
        this.add(jRadioButton1);

        // Adding "jRadioButton4" on JFrame.
        this.add(jRadioButton2);

        // Adding "jButton" on JFrame.
        this.add(jButton);

        // Adding JLabel "L2" on JFrame.
        this.add(L1);

        // Adding "jRadioButton1" and "jRadioButton3" in a Button Group "G2".
        G1.add(jRadioButton1);
        G1.add(jRadioButton2);

        this.setBounds(100, 100, 400, 200);

        // Setting Title of frame.
        this.setTitle((buy==0)?"Buyer":"Seller" + "menu");

        // Setting Visible status of frame as true.
        this.setVisible(true);

        // Adding Listener to JButton.
        jButton.addActionListener(new ActionListener() {

            // Anonymous class.

            public void actionPerformed(ActionEvent e)
            {
                // Override Method

                // Declaration of String class Objects.
                String qual = " ";

                // If condition to check if jRadioButton2 is selected.
                if (jRadioButton1.isSelected()) {
                    menuType = 0;
                }

                else if (jRadioButton2.isSelected()) {

                    menuType = 1;
                }
                else {

                    qual = "NO Button selected";
                }

                System.out.println(qual);
                synchronized (lock) {
                    lock.notify();
                }

            }
        });
    }

    public void populateRadioButtons2(ArrayList<String> list, String buyer) {
        System.out.println("Populating radio buttons..");
        buttons = new ArrayList<JRadioButton>();
        ArrayList<String> values = new ArrayList<String>();
        // Setting layout as null of JFrame.
        this.setLayout(null);


        // Initialization of object of "JButton" class.
        jButton = new JButton("Negotiate");

        // Initialization of object of "ButtonGroup" class.
        G1 = new ButtonGroup();

        // Initialization of object of " JLabel" class.
        L1 = new JLabel("list" );
        int x = 120, y = 120;
        for (String s : list) {
            System.out.println(s);
            JRadioButton but = new JRadioButton();
            but.setText(s);
            but.setBounds(30, 30, 120, 50);
            x += y;
            values.add(s);
            this.add(but);
            G1.add(but);
            buttons.add(but);
        }

        // Setting Bounds of "jButton".
        jButton.setBounds(125, 90, 80, 30);

        // Setting Bounds of JLabel "L2".
        L1.setBounds(20, 30, 150, 50);


        // Adding "jButton" on JFrame.
        this.add(jButton);

        // Adding JLabel "L2" on JFrame.
        this.add(L1);


        this.setBounds(100, 100, x + 100, 200);

        // Setting Title of frame.
        this.setTitle("MENU EXCLUSIVE FOR " + buyer);

        // Setting Visible status of frame as true.
        this.setVisible(true);

        // Adding Listener to JButton.
        jButton.addActionListener(new ActionListener() {

            // Anonymous class.

            public void actionPerformed(ActionEvent e) {
                // Override Method

                // Declaration of String class Objects.
                String qual = " ";

                // If condition to check if jRadioButton2 is selected.
                int i = 0;
                for (JRadioButton but : buttons) {
                    if (but.isSelected()) {
                        productName = values.get(i);
                    }
                    i++;
                }

                System.out.println(qual);
                synchronized (lock) {
                    lock.notify();
                }

            }
        });
    }

    public void populateRadioButtons(ArrayList<String> list, String buyer)
    {
        System.out.println("Populating radio buttons..");
        buttons = new ArrayList<JRadioButton>();
        ArrayList<String> values = new ArrayList<String>();
        // Setting layout as null of JFrame.
        this.setLayout(null);


        // Initialization of object of "JButton" class.
        jButton = new JButton("Click");

        // Initialization of object of "ButtonGroup" class.
        G1 = new ButtonGroup();

        // Initialization of object of " JLabel" class.
        L1 = new JLabel(buyer+"Menu");
        int x = 120, y= 120;
        for(String s: list) {
            System.out.println(s);
            JRadioButton but = new JRadioButton();
            but.setText(s);
            but.setBounds(x, 30, 120, 50);
            x+=y;
            values.add(s);
            this.add(but);
            G1.add(but);
            buttons.add(but);
        }

        // Setting Bounds of "jButton".
        jButton.setBounds(125, 90, 80, 30);

        // Setting Bounds of JLabel "L2".
        L1.setBounds(20, 30, 150, 50);


        // Adding "jButton" on JFrame.
        this.add(jButton);

        // Adding JLabel "L2" on JFrame.
        this.add(L1);


        this.setBounds(100, 100, x+100, 200);

        // Setting Title of frame.
        this.setTitle("MENU EXCLUSIVE FOR "+ buyer);

        // Setting Visible status of frame as true.
        this.setVisible(true);

        // Adding Listener to JButton.
        jButton.addActionListener(new ActionListener() {

            // Anonymous class.

            public void actionPerformed(ActionEvent e)
            {
                // Override Method

                // Declaration of String class Objects.
                String qual = " ";

                // If condition to check if jRadioButton2 is selected.
                int i = 0;
                for(JRadioButton but: buttons){
                    if(but.isSelected()){
                        productName = values.get(i);
                    }
                    i++;
                }

                System.out.println(qual);
                synchronized (lock) {
                    lock.notify();
                }

            }
        });
    }

    public void waitForPlay() {
        try {
            synchronized (lock) {
                lock.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setVisible(false);
    }
}
