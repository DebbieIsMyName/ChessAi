public class Board {
    public Spot[][] spots;

    public Board() {
    	spots = new Spot[8][8];
    	setBoard();
    }
    
    private void setBoard(){
      
      // draw white    
          for(int i=0; i<8; i++){ // draw pawns
          	spots[i][1] = new Spot(new Pawn(true));
          }
          spots[0][0] = new Spot(new Rook(true));
          spots[7][0] = new Spot(new Rook(true));
          spots[1][0] = new Spot(new Knight(true));
          spots[6][0] = new Spot(new Knight(true));
          spots[2][0] = new Spot(new Bishop(true));
          spots[5][0] = new Spot(new Bishop(true));
          spots[3][0] = new Spot(new Queen(true));
          spots[4][0] = new Spot(new King(true));  
          
       // draw middle
        for(int i=0; i<spots.length; i++){
	          for(int j=2; j<6; j++){
	              spots[i][j] = new Spot();
	          }
        }
        
        // draw black
        for(int i=0; i<8; i++){ // draw pawns
        	spots[i][6] = new Spot(new Pawn(false));
        }
        spots[0][7] = new Spot(new Rook(false));
        spots[7][7] = new Spot(new Rook(false));
        spots[1][7] = new Spot(new Knight(false));
        spots[6][7] = new Spot(new Knight(false));
        spots[2][7] = new Spot(new Bishop(false));
        spots[5][7] = new Spot(new Bishop(false));
        spots[3][7] = new Spot(new Queen(false));
        spots[4][7] = new Spot(new King(false)); 
    }
    
    public Spot getSpot(int x, int y) {
        return spots[x][y];
    }
    public void setSpot(int x, int y, Piece piece){
    	spots[x][y] = new Spot(piece);
    }
    public void deleteSpot(int x, int y){
    	spots[x][y] = new Spot();
    }
    
    public void printBoard(){
    	final String ANSI_RED = "\u001B[31m";
    	final String ANSI_RESET = "\u001B[0m";
//    	System.out.println(ANSI_RED + "This text is red!" + ANSI_RESET);
/*
 * public static final String ANSI_RESET = "\u001B[0m";
public static final String ANSI_BLACK = "\u001B[30m";
public static final String ANSI_RED = "\u001B[31m";
public static final String ANSI_GREEN = "\u001B[32m";
public static final String ANSI_YELLOW = "\u001B[33m";
public static final String ANSI_BLUE = "\u001B[34m";
public static final String ANSI_PURPLE = "\u001B[35m";
public static final String ANSI_CYAN = "\u001B[36m";
public static final String ANSI_WHITE = "\u001B[37m";    	
 */
    	for(int y = 0; y<8; y++){
    		System.out.println();
    		for(int x = 0; x<8; x++){
    			if(spots[x][y] != null)
	    			if(spots[x][y].isOccupied())
	    				if(spots[x][y].getPiece().white)
	    					System.out.print(ANSI_RED + spots[x][y].getPiece().type  + ANSI_RESET + " ");
	    				else
	    					System.out.print(spots[x][y].getPiece().type + " ");
	    			else
	    				System.out.print("0 ");
	    		else
	    			System.out.print("?");
    	
    		
    		}
    	}
    	System.out.println();
    }
    
    public void moveOptions(int x, int y){
    	if(!spots[x][y].isOccupied())
    		System.out.println("Error: choose a piece");
    	else if(x>7 || x<0 || y>7 || y<0)
    		System.out.println("Error: off board");
    	else
    		spots[x][y].piece.moveOptions(x, y);
    }
    
    public void resetDanger(){
    	for(int y = 0; y<8; y++)
    		for(int x = 0; x<8; x++)
	    		if(spots[x][y].isOccupied())
	    			spots[x][y].piece.inDanger = false;
    }

}