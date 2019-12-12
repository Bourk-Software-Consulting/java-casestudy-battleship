import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class GameController
{
    public static final int ASCII_A = 65;
    public static final int TABLE_OFFSET = 1;

    public static Boolean CheckIsHit(Iterable<Ship> ships, Position shot)
    {
        if (ships == null)
        {
            throw new IllegalArgumentException("ships");
        }

        if (shot == null)
        {
            throw new IllegalArgumentException("shot");
        }

        for (Ship ship : ships)
        {
            for (Position position : ship.positions)
            {
                if (position.Equals(shot))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static ArrayList<Ship> InitializeShips()
    {
        ArrayList<Ship> ships = new ArrayList<Ship>();
        ships.add(new Ship( "Aircraft Carrier",  5, Color.BLUE));
        ships.add(new Ship( "Battleship",  4, Color.RED));
        ships.add(new Ship( "Submarine",  5, Color.GRAY));
        ships.add(new Ship( "Destroyer",  5, Color.YELLOW));
        ships.add(new Ship( "Patrol Boat",  5, Color.GREEN));
        return ships;
    }

    Character[][] boardGame = {
            {' ','A','B','C','D','E','F','G','H'},
            {'1',' ',' ',' ',' ',' ',' ',' ',' '},
            {'2',' ',' ',' ',' ',' ',' ',' ',' '},
            {'3',' ',' ',' ',' ',' ',' ',' ',' '},
            {'4',' ',' ',' ',' ',' ',' ',' ',' '},
            {'5',' ',' ',' ',' ',' ',' ',' ',' '},
            {'6',' ',' ',' ',' ',' ',' ',' ',' '},
            {'7',' ',' ',' ',' ',' ',' ',' ',' '},
            {'8',' ',' ',' ',' ',' ',' ',' ',' '}};

    public Character[][] setAirCraft(String positionAndOrientation) {

        int size = 5;
        int column  = ((int) Character.toUpperCase(positionAndOrientation.charAt(0))) - ASCII_A + TABLE_OFFSET;
        int row = Integer.parseInt(positionAndOrientation.substring(1,2));
        char orientation = positionAndOrientation.charAt(2);

        for(int x = 0 ; x < size ; x++){
            boardGame[row][column]='A'; //TODO
            column++;
        }

        return boardGame;
    }
}