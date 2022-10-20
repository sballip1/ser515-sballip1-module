import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        PTBSFacade fac = new PTBSFacade();
        fac.login();
        while(!fac.startApp()){
            fac.login();
        };
    }
}