package wk2;

import java.util.Scanner;

public class NormalPlayer extends Player{

    /*
        boolean value
            hasUsedSuperPower

        Scanner ask questions
     */
    private boolean hasUsedSuperPower;
    private Scanner input = new Scanner(System.in);


    public NormalPlayer() {
    }

    public NormalPlayer(String name, double attack, double health) {
        super(name, attack, health);
    }

    /**
     * This method allows Player to use their SuperPower only once.
     * They get the choice of increase attack or increasing health.
     * If they choose to increase attack, the attack will increase by 1
     * If they choose to increase health, the health will increase by 3
     */
    @Override
    public void useSuperPower() {

        if(!hasUsedSuperPower){
            hasUsedSuperPower = true;
            System.out.println("What would you like to do? Increase attack or Increase Health?");
            System.out.println("Enter 'A' for attack or 'H' for health");
            String result = input.nextLine();

            if(result.toLowerCase().charAt(0) == 'a'){
                increaseAttack(1);
            } else if (result.toLowerCase().charAt(0) == 'h') {
                decreaseHealth(-3);
            }
        }

    }
}
