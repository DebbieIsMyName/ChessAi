import java.util.ArrayList;
import java.util.List;

public class Piece {
    public boolean white;
    public boolean inDanger;
    public char type;
    public int value;
    public List<int[]> moves = new ArrayList<int[]>();

    public Piece(boolean white) {
        this.white = white;
    }
    
    public void moveOptions(int x, int y){
    		System.out.println("Error getting move options for: " + x + ", " + y);
    }
    
    public void canMove(boolean pieceWhite, int toX, int toY){
//    	System.out.println("Can move try: " + toX + ", " + toY);
    	if(toX<=7 && toX>=0 && toY<=7 && toY>=0){
	    	if(!Game.board.spots[toX][toY].isOccupied()){
	    		moves.add(new int[]{toX,toY});
			//	System.out.println(toX + ", " + toY);
	    	}
			if(Game.board.spots[toX][toY].isOccupied() && (Game.board.spots[toX][toY].piece.white != pieceWhite)){
				Game.board.spots[toX][toY].piece.inDanger = true;
				moves.add(new int[]{-1, toX,toY});
			//	System.out.println("Kill: " + toX + ", " + toY);
			}
    	}
    }
    
    
}