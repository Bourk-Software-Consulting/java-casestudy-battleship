import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/// <summary>
/// The ship.
/// </summary>
public class Ship
{
    /// <summary>
    /// Gets  the name.
    /// </summary>
    protected String name;

    /// <summary>
    /// The color of the ship
    /// </summary>
    private  Color color;

    private Boolean isPlaced;

    /// <summary>
    /// Initializes a new instance of the <see cref="com.bourksoftware.Ship"/> class.
    /// </summary>
    public Ship(String name, Integer size, java.awt.Color color)
    {
        this.name = name;
        this.size = size;
        this.color = color;
        positions = new ArrayList<Position>();
    }

    /// <summary>
    /// Gets the positions.
    /// </summary>
    public ArrayList<Position> positions;


    /// <summary>
    /// Gets or sets the size.
    /// </summary>
    private Integer size;


    /// <summary>
    /// The add position.
    /// </summary>
    /// <param name="input">
    /// The input.
    /// </param>
    public void AddPosition(String input)
    {
        if (positions == null)
        {
            positions = new ArrayList<Position>();
        }

        Letters letter = Enum.valueOf(Letters.class, input.toUpperCase().substring(0, 1));

        Integer number = Integer.parseInt(input.substring(1, 2));
        positions.add(new Position(letter,  number));
    }

    public Boolean IsPlaced() {
        return isPlaced;
    }
    public void setIsPlaced(Boolean value)
    {
            if (value.equals(isPlaced)) return;
            isPlaced = value;
    }


    public void place() throws IOException {

        System.out.println();
        System.out.println("Please enter the positions for the "+ name+" (size: "+ size+")" );

        for(int  i = 0 ; i < size ; i ++) {
            System.out.println("Enter position " + i + " of " + size + " (i.e A3):");
            BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
            AddPosition(obj.readLine());
        }
    }
}
