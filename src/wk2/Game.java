package wk2;

public interface Game {

    void start();
    void stop();
    void pause();
    void resume();
    boolean login();
    boolean validateLogin(String username, String password);
    void logout();
    boolean save(String fileName);
    boolean load(String fileName);

    void end();
}
