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

    public void takeDamage(int damage){
        // int amount = rand.nextInt(minDamage,maxDamage + 1);
        int hp = Math.max(0, hp - damage);

    }
    public void heal(int amount){
        int hp = Math.min(maxHp, hp + amount);
    }
    public int attack(Hero target, Random rand){
        int calcDamage = rand.nextInt(minDamage,maxDamage + 1);
        target.takeDamage(calcDamage, rand);
        return calcDamage;
    }
}
