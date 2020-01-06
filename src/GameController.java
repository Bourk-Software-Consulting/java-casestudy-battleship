import java.awt.*;
import java.util.ArrayList;

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
        ships.add(new AircraftCarrier());
        ships.add(new Ship( "Battleship",  4, Color.RED));
        ships.add(new Ship( "Submarine",  5, Color.GRAY));
        ships.add(new Ship( "Destroyer",  5, Color.YELLOW));
        ships.add(new Ship( "Patrol Boat",  5, Color.GREEN));
        return ships;
    }


}