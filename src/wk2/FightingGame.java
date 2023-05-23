package wk2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FightingGame implements Game {


    private Scanner input = new Scanner(System.in);
    private ArrayList<Player> players = new ArrayList<>();
    //alt+insert

    @Override
    public void start() {
        System.out.println("Welcome to our fighting game");

        if(login()){

            int validPlayers = 0;
            while(validPlayers < 2){
                try{
                    System.out.println("Enter Name for Player "  + (validPlayers + 1));
                    String name = input.nextLine();
                    System.out.println("Enter attack for " + name);
                    double attack = input.nextDouble();
                    System.out.println("Enter health for " + name);
                    double health = input.nextDouble();
                    input.nextLine();  //consume nl characater

                    players.add(new NormalPlayer(name, attack, health));
                    validPlayers++;
                }
                catch (InputMismatchException e){
                    System.out.println("Invalid numerical inputs");
                }
                catch (Exception e){
                    System.err.println(e.getMessage());
                }
            }


        }
        else{
            System.out.println("Login required");
        }

    }

    @Override
    public void stop() {
        System.out.println("Do you want to stop the game?");
    }

    @Override
    public void pause() {
        System.out.println("The game is now on pause");
    }

    @Override
    public void resume() {

        System.out.println("Break time over, let's resume the fight");
    }

    @Override
    public boolean login() {
        System.out.println("Enter username");
        String uname = input.nextLine();
        System.out.println("Enter password");
        String pwd = input.nextLine();
        return validateLogin(uname, pwd);
    }

    @Override
    public boolean validateLogin(String username, String password) {
        return username.equals("admin") && password.equals("pass");
    }

    @Override
    public void logout() {

        System.out.println("You are now logged out");
    }

    @Override
    public boolean save(String fileName) {
        System.out.println("Not yet implemented");
        return false;
    }

    @Override
    public boolean load(String fileName) {
        System.out.println("Not yet implemented");
        return false;
    }

    @Override
    public void end(){
        System.out.println("The game is over! Thanks for playing");
    }

    private boolean isGameOver(){
        //iterate through all players. determine if health is lte 0

        for(Player current : players){
            if(current.getHealth() <= 0)
                return true;
        }

        return false;

    }

    private void turn(int attacker){

        int victim = attacker == 0 ? 1 : 0;
        System.out.printf("%s is attacking %s%n",
                players.get(attacker).getName(),
                players.get(victim).getName()
                );

            players.get(victim).decreaseHealth(players.get(attacker).getAttack());

                System.out.printf("%s health is now %.1f%n",
                players.get(victim).getName(),
                players.get(victim).getHealth()
                );
        System.out.println("*".repeat(20));

    }

    private void fight(){

        int counter = -1;
        while(!isGameOver()){
            counter ++;
            turn(counter % 2);
        }
        end();
    }

    public FightingGame(){

        start();
        fight();
    }
}
