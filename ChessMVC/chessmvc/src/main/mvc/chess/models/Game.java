package src.main.mvc.chess.models;

import src.main.mvc.utils.Console;

public class Game{
	
	private static Board board;
	private static Console console;
	
	public Game() {
		board = new Board();
		console = new Console();
	}
		
	public void createBoard() {
		board.createBoard();
	}
	
	public void clearBoard() {
		for(int i=0;i<8;i++) {	
			for(int j=0;j<8;j++) {	
			Piece piece = board.getPiecePosition()[i][j];		
			if(piece != null) {
					board.setPiecePosition(i, j, null);
				}
			}
		}
	}
	
	
	public void showBoard() {
		board.showBoard();
	}
	
	
	public void changeTurn() {
		board.changeTurn();
	}
	
	public Turn getTurn() {
		return board.turn;
	}
	
	
	public Error isMovePossible(int[] playerMovements) {
		Piece piece = board.getPieceLocation(playerMovements[0], playerMovements[1]);
		if(piece.color == board.turn.getcolor()) {	
			boolean isCorrectPosition = piece.move_piece(playerMovements[0], playerMovements[1], playerMovements[2], playerMovements[3]);
			if(isCorrectPosition == false) {
					return Error.WRONG_POSITION;
			}
		}else {
			return Error.ENEMY_PIECE;
		}
		return null;
	}
	
	public void movePieceOnBoard(int[] playerMovements) {
		Piece piece = board.getPieceLocation(playerMovements[0], playerMovements[1]);
		board.changeTurn();
		board.setPiecePosition(playerMovements[2], playerMovements[3], piece);
		board.setPiecePosition(playerMovements[0], playerMovements[1], null);
		board.changeTurn();
		boolean isKingChecked = isKingChecked();
		if(isKingChecked != true) {		
			board.setPiecePosition(playerMovements[2], playerMovements[3], piece);
			board.setPiecePosition(playerMovements[0], playerMovements[1], null);					
		}
	}
	
	
	private static int[] getEnemyKingsPosition(){
		
		int positionX = 0; 
		int positionY = 0;
		
		for(int i = 0; i < 8; i++) {	
			for(int j = 0; j < 8; j++) {
				
				if(board.getPiecePosition()[i][j]!=null) {
					if(board.getPiecePosition()[i][j].color!=board.turn.getcolor() && board.getPiecePosition()[i][j].pieceType == PieceTypes.KING) {
						positionX = i;
						positionY = j;
					}
				}	
			}
		}
		return new int[] {positionX, positionY};		
	}
	
	
	public static boolean isKingChecked() {
		boolean isKingChecked=false;
		int enemyKingPosition[] = getEnemyKingsPosition();

		boolean isAttackToKingPossible =false;
		for(int i=0;i<8;i++) {		
			for(int j=0;j<8;j++) {
				if(board.getPiecePosition()[i][j] != null && (board.getPiecePosition()[i][j].color != board.getPiecePosition()[enemyKingPosition[0]][enemyKingPosition[1]].color)) {
					isAttackToKingPossible = board.getPiecePosition()[i][j].move_piece(i, j, enemyKingPosition[0], enemyKingPosition[1]);
					if(isAttackToKingPossible == true) {
						isKingChecked = true;
						break;
					}
				}
			}
		}
		return isKingChecked;
	}
	
	public static boolean isDefensePossible(int[] playerMovements) {
		boolean isDefensePossible = false;
		Piece pieceAttacker = board.getPieceLocation(playerMovements[2],playerMovements[3]);
		board.changeTurn();
		for(int i=0;i<8;i++) {	
			for(int j=0;j<8;j++) {	
			Piece piece = board.getPiecePosition()[i][j];		
				if(piece != null) {
					if(piece.color == board.turn.getcolor()) {
						if(piece.getClass() == King.class) {
							isDefensePossible = piece.move_piece(i,j,playerMovements[2],playerMovements[3]);
							if(isDefensePossible) {
								board.setPiecePosition(playerMovements[2],playerMovements[3], piece);
								if(isKingChecked() == false) {
									board.setPiecePosition(i,j, piece);
									board.setPiecePosition(playerMovements[2],playerMovements[3], pieceAttacker);
									board.changeTurn();
									return isDefensePossible;
								}
									board.setPiecePosition(i,j, piece);
									board.setPiecePosition(playerMovements[2],playerMovements[3], pieceAttacker);
							}							
						}else {
							isDefensePossible = piece.move_piece(i,j,playerMovements[2],playerMovements[3]);
							if(isDefensePossible == true) {
								board.changeTurn();
								return isDefensePossible;
							}
						}
					}
				}
			}
		}
		board.changeTurn();
		return isDefensePossible;
	}
	
	
	public static boolean isCheckMate() {	
		boolean isCheckMate;
		isCheckMate = verifyCheckMate();
		if(isCheckMate == true) {
			return false;
		}else {
			return true;
		}
	}
	
	
	private static boolean verifyCheckMate() {
		boolean isCheckMate=false;
		for(int i=0;i<8;i++) {	
			for(int j=0;j<8;j++) {	
			Piece piece = board.getPiecePosition()[i][j];		
			if(piece != null && piece.getClass() == King.class) {
					for(int k = 0; k < 8; k++) {
						for(int m = 0; m < 8; m++) {					
							boolean  isMovePossible = false;
							if(piece.color == board.turn.getcolor()) {
								isMovePossible = piece.move_piece(i, j, k, m);
							}
							if(isMovePossible == true) {
								board.changeTurn();
								boolean isKingChecked = isKingChecked();
								if(isKingChecked == true) {
								}else {
									isCheckMate = true;
								}
							}else {
								board.changeTurn();
							}	
						}
					}
							
				}
			}
		}
		return isCheckMate;
	}		
	
	
	public boolean isGameFinished() {
		boolean check_mate = isCheckMate();
		return check_mate;
	}
	
		
}		
