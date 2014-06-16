public class BoardNode{

    private int price, rent,color; //sale
    private String name;
    private BoardNode next;
    private Character owner;
    private String type;
    private int houses;
    private boolean fullSet;

    public BoardNode(String x, int c, int r, int p,
		     String s, BoardNode b){
	type = x;
	color = c;
	rent = r;
	price = p;
	name = s;
	next = b;
	owner = null;
	houses = 0;
	fullSet = false;
    }

    /*===================V Accessor Methods V====================*/    
    public int getPrice(){
	return price;
    }
    public int getRent(){
	return rent;
    }
    public int getColor(){
	return color;
    }
    public String  getName(){
	return name;
    }
    public BoardNode  getNext(){
	return next;
    }
    public Character  getOwner(){
	return owner;
    }
    public String getType(){
    	return type;
    }
    public int getHouseNum(){
	return houses;
    }
    public boolean getFullSet(){
	return fullSet;
    }
    public String getRealColor(){
	String[] colors = {"purple","light blue","pink","orange",
			   "red","yellow","green","dark blue"};
	if (color != -1){
	    return colors[color];
	}else{
	    return "no color";
	}

    }
    /*===================^ Mutator Methods ^====================*/      
    public void setPrice(int x){//not nesssecary?
	price = x;
    }
    public void setRent(int x){//not nessecary?
	rent = x;
    }
    public void setName(String x){//not nesssecary?
	name = x;
    }
    public void setColor(int x){//not nesssecary?
	color = x;
    }
    public void setNext(BoardNode x){
	next = x;
    }
    public void setOwner(Character x){
	owner = x;
    }
    public void setType(String x){
    	type = x;
    }

    public void addHouse(){
	if (!fullSet){
	    System.out.println(owner.getName() + " need the full set of properties of this "+
			       "color to purchase a house");
	}else{
	    if(houses >= 5){
		System.out.println(owner.getName() + " already have a hotel on" + name +
				   ", you may not further upgrade it.");
	    }else{
		houses += 1;
		rent = (rent+color) * (color + 1) + 100;
		//maybe use a better system to determine rent
		if (houses == 5){
		    	System.out.println(owner.getName() + " now have a hotel on " + name);
		}else{
		    System.out.println(owner.getName() + "you now have " + (houses) 
				       + " house(s) on "+ name);
		}
		//fix grammar later maybe?
	    }
	}
    }

    public void makeFullSet(){
	fullSet = true;
    }
}
