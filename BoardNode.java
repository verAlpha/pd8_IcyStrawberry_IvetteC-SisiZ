public class BoardNode{

    private int price, rent,color; //sale
    private String name;
    private BoardNode next;
    private Character owner;
    private boolean purchaseable;

    public BoardNode(boolean x, int c, int r, int p, String s, BoardNode b){
	purchaseable = x;
	color = c;
	rent = r;
	price = p;
	name = s;
	next = b;
	owner = null;
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
    public boolean canPurchase(){
    	return purchaseable;
    }
    /*===================^ Mutator Methods ^====================*/      
    public void setPrice(int x){
	price = x;
    }
    public void setRent(int x){
	rent = x;
    }
    public void setName(String x){
	name = x;
    }
    public void setColor(int x){
	color = x;
    }
    public void setNext(BoardNode x){
	next = x;
    }
    public void setOwner(Character x){
	owner = x;
    }
    public void setPurchaseable(boolean x){
    	purchaseable = x;
    }
  
   
}
