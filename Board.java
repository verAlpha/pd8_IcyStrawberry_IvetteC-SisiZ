public class Board{
      
      BoardNode _start;
      BoardNode[] charterLocations;
      
      public Board(int characternumber){
          characterLocations = new BoardNode[characternumber];
          _start = new BoardNode(-1, -1, -1, "GO", null);
          BoardNode temp1 = new BoardNode(7, 50, 450, "loc last", _start);
          BoardNode temp2 = new BoardNode(7, 35, 350, "loc last-1", temp1);
          BoardNode temp3 = new BoardNode(6, 27, 300, "loc last-2", temp2);
          BoardNode temp4 = new BoardNode(6, 25, 250, "loc last-3", temp3);
          BoardNode temp5 = new BoardNode(6, 23, 200, "loc last-4", temp4);
          BoardNode temp6 = new BoardNode(5, 20, 150, "loc last-5", temp5);
          //add the rest of the locations in
        
        
        
        _start.setNext(temp20);
      }
  
      private void setCharacterLocaton(BoarNode newLoc, Character c){
            characterLocations[c.getNumber()] = newLoc;
            
      }
  
  
      public void 










}
