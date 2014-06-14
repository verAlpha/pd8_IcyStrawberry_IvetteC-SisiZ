//test

import java.util.ArrayList;

public class Character{

    String name;
    int money;
    int initialDiceRoll;
    BoardNode[] properties;
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
    

    public void getStats(){
	System.out.println("NAME: " + name);
	System.out.println("MONEY: $" + money);
	System.out.println("PROPERTIES:");
	for(BoardNode x: properties){
	    if(x != null){
		System.out.println(" - "+ x.getName() + " (" +
				    "with " +  x.getHouseNum() + " houses)");
	    }
	}
	System.out.println("CURRENT LOCATION: " + currentLocation.getName());
	System.out.println("\n");
    }
   
    /* 
    public static String stringify(BoardNode[] b){
	String s = "";
	for(int i = 0; i < b.length; i++){
	    if(b[i] == null){
		s+= "null , ";
	    }else {
		s+= b[i].getName() + " , ";
	    }
	}
	return s;
	}*/


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
	    //add something about having full sets, put yet another variable in boardNode?bookean fullSet?
	    boolean full = false;
	    int x = location.getColor();
	    for (int i = 0; i < 3; i++){
		if (properties[x*3 + i] == null){
		    properties[x*3 + i] = location;
		    if(i == 2){
			full = true;
		    }
		    // System.out.println(stringify(properties));
		    ////////
		    break;
		   
		}
	    }
	    if(full){
		for (int i = 0; i < 3; i++){
		    properties[x*3 +i].makeFullSet();
		    properties[x*3 +i].setRent(properties[x*3 +i].getRent() * 2);
		}
	    }
	
	    
	    money -= location.getPrice();
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

    public void drawCard(){
	Card c = board.getChance().getNext();
	if(c.getAmountAdded() != 0){
	    money += c.getAmountAdded();
	    board.addToFreeParking(c.getAmountAdded());
	    System.out.println(c.getName());
	}
	else if (c.getNewLoc() != null){
	    boolean go = false;
	    while(currentLocation.getNext().getName().equals( c.getNewLoc())){
		if (currentLocation.getNext().getName().equals("GO")){
		    go = true;
		}
		currentLocation = currentLocation.getNext();
	    }
	    currentLocation= currentLocation.getNext();
	    if(go){
		System.out.println("you passed GO as you were going to" +
				   c.getNewLoc() + ", collect $200");
	    }
	    locAction();
	}

    }

    public boolean endConditions(){
	//true means game over
	//false means game not over
	if(money <= 0){
	    System.out.println( name + "has no money left and had lost");
	    return true;
	}
	return false;
	//more conditions later?
	//add something in for who has won?
	//if one player loses does the game end? or others continue?
    }

  
    public void changeLocation(){
	int x = roll();
	for (int i = 0; i< x; i++){
            currentLocation = currentLocation.getNext();
        }
        System.out.println(name+" landed on "+ currentLocation.getName());
    }
  
    public void locAction(){
	if (currentLocation.getType().equals("Property")){
	    if(currentLocation.getOwner() != null){
		payRent( currentLocation );	
	    }else{
		buyProperty(currentLocation);
	    }
	}else if (currentLocation.getType().equals("Card")){
	    drawCard();
	    //cards initiall just add or subtract $??
	    /*}else if (currentLocation.getType().equals("Jail")){
	   System.out.println("just visting jail");*/
	}else if (currentLocation.getType().equals("GO")){
	    //do nothing
	    System.out.println("pass go collect 200");
	    money += 200;
	}
	else if(currentLocation.getType().equals("FreeParking")){
	    int m = board.getFreePaking();
	    money += m;
	    System.out.println("You gained $" + m + "from free parking");
	    board.emptyFreeParking();
	}
    }

    public void  moveHelp(){
	changeLocation();
        locAction();
    }
    public boolean move(){//overriden by subclasses
	return false;
    }
    
    /*========== Accesor Methods =============*/
    public String getName(){
	return name;
    }
    public int getMoney(){
	return money;
    }
    public int getInitialDiceRoll(){
	return initialDiceRoll;
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
    public void setInitialDiceRoll(int x){
	initialDiceRoll = x;
    }

}
