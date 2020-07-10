package src.main.mvc.chess.models;

public abstract class Piece {
	Color color;
	PieceSymbol pieceSymbol;
	PieceTypes pieceType;
	
	abstract boolean move_piece(int coordinateX1,int coordinateY1,int coordinateX2,int coordinateY2);
}

