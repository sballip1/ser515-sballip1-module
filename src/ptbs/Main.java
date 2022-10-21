package ptbs;

import java.io.IOException;


//GITHUB link : https://github.com/sballip1/ser515-sballip1-module
public class Main {
    public static void main(String[] args) throws IOException {
        while(true){
            PTBSFacade fac = new PTBSFacade();
            boolean flag = false;
            while(!flag){
                flag = fac.login();
            }
            fac.startapp();
        }
    }
}