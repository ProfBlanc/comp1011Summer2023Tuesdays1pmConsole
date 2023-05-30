package wk4;
import com.google.gson.*;
import wk2.*;
public class Week4 {

    public static void main(String[] args) {
        /*

            JSON: JavaScript Object Notation
                universal format for data transfer

            Why use JSON: convert an object to a String & vice-versa
            Uses: easily read and write data as string => convert it easily from string to object and vice versa
         */

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        //create a Normal Player
        NormalPlayer player1 = new NormalPlayer("Batman", 10, 30);
        System.out.println(player1);

        String json1 = gson.toJson(player1);
        System.out.println(json1);

        NormalPlayer player2 = gson.fromJson(json1, NormalPlayer.class);
        player2.setName("New Name");
        System.out.println(player2);

    }
}
