public class Game {
    static Board board;
    static boolean whitesTurn;
    public Game() {
    	board = new Board();
    	whitesTurn = true;
    }
    
    public void move(int fromX, int fromY, int toX, int toY){
    	board.setSpot(toX, toY, board.getSpot(fromX, fromY).piece);
    	board.deleteSpot(fromX, fromY);
    }
    
    public void setDanger(){
    	for(int x = 0; x<8; x++){
    		for(int y = 0; y<8; y++){
    			if(board.spots[x][y].isOccupied() && (board.spots[x][y].piece.white == whitesTurn))
    				board.spots[x][y].piece.inDanger = false;
    		}
    	}
    }
}