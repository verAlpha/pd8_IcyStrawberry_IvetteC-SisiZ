//testing github

import java.util.Scanner;

public class Player extends Character{
    

    public Player(String n, Board b){
	super(n,b);
    }

    public boolean buyProperty(BoardNode location){
	Scanner scan = new Scanner(System.in);
	System.out.println("Would you like to purchase " +
			   location.getName()+ "? ($" +
			   location.getPrice() +")");
	String input = scan.nextLine();
	if(input.equals("yes")){
	    super.buyProperty(location);
	    return true;
	}else if(input.equals("no")){
	    return false;
	}else {
	    System.out.println("invalid input");
	    super.buyProperty(location);
	}
	return false;
    }

    public void getStats(){
	System.out.println("name: " + name);
	System.out.println("money: $" + money);
	System.out.println("properties: ");
	//make function to print this whith houses too
	System.out.println("current location" + currentLocation.getName());
    }

    public void buyHouse(){
     	System.out.println("for which property would you like to buy a house?");
     	Scanner scan = new Scanner(System.in);
     	String prop = scan.nextLine();
     	int x = -1;
     	for (int i = 0; i < properties.length; i++){
     	    if (properties[i] != null){
     		if( properties[i].getName().equals( prop )){
     		    x = i;
		    break;
		}
	    }
	}
	if (x == -1){
	    System.out.println("you do not own " + prop +
			      ", or you typed it out wrong,");
	}else if( properties[x%3] != null &&
		  properties[x%3 + 1] != null &&
		  properties[x%3 + 2] != null ){
	    System.out.println("you don't own all the "+"__color"+" properties");
			       //fill in color?
	}else if ((properties[x].getColor()/4) * 50 > money){
	    System.out.println("you do not have enough money to buy a house for" +
			       properties[x].getName());

	} else{
	    //maybe have ability to buy multiple houses at once?
	    properties[x].addHouse();
	    money -= properties[x].getColor()/4 * 50 ;
	}
    }

    public boolean  move(){
	moveHelp();
	boolean boo = true;
	System.out.println(name+ ", what would you like to do anything else?" +
			   "(buy house, trade, get stats, pass)"); 
	while(boo){
	    Scanner scan = new Scanner(System.in);
	    String input = scan.nextLine();
	    if(input.equals("pass")){
		System.out.println(name+ "'s turn is over");
		boo = false;
	    }else if(input.equals("buy house")){
		buyHouse();
	    }else if(input.equals("get stats")){
		getStats();
	    }else if(input.equals("trade")){
	    
	    }else{
		System.out.println("invalid input, try again");
	    }
		
	}
	return endConditions();

	
    }

  

}
