public class Board{
      
    BoardNode _start;
    BoardNode[] characterLocations;
    Deck _chance;
    //Deck _communityChest;
      
    public Board(int characternumber){
	characterLocations = new BoardNode[characternumber];
	
	_start = new BoardNode("GO",-1, -1, -1, "GO", null);

        String[] locs = {"Boardwalk", "Park Place", "Bond Street", "Card",
			 "Pennsylvania Avenue","North Carolian Street", "Paciffic Avenue","Card",
			 "Marvin Garens","Ventor Avenue", "Atlantic Avenue","Card",
			 "Illinois Avenue", "Indiana Avenue","Kentuky Avenue","Jail",
			 "New York Avenue", "Tennesse Avenue", "St.James Place","Card",
			 "Virginia Avenue", "States Avenue","St.Charles Place","Card",
			 "Connectict Avenue", "Vermont Avenue","Oriental Avenue","Card",
			 "Baltic Avenue", "Mediteranina Avenue","Oxford Street"};
	BoardNode temp = _start;
	
	for (int i = 0; i < locs.length; i++){
	    if (locs[i].equals("Card")){
		temp = new BoardNode("Card",-1, -1, -1, locs[i], temp);
	    }else if(locs[i].equals("Jail")){
		temp = new BoardNode("Jail",-1, -1, -1, locs[i], temp);
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


}
