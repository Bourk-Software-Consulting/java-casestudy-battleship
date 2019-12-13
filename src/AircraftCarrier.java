import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AircraftCarrier extends Ship {
    private static final Character AircraftCarrierCode = 'A';

    public static int size = 5;

    public AircraftCarrier() {
        super("Aircraft Carrier",  size, Color.BLUE);
    }

    @Override
    public void place() throws IOException {
        System.out.println();
        System.out.println("Please enter the position for the Front of the Ship with its orientation (Horizontal (H) or Vertical (V) for the "+ this.name +" (size: "+ size+")" );
        System.out.println("example: A4H = will result in placing the Aircraft Carrier at Coordinates: A4 A5 A6 A7 A8");
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));

        boolean placing = true;
        while(placing){
            try {
                String positionAndOrientation = obj.readLine();
                placeAt(positionAndOrientation);
                placing=false;
            }
            catch (Exception e){
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
            GameController.boardGame[row][column]= AircraftCarrierCode;

            if(orientation == 'H')
                column++;
            else
                row++;
        }
    }
}
