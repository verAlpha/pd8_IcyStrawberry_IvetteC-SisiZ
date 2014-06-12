public class Deck{
    
    private Card[] deck;
    private int current;

    // String[] cards = {"Jail Card", "Penalty Card", "Reward Card", "Generous Card", "Receiving Card"};

    String[] cards = {
	"Advance to Go (collect $200)",
	"Advance to Illinois Ave.", 
	//Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times the amount thrown. 
	//Advance token to the nearest Railroad and pay owner twice the rental to which he/she is otherwise entitled. If Railroad is unowned, you may buy it from the Bank. (There are two of these.) 
	"Advance to St. Charles Place",
	"Bank pays you dividend of $50",
	//Get out of Jail free – this card may be kept until needed, or traded/sold
	//Go back 3 spaces 
	//Go directly to Jail – do not pass Go, do not collect $200 
	//Make general repairs on all your property – for each house pay $25 – for each hotel $100 
	"Pay poor tax of $15",
	//Take a trip to Reading Railroad – if you pass Go collect $200 
	"Take a walk on the Boardwalk – advance token to Boardwalk",
	//You have been elected chairman of the board – pay each player $50 
	"Your building loan matures – collect $150 ",
	"You have won a crossword competition - collect $100",

	"Advance to Go (collect $200)",
	"Bank error in your favor – collect $75",
	"Doctors fees – Pay $50",
	//"Get out of jail free – this card may be kept until needed, or sold ",
	//"Go to jail – go directly to jail – Do not pass Go, do not collect $200",
	//"It is your birthday Collect $10 from each player ",
	//"Grand Opera Night – collect $50 from every player for opening night seats ",
	"Income Tax refund – collect $20",
	"Life Insurance Matures – collect $100", 
	"Pay Hospital Fees of $100 ",
	"Pay School Fees of $50",
	"Receive $25 Consultancy Fee", 
	//"You are assessed for street repairs – $40 per house, $115 per hotel",
	"You have won second prize in a beauty contest– collect $10",
	"You inherit $100",
	"From sale of stock you get $50",
	"Holiday Fund matures - Receive $100 "
    };

    int[] money = {0 , 0 , 0 , 50 , 0 , 0 , 150 , 100 ,
		   0 , 75 , -50 , 20 , 100 , -100 , -50 , 25 , 10 , 100 , 50 , 100 }; 

    String[] locs = {"GO" , "Illinois Ave" , "St.Charles Place" , null , null , "Boardwalk" , null , null ,
		     "GO" , null , null , null , null , null , null , null , null , null , null , null , null};

    public Deck(){
	System.out.println(cards.length + " , " + locs.length + " , " + money.length);
	deck = new Card[cards.length];
	for (int i = 0; i < cards.length; i++){
	    deck[i] = new Card( cards[i], money[i] , locs[i]);
	}
	current = 0;
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
    /* public void shuffle(){
	Card[] temp = new Card[deck.length];
	


	}*/


}
