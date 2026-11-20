import java.util.Random;
public class Hero{
    Random rand = new Random();
    private String nombre;
    private int hp, maxHp, maxDamage, minDamage;

    public Hero(String nombre, int hp, int maxHp, int maxDamage, int minDamage){
        this.nombre = nombre;
        this.hp = hp;
        this.maxHp = maxHp;
        this.maxDamage = maxDamage;
        this.minDamage = minDamage;
    }

    public void getNombre(){
        System.out.println(this.nombre);
    }

    public int takeDamage(int amount, Random rand){
        int amout = rand.nextInt(minDamage,maxDamage + 1);
        int hp = Math.max(0, hp - amount);
        return hp;
    }
    public int heal(int amount){
        int hp = Math.max(0, hp + amount);
        return hp;
    }
    public int attack(Hero target, Random rand){
        int calcDamage = rand.nextInt(minDamage,maxDamage + 1);
        target.takeDamage(calcDamage)
        return calcDamage;
    }
}
