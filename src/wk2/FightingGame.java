package wk2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class FightingGame implements Game {


    private final Scanner input = new Scanner(System.in);
    private ArrayList<Player> players = new ArrayList<>();
    //alt+insert

    private final Path rootPathPlayers = Path.of("./src/game_data/players");
    private final Path rootPathGames = Path.of("./src/game_data/games");

    private boolean forceGameOver = false;

    private Gson gson;

    private GsonBuilder gsonBuilder = new GsonBuilder();

    private StringBuilder answer = new StringBuilder();

    private void clearAnswer(){
        answer.setLength(0); //clear all contents
    }
    private void choose(){

        System.out.println("Do you want to (S)tart a new game or (L)oad a previous game?");
        clearAnswer();
        answer.append(input.nextLine());

        char firstChar = answer.toString().toLowerCase().charAt(0);

        if(firstChar == 's'){
            userEntersPlayers();
        } else if (firstChar == 'l') {
            //userChoosesGame();
            userChoosesGameOrPlayer();
        }

    }
    private void userChoosesGameOrPlayer(){

        System.out.println("Do you want to load a (G)ame or load (P)layers?");
        clearAnswer();
        answer.append(input.nextLine());
        if(answer.toString().equalsIgnoreCase("g")){
            userChoosesGames();
        }
        else if(answer.toString().equalsIgnoreCase("p")){
            userChoosesPlayers();
        }

    }
    private void userChoosesGames(){

        //list all games

        //load the one game

        try{

            List<String> data = Files.readAllLines(rootPathGames.resolve("Game_Batman_vs_Superman.txt"));
            players.add(gson.fromJson(data.get(0), NormalPlayer.class));
            players.add(gson.fromJson(data.get(1), NormalPlayer.class));

        }
        catch (Exception e){
            System.err.println(e);
        }



    }
    private void userChoosesPlayers() {

        //ask user to enter game;

        String[] playerNames = rootPathPlayers.toFile().list();

        int validPlayers = 0;
        while (validPlayers < 2){
        System.out.println("Choose a player " + (validPlayers + 1));
        int index = 0;
        for (String player : Objects.requireNonNull(playerNames)) {
            index++;
            System.out.println(index + " for " + player.split(".txt")[0]);


        }
        System.out.println("Which player do you choose?");
           answer.append(input.nextLine());

            try{
                int choice = Integer.parseInt(answer.toString());
                System.out.println(choice);
                if (index <= playerNames.length && loadDataFile(playerNames[choice - 1])) {
                validPlayers++;
                }

            }
            catch (Exception e){

                if(load(answer.toString().trim() + ".txt") && loadDataFile(answer.toString().trim() + ".txt" ) ) {

                    validPlayers++;
                }

            }


        //if(load("batman") || load("superman")){
    }

    }

    private boolean loadDataFile(String fileName){
        int playerSize = players.size();
        try {
            List<String> lines = Files.readAllLines(rootPathPlayers.resolve(fileName));
            //instantiate both Player objects into ArrayList of Player called players

            players.add(new NormalPlayer(lines.get(0).trim(),
                    Double.parseDouble(lines.get(1)),
                    Double.parseDouble(lines.get(2))));
        }
        catch (Exception e){
            System.err.println("Could not load file " + fileName);

        }

        return players.size() != playerSize;
    }
    private void userEntersPlayers(){
        int validPlayers = 0;
        while(validPlayers < 2){
            try{
                System.out.println("Enter Name for Player "  + (validPlayers + 1));
                String name = input.nextLine();
                System.out.println("Enter attack for " + name);
                double attack = input.nextDouble();
                System.out.println("Enter health for " + name);
                double health = input.nextDouble();
                input.nextLine();  //consume nl character

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
    @Override
    public void start() {
        System.out.println("Welcome to our fighting game");

        if(login()){

            choose();

            /*
                Ask user whether they want to START a game or LOAD a game.
                If Start game, use the while loop
                If load game, automatically load batman and superman txt file data
                create objects

             */
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
    public boolean save(Path path, String content) {

        try{
            Files.writeString(path, content);
            return true;
        }
        catch(Exception e){
            System.err.println(e);
            return false;
        }

    }

    @Override
    public boolean load(String fileName) {
        return rootPathPlayers.resolve(fileName).toFile().exists();
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

        return forceGameOver;

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

        separator();
        askUserWhatToDoNext();
        separator();
    }

    private void askUserWhatToDoNext(){

        System.out.println("Do you want to save the game?");
        String answer = input.nextLine();
        if(answer.toLowerCase().charAt(0) == 'y'){

            //save the game
            //path, filename, contents

            String filename = String.format("Game_%s_vs_%s.txt", players.get(0).getName(), players.get(1).getName());

            String value1 = gson.toJson(players.get(0));
            String value2 = gson.toJson(players.get(1));
            String content = String.format("%s%n%s", value1, value2);

            if(save(rootPathGames.resolve(filename), content)){

                System.out.println("Game Saved");
                //exit the fight
                forceGameOver = true;
            }
            else{
                System.out.println("Could not save the game");
            }


        }
    }
    private void separator(){
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

        gson = gsonBuilder.create();
        start();
        fight();
    }
}
