import java.util.ArrayList;

public class Rook extends Piece{

    public Rook(boolean white) {
        super(white);
        super.type = 'R';
        super.value = 50;
        // TODO Auto-generated constructor stub
    }
    public void moveOptions(int x, int y){
    	// clears any previous moves
    	super.moves = new ArrayList<int[]>();
    	
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
    }

}