import java.io.*;

public class Driver{












  public static void main( String[] args ){
      Board _board = new Board(2);
    
    
    Scanner scan = new Scanner()
    Player _player1;
    Player _player2;
          //later ask how many players? add compter players?
    System.out.println("What is the name of the first palyer?");
    String name = scan.nextLine();
    _player1.setName(name);
    
    System.out.println("What is the name of the second palyer?");
    name = scan.nextLine();
    _player2.setName(name);
    
    
    System.out.println("Roll to determine the turn order. Please type roll");
    int dice1 = _player1.roll();
    
    System.out.println("Roll to determine the turn order. Please type roll");
    int dice2 = _player2.roll();

    if (dice1 > dice2){
      _player1.move();
      //System.out.println("Please type one of the following: buy property, pass, bank and property information, ");
      // we have to write a pass method and a bank and property information grabbing method.
     /* String response = scan.nextLine();
      if (response.equals("buy property"))
        _player1.buyProperty();
      else
        // implement code*/
    }
    // ahould we deal with the case that if they're both equal?
    else{
      _player2.move();
     /* System.out.println("Please type one of the following: buy property, pass, bank and property information, ");
      // we have to write a pass method and a bank and property information grabbing method.
      String response = scan.nextLine();
      if (response.equals("buy property"))
        _player2.buyProperty();
      else*/
        // implement code
    }
  }

}
