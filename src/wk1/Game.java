package wk1;

public class Game {
    Player player1, player2;
    Player[] allPlayers;

    public Game(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
        allPlayers = new Player[]{player1, player2};
    }

    public void turn(Player attacker, Player victim){

        System.out.printf("%s is attacking %s%n",
                attacker.getName(), victim.getName());
        victim.setHealth(victim.getHealth() - attacker.getAttack());
        System.out.printf("%s health is now %d%n", victim.getName(), victim.getHealth());
    }

    public void turn(int attacker){
        /*
        if(num == 0){
            player2.setHealth(player2.getHealth() - player1.getAttack());
        }
        else if(num == 1){
            player1.setHealth(player1.getHealth() - player2.getAttack());

        }

         */
        if(attacker < 0 || attacker > 1)
            return;

        int victim = attacker == 1 ? 0 : 1;

        if(attacker == 1)
            victim = 0;
        else
            victim = 1;

        System.out.printf("%s is attacking %s%n",
                allPlayers[attacker].getName(), allPlayers[victim].getName());
        allPlayers[victim].setHealth(allPlayers[victim].getHealth() - allPlayers[attacker].getAttack());
        System.out.printf("%s health is now %d%n",
                allPlayers[victim].getName(), allPlayers[victim].getHealth());
    }
    public boolean isGameOver(){

        return player1.getHealth() <= 0 || player2.getHealth() <= 0 ;
    }
}
