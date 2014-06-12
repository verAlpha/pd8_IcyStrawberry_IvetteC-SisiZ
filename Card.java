public class Card {
    
    // private String type;//for now all just add/subtract $
    //later change location, and pay/get $from other players?
    private int ammountAdded;
    private String name;//add real card things like bank error collect 100?
    private String newLoc;

    public Card( String s, int n, String l){
	name = s;
	ammountAdded = n;
	//type = t;
	newLoc = l;
    }

    public String getName(){
	return name;
    }

    public int getAmountAdded(){
	return ammountAdded;
    }
    public String getNewLoc(){
	return newLoc;
    }

}
