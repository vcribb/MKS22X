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
	board[startingRow][startingCol] = -1;
	return solveH(startingRow, startingCol, 1);
    }

    private boolean solveH(int row, int col, int level){
	if (row >= board.length || col >= board[0].length || row < 0 || col < 0){
	    return false;
	}
	if (level > board.length * board[0].length){
	    return true;
	}
	for (int r = 0; r < board.length; r++){
	    for (int c = 0; c < board[0].length; c++){
		if (board[r][c] < 0 && addKnight(r, c, level)){
		    if (solveH(r+2, c+1, level+1)||
			solveH(r+2, c-1, level+1)||
			solveH(r-2, c+1, level+1)||
			solveH(r-2, c-1, level+1)||
			solveH(r+1, c+2, level+1)||
			solveH(r+1, c-2, level+1)||
			solveH(r-1, c+2, level+1)||
			solveH(r-1, c-2, level+1)){
			return true;
		    }
		}
		removeKnight(r, c, level);
	    }
	}
	return false;
    }

    private boolean addKnight(int r, int c, int level){
	if (r < 0 || c < 0 || r >= board.length || c >= board[0].length){
	    return false;
	}
	if (board[r][c] > -1){
	    return false;
	}
	board[r][c] = level;
	try{
	    if (board[r+2][c+1] == 0){
		board[r+2][c+1] = -1;
	    }
	}
	catch (ArrayIndexOutOfBoundsException e){}
	try{
	    if (board[r+2][c-1] == 0){
		board[r+2][c-1] = -1;
	    }
	}
	catch (ArrayIndexOutOfBoundsException e){}
	try{
	    if (board[r-2][c+1] == 0){
		board[r-2][c+1] = -1;
	    }
	}
	catch (ArrayIndexOutOfBoundsException e){}
	try{
	    if (board[r-2][c-1] == 0){
		board[r-2][c-1] = -1;
	    }
	}
	catch (ArrayIndexOutOfBoundsException e){}
	try{
	    if (board[r+1][c+2] == 0){
		board[r+1][c+2] = -1;
	    }
	}
	catch (ArrayIndexOutOfBoundsException e){}
	try{
	    if (board[r+1][c-2] == 0){
		board[r+1][c-2] = -1;
	    }
	}
	catch (ArrayIndexOutOfBoundsException e){}
	try{
	    if (board[r-1][c+2] == 0){
		board[r-1][c+2] = -1;
	    }
	}
	catch (ArrayIndexOutOfBoundsException e){}	   
	try{
	    if (board[r-1][c-2] == 0){
		board[r-1][c-2] = -1;
	    }
	}
	catch (ArrayIndexOutOfBoundsException e){}
	return true;
    }

    private boolean removeKnight(int r, int c, int level){
	if (r < 0 || c < 0 || r >= board.length || c >= board[0].length){
	    return false;
	}
	if (board[r][c] == level){
	    board[r][c] = 0;
	    try{
		if (board[r+2][c+1] < 0){
			board[r+2][c+1] = 0;
		}
	    }
	    catch (ArrayIndexOutOfBoundsException e){}
	    try{
		if (board[r+2][c-1] < 0){
		    board[r+2][c-1] = 0;
		}
	    }
	    catch (ArrayIndexOutOfBoundsException e){}
	    try{
		if (board[r-2][c+1] < 0){
		    board[r-2][c+1] = 0;
		}
	    }
	    catch (ArrayIndexOutOfBoundsException e){}
	    try{
		if (board[r-2][c-1] < 0){
		    board[r-2][c-1] = 0;
		}
	    }
	    catch (ArrayIndexOutOfBoundsException e){}
	    try{
		if (board[r+1][c+2] < 0){
		    board[r+1][c+2] = 0;
		}
	    }
	    catch (ArrayIndexOutOfBoundsException e){}
	    try{
		if (board[r+1][c-2] < 0){
		    board[r+1][c-2] = 0;
		}
	    }
	    catch (ArrayIndexOutOfBoundsException e){}
	    try{
		if (board[r-1][c+2] < 0){
		    board[r-1][c+2] = 0;
		}
	    }
	    catch (ArrayIndexOutOfBoundsException e){}	   
	    try{
		if (board[r-1][c-2] < 0){
		    board[r-1][c-2] = 0;
		}
	    }
	    catch (ArrayIndexOutOfBoundsException e){}
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
	KnightBoard b = new KnightBoard(4, 5);
	System.out.println(b.solve(0,0));
	System.out.println(b.toString());
    }
    
}
