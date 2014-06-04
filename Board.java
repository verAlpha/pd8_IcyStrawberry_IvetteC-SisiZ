public class Board{
      
    BoardNode _start;
    BoardNode[] characterLocations;
      
    public Board(int characternumber){
	characterLocations = new BoardNode[characternumber];
	
	_start = new BoardNode(false,-1, -1, -1, "GO", null);

        String[] locs = {"Boardwalk", "Park Place", "Bond Street", "Card",
			 "Pennsylvania Avenue","North Carolian Street", "Paciffic Avenue","Card",
			 "Marvin Garens","Ventor Avenue", "Atlantic Avenue","Card",
			 "Illinois Avenue", "Indiana Avenue","Kentuky Avenue","Jail",
			 "New York Avenue", "Tennesse Avenue", "St.James Place","Card",
			 "Virginia Avenue", "States Avenue","St.Charles Place","Card",
			 "Connectict Avenue", "Vermont Avenue","Oriental Avenue","Card",
			 "Baltic Avenue", "Mediteranina Avenue","Oxford Street"};
	BoardNode temp = _start;
	
	for (int i = 0; i < loc.length; i++){
	    if (i % 4 == 0)
		temp = new BoardNode(false,-1, -1, -1, locs[i], temp);
	    else
		temp = new BoardNode(true, 7-(i/loc.length), (loc.length-i)*2,
				     i*20, locs[i],temp);
	}
	//add in other types later now just standard properties
        //

	_start.setNext(temp);

	for(int i = 0; i < characterLocations.length; i++){
	    characterLocations[i] = _start;
	}

    }
  
    public void setCharacterLocaton(BoardNode newLoc, Character c){
	characterLocations[c.getNumber()] = newLoc;            
    } 

    public BoardNode start(){
	return _start;
    }


}
