import java.util.Random;
public class Fighter{
    private String name;
    private int hp, maxHp, minHp, maxDamage, minDamage;

    public Fighter(String name, int hp, int maxHp, int maxDamage, int minDamage)
    {
        this.name = name;
        this.hp = hp;
        this.maxHp = maxHp;
        this.maxDamage= maxDamage;
        this.minDamage = minDamage;
    }
    public void takeDamage(int damage)
    {
        hp = Math.max(0, hp - damage);
    }

    public int attack(Fighter target)
    {
        Random rand = new Random();
        int damage = rand.nextInt(minDamage, maxDamage + 1);
        target.takeDamage(damage);
        return damage;
    }

    public void heal(int amount)
    {
        hp = Math.min(maxHp, hp + amount);
    }
    public boolean isAlive()
    {
        return hp > 0;
    }
    public String getName()
    {
        return name;
    }
    public int getHp()
    {
        return hp;
    }
}
