import java.util.ArrayList;

public class Bishop extends Piece{

    public Bishop(boolean white) {
        super(white);
        super.type = 'B';
        super.value = 30;
        // TODO Auto-generated constructor stub
    }
    
    public void moveOptions(int x, int y){
    	// clears any previous moves
    	super.moves = new ArrayList<int[]>();
    	
    	int tempX;
		int tempY;
		boolean running;
		//right down
				running = true;
				tempX = x;
				tempY = y;
    			while((tempX++<7 && tempY++<7) && running){
    				if(Game.board.spots[tempX][tempY].isOccupied()){
    					canMove(super.white,tempX,tempY);
    					running = false;
    				}
    				else
    					canMove(super.white,tempX,tempY);
    				
    			}
		
		//left down
				running = true;
    			tempX = x;
    			tempY = y;
    			while((tempX-->0 && tempY++<7) && running){
    				if(Game.board.spots[tempX][tempY].isOccupied()){
    					canMove(super.white,tempX,tempY);
    					running = false;
    				}
    				else
    					canMove(super.white,tempX,tempY);
    			}
		
		//right up
				running = true;
				tempX = x;
				tempY = y;
    			while((tempX++<7 && tempY-->0) && running){
    				if(Game.board.spots[tempX][tempY].isOccupied()){
    					canMove(super.white,tempX,tempY);
    					running = false;
    				}
    				else
    					canMove(super.white,tempX,tempY);
    			}
		
		//left up
				running = true;
    			tempX = x;
    			tempY = y;
    			while((tempX-->0 && tempY-->0) && running){
    				if(Game.board.spots[tempX][tempY].isOccupied()){
    					canMove(super.white,tempX,tempY);
    					running = false;
    				}
    				else
    					canMove(super.white,tempX,tempY);
    			}
		
    }

}