import java.util.Scanner;
import java.util.Random;
public class Main {
        Scanner sc = new Scanner(System.in);
        public static void ClearConsole() {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////

        public static int RandomExp(){
                Random rn = new Random();
                int exponentValue = rn.nextInt(0,10);
                return exponentValue;
        }
        public static int ExponentResult(int exponentValue){

            int base = 2;
            int exponentResult = 1;
            System.out.println("To cause damage to Sentinel you should resolve the following problems: ");
            System.out.println("       binary number "+ base + "^" + exponentValue + " to decimal");
            for(int a = 0; a<exponentValue;a++){
                exponentResult *= base;
            }
            return exponentResult;
        }
        public static int ExponentResultUser(){
            Scanner sc = new Scanner(System.in);
            System.out.print("❯  ");
            int exponentResultUser = sc.nextInt();
            return exponentResultUser;
        }


        public static boolean Battle(){
            int enemy_hp = 100;
            int my_hp = 100;

            do{
            EnemyShow();
            int exponentValue = RandomExp();
            int exponentResult = ExponentResult(exponentValue);
            int exponentResultUser = ExponentResultUser();
            if(exponentResult == exponentResultUser){
                System.out.println("TRUE");
                enemy_hp -= 25;
                System.out.println("My HP: "+my_hp);
                System.out.println("Enemy HP: "+enemy_hp);


            }else{
                System.out.println("FALSE");
                my_hp -= 25;
                System.out.println("My HP: "+my_hp);
                System.out.println("Enemy HP: "+enemy_hp);

            }
            }while(enemy_hp > 0 && my_hp > 0);

            if(enemy_hp <= 0){
                System.out.println("YOU WON");
            }else{
                System.out.println("YOU LOST");
            }

        return my_hp>0;
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


    public static void firstEnemy(){
        Enemy enemy = new Enemy(100, 25);
        enemy.ShowEnemy();
    }


    public static void SubiendoEscaleras(){
        System.out.println("Subiendo las escaleras Petya fue atacado por un Sentinell");

    }

    public static void ChapterOneScenarioOneOptionThree(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Vasya esta en coma, por lo que no me puede escribir eso");
        System.out.println("Admeas estoy cansado, lo revisare despues si es un virus");
        System.out.println("");
        System.out.println("(10 minutos despues)");
        System.out.println("Hey Vasya yo se que estas aqui, urgentemente encuentra mi portatil");
        ChapterOneScenarioOneOptionOne();


    }
    public static void ChapterOneScenarioOneOptionOne(){
        Scanner sc = new Scanner(System.in);
        System.out.println("(Ir a casa de Vasya y encotrar su portatil)");
        System.out.println("Petya coge una bici y va a la casa donde antes vivia Vasya");

        // System.out.println("el piso 7, subo por las escalers o por un ascensor?");
        System.out.println("");
        System.out.println("1 - subir por las escaleras\n2 - Subir por un ascensor");
        System.out.println("");

        int escalerasAscensor = sc.nextInt();
        switch(escalerasAscensor){
            case 1:
            System.out.println("Pues vamos a subir por las escaleras");
            System.out.println("Oh no, Sentinel ");
            System.out.println("ganar a Sentinel");

            Battle();



            // PrintEnemyCliMotionOne();
            break;
            case 2: System.out.println
            ("<<Pulsa el boton para llamar el ascensor>>\n Parece que no funciona, \npues vamos a subir por las escaleras ");
            break;
        }

    }
    public static void ChapterOneScenarioOneOptionTwo(){
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while(running){
            System.out.println("2 - Analizar los procesos del sistema");
            System.out.println("Introduce el nombre de utility para ver los procesos ejecutados en el sistema Linux");
            System.out.print("❯  ");
            String htopComand = sc.nextLine();

            if(htopComand.equals("htop") || htopComand.equals("top")){
                System.out.println("PID USER PRI NI VIRT RES PRIV S CPU% MEM%+ TIME+ Command");
                System.out.println("3844 rootman 8 -12 1723M 257M 49088 S 25.2 0.8 4:15.64 niri --session");
                System.out.println("27470 rootman 16 4 72580 64704 1028 S 19.4 0.2 0:00.74 slurp");
                running = false;
            }
            else{
                System.out.println("fish: Unknown command: " + htopComand);
            }
        }
    }

    public static void ChapterOneScenarioOne(){
        Scanner sc = new Scanner(System.in);
        System.out.println("chapterOneScenarioOne");

        System.out.println("(A Petya le llega un mensaje cifrado por su terminal)");
        System.out.println("(cifrado) Petya, si puedes leer esto, encuentra mi portatil");
        System.out.println("Choose option 1-3: ");
        System.out.println("1 - Ir a casa de Vasya y encotrar su portatil");
        System.out.println("2 - Analizar los procesos del sistema");
        System.out.println("3 - No debo prestar atencion a este mensaje");
        System.out.println(": ");
        int optionScenario = sc.nextInt();

            switch(optionScenario){
                case 1: ChapterOneScenarioOneOptionOne();break;
                case 2: ChapterOneScenarioOneOptionTwo();break;
                case 3: ChapterOneScenarioOneOptionThree();break;
            }

    }
    public static int Menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("THE AWAKNES OF THE HERO");
        System.out.println("select from 1-4");
        System.out.println("1 - play game");
        System.out.println("2 - consultar ranking");
        System.out.println("3 - options");
        System.out.println("4 - exit");
        int menu = sc.nextInt();
        return menu;
    }
	public static void main(String[] args){
    Scanner sc = new Scanner(System.in);



    boolean running = true;
    while(running){
    int menu = Menu();
        ClearConsole();
        switch(menu){
            case 1:
            ChapterOneScenarioOne();break;
            case 2: System.out.println("Rankings --");break;
            case 3: System.out.println("Options --");break;
            case 4: System.out.println("exited --");
            running = false; break;
            default: System.out.println("");
            running = false;

        }
    }
}
}
