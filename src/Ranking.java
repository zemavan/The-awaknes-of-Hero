public class Ranking
{
    private String username;
    private int points;
    private int power;
    private int investigator;
    private int intellegent;


    public Ranking(String username, int points){
        this.username = username;
        this.points = points;
    }

    public int Points(int amount){
        return points += amount;
    }
    public int getPoints(){
        return points;
    }
    public String getUsername(){
        return username;
    }

    public void showRanking(){
        System.out.println("username" + username + "points" + points);
    }

}
