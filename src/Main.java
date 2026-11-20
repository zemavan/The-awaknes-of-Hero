import java.util.Scanner;

public class Main {
    final
    public static void clearConsole(){
        // Source - https://stackoverflow.com/a/10241460
        // Posted by Joni, modified by community. See post 'Timeline' for change history
        // Retrieved 2026-11-20, License - CC BY-SA 3.0

        System.out.print("\033[H\033[2J");
        System.out.flush();

    }
    public static void showMenu(){
        Scanner sc = new Scanner(System.in);
                System.out.println("EL DESPERTAR DEL HÉROE");
                System.out.println("1 - nueva partida");
                System.out.println("2 - consultar ranking");
                System.out.println("3 - ayuda");
                System.out.println("4 - salir");
                System.out.println("eleige la opcion de 1 a 4: ");
    }
    public static int rInt(Scanner sc){
        while(!sc.hasNextInt()){
            System.out.println("Prueba otra vez: ");
            sc.next();
        }
        int result = sc.nextInt();
        return result;
    }
    public static String rString(Scanner sc, String text){
        System.out.println(text);
        String result = sc.nextLine();
        while(result.isBlank()) {
            System.out.println("Prueba otra vez: ");
            result = sc.nextLine();
        }
        return result;
    }
    public static void play(){
        System.out.println("Play");
    }
    public static void ranking(){
        System.out.println("ranking");
    }
    public static void ayuda(){
        System.out.println("ayuda");
    }
    public static void salir(){
        System.out.println("salir");
    }

    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String username = rString(sc, "introduce tu nickname: "); clearConsole();
    //   String username int hp, int maxHp, int maxDamage, int minDamage)
    Hero user = new Hero(username, 100, 100, 20, 10);
    int option;
    showMenu();
    option = rInt(sc);
    switch(option){
        case 1: play(); clearConsole(); System.out.println("cleaned");break;
        case 2: ranking();break;//consultar ranking
        case 3: ayuda();break;//ayuda
        case 4: salir();break;//salir
    }
}
}
