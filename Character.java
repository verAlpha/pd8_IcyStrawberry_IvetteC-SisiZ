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

  public void payRent(BoardNode location){
	location.getOwner().setMoney(location.getOwner().getMoney()+
				     location.getRent());
	money -= location.getRent();
	System.out.println("rent paid");
    }
    
    public void askBuy(currentLocation){
        //
    }


    public void move(){
        int x = roll();
        System.out.println("You rolled a " + x + " .");
        for (int i = 0; i< x; i++){
            currentLocation = currentLocation.getNext();
        }
        if (currentLocation.canPurchase()){
                askBuy(currentLocation);
        }else if(currentLocation.getOwner != null){
            payRent( currentLocation );
        }/*else if non purchaseable location
            
            
            */
            
        }
    }
    
    /*========== Accesor Methods =============*/
    public String getName(){
	return name;
    }
    public int getMoney(){
	return money;
    }
    public int getNum(){
	return number;
    }
    public ArrayList getProperties(){
	return properties;
    }
    public BoardNode getLocation(){
	return currentLocation;
    }
    public Board getBoard(){
	return board;
    }

    /*========== Mutator Methods =============*/
    public void setMoney(int n){
	money = n;
    }
    public void setLocation(BoardNode nextLocation){
	currentLocation = nextLocation;
    }
}
