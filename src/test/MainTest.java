import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by joshuakeough on 9/30/16.
 */
public class MainTest {
    @Test
    public void testPopulateGame() throws Exception {
        ArrayList<String> gameChars = new ArrayList<>();
        int i;
        for (i = 0; i < 7; i++) {
            gameChars.add("_");
        }
        System.out.println(gameChars.size());
        assertTrue(gameChars.size() == 7);

    }

    @Test
    public void testUserEntryWrong() {
        boolean guess;
        String letter = "c";
        switch (letter.toLowerCase()) {
            case "b":
                guess = true;
                break;
            default:
                guess = false;

        }
        assertTrue(!guess);
    }

    @Test
    public void testUserEntryCorrect() {
        boolean guess;
        String letter = "b";
        switch (letter.toLowerCase()) {
            case "b":
                guess = true;
                break;
            default:
                guess = false;

        }
        assertTrue(guess);

    }

}