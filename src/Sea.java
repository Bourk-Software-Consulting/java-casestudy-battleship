public class Sea implements ISea
{
   private Character[][] boardgame= {
        {' ','A','B','C','D','E','F','G','H'},
        {'1',' ',' ',' ',' ',' ',' ',' ',' '},
        {'2',' ',' ',' ',' ',' ',' ',' ',' '},
        {'3',' ',' ',' ',' ',' ',' ',' ',' '},
        {'4',' ',' ',' ',' ',' ',' ',' ',' '},
        {'5',' ',' ',' ',' ',' ',' ',' ',' '},
        {'6',' ',' ',' ',' ',' ',' ',' ',' '},
        {'7',' ',' ',' ',' ',' ',' ',' ',' '},
        {'8',' ',' ',' ',' ',' ',' ',' ',' '}};

    @Override
    public void placeShip(int row, int column, Character shipCode) {
        boardgame[row][column]=shipCode;
    }

    public Character[][] getBoardgame() {
        return boardgame;
    }
}
