public Deck{
    
    private Card[] deck;

    String[] cards = {"Jail Card", "Penalty Card", "Reward Card", "Generous Card", "Receiving Card"};

    public Deck(){
	for (int i = 0: i < cards.length; i++)
	    deck[i] = Card(cards[i], i + 1);
    }

    public Card getDeck( ){
	return deck;
    }

    public Card getCard(int index){
	return deck[index - 1];
    }

}