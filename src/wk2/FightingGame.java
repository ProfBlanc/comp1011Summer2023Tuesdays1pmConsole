package wk2;

public class FightingGame implements Game {

    //alt+insert

    @Override
    public void start() {
        System.out.println("Welcome to our fighting game");
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
        return false;
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
}
