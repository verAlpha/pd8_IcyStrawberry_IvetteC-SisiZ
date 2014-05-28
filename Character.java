public class Character{

    String name;
    int money;
    ArrayList<BoardNode> properties;
    BoardNode CurrentLocation;
    Board board;

    public Character(String n, Board b){
            name = n;
            money = 1500;
            properties = null;
            Board = b;
            CurrentLocation = b.start();
    }

    public int roll(){
        return (int)(Math.random() *6) + 1;
    }

    public void buyProperty( BoardNode location );

    public void payRent(BoardNode location);

    

}
