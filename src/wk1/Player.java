package wk1;

public class Player {
    private String name;
    private int attack, health;

    //alt+insert

    public Player(String name, int attack, int health) {
        this.name = name;
        this.attack = attack;
        this.health = health;
    }
    public Player(){}

    //alt+insert

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
