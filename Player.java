import java.util.ArrayList;
import java.util.List;

public class Player {
	boolean white;
//	int[] myPieces;
//	int[] opponentPieces;
	//public List<int[]> moves = new ArrayList<int[]>();
	List<int[]> myPieces;
	List<int[]> opponentPieces;
	
	int myValue;
	int opponentValue;
	public Player(boolean isWhite){
		white = isWhite;
		getPiecesValue();
		moveSuggestions();
	}
	
	public void getPiecesValue(){
		myPieces = new ArrayList<>();
		opponentPieces = new ArrayList<>();
		myValue = 0;
		opponentValue = 0;
		for(int x = 0; x<8; x++){
    		for(int y = 0; y<8; y++){
    			if(Game.board.spots[x][y].isOccupied()){
    				if(Game.board.spots[x][y].piece.white == white){
    					myPieces.add(new int[] {x,y});
    					//myValue += Game.board.spots[x][y].piece.value;
    					myValue += getPieceValue(x,y);
        			}
    				else{
    					opponentPieces.add(new int[] {x,y});
    					//opponentValue += Game.board.spots[x][y].piece.value;
    					opponentValue += getPieceValue(x,y);
    				}
    			}
    		}
    		
    	}	
		/*
		System.out.println("My pieces:");
		
		for(int x = 0; x<myPieces.size(); x++){
			System.out.println(myPieces.get(x)[0] + ", " + myPieces.get(x)[1]);
    	}
    	*/
	}
	
	
	public void getPottentPiecesValue(int currX, int currY, int newX, int newY){
//move piece
//get value
//move piece back
		System.out.println("My pieces:");
		
		for(int x = 0; x<myPieces.size(); x++){
			System.out.println(myPieces.get(x)[0] + ", " + myPieces.get(x)[1]);
    	}
		
// does not work because different array
/*		
		if(!myPieces.contains(new int[] {6,3})){
			System.out.println("Error invalid piece selection");
		}
*/
//		else{
			Spot temp = null;
			//so piece isnt deleted 
			if(Game.board.getSpot(newX,newY).isOccupied()){
				temp = Game.board.getSpot(newX,newY);
				opponentPieces.remove(new int[] {newX,newY});
			}
			Game.move(currX,currY,newX,newY);
			myPieces.remove(new int[] {currX,currY});
			myPieces.add(new int[] {newX,newY});
			
			
			int tempMyValue = 0;
			int tempOpValue = 0;
			
			for(int x = 0; x<myPieces.size(); x++){
				tempMyValue += getPieceValue(myPieces.get(x)[0], myPieces.get(x)[1]);
	    	}	
			for(int x = 0; x<opponentPieces.size(); x++){
				tempOpValue += getPieceValue(opponentPieces.get(x)[0], opponentPieces.get(x)[1]);
	    	}
		

			Game.move(newX,newY,currX,currY);
			myPieces.remove(new int[] {newX,newY});
			myPieces.add(new int[] {currX,currY});
			
			if(temp != null){
				Game.board.setSpot(newX,newY, temp.piece);
				opponentPieces.add(new int[] {newX,newY});
			}
			
			System.out.println("My score is at: " + tempMyValue + "\nOpp score is at: " + tempOpValue);
//		}
	}

	
	public void moveSuggestions(){
		System.out.println("My piece value is: " + myValue);
//		List<int[]> temp;
		int maxKill = 0;
		ArrayList<Integer> moveSuggestions = new ArrayList<>();
		for(int i = 0; i<(myPieces.size()); i++){
			int tempX = myPieces.get(i)[0];
			int tempY = myPieces.get(i)[1];
			System.out.println("Checking: " + tempX + ", " + tempY  );
//			temp = Game.board.spots[(2*i)+1][(2*i)+2].piece.moves;
			Game.board.moveOptions(tempX,tempY);
			if(Game.board.spots[tempX][tempY].piece.moves != null){   // might not need... dont think it will ever be null is command just called
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
			System.out.println(moveSuggestions.get(i) + ", " + moveSuggestions.get(++i));
		}
		
	}
	public int getPieceValue(int x, int y){
		int possitionVal = Game.board.spotVal(x, y); 
		int pieceVal = Game.board.spots[x][y].piece.value;
		int numMoves = 0;
		
		Game.board.moveOptions(x,y);
		if(Game.board.spots[x][y].piece.moves != null) // might not need... dont think it will ever be null is command just called
			numMoves = Game.board.spots[x][y].piece.moves.size();
			//System.out.println("Piece: " + Game.board.spots[x][y].piece.type + " at " + x + ", " + y + " has moveoptions of " + Game.board.spots[x][y].piece.moves.size());
		
		
		if(Game.board.spots[x][y].piece.type == 'K'){
			System.out.println("Piece: " + Game.board.spots[x][y].piece.type + " at " + x + ", " + y + " has a value of " + ((possitionVal+1)*pieceVal));
			return ((possitionVal+1)*pieceVal);
		}
		else{
			System.out.println("Piece: " + Game.board.spots[x][y].piece.type + " at " + x + ", " + y + " has a value of " + ((7-possitionVal)*pieceVal));
			return ((7-possitionVal)*pieceVal*numMoves);
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
