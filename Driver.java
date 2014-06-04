//test

import java.util.Scanner;

public class Driver{



 

    public static void main( String[] args ){
	Board _board = new Board(2);
	boolean end = false;//determines if the game is over
    
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
