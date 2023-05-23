package wk3;
import wk2.*;
import com.google.gson.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Week3 {
    static void example1(){
        Cat cat = new Cat("Cat", 123);
        Lion lion = new Lion("Simba", 456,
                987);
        System.out.println(lion);
        System.out.println(cat);
    }
    static void example2(){

        /*
            fm is done using 2 packages
                java.io
                java.nio

            Path: a location in file system
            File: ONE file or folder in file system
         */
        //navigate ./src/game_data/players
        // read the info in files batman.txt, superman.txt
        Path path = Path.of("./src/game_data", "players");

        System.out.println(path.toFile().exists());
        File[] allFiles = path.toFile().listFiles();

        for(File each : allFiles){

            //System.out.println(each.getName());
            try {
                List<String> lines = Files
                        .readAllLines(
                                path.resolve(each.getName()));

                Player player1 = new NormalPlayer(lines.get(0).trim(),
                        Double.parseDouble(lines.get(1)),
                        Double.parseDouble(lines.get(2)));

                System.out.println(player1);
            }
            catch (Exception e){
                System.err.println(e);
            }

        }


    }
    public static void main(String[] args) {
        example2();
    }
}
