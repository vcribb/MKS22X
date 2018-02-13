public class KnightBoard{

    int[][]board;

    public KnightBoard(int startingRows, int startingCols){
	if (startingRows < 0 || startingCols < 0){
	    throw new IllegalArgumentException();
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
		    s+="__ ";
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
	    throw new IllegalArgumentException();
	}
	for (int j = 0; j < board.length; j++){
	    for (int k = 0; k < board[0].length; k++){
		if (board[j][k]!=0){
		    throw new IllegalStateException();
		}
	    }
	}
	return solveH(startingRow, startingCol, 0);
    }

    private boolean solveH(int row, int col, int level){
	return true;
    }

    public int countSolutions(int startingRow, int startingCol){
	return 0;
    }

    public static void main (String[]args){
	KnightBoard b = new KnightBoard(5, 5);
	System.out.println(b.toString());
	b.solve(1, 5);
    }
    
}
