package wk1;

public class Main {
    public static void main(String[] args) {

        Player player2 = new Player("Superman", 6, 21);
        Game game = new Game(
                new Player("Batman", 5, 20),
                player2
                );

        //each player will take TURNS attacking another player
        //health of one player will decrease by the attack value of
        //other player
/*
        game.turn(game.player1, game.player2);
        System.out.println("*".repeat(20));
        game.turn(game.player2, game.player1);
*/
        int counter = -1;
        while(!game.isGameOver()){
            counter++;
            game.turn(counter % 2);
            System.out.println("*".repeat(20));
        }


    }
}