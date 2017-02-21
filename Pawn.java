import java.util.ArrayList;

public class Pawn extends Piece{

    public Pawn(boolean white) {
        super(white);
        super.type = 'p';
        super.value = 10;
        
        // TODO Auto-generated constructor stub

    }
    
    public void moveOptions(int x, int y){
    	// clears any previous moves
    	super.moves = new ArrayList<int[]>();
   
		if(super.white == true){
			if(y<7 && !Game.board.spots[x][y+1].isOccupied()){
				super.moves.add(new int[]{x,y+1});
				//System.out.println(x + ", " + (y+1));
			}
			if(y == 1 && !Game.board.spots[x][y+2].isOccupied()){
				super.moves.add(new int[]{x,y+2});
				//System.out.println(x + ", " + (y+2));
			}
			if((x<7 && y<7) && Game.board.spots[x+1][y+1].isOccupied() && !Game.board.spots[x+1][y+1].piece.white){
	    		super.moves.add(new int[]{-1,x+1,y+1});
				//System.out.println("Kill: " + (x+1) + ", " + (y+1));
			}
			if((x>0 && y<7) && Game.board.spots[x-1][y+1].isOccupied() && !Game.board.spots[x-1][y+1].piece.white){
				super.moves.add(new int[]{-1,x-1,y+1});
				//System.out.println("Kill: " + (x-1) + ", " + (y+1));
			}
		}
		else{
			if(y>0 && !Game.board.spots[x][y-1].isOccupied()){
				super.moves.add(new int[]{x,y-1});
				//System.out.println(x + ", " + (y-1));
			}
			if(y == 6 && !Game.board.spots[x][y-2].isOccupied()){
				super.moves.add(new int[]{x,y-2});
				//System.out.println(x + ", " + (y-2));
			}
			if((x<7 && y>0) && Game.board.spots[x+1][y-1].isOccupied() && Game.board.spots[x+1][y-1].piece.white){
				super.moves.add(new int[]{-1,x+1,y-1});
				//System.out.println("Kill: " + (x+1) + ", " + (y-1));
			}
			if((x>0 && y>0) && Game.board.spots[x-1][y-1].isOccupied() && Game.board.spots[x-1][y-1].piece.white){
				super.moves.add(new int[]{-1,x-1,y-1});
				//System.out.println("Kill: " + (x-1) + ", " + (y-1));
			}
		}	
    }


}