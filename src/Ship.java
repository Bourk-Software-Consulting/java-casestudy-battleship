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
    protected Character code = 'S';

    /// <summary>
    /// Gets  the name.
    /// </summary>
    protected String name;

    /// <summary>
    /// The color of the ship
    /// </summary>
    private  Color color;
    private ISea sea;

    private Boolean isPlaced;

    /// <summary>
    /// Initializes a new instance of the <see cref="com.bourksoftware.Ship"/> class.
    /// </summary>
    public Ship(String name, Integer size, java.awt.Color color, ISea boardgame)
    {
        this.name = name;
        this.size = size;
        this.color = color;
        this.sea = boardgame;
        positions = new ArrayList<Position>();
    }
    public Ship(String name, int size, Color color) {
        this(name,size,color,null);
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
        System.out.println("Please enter the position for the Front of the Ship with its orientation (Horizontal (H) or Vertical (V) for the "+ this.name +" (size: "+ size+")" );
        System.out.println("example: A4H = will result in placing the ship at Coordinates: A4 A5 A6 A7 A8");
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));

        boolean placing = true;
        while(placing){
            try {
                String positionAndOrientation = obj.readLine();
                placeAt(positionAndOrientation);
                placing=false;
            }
            catch (Exception e){ //TODO Instead of using Exception - use if, to speed up the program
                System.out.println("Please enter a valid position and orientation");
            }
        }
    }

    public void placeAt(String positionAndOrientation){

        AddPosition(positionAndOrientation.substring(0,2));

        int column  = ((int) Character.toUpperCase(positionAndOrientation.charAt(0))) - GameController.ASCII_A + GameController.TABLE_OFFSET;
        int row = Integer.parseInt(positionAndOrientation.substring(1,2));
        char orientation = positionAndOrientation.charAt(2);

        for(int x = 0 ; x < size ; x++){

            if(sea!=null)
                sea.placeShip(row,column, code);

            if(orientation == 'H')
                column++;
            else
                row++;
        }
    }
}
