//testing github

import java.util.Scanner;

public class Player extends Character{
    

    public Player(String n, Board b){
	super(n,b);
    }

    public boolean buyProperty(BoardNode location){
	Scanner scan = new Scanner(System.in);
	System.out.println("Would you like to purchase " +
			   location.getName()+ "? (" +
			   location.getRent() +")");
	String input = scan.nextLine();
	if(input.equals("yes")){
	    super.buyProperty(location);
	    return true;
	}else if(input.equals("no")){
	    return false;
	}else {
	    System.out.println("invalid input");
	    askBuy(location);
	}
	return false;
    }

    public BoardNode buyHouse(){
	System.out.println("for which property would you like to buy a house?");
	Scanner scan = new Scanner(System.in);
	String prop = scan.nextLine();
	boolean own = false;
	for (BoardNode x: properties){
	    if (x.getName() == prop){
		own = true;
		break;
	    }
	}
	if (own == false){
	    System.out.println("you do not own that location or you entered it wrong,");
	    return null;
}	
    }

    public void move(){
	super.move();
	boolean boo = true;
	System.out,println(name+ ", what would you like to do anything else? (buy houses, trade, pass)"); 
	while(boo){
	    Scanner scan = new Scanner(System.in);
	    String input = scan.nextLine();
	    if(input.equals("pass")){
		System.out.println(name+ "'s turn is over");
		boo = false;
	    }else if(input.equals("buy house")){
		buyhouse();
	    }else if(input.equals("trade")){
	    
	    }
		
	}
	
    }

  

}
