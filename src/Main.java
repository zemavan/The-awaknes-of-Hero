import java.util.Random;
import java.util.Scanner;

public class Main {
    static final int HERO_MAX_HP = 100;
    static final int HERO_MIN_DAMAGE = 10;
    static final int HERO_MAX_DAMAGE = 20;
    static final int[] ENEMY_HP = {40, 60, 80};
    static final int ENEMY_MIN_DAMAGE = 5;
    static final int ENEMY_MAX_DAMAGE = 15;
    static final int POCIONES = 3;
    static final int HEAL = 25;
    static final int POINTS_ENEMY_WIN = 100;
    static final int RESULT_WON = 0;
    static final int RESULT_LOST = 1;
    static final int RESULT_QUIT = 2;
    static void clearConsole(){
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
    public static void play(String username, Scanner sc, Random rand){
        Hero user = new Hero(username, HERO_MAX_HP, HERO_MAX_HP, HERO_MAX_DAMAGE, HERO_MIN_DAMAGE);
        Invenatario inv = new Invenatario(POCIONES, HEAL);
        int points = 0;
        int loses = 0;

        for(int i = 0; i < ENEMY_HP.length; i++){
            Hero enemy = new Hero("Sentinel " + i, ENEMY_HP[i], ENEMY_HP[i], ENEMY_MAX_DAMAGE, ENEMY_MIN_DAMAGE);
            int result = simularCombate(user, enemy, inv, sc, rand);
            if(result != RESULT_WON){
                break;
            }
            loses++;
            points += POINTS_ENEMY_WIN;
            System.out.println(enemy.returnNombre() + " derrotado. Puntos: " + points);
            }
            if(loses == ENEMY_HP.length){
                   points += user.getHp();   // bonus de vida solo al ganar la aventura
                   System.out.println("Has ganado la aventura!");
               } else {
                   System.out.println("Fin de la partida.");
               }
               System.out.println("Puntuacion final: " + points);
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
    public static void EnemyShow(){
        System.out.println("       ***     ");
        System.out.println("      (___)   * ");
        System.out.println("     ( @ @ ) /    ");
        System.out.println("      )-@-( /    ");
        System.out.println("    / | _ |     ");
        System.out.println("   /  { _ }     ");
        System.out.println("  *  /_| |_|     ");
        System.out.println("");
            }

    public static void attacar(Hero turnoatacar, Hero turnorecibir ,Random rand){
        int damage = turnoatacar.attack(turnorecibir, rand);
        System.out.println(turnoatacar.returnNombre() + " ataca a " + turnorecibir.returnNombre()
                    + " y causa " + damage + " de danio. Le quedan " + turnorecibir.getHp() + " HP");
        }
    }

    public static boolean usarPociones(Hero user, Invenatario inv){
        if(!inv.hayPociones()){
            System.out.println("No hay pociones");
            return false;
        }
        if(user.fullHp()){
            System.out.println("Tu vida es maxima, no se puede usar la pocion");
            return false;
        }
        user.heal(inv.usePociones());
        System.out.println("+" + HEAL + " de vida:   " + user.getHp());
        return true;

    }

    public static int simularCombate(
        Hero user,
        Hero enemy,
        Invenatario inv,
        Scanner sc, Random rand)
    {
        System.out.println("Primer enemigo " + enemy.returnNombre());
        while(user.getHp() > 0 && enemy.getHp()>0){
            EnemyShow();
            boolean cambiarTurno = false;
            System.out.println(enemy.returnNombre() + " HP: " + enemy.getHp());
            System.out.println(user.returnNombre() + " HP: " + user.getHp());
            System.out.println("1 - Atacar  2 - Usar pocion  3 - Inventario  4 - Abandonar");
            System.out.print("Tu opcion: ");
            int option = rInt(sc);
            switch(option){
                case 1:
                attacar(user, enemy, rand);
                cambiarTurno = true;
                break;
                case 2:
                if(usarPociones(user, inv)){
                    cambiarTurno = true;
                }
                break;
                case 3:
                inv.show();
                break;
                case 4:
                return RERESULT_QUIT;
                default:
                System.out.println("Tu opcion fuera del rango");
            }
            if(cambiarTurno && enemy.getHp() > 0){
                attacar(enemy, user, rand);
            }
        }
        if(user.getHp() > 0){
            return RESULT_WON;
        }else{
            return RESULT_LOST;
        }
    }

    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    //   String username int hp, int maxHp, int maxDamage, int minDamage)
    // Hero user = new Hero(username, 100, 100, 20, 10);
    // Hero enemy = new Hero("Sentinel", 100, 100, 15, 5);
    // Invenatario inv = new Invenatario(3, 20);
    Random rand = new Random();
    int option;
    do{
    showMenu();
    option = rInt(sc);
    switch(option){
        case 1:
        String username = rString(sc, "introduce tu nickname: ");
        play(username, sc, rand);
        break;
        case 2: ranking();break;//consultar ranking
        case 3: ayuda();break;//ayuda
        case 4: salir();break;//salir
    }
    }while(option!=4);
}
}
