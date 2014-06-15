//testing github

import java.util.Scanner;

public class Player extends Character{
    

    public Player(String n, Board b){
	super(n,b);
    }

    public boolean buyProperty(BoardNode location){
	Scanner scan = new Scanner(System.in);
	System.out.println("\nWould you like to purchase " +
			   location.getName() + "($" +
			   location.getPrice() +")"+ "? (yes/no)");
	String input = scan.nextLine();
	while (!(input.equals("yes") || input.equals("no"))){
	    System.out.println("invalid input");
	    input = scan.nextLine();
	}
	if(input.equals("yes")){
	    super.buyProperty(location);
	    return true;
	}else if(input.equals("no")){
	    return false;
	}
	/*else {
	    System.out.println("invalid input");
	    super.buyProperty(location);
	    }*/
	// ^does not work instead it gets exited ^
	return false;
    }

    public void buyHouse(){
     	System.out.println("for which property would you like to buy a house/hotel? (house/hotel/cancel)");
     	Scanner scan = new Scanner(System.in);
     	String prop = scan.nextLine();
	int x = -1;
	if (prop.equals ("cancel"))
	    x = -2;
	else{
	    for (int i = 0; i < properties.length; i++){
		if (properties[i] != null)
		    if( properties[i].getName().equals( prop )){
			x = i;
			break;
		    }
	    
	    }
	}
	if (x == -1){
	    System.out.println("you do not own " + prop +
			       ", or you typed it out wrong,");
	}else if (x == -2){
	    System.out.println("Transaction was canceled.");
	} else if( !properties[x].getFullSet() ){
	    System.out.println("you don't own all the properties of this color");
	    //fill in color?
	    //too hard? colors are numbers
	}else if ((properties[x].getColor()/4) * 50 > money){
	    System.out.println("you do not have enough money to buy a house/hotel for" +  properties[x].getName());

	} else{
	    //maybe have ability to buy multiple houses at once?
	    properties[x].addHouse();
	    money -= properties[x].getColor()/4 * 50 ;
	}
    }

    public boolean  move(){
	moveHelp();
	boolean boo = true;
	System.out.println("\n" + name+ ", what would you like to do anything else?" +
			   "(buy house/get stats/pass)"); 
	while(boo){
	    Scanner scan = new Scanner(System.in);
	    String input = scan.nextLine();
	    if(input.equals("pass")){
		System.out.println(name+ "'s turn is over.");
		boo = false;
		break;
	    }else if(input.equals("buy house")){
		buyHouse();
	    }else if(input.equals("get stats")){
		getStats();
	    }else if(input.equals("trade")){

	    }else{
		System.out.println("invalid input, try again");
	    }
	    System.out.println(name + ", would you like to do anything else? (buy house/get stats/pass)");

	}
	System.out.println("\n");
	return endConditions();


    }

  

}
