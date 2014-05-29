import java.util.ArrayList;

public class Character{

    String name;
    int money;
    int number
    ArrayList<BoardNode> properties;
    BoardNode currentLocation;
    Board board;

    public Character(String n, Board b){
            name = n;
            money = 1500;
            properties = null;
            board = b;
            currentLocation = b.start();
    }

    public int roll(){
        int x = (int)(Math.random() *6) +  (int)(Math.random() *6) + 2; 
        System.out.println("you rolled a: " + x);
        return x;
        //maybe addin something for doubles later?
    }

    public void buyProperty( BoardNode location );

    public void payRent(BoardNode location);

    public void askBuy(currentLocation){
        
    }

    public void move(){
        int x = roll()
        for (int i = 0; i< x; i++){
            currentLocation = currentLocation.getNext();
        }
        if (currentLocation.canPurchase()){
            if(currentLocation.getPrice() < money){
                askBuy(currentLocation);
            }else{
                System.out.println("you do not have enough movey to purchase this location");
            }
        }else{
            //if has owner pay rent
                //if can't pay rent lose
            //if non-purchusable thing do that action
            
        }
    }

}
