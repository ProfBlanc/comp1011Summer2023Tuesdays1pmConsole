package wk2;

public abstract class Player {

    private String name;
    private double attack, health;

    public Player(){}

    public Player(String name, double attack, double health) {
        this.name = name;
        this.attack = attack;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.trim().length() < 3)
            throw new IllegalArgumentException(
                    String.format("The name '%s' is too short. " +
                            "Needs to be at least 3 characters", name)
            );
        this.name = name;
    }

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        if(attack < 3 || attack > 10)
            throw new IllegalArgumentException("Attack value must be between 3 and 10");
        this.attack = attack;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        if(health < 20 || health > 30)
            throw new IllegalArgumentException("Health value must be between 20 and 30");

        this.health = health;
    }
    public abstract void useSuperPower();

    public void increaseAttack(double value){
        attack += value;
    }
    public void decreaseHealth(double value){
        health -= value;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", attack=" + attack +
                ", health=" + health +
                '}';
    }
}
