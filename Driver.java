//test

import java.util.Scanner;
import java.util.ArrayList;

public class Driver{


    private static int askPlayerNum(){
	Scanner scan = new Scanner(System.in);
	System.out.println("How many human players will be playing? ");
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
    private static int askCompPlayerNum(int x){
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

    private static Player makePlayer( int x , Board b){
	Player p = new Player("" , b);
	Scanner scan = new Scanner(System.in);	
	System.out.println("What is the name of player " + (x+1) + "?");
	String name = scan.nextLine();
	p.setName(name);
	return p;
    }
    private static ComputerPlayer makeCompPlayer( Board b){
	ComputerPlayer p = new ComputerPlayer("", b);
	return p;
    }
    //what if same name chosen twice????


    public static void main( String[] args ){

	/*KEEP ALL THIS OLD STUFF IN CASE THE NEW STUFF DOESN'T WORK
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
	*/

	//SETTING UP PLAYERS
	int numPlayers = askPlayerNum();
	int numCompPlayers = askCompPlayerNum(numPlayers);
	Scanner scan = new Scanner(System.in);

	int totalNumPlayers = numCompPlayers + numPlayers;
	Board _board = new Board(totalNumPlayers);
    
	Character[] _players = new Character[totalNumPlayers];
	for(int i = 0; i < numPlayers; i++){
	    _players[i] = makePlayer(i, _board);
	}
	for(int i = numPlayers; i< totalNumPlayers; i++){
	    _players[i] = makeCompPlayer(_board);
	}

	//SETTING UP TURN ORDER
	//couldn't think of simple more efficent way to do this. ideas?	
	// if = dice roll just give first players priority? simpler.
	for( int i = 0; i < totalNumPlayers; i++){
	    System.out.println( _players[i].getName() +
			       " now rolling to determine the turn order.");
	    _players[i].setInitialDiceRoll( _players[i].roll() );
	}

	ArrayList<Character> temp = new ArrayList<Character>();
	for (int i = 0; i < totalNumPlayers; i++){
	    // awesome usage of sort!
	    if(temp.size() == 0){
		temp.add(_players[i]);
	    }else{
		int j = 0;
		while(j < temp.size() && _players[i].getInitialDiceRoll() < temp.get(j).getInitialDiceRoll() ){
		    j++;
		}
		temp.add(j, _players[i]);
	    }
	    _players[i].setNumber(i); // set the number of the character
	}

	//putting players back into an array rather than array list because i find them easier to work with
	for (int i = 0; i < totalNumPlayers; i++){
	    _players[i] = temp.get(i);
	}

	System.out.println("\nTurn order is as follows:");
	for (int i = 0; i < totalNumPlayers; i++){
	    System.out.println( (i+1) + ".)" + _players[i].getName());
	}

	//ACTUAL START OF GAME
	boolean end = false;//determines if the game is over
	while(!end){
	    for(int i = 0; i < totalNumPlayers ; i++){
		end = _players[i].move();
		if(end){
		    for (int j = 0; j < _players.length; j++)
			_players[j].getStats();
		    break;
		}
	    }
	}
	//need to type cast?

	//Some sort of print line about how game is over? don't know what to say/ what's redundant b/c in other files
	//if somebody loses entire game over? --that's how it is now, should it chage
	//game ends player has to ctrl c to get out of game -- how to auto cancel?

    }
}
