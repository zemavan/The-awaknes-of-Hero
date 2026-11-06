public class Fighter{
    private String name; private int hp; private int damage;

    public Fighter(String name, int hp, int damage)
    {
        this.name = name; this.hp = hp; this.damage = damage;
    }
    public void takeDamage(int damage)
    {
        hp = hp - damage;
    }
    public void attack(Fighter target)
    {
        target.takeDamage(damage);
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
