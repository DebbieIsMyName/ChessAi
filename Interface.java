import java.util.Scanner;

public class Interface {
	static Scanner in = new Scanner(System.in);
	static int x;
	static int y;
	static Game game;
	public static void main(String[] args) {
		boolean running = true;
		
		System.out.println("Running");
		
		game = new Game();
		Game.board.printBoard();
//		game.move(1, 0, 0, 5);
//		game.move(0, 6, 1, 0);
		game.move(4, 1, 4, 3);
		game.move(5, 6, 5, 4);
		game.move(3, 6, 3, 5);
		game.move(3, 1, 3, 3);
		game.move(6, 7, 7, 4);
//		game.board.printBoard();
		System.out.println("0 to see board");
		System.out.println("1 to see moves of a piece");
		System.out.println("2 to move a piece");
		System.out.println("-1 to exit");
		
		int temp;
		while(running){
			temp = in.nextInt();
			
			switch(temp){
			case 0:
				Game.board.printBoard();
				break;
			case 1:
				getMoveOptions();
				break;
			case 2:
				move();
				break;
			case -1:
				running = false;
				break;
			default:
				System.out.println("Invalid input");
			}
			
		}
//		game.board.printBoard();
		Player bob = new Player(true);
		
		System.out.println("Done Running");
	}
	
	private static void getPoint(){
		System.out.print("Enter x and y: ");
		x = in.nextInt();
		y = in.nextInt();
		
	}
	private static void getMoveOptions(){
		getPoint();
		Game.board.moveOptions(x, y);
		for(int m = 0; m<Game.board.spots[x][y].piece.moves.size(); m++){
			System.out.print("Move " + m + " : ");
			if(Game.board.spots[x][y].piece.moves.get(m)[0] == -1){
				System.out.print(" Kill - " + Game.board.spots[x][y].piece.moves.get(m)[1] + ", " + Game.board.spots[x][y].piece.moves.get(m)[2] + "\n");
			}
			else
				System.out.print(Game.board.spots[x][y].piece.moves.get(m)[0] + ", " + Game.board.spots[x][y].piece.moves.get(m)[1] + "\n");
		}
	}
	private static void move(){
		getMoveOptions();
		int moves = Game.board.spots[x][y].piece.moves.size();
		if(moves == 0)
			System.out.println("Invalid move choice: That piece cannot move");
		else{
			int move = -1;
			while (move==-1){
				System.out.print("Enter move: ");
				move = in.nextInt();
				if(move<0 && move>=moves){
					System.out.println("Invalid move choice");
					move = -1;
				}
			}
			if(Game.board.spots[x][y].piece.moves.get(move)[0] == -1)
				game.move(x, y, Game.board.spots[x][y].piece.moves.get(move)[1], Game.board.spots[x][y].piece.moves.get(move)[2]);
			else
				game.move(x, y, Game.board.spots[x][y].piece.moves.get(move)[0], Game.board.spots[x][y].piece.moves.get(move)[1]);
			
		}
	}

}
