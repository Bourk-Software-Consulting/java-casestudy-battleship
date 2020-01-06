import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FleetSetupTests {

    //JUnit 5.4

    //The first new feature to be added is to set the Aircraft Carrier to position A2 and tell the game that it goes Horizontally
    //This simplifies the positioning of the pieces during setup
    @Test
    public void testAircraftA2H(){

        Character[][] expectedBoard = {
                {' ','A','B','C','D','E','F','G','H'},
                {'1',' ',' ',' ',' ',' ',' ',' ',' '},
                {'2','A','A','A','A','A',' ',' ',' '},
                {'3',' ',' ',' ',' ',' ',' ',' ',' '},
                {'4',' ',' ',' ',' ',' ',' ',' ',' '},
                {'5',' ',' ',' ',' ',' ',' ',' ',' '},
                {'6',' ',' ',' ',' ',' ',' ',' ',' '},
                {'7',' ',' ',' ',' ',' ',' ',' ',' '},
                {'8',' ',' ',' ',' ',' ',' ',' ',' '}};
        Sea sea = new Sea();
        new AircraftCarrier(sea).placeAt("A2H");
        assertArrayEquals(expectedBoard,sea.getBoardgame());
    }

    @Test
    public void testCruiserC4V(){
        Character[][] expectedBoard = {
                {' ','A','B','C','D','E','F','G','H'},
                {'1',' ',' ',' ',' ',' ',' ',' ',' '},
                {'2',' ',' ',' ',' ',' ',' ',' ',' '},
                {'3',' ',' ',' ',' ',' ',' ',' ',' '},
                {'4',' ',' ','C',' ',' ',' ',' ',' '},
                {'5',' ',' ','C',' ',' ',' ',' ',' '},
                {'6',' ',' ','C',' ',' ',' ',' ',' '},
                {'7',' ',' ',' ',' ',' ',' ',' ',' '},
                {'8',' ',' ',' ',' ',' ',' ',' ',' '}};

        Sea sea = new Sea();
        new Cruiser(sea).placeAt("C4V");
        assertArrayEquals(expectedBoard,sea.getBoardgame());
    }
}
