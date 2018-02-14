public class KnightBoard{
    int[][]board;

    public KnightBoard(int startingRows, int startingCols){
	if (startingRows < 0 || startingCols < 0){
	    throw new IllegalArgumentException("Invalid board size");
	}
	board = new int[startingRows][startingCols];
	for (int j = 0; j < startingRows; j++){
	    for (int k = 0; k < startingCols; k++){
		board[j][k] = 0;
	    }
	}
    }

    public String toString(){
	String s = "";
	for (int j = 0; j < board.length; j++){
	    for (int k = 0; k < board[0].length; k++){
		if (board[j][k] == 0){
		    s+=" _ ";
		}
		else{
		    if (board[j][k]/10 == 0){
			s+=" "+board[j][k]+" ";
		    }
		    else{
			s+=""+board[j][k]+" ";
		    }
		}
	    }
	    s+="\n";
	}
	return s;
    }

    public boolean solve(int startingRow, int startingCol){
	if (startingRow < 0 || startingCol < 0 ||
	    startingRow >= board.length || startingCol >= board[0].length){
	    throw new IllegalArgumentException("Invalid parameters");
	}
	for (int j = 0; j < board.length; j++){
	    for (int k = 0; k < board[0].length; k++){
		if (board[j][k]!=0){
		    throw new IllegalStateException("The board is not empty");
		}
	    }
	}
	return solveH(startingRow, startingCol, 1);
    }

    private boolean solveH(int row, int col, int level){
	if (level >= board.length * board[0].length){
	    return true;
	}
	return false;
    }

    public int countSolutions(int startingRow, int startingCol){
	if (startingRow < 0 || startingCol < 0 ||
	    startingRow >= board.length || startingCol >= board[0].length){
	    throw new IllegalArgumentException("Invalid parameters");
	}
	for (int j = 0; j < board.length; j++){
	    for (int k = 0; k < board[0].length; k++){
		if (board[j][k]!=0){
		    throw new IllegalStateException("The board is not empty");
		}
	    }
	}
	return 0;
    }

    public static void main (String[]args){
	KnightBoard b = new KnightBoard(1, 2);
	System.out.println(b.toString());
	System.out.println(b.solve(0, 0));
    }
    
}
