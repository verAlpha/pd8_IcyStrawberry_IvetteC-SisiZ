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
	return true;
	
	 

    }

    //maybe add ability to buy houses
   

    public void buyHouse(){
	if (Math.random() > .2){//randomly chooses to buy house
	    String prop;
	    BoardNode b = null;
	    for(int i = 0; i < properties.length; i++){
		if(properties[i].getFullSet()){
		    prop = properties[i];
		    break;
		}
	    }
	    
	    if(prop != null){//if  any full sets
		int x = -1;
		if ((properties[x].getColor()/4) * 50 < money/2){
		    properties[x].addHouse();
		    money -= properties[x].getColor()/4 * 50 ;
		}
=======
	public boolean move(){
		moveHelp();
		
		//something about buyinh houses? 
		//if rand # > .3 
		//then sort through properties and see if full set, if so buy house
		
		return endConditions();
>>>>>>> f0ba0e369c50b3e6a00f230501609017f4af5dd3



	    }
	}
    }
}
    
