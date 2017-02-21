import java.util.ArrayList;

public class Player {
	boolean white;
//	int[] myPieces;
//	int[] opponentPieces;
	ArrayList<Integer> myPieces;
	ArrayList<Integer> opponentPieces;
	int myValue;
	int opponentValue;
	public Player(boolean isWhite){
		white = isWhite;
		getPieces();
		moveSuggestions();
	}
	
	public void getPieces(){
		myPieces = new ArrayList<>();
		opponentPieces = new ArrayList<>();
		myValue = 0;
		opponentValue = 0;
		for(int x = 0; x<8; x++){
    		for(int y = 0; y<8; y++){
    			if(Game.board.spots[x][y].isOccupied()){
    				if(Game.board.spots[x][y].piece.white == white){
    					myPieces.add(x);
    					myPieces.add(y);
    					myValue += Game.board.spots[x][y].piece.value;
        			}
    				else{
    					opponentPieces.add(x);
    					opponentPieces.add(y);
    					opponentValue += Game.board.spots[x][y].piece.value;
    				}
    			}
    		}
    	}	
	}
	
	public void moveSuggestions(){
//		List<int[]> temp;
		int maxKill = 0;
		ArrayList<Integer> moveSuggestions = new ArrayList<>();
		for(int i = 0; i<(myPieces.size()/2); i++){
			int tempX = myPieces.get((2*i)+1);
			int tempY = myPieces.get((2*i)+2);
			System.out.println("Checking: " + tempX + ", " + tempY  );
//			temp = Game.board.spots[(2*i)+1][(2*i)+2].piece.moves;
			Game.board.moveOptions(tempX,tempY);
			if(Game.board.spots[tempX][tempY].piece.moves != null){
				for(int m = 0; m<Game.board.spots[tempX][tempY].piece.moves.size(); m++){
					if(Game.board.spots[tempX][tempY].piece.moves.get(m)[0] == -1){
						if(Game.board.spots[Game.board.spots[tempX][tempY].piece.moves.get(m)[1]][Game.board.spots[tempX][tempY].piece.moves.get(m)[2]].piece.value == maxKill){
							moveSuggestions.add(tempX);
							moveSuggestions.add(tempY);
						}
						else if(Game.board.spots[Game.board.spots[tempX][tempY].piece.moves.get(m)[1]][Game.board.spots[tempX][tempY].piece.moves.get(m)[2]].piece.value > maxKill){
							maxKill = Game.board.spots[Game.board.spots[tempX][tempY].piece.moves.get(m)[1]][Game.board.spots[tempX][tempY].piece.moves.get(m)[2]].piece.value;
							moveSuggestions = new ArrayList<>();
							moveSuggestions.add(tempX);
							moveSuggestions.add(tempY);
						}
					}
				}
			}
			else
				System.out.println("Error");
			}
		
		for(int i = 0; i<moveSuggestions.size(); i++){
			System.out.println(moveSuggestions.get(i) + ", " + moveSuggestions.get(i++));
		}
		
	}
/*
 Game.board.moveOptions(x, y);
		for(int m = 0; m<Game.board.spots[x][y].piece.moves.size(); m++){
			System.out.print("Move " + m + " : ");
			if(Game.board.spots[x][y].piece.moves.get(m)[0] == -1){
				System.out.print(" Kill - " + Game.board.spots[x][y].piece.moves.get(m)[1] + ", " + Game.board.spots[x][y].piece.moves.get(m)[2] + "\n");
			}
			else
				System.out.print(Game.board.spots[x][y].piece.moves.get(m)[0] + ", " + Game.board.spots[x][y].piece.moves.get(m)[1] + "\n");
		} 	
 */
	
	

}
