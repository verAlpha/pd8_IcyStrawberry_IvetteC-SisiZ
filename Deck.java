public class Deck{
    
    private Card[] deck;
    private int current;

    String[] cards = {"Jail Card", "Penalty Card", "Reward Card", "Generous Card", "Receiving Card"};

    public Deck(){
	for (int i = 0; i < cards.length; i++){
	    deck[i] = new Card(cards[i], i + 1);
	}
    }

    public Card[] getDeck( ){
	return deck;
    }

    public Card getCard(int index){
	return deck[index - 1];
    }

    public Card getNext(){
	if (current == deck.length - 1){
	    current = 0;
	    return deck[deck.length - 1];
	}
	current ++;
	return deck[current - 1];
    }

}
