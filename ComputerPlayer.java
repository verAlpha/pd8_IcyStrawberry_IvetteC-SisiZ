public class ComputerPlayer extends Character{

    private String[] NAMES = {"Bob", "Sam", "John", "Mary"};

    public ComputerPlayer( String s, Board b){
	super(s, b);	
	String n = NAMES[(int)(Math.random() * NAMES.length)];
	name = n;
    }

    public boolean buyProperty(BoardNode location){
	if (Math.random() > .2){
	    return super.buyProperty(location);
	}else{
	    return false; //passes it.
	}
    }	
    
<<<<<<< HEAD
=======
    public boolean move(){
	moveHelp();
	return true;
	
	 

    }
>>>>>>> 71af4e7144143cfaa0e6f411d45f5c6d2eddf700

    //maybe add ability to buy houses
   

    public void buyHouse(){
	if (Math.random() > .2){//randomly chooses to buy house
	    BoardNode prop = null;
	    for(int i = 0; i < properties.length; i++){
		if(properties[i].getFullSet()){
		    prop = properties[i];
		    break;//just chooses first property that is full set
		}
	    }	    
	    if(prop != null){//if  any full sets
		if ((prop.getColor()/4) * 50 < money/2){//if can afford
		    prop.addHouse();
		    money -= prop.getColor()/4 * 50;
		    System.out.println(name + "has bought a house for"+
				       prop.getName());
		}
<<<<<<< HEAD
=======
	public boolean move(){
		moveHelp();
		
		//something about buyinh houses? 
		//if rand # > .3 
		//then sort through properties and see if full set, if so buy house
		
		return endConditions();



>>>>>>> 71af4e7144143cfaa0e6f411d45f5c6d2eddf700
	    }
	}
    }

    public boolean move(){
	moveHelp();
	buyHouse();
		
	return endConditions();
    }


}
    
