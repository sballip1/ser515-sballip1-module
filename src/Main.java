import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        PTBSFacade fac = new PTBSFacade();
        boolean flag = false;
        while(!flag){
            flag = fac.login();
        }
        fac.startapp();
    }
}