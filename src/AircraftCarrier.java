import java.awt.*;

class AircraftCarrier extends Ship {
    AircraftCarrier(ISea gameController) {
        super("Aircraft Carrier", 5, Color.BLUE,gameController);
        code = 'A';
    }
    AircraftCarrier(){
        this(null);
    }
}
