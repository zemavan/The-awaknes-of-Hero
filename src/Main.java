import java.util.Scanner;

public class Main {


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
 public static void main(String[] args){
     Scanner sc = new Scanner(System.in);
     int option;
     do{
         showMenu();
         option = rInt(sc);
         switch(option){
             case 1: //nueva partida
             case 2: //consultar ranking
             case 3: //ayuda
             case 4: //salir
         }
     }
 }
}
