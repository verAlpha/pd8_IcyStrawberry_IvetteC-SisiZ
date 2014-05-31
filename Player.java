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
	Scanner scan = new Scanner(System.in);
	String input = scan.nextLine();
	while(!input.equals("")){
		
		
	}
	
    }

  

}
