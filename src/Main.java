
import spark.ModelAndView;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;


public class Main {
    private static ArrayList<String> gameChars = new ArrayList<>();
    private static int guesses;
    private static String v1 = "(";
    private static String v2 = ")";
    private static String v3 = "(";
    private static String v4 = "|";
    private static String v5 = "|";
    private static String v6 = ") ";
    private static String v7 = "|";
    private static String v8 = "|";
    private static String v9 = "<";
    private static String v10 = ">";
    private static boolean a;



    public static void main(String[] args) {




        populateGame();
//        showGameInstructions();
        Spark.staticFileLocation("/public");
        Spark.init();
        Spark.get("/", ((request, response) -> {
                    String lose = "You lose";
                    String winner = "You Win!!";
                    int guessesLeft = 10 - guesses;
                    HashMap m = new HashMap();

                    if (guesses > 0) {
                        m.put("v1", v1);
                    }
                    if (guesses > 1) {
                        m.put("v2", v2);
                    }
                    if (guesses > 2) {
                        m.put("v3", v3);
                    }
                    if (guesses > 3) {
                        m.put("v4", v4);
                    }
                    if (guesses > 4) {
                        m.put("v5", v5);
                    }
                    if (guesses > 5) {
                        m.put("v6", v6);
                    }
                    if (guesses > 6) {
                        m.put("v7", v7);
                    }
                    if (guesses > 7) {
                        m.put("v8", v8);
                    }
                    if (guesses > 8) {
                        m.put("v9", v9);
                    }
                    if (guesses > 9) {
                        m.put("v10", v10);
                        m.put("lose", lose);
                    }

                    if (a = true) {

                        m.put("guesses", guessesLeft);
                    }
//                    if (a = false) {
//                        m.remove("wrong");
//                        m.remove("guesses");
//                    }
                    if (!gameChars.contains("_")) {
                        m.put("winner", winner);
                    }
                    m.put("word", gameChars);
                    return new ModelAndView(m, "Hangman.html");

                }),
                new MustacheTemplateEngine()
        );
        Spark.get("/instructions", ((request, response) -> {
                    HashMap m = new HashMap();
                    return new ModelAndView(m, "instructions.html");
                }), new MustacheTemplateEngine()
        );
        Spark.post("/post", ((request, response) -> {
            String letter = request.queryParams("letter");
            if (letter == null) {
                letter = "";
            }
            if (letter.length() > 1) {
                letter = letter.substring(0, 1);
            }
            switch (letter.toLowerCase()) {
                case "b":
                    gameChars.set(0, "B");
//                    System.out.println(gameChars.toString());
//                    a = false;
                    break;
                case "i":
                    gameChars.set(1, "I");
//                    System.out.println(gameChars.toString());
//                    a = false;
                    break;
                case "c":
                    gameChars.set(2, "C");
                    gameChars.set(4, "C");
//                    System.out.println(gameChars.toString());
//                    a = false;
                    break;
                case "y":
                    gameChars.set(3, "Y");
//                    System.out.println(gameChars.toString());
//                    a = false;
                    break;
                case "l":
                    gameChars.set(5, "L");
//                    System.out.println(gameChars.toString());
//                    a = false;
                    break;
                case "e":
                    gameChars.set(6, "E");
//                    System.out.println(gameChars.toString());
//                    a = false;
                    break;
                default:
//                    System.out.println("Sorry that's not one of the letters. Try again");
                    guesses++;
//                    System.out.printf("Remaining tries %s\n", (10 - guesses));

            }
            response.redirect("/");
            return "";
        }));
    }


    static void populateGame() {
        int i;
        for (i = 0; i < 7; i++) {
            gameChars.add("_");
        }
        System.out.println(gameChars.toString());
    }

//    static void showGameInstructions() {
//        System.out.println("Hello player!\n We are going to play a game of HangMan!\n" +
//                " Go ahead and try to guess the letters.\n You only get 10 guesses so be careful!\n " +
//                "Please enter a letter!");
//    }


    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %s %s", gameChars.get(0), gameChars.get(1), gameChars.get(2), gameChars.get(3), gameChars.get(4), gameChars.get(5), gameChars.get(6));
    }
}
