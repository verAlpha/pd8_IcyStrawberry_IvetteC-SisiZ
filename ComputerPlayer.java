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
	    System.out.println(name + " has chosen not to buy "+
			       location.getName());
	    return false; //passes it.
	}
    }	
    

    //maybe add ability to buy houses
   

    public void buyHouse(){
	if (Math.random() > .5){//randomly chooses to buy house
	    BoardNode prop = null;
	    for(int i = 0; i < properties.length; i++){
		if (properties[i] != null){
		    if(properties[i].getFullSet()){
			prop = properties[i];
			break;//just chooses first property that is full set
		    }
		}
	    }	    
	    if(prop != null){//if  any full sets
		if ((prop.getColor()/4) * 50 < money/2){//if can afford
		    prop.addHouse();
		    money -= prop.getColor()/4 * 50;
		    System.out.println(name + "has bought a house for "+
				       prop.getName());
		}
	    }
	}
    }

    public boolean move(){
	moveHelp();
	//don't know why this needed
	//i think buy property which is called in moveHelp should work
	buyHouse();

	return endConditions();
    }


}
