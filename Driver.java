//test

import java.util.Scanner;

public class Driver{


    public int askPlayerNum(){
	Scanner scan = new Scanner(System.in);
	System.out.println("How many human players will be playing?");
	String s = scan.nextLine();
	int n = (int)(Integer.parseInt(s));
	if (n < 1){
	    System.out.println("there must be at least one human player, try again");
	    return askPlayerNum();
	}else if (n >= 5){
	    System.out.println("there is a maximum of five people for this game, try again");
	    return askPlayerNum();
	}else{
	    return n;
	}
    }

    public int askCompPlayerNum(int x){
	// x is number of human players
	Scanner scan = new Scanner(System.in);
	System.out.println("How many computer players would you like?");
	String s = scan.nextLine();
	int n = (int)(Integer.parseInt(s));
	if (n < 0){
	    System.out.println("you can't have negative players, try again");
	    return askCompPlayerNum(x);
	}else if (n > 6 - x){
	    System.out.println("there is a maximum of six people for this game "+
			       "there are already " + x + "human palyers," +
			       " try again");
	    return askCompPlayerNum(x);
	}else{
	    return n;
	}
    }


    public void getPlayerName(Player p, int x){
	Scanner scan = new Scanner(System.in);	
	System.out.println("What is the name of player " + x + "?");
	String name = scan.nextLine();
	p.setName(name);
	
    }
 

    public static void main( String[] args ){
	/*	int numPlayers = askPlayerNum();
	int numCompPlayers = askCompPlayerNum(numPlayers);
	Scanner scan = new Scanner(System.in);

	int totalNumPlayers = numCompPlayers + numPlayers;
	Board _board = new Board(totalNumPlayers);
	boolean end = false;//determines if the game is over
    
	// make this a for loop depending numPlayers, comp players auto generated
	//array of players?
	for(int i = 0; i < numPlayers; i++){


	}
	*/
	boolean end = false;//determines if the game is over
	Board _board = new Board(2);//

	Scanner scan = new Scanner(System.in);


	Player _player1 = new Player("",_board);
	Player _player2 = new Player("",_board);
	//later ask how many players? add compter players?
	System.out.println("What is the name of the first palyer?");
	String name = scan.nextLine();
	_player1.setName(name);
    
	System.out.println("What is the name of the second palyer?");
	name = scan.nextLine();
	_player2.setName(name);
    
    
	System.out.println("Rolling to determine the turn order.");
	int dice1 = _player1.roll();
    
	System.out.println("Rolling to determine the turn order.");
	int dice2 = _player2.roll();


	// how would we deal with the case that if they're both equal? reroll?
	if (dice1 > dice2){
	    System.out.println(_player1.getName() +" is going first");
	    while(!end){
		end = _player1.move();
		end = _player2.move();
	    }

	}else{
	    System.out.println(_player2.getName() +" is going first");
	    while(!end){
		end = _player2.move();
		end = _player1.move();
	    }
	}
	    
	    
    }
}
