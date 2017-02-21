public class Spot {
    Piece piece = null;
    Boolean occupied;

    public Spot(Piece piece) {
        this.piece = piece;
        this.occupied = true;
    }
    
    public Spot() {
        this.occupied = false;
    }

    
    public Piece getPiece(){
    	return piece;
    }

    /*
    public void occupySpot(Piece piece){
        //if piece already here, delete it, i. e. set it dead
        if(this.piece != null)
            this.piece.setAvailable(false);
        //place piece here
        this.piece = piece;
    }
	*/
    public boolean isOccupied() {
        return occupied;
    }

    public Piece releaseSpot() {
        Piece releasedPiece = this.piece;
        this.piece = null;
        return releasedPiece;
    }

}