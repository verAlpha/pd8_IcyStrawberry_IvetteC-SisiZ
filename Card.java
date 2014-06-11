public class Card {
    
    private String type;//for now all just add/subtract $
    //later change location, and pay/get $from other players?
    private int ammountAdded;
    private String name;//add real card things like bank error collect 100?

    public Card(String t, String s, int n){
	name = s;
	cardNumber = n;
	type = t;
    }

    public String getName(){
	return name;
    }

    public int getAmountAdded(){
	return ammountAdded;
    }

    public String getType(){
	return type;
    }

}
