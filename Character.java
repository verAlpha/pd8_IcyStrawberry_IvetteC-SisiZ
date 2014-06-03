import java.util.ArrayList;

public class Character{

    String name;
    int money;
    int number;
    BoardNode[] properties;
    //maybe turn into array of arrays? to sort by color?   
    BoardNode currentLocation;
    Board board;

    public Character(String n, Board b){
            name = n;
            money = 1500;
            properties = new BoardNode[24];
            board = b;
            currentLocation = b.start();
    }

    public int roll(){
        int x = (int)(Math.random() *6) +  (int)(Math.random() *6) + 2; 
        System.out.println(name+" rolled a: " + x);
        return x;
        //maybe add in something for doubles later?
        //possibly have character press something to roll?
    }

    public boolean buyProperty( BoardNode location ){
	if(location.getOwner() != null){
	    System.out.println(location.getOwner().getName() + 
			       " already owns " + location.getName() );
	    return false;
	}else if(location.getPrice() > money){
	    System.out.println("you do not have enough money to buy "
			       + location.getName());
	    return false;
	}else{
	    int x = location.getColor();
	    for (int i = 0; i < 3; i++){
		if (properties[x*3 + i] == null){
		    properties[x*3 + i] = location;
		    break;
		}
	    }
	    location.setOwner(this);
	    return true;
	}
    }

    public void payRent(BoardNode location){
	location.getOwner().setMoney(location.getOwner().getMoney()+
				     location.getRent());
	money -= location.getRent();
	System.out.println("rent paid");
    }

    public void move(){
        int x = roll();
        for (int i = 0; i< x; i++){
            currentLocation = currentLocation.getNext();
        }
        System.out.println(name+" landed on "+ currentLocation.getName());
	if(currentLocation.getOwner() != null){
            payRent( currentLocation );	
	}else if (currentLocation.canPurchase()){
	    buyProperty(currentLocation);
        }
	/*
	  non-properties do later
	  optional stuff like buying houses in subclasses
	 */
            
    }

    
    /*========== Accesor Methods =============*/
    public String getName(){
	return name;
    }
    public int getMoney(){
	return money;
    }
    public int getNumber(){
	return number;
    }
    public BoardNode[] getProperties(){
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
    public void setName(String s){
	name = s;
    }

}
