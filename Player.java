import java.io.*;

public class Player extends Character{
    

    public Player(String n, Board b){
	super(n,b);
    }

    public void buyProperty( BoardNode location ){
	if (money > location.getPrice() && location.getOwner() == null)
	    myProp.add(location);
	if (hasProperty() )
	    System.out.println("you already own this property");
	else{
	    System.out.println(" Not enough money or already bought property.");
	    // to implement: check whether another person already claimed it.
	}
    }


  

    public boolean Buy(BoardNode location){
	Scanner scan = new Scanner;
	System.out.println("Would you like to purchase " +
			   location.getName()+ "? (" +
			   location.getRent() +")");
	String input = scan.nextLine();
	if(input.equal("yes")){
	    buyproperty(location);
	    return true;
	}else if(input.equals("no")){
	    return false;
	}else {
	    System.out.println("invalid input");
	    askBuy(location);
	}
    }

    
    public void move(){
	super();
	Scanner scan = new Scanner();
	
	while(){
		
		
	}
	
	}

    /*========= Helper Methods ============*/
    public boolean hasProperty(BoardNode location){
	for (BoardNode b: myProp)
	    if (loc.getName() == b.getName())
		return true;
	return false;
    }

}
