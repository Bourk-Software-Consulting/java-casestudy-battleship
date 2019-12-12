import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static ArrayList<Ship> myFleet;
    private static ArrayList<Ship> enemyFleet;

    public static void main(String[] args) throws IOException {
        System.out.flush();

        System.out.println(
                           "                                     |__\" +\n" +
                "                                                |\\/\" +\n" +
                "                                                 ---\" +\n" +
                "                                         !      | |||\" +\n" +
                "                                       _/|     _/|-++'\" +\n" +
                "                                    +  +--|    |--|--|_ |-\" +\n" +
                "                                 { /|__|  |/\\__|  |--- |||__/\" +\n" +
                "                                +---------------___[}-_===_.'____                 /\\\" +\n" +
                "                            ____`-' ||___-{]_| _[}-  |     |_[___\\==--            \\/   _\" +\n" +
                "             __..._____--==/___]_|__|_____________________________[___\\==--____,------' .7\" \n" +
                "           |                        Welcome to Battleship                         BB-61/\" \n" +
                "            \\_________________________________________________________________________|\"\n" +
                "        ;");
        InitializeGame();

        StartGame();
    }

    private static void StartGame() throws IOException {
        System.out.flush();
        System.out.println("                  __");
        System.out.println("                 /  \\");
        System.out.println("           .-.  |    |");
        System.out.println("   *    _.-'  \\  \\__/");
        System.out.println("    \\.-'       \\");
        System.out.println("   /          _/");
        System.out.println("  |      _  /\"\"");
        System.out.println("  |     /_\'");
        System.out.println("   \\    \\_/");
        System.out.println("    \"\"\"\"\"\"\"\"");

        do
        {
            System.out.println();
            System.out.println("Player, it's your turn");
            System.out.println("Enter coordinates for your shot :");
            BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
            Position position = ParsePosition(obj.readLine());
            Boolean isHit = GameController.CheckIsHit(enemyFleet, position);
            if (true)
            {
                DisplayHit();
            }

            System.out.println(isHit ? "Yeah ! Nice hit !" : "Miss");

            position = GetRandomPosition();
            isHit = GameController.CheckIsHit(myFleet, position);
            System.out.println();
            System.out.println("Computer shot in "+position.Column + position.Row +" and "+ (isHit ? "has hit your ship !" : "miss"));
            if (isHit)
            {
                DisplayHit();
            }
        }
        while (true);
    }

    private static Position GetRandomPosition()
    {
        int rows = 8;
        Letters letter = Letters.values()[(int)(Math.random()*Letters.values().length)];
        Random random = new Random();
        Integer number = random.nextInt(rows);
        Position position = new Position(letter, number);
        return position;
    }

    private static void InitializeGame() throws IOException {
        InitializeMyFleet();
        InitializeEnemyFleet();
    }

    private static void InitializeMyFleet() throws IOException {
        myFleet = GameController.InitializeShips();
        System.out.println("Please position your fleet (Game board size is from A to H and 1 to 8) :");

        for (Ship ship : myFleet)
        {
            System.out.println();
            System.out.println("Please enter the positions for the "+ship.name+" (size: "+ship.size+")" );
            for (int i = 1; i <= ship.size; i++)
            {
                System.out.println("Enter position "+i+ " of "+ship.size +" (i.e A3):");
                BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
                ship.AddPosition(obj.readLine());
            }
        }
    }
    private static void DisplayHit()
    {
        System.out.println( "                \\         .  ./"  +"\n" +
                "              \\      .:\"\";'.:..\"\"   /" + "\n" +
                "                  (M^^.^~~:.'\"\")." + "\n" +
                "            -   (/  .    . . \\ \\)  -" + "\n" +
                "               ((| :. ~ ^  :. .|))" + "\n" +
                "            -   (\\- |  \\ /  |  /)  -" + "\n" +
                "                 -\\  \\     /  /-" + "\n" +
                "                   \\  \\   /  /" + "\n");
    }

    public static Position ParsePosition(String input)
    {
        Letters letter = Letters.values()[(int)(Math.random()*Letters.values().length)];
        Integer number = Integer.parseInt(input.substring(1, 2));
        return new Position(letter, number);
    }

    private static void InitializeEnemyFleet()
    {
        enemyFleet = GameController.InitializeShips();

        enemyFleet.get(0).positions.add(new Position ( Letters.B,  4 ));
        enemyFleet.get(0).positions.add(new Position (  Letters.B,  5 ));
        enemyFleet.get(0).positions.add(new Position (  Letters.B,  6 ));
        enemyFleet.get(0).positions.add(new Position (  Letters.B,  7 ));
        enemyFleet.get(0).positions.add(new Position (  Letters.B,  8 ));

        enemyFleet.get(1).positions.add(new Position (  Letters.E,  6 ));
        enemyFleet.get(1).positions.add(new Position (  Letters.E,  7 ));
        enemyFleet.get(1).positions.add(new Position (  Letters.E,  8 ));
        enemyFleet.get(1).positions.add(new Position (  Letters.E,  9 ));

        enemyFleet.get(2).positions.add(new Position (  Letters.A,  3 ));
        enemyFleet.get(2).positions.add(new Position (  Letters.B,  3 ));
        enemyFleet.get(2).positions.add(new Position (  Letters.C,  3 ));

        enemyFleet.get(3).positions.add(new Position (  Letters.F,  8 ));
        enemyFleet.get(3).positions.add(new Position (  Letters.G,  8 ));
        enemyFleet.get(3).positions.add(new Position (  Letters.H,  8 ));

        enemyFleet.get(4).positions.add(new Position (  Letters.C,  5 ));
        enemyFleet.get(4).positions.add(new Position (  Letters.C,  6 ));
    }
}
