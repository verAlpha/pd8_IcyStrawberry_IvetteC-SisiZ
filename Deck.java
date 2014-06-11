public class Deck{
    
    private Card[] deck;
    private int current;

    // String[] cards = {"Jail Card", "Penalty Card", "Reward Card", "Generous Card", "Receiving Card"};

    String[] cards = {//Advance to Go (Collect $200) 
		      //Advance to Illinois Ave. 
		      //Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times the amount thrown. 
		      //Advance token to the nearest Railroad and pay owner twice the rental to which he/she is otherwise entitled. If Railroad is unowned, you may buy it from the Bank. (There are two of these.) 
		      //Advance to St. Charles Place – if you pass Go, collect $200 
	"Bank pays you dividend of $50",
	//Get out of Jail free – this card may be kept until needed, or traded/sold--TOO COMPLICATED PROB WON'T USE
	//Go back 3 spaces 
	//Go directly to Jail – do not pass Go, do not collect $200 
	//Make general repairs on all your property – for each house pay $25 – for each hotel $100 
	"Pay poor tax of $15",
	//Take a trip to Reading Railroad – if you pass Go collect $200 
	//Take a walk on the Boardwalk – advance token to Boardwalk 
	//You have been elected chairman of the board – pay each player $50 
	"Your building loan matures – collect $150 ",
	"You have won a crossword competition - collect $100",

    };

    int[] money = {50 , -15 , 150 , 100}; 


    public Deck(){
	deck = new Card[cards.length];
	for (int i = 0; i < cards.length; i++){
	    deck[i] = new Card("addMoney", cards[i], money[i]);
	}
	curent = 0;
    }

    public Card[] getDeck( ){
	return deck;
    }

    public Card getCard(int index){
	return deck[index - 1];
    }

    public Card getNext(){
	if (current == deck.length - 1){
	    //shuffle();
	    current = 0;
	    return deck[deck.length - 1];
	}
	current ++;
	return deck[current - 1];
    }

    //maybe add in some sort of shuffling mechanism??
    public void shuffle(){
	Card[] temp = new Card[deck.length];
	


    }


}
