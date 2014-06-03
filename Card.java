public Card {
    
    private String name;
    private int cardNumber;

    public Card(String s, int n){
	name = s;
	cardNumber = n;
    }

    public String getName(){
	return name;
    }

    public String getCardNumber(){
	return cardNumber;
    }
}