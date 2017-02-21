import java.util.ArrayList;

public class Knight extends Piece{

    public Knight(boolean white) {
        super(white);
        super.type = 'N';
        super.value = 30;
    }

    public void moveOptions(int x, int y){
    	// clears any previous moves
    	super.moves = new ArrayList<int[]>();
    	
		//right
			canMove(super.white,(x+2),(y+1));
			canMove(super.white,(x+2),(y-1));
		//left
			canMove(super.white,(x-2),(y+1));
			canMove(super.white,(x-2),(y-1));
		//down
			canMove(super.white,(x+1),(y+2));
			canMove(super.white,(x-1),(y+2));
		//up
			canMove(super.white,(x+1),(y-2));
			canMove(super.white,(x-1),(y-2));
			
    }
}