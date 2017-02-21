import java.util.ArrayList;

public class King extends Piece{

    public King(boolean white) {
        super(white);
        super.type = 'K';
        super.value = 100;
        // TODO Auto-generated constructor stub
    }
    public void moveOptions(int x, int y){
    	// clears any previous moves
    	super.moves = new ArrayList<int[]>();
    	
    //right
		canMove(super.white,(x+1),(y+1));
		canMove(super.white,(x+1),(y));
		canMove(super.white,(x+1),(y-1));
	//left
		canMove(super.white,(x-1),(y+1));
		canMove(super.white,(x-1),(y));
		canMove(super.white,(x-1),(y-1));
	//down
		canMove(super.white,(x),(y+1));
	//up
		canMove(super.white,(x),(y-1));
}

}