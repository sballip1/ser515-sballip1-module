package ptbs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;

public class Login extends JFrame implements ActionListener{

    static final Object lock = new Object();
    ArrayList<String> users;

    ArrayList<String> password;

    ArrayList<Integer> userRole;
    JPanel panel;
    JLabel user_label, password_label, message;
    JTextField userName_text;
    JPasswordField password_text;
    JButton submit, cancel;
    boolean valid;

    String username;
    int role;
    Login() throws IOException {
        valid = true;
        users = new ArrayList<String>();
        password = new ArrayList<String>();
        userRole = new ArrayList<Integer>();
        createGUI();
        Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
        //System.out.println(""path);
        populatePeople("src//SellerInfo.txt",1);
        populatePeople("src//BuyerInfo.txt",0);
    }

    private void populatePeople(String path, int _role) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        while((line = br.readLine())!=null)
        {
            String [] user_auth = line.split(":");
            users.add(user_auth[0]);
            password.add(user_auth[1]);
            userRole.add(_role);
        }
    }

    public void waitForCreds(){
        try {
            synchronized (lock) {
                lock.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean getValidity(){
        return valid;
    }

    private void setValidity(String username, String pwd){
        for(int i = 0;i<users.size();i++) {
            String user = users.get(i);
            if (user.equals(username)) {
                valid = false;
                role = userRole.get(i);
                if (pwd.equals(password.get(i))) {
                    System.out.println("Successfully logged in: "+user+" "+role);
                    this.username = user;
                    valid = true;
                }
                return;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String userName = userName_text.getText();
        String password = password_text.getText();
        setValidity(userName.trim(),password);
        if (getValidity()) {
            JOptionPane.showMessageDialog(null, "ptbs.Login Successful");
        }
        else {

            setVisible(false);
            JOptionPane.showMessageDialog(null, "Username or Password mismatch. Enter Credentials again");

        }
        synchronized (lock) {
            lock.notify();
        }
        setVisible(false);
    }


    private void createGUI(){
        user_label = new JLabel();
        user_label.setText("User Name :");
        userName_text = new JTextField();
        // Password Label
        password_label = new JLabel();
        password_label.setText("Password :");
        password_text = new JPasswordField();
        // Submit
        submit = new JButton("SUBMIT");
        panel = new JPanel(new GridLayout(3, 1));
        panel.add(user_label);
        panel.add(userName_text);
        panel.add(password_label);
        panel.add(password_text);
        message = new JLabel();
        panel.add(message);
        panel.add(submit);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Adding the listeners to components..
        submit.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("Please ptbs.Login Here !");
        setSize(450,350);
        setVisible(true);
    }

    public int getRole() {
        return this.role;
    }

    public String getUsername(){
        return this.username;
    }
}
