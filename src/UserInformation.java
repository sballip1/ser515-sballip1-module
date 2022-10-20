public class UserInformation {

    String name;
    int role;
    UserInformation(String name, int role){
        this.name= name;
        this.role = role;
    }

    int getRole(){
        return role;
    }

    String getName(){
        return name;
    }

}
