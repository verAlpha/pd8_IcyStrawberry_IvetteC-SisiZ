public class ComputerPlayer extends Character{

    private char[] consonants = {'b', 'c', 'd', 'f', 
				 'g', 'h', 'j', 'k',
				 'l', 'm', 'n', 'q', 
				 'r', 's', 't', 'v', 
				 'w', 'x', 'y', 'z'};

    private char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};


    public ComputerPlayer( String s, Board b){
	super(s, b);	
	name = toName();
    }

    public String toName(){
	String name = "";
	for (int i = 0; i < Math.random()*8; i++){
	    double random = Math.random();
	    if (random > 0.65)
		name += consonants[(int)(Math.random() * consonants.length)];
	    else
		name += vowels[(int)(Math.random() * vowels.length)];
	}
	return name;
    }
	    

    public boolean buyProperty(BoardNode location){
	// super.getStats();
	// System.out.println("Computer buyProperty");
	if (Math.random() > .2){
	    //System.out.println("Computer buyProperty If statement");
	    boolean b = super.buyProperty(location);
	    //System.out.println("Boolean B: " + b);
	    //super.getStats();
	    if (b)
		System.out.println(name + " has bought " + location.getName());
	    else
		System.out.println(name + " could not buy " + location.getName());
	    return b;
	}else{
	    System.out.println("Computer buyProperty Else statement");
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
