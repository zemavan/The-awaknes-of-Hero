import java.util.Scanner;

public class Main {
        public static void ClearConsole() {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }

    public static int ChapterOneScenarioOne(){
        Scanner sc = new Scanner(System.in);
        System.out.println("chapterOneScenarioOne");

        System.out.println("(Петя получил зашифрованое письмо на своем теримнале)");
        System.out.println("ПЕТЯ если ты можешь это читать то найди мой ноутбук");
        System.out.println("Choose option 1-3: ");
        System.out.println("1 - Go to Vasya's house and find his laptop");
        System.out.println("2 - Open terminal");
        System.out.println("3 - I should not pay attention because Vasya is in coma");
        System.out.println(": ");
        int option = sc.nextInt();
        return option;


    }

	public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("introduce your username here: ");
    String user = sc.nextLine();
    Username username = new Username(user);


    boolean running = true;
    while(running){
    System.out.println("THE AWAKNES OF THE HERO");
    System.out.println("select from 1-3");
    System.out.println("1 - play game");
    System.out.println("2 - options");
    System.out.println("3 - exit");
    int optionMenu = sc.nextInt();

        ClearConsole();
        switch(optionMenu){
            case 1:
            int option = ChapterOneScenarioOne();
            running = false;
            break;
            case 2: System.out.println("Options"); break;
            case 3: System.out.println("Goodbye"); break;

        }

        switch(option)

    	}
 }
}
