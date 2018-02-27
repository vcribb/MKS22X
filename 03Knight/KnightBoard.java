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
	return solveH(startingRow, startingCol, 2);
    }

    private boolean solveH(int row, int col, int level){
	if (row >= board.length || col >= board[0].length || row < 0 || col < 0){
	    return false;
	}
	if (level > board.length * board[0].length){
	    return true;
	}
	board[row][col] = level - 1;
	if (row + 2 >= 0 && row + 2 < board.length &&
	    col + 1 >= 0 && col + 1 < board[0].length &&
	    board[row + 2][col + 1] == 0){
	    board[row + 2][col + 1] = level;
	    if (solveH(row + 2, col + 1, level + 1)){
		return true;
	    }
	    board[row + 2][col + 1] = 0;
	}
	if (row + 2 >= 0 && row + 2 < board.length &&
	    col - 1 >= 0 && col - 1 < board[0].length &&
	    board[row + 2][col - 1] == 0){
	    board[row + 2][col - 1] = level;
	    if (solveH(row + 2, col - 1, level + 1)){
		return true;
	    }
	    board[row + 2][col - 1] = 0;
	}
	if (row - 2 >= 0 && row - 2 < board.length &&
	    col + 1 >= 0 && col + 1 < board[0].length &&
	    board[row - 2][col + 1] == 0){
	    board[row - 2][col + 1] = level;
	    if (solveH(row - 2, col + 1, level + 1)){
		return true;
	    }
	    board[row - 2][col + 1] = 0;
	}
	if (row - 2 >= 0 && row - 2 < board.length &&
	    col - 1 >= 0 && col - 1 < board[0].length &&
	    board[row - 2][col - 1] == 0){
	    board[row - 2][col - 1] = level;
	    if (solveH(row - 2, col - 1, level + 1)){
		return true;
	    }
	    board[row - 2][col - 1] = 0;
	}
	if (row + 1 >= 0 && row + 1 < board.length &&
	    col + 2 >= 0 && col + 2 < board[0].length &&
	    board[row + 1][col + 2] == 0){
	    board[row + 1][col + 2] = level;
	    if (solveH(row + 1, col + 2, level + 1)){
		return true;
	    }
	    board[row + 1][col + 2] = 0;
	}
	if (row + 1 >= 0 && row + 1 < board.length &&
	    col - 2 >= 0 && col - 2 < board[0].length &&
	    board[row + 1][col - 2] == 0){
	    board[row + 1][col - 2] = level;
	    if (solveH(row + 1, col - 2, level + 1)){
		return true;
	    }
	    board[row + 1][col - 2] = 0;
	}
	if (row - 1 >= 0 && row - 1 < board.length &&
	    col + 2 >= 0 && col + 2 < board[0].length &&
	    board[row - 1][col + 2] == 0){
	    board[row - 1][col + 2] = level;
	    if (solveH(row - 1, col + 2, level + 1)){
		return true;
	    }
	    board[row - 1][col + 2] = 0;
	}
	if (row - 1 >= 0 && row - 1 < board.length &&
	    col - 2 >= 0 && col - 2 < board[0].length &&
	    board[row - 1][col - 2] == 0){
	    board[row - 1][col - 2] = level;
	    if (solveH(row - 1, col - 2, level + 1)){
		return true;
	    }
	    board[row - 1][col - 2] = 0;
	}
	board[row][col] = 0;
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
	return countH(startingRow, startingCol, 2, 0);
    }

    public int countH(int row, int col, int level, int numSolutions){
	if (level > board.length * board[0].length){
	    numSolutions++;
	    return numSolutions;
	}
	board[row][col] = level - 1;
	if (row + 2 >= 0 && row + 2 < board.length &&
	    col + 1 >= 0 && col + 1 < board[0].length &&
	    board[row + 2][col + 1] == 0){
	    board[row + 2][col + 1] = level;
	    numSolutions = countH(row + 2, col + 1, level + 1, numSolutions);
	    board[row + 2][col + 1] = 0;
	}
	if (row + 2 >= 0 && row + 2 < board.length &&
	    col - 1 >= 0 && col - 1 < board[0].length &&
	    board[row + 2][col - 1] == 0){
	    board[row + 2][col - 1] = level;
	    numSolutions = countH(row + 2, col - 1, level + 1, numSolutions);
	    board[row + 2][col - 1] = 0;
	}
	if (row - 2 >= 0 && row - 2 < board.length &&
	    col + 1 >= 0 && col + 1 < board[0].length &&
	    board[row - 2][col + 1] == 0){
	    board[row - 2][col + 1] = level;
	    numSolutions = countH(row - 2, col + 1, level + 1, numSolutions);
	    board[row - 2][col + 1] = 0;
	}
	if (row - 2 >= 0 && row - 2 < board.length &&
	    col - 1 >= 0 && col - 1 < board[0].length &&
	    board[row - 2][col - 1] == 0){
	    board[row - 2][col - 1] = level;
	    numSolutions = countH(row - 2, col - 1, level + 1, numSolutions);
	    board[row - 2][col - 1] = 0;
	}
	if (row + 1 >= 0 && row + 1 < board.length &&
	    col + 2 >= 0 && col + 2 < board[0].length &&
	    board[row + 1][col + 2] == 0){
	    board[row + 1][col + 2] = level;
	    numSolutions = countH(row + 1, col + 2, level + 1, numSolutions);
	    board[row + 1][col + 2] = 0;
	}
	if (row + 1 >= 0 && row + 1 < board.length &&
	    col - 2 >= 0 && col - 2 < board[0].length &&
	    board[row + 1][col - 2] == 0){
	    board[row + 1][col - 2] = level;
	    numSolutions = countH(row + 1, col - 2, level + 1, numSolutions);
	    board[row + 1][col - 2] = 0;
	}
	if (row - 1 >= 0 && row - 1 < board.length &&
	    col + 2 >= 0 && col + 2 < board[0].length &&
	    board[row - 1][col + 2] == 0){
	    board[row - 1][col + 2] = level;
	    numSolutions = countH(row - 1, col + 2, level + 1, numSolutions);
	    board[row - 1][col + 2] = 0;
	}
	if (row - 1 >= 0 && row - 1 < board.length &&
	    col - 2 >= 0 && col - 2 < board[0].length &&
	    board[row - 1][col - 2] == 0){
	    board[row - 1][col - 2] = level;
	    numSolutions = countH(row - 1, col - 2, level + 1, numSolutions);
	    board[row - 1][col - 2] = 0;
	}
	board[row][col] = 0;
	return numSolutions;
    }

    public static void main (String[]args){
	//testing the runtime
	long startTime = System.nanoTime();
	KnightBoard b = new KnightBoard(7, 7);
	System.out.println(b.solve(2, 2));
	System.out.println(b.toString());
	long stopTime = System.nanoTime();
	System.out.println((stopTime - startTime)/1000000000.0);
    }
    
}
