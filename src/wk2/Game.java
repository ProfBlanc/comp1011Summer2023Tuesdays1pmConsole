package wk2;

import java.nio.file.Path;

public interface Game {

    void start();
    void stop();
    void pause();
    void resume();
    boolean login();
    boolean validateLogin(String username, String password);
    void logout();
    boolean save(Path path, String content);
    boolean load(String fileName);

    void end();
}
