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

    public void buyHouse(){
	System.out.println("for which property would you like to buy a house?");
	Scanner scan = new Scanner(System.in);
	String prop = scan.nextLine();
	int x = -1;
	for (int i = 0; i < properties.length; i++){
	    if (properties[i].getName().equals( prop )){
		x = i;
		break;
	    }
	}
	if (x == -1){
	    System.out.println("you do not own " + prop +
			      ", or you typed it out wrong,");
	}else if( properties[x%3] != null &&
		  properties[x%3 + 1] != null &&
		  properties[x%3 + 2] != null &&){
	    System.out.println("you don't own all the "+"__color"+" properties");
			       //fill in color?
	}else if ((color/4) * 50 > money){
	    System.out.println("you do not have enough money to buy ab house for" +
			       properties[x].getName())

	} else{
	    //maybe have ability to buy multiple houses at once?
	    properties[x].addHouse();
	    money -= (color/4) * 5;
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
