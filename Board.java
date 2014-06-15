public class Board{
      
    BoardNode _start;
    BoardNode[] characterLocations;
    Deck _chance;
    int _freeParking;
    //Deck _communityChest;
      
    public Board(int characternumber){
	characterLocations = new BoardNode[characternumber];

	_start = new BoardNode("GO",-1, -1, -1, "GO", null);

        String[] locs = {"Boardwalk", "Park Place", "Bond Street", "Chance",
			 "Pennsylvania Avenue","North Carolian Street", "Paciffic Avenue","Chance",
			 "Marvin Garens","Ventor Avenue", "Atlantic Avenue","Chance",
			 "Illinois Avenue", "Indiana Avenue","Kentuky Avenue","Free Parking",
			 "New York Avenue", "Tennesse Avenue", "St.James Place","Chance",
			 "Virginia Avenue", "States Avenue","St.Charles Place","Chance",
			 "Connectict Avenue", "Vermont Avenue","Oriental Avenue","Chance",
			 "Baltic Avenue", "Mediteranina Avenue","Oxford Street"};
	BoardNode temp = _start;

	/*Ivette, I got rid of the jail because it seemed too complcated and it had no features yet,
	  I replaced it with free parking but if you have ideas on implementing the jail you can add it
	  back in, in place of a card or something.
	 */
	for (int i = 0; i < locs.length; i++){
	    if (locs[i].equals("Chance")){
		temp = new BoardNode("Card",-1, -1, -1, locs[i], temp);
	    }else if(locs[i].equals("Jail")){
		temp = new BoardNode("FreeParking",-1, -1, -1, locs[i], temp);
	    }else{
		temp = new BoardNode("Property", 7-(i/locs.length), (locs.length-i)*2,
				     i*20, locs[i],temp);
	    }
	}
	//add in other types later now just standard properties
        //

	_start.setNext(temp);

	for(int i = 0; i < characterLocations.length; i++){
	    characterLocations[i] = _start;
	}
	_chance = new Deck();
	_freeParking = 0;
	//_communityChest = new Deck();

    }

    public Deck getChance(){
	return _chance;
    }
  
    public void setCharacterLocaton(BoardNode newLoc, Character c){
	characterLocations[c.getNumber()] = newLoc;            
    } 

    public BoardNode start(){
	return _start;
    }
    public int getFreePaking(){
	return _freeParking;
    }
    public void addToFreeParking(int x){
	_freeParking += x;
    }
    public void emptyFreeParking(){
	_freeParking = 0;
    }
    

}
