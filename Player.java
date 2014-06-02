//testing github

import java.util.Scanner;

public class Player extends Character{
    

    public Player(String n, Board b){
	super(n,b);
    }

    public boolean askBuy(BoardNode location){
	Scanner scan = new Scanner(System.in);
	System.out.println("Would you like to purchase " +
			   location.getName()+ "? (" +
			   location.getRent() +")");
	String input = scan.nextLine();
	if(input.equals("yes")){
	    buyProperty(location);
	    return true;
	}else if(input.equals("no")){
	    return false;
	}else {
	    System.out.println("invalid input");
	    askBuy(location);
	}
	return false;
    }

  
    public void move(){
	super.move();
	boolean boo = true;
	System.out,println(name+ ", what would you like to do anything else? (buy houses, trade, pass)"); 
	while(boo){
	    Scanner scan = new Scanner(System.in);
	    String input = scan.nextLine();
	    if(input.equals("pass")){
		boo = false;
	    }else if(input.equals("buy house")){
	    
	    }else if(input.equals("trade")){
	    
	    }
		
	}
	
    }

  

}
