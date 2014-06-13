public class ComputerPlayer{

    public Character(String n, Board b){
	super(n, b);
	String[] comp = {"Bob", "Sam", "John", "Mary"};
	name = comp[(int)(Math.random() * comp.length)];
    }

    

    public boolean buyProperty(BoardNode location){
	if (Math.random() > .2)
	    super();
	else
	    return false; //passes it.
	    
    }	
    
	public boolean move(){
		moveHelp();
		
		//something about buyinh houses? 
		//if rand # > .3 
		//then sort through properties and see if full set, if so buy house
		
		return endConditions();

	}

}

    
