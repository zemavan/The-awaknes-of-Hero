public class Username{
    private String username;
    public Username(String username){
        this.username = username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        String name = "Username : " + this.username;

        return name;
    }


}
