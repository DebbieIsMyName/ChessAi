import java.util.ArrayList;

public class Queen extends Piece{

    public Queen(boolean white) {
        super(white);
        super.type = 'Q';
        super.value = 90;
    }

    public void moveOptions(int x, int y){
    	// clears any previous moves
    	super.moves = new ArrayList<int[]>();
    	
		//Rook
		int tempX;
		int tempY;
		boolean running;
		//right
			running = true;
			tempX = x;
			while(tempX++<7 && running){
				if(Game.board.spots[tempX][y].isOccupied()){
					canMove(super.white,tempX,y);
					running = false;
				}
				else
					canMove(super.white,tempX,y);
				
			}
		
		//left
			running = true;
			tempX = x;
			while(tempX-->0 && running){
				if(Game.board.spots[tempX][y].isOccupied()){
					canMove(super.white,tempX,y);
					running = false;
				}
				else
					canMove(super.white,tempX,y);
			}
		//down
			running = true;
			tempY = y;
			while(tempY++<7 && running){
				if(Game.board.spots[x][tempY].isOccupied()){
					canMove(super.white,x,tempY);
					running = false;
				}
				else
					canMove(super.white,x,tempY);
			}
		
		//up
			running = true;
			tempY = y;
			while(tempY-->0 && running){
				if(Game.board.spots[x][tempY].isOccupied()){
					canMove(super.white,x,tempY);
					running = false;
				}
				else
					canMove(super.white,x,tempY);
			}
	//Bishop
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