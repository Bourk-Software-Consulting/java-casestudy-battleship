import java.awt.*;

public class Cruiser extends Ship{
    public Cruiser(ISea gameController) {
        super("Cruiser",3, Color.GREEN,gameController);
        code='C';
    }
}
