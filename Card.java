public class Card {
    
    private String name;
    private int cardNumber;
    private String message;//add real card things like bank error collect 100?

    public Card(String s, int n){
	name = s;
	cardNumber = n;
    }

    public String getName(){
	return name;
    }

    public int getCardNumber(){
	return cardNumber;
    }
}
