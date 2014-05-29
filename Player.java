public class Player extends Character{
    
    ArrayList<BoardNode> myProp;

    public Character(String n, Board b){
	super();
	
    }

    public int roll(){
	super;
    }

    public void buyProperty( BoardNode location ){
	if (money > location.getPrice() && myProp.size() == 0)
	    myProp.add(location);
	if (money > location.getPrice() && hasProperty(location)==false)
	    myProp.add(location);
	else{
	    System.out.println(" Not enough money or already bought property.");
	    // to implement: check whether another person already claimed it.
	}
    }
	

    public void payRent(BoardNode location);

    public void move(){
	super;
    }

    /*========= Helper Methods ============*/
    public boolean hasProperty(BoardNode location){
	for (BoardNode b: myProp)
	    if (loc.getName() == b.getName())
		return true;
	return false;
    }

}
