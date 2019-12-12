import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/// <summary>
///     The game controller.
/// </summary>
public class GameController
{
    /// <summary>
    /// Checks the is hit.
    /// </summary>
    /// <param name="ships">
    /// The ships.
    /// </param>
    /// <param name="shot">
    /// The shot.
    /// </param>
    /// <returns>
    /// True if hit, else false
    /// </returns>
    /// <exception cref="System.IllegalArgumentException">
    /// ships
    ///     or
    ///     shot
    /// </exception>
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

    /// <summary>
    ///     The initialize ships.
    /// </summary>
    /// <returns>
    ///     The <see cref="Iterable" />.
    /// </returns>
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

    /// <summary>
    /// The is ships valid.
    /// </summary>
    /// <param name="ship">
    /// The ship.
    /// </param>
    /// <returns>
    /// The <see cref="Boolean"/>.
    /// </returns>
    public static Boolean IsShipValid(Ship ship)
    {
        return ship.positions.size() == ship.size;
    }

    public static Position GetRandomPosition(int size)
    {
        Letters lettre = Letters.values()[(int)(Math.random()*Letters.values().length)];
        Random random = new Random();
        Integer number = random.nextInt(size);
        Position position = new Position(lettre, number);
        return position;
    }
}