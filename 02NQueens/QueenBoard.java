public class QueenBoard{
    private int[][]board;

    public QueenBoard(int size){
	board = new int[size][size];
	for (int j = 1; j < size; j++){
	    for (int k = 1; k < size; k++){
		board[j][k] = 0;
	    }
	}
    }

    private boolean addQueen(int r, int c){
	if (board[r][c] == 0){
	    board[r][c] = -1;
	    for (int x = c+1; x < board.length; x++){
		board[r][x]++;
	    }
	    if (c < board.length - 1){
		int y = c+1;
		int x = r+1;
		while (x < board.length && y < board.length){
		    board[x][y]++;
		    y++;
		    x++;
		}
	    }
	    int z = r-1;
	    for (int x = c+1; x < board.length; x++){
		if (z > -1){
		    board[z][x]++;
		    z--;
		}
	    }
	    return true;
	}
	return false;
    }

    private boolean removeQueen(int r, int c){
	if (board [r][c] == -1){
	    board[r][c] = 0;
	    for (int x = c+1; x < board.length; x++){
		board[r][x]--;
	    }
	    if (c < board.length - 1){
		int y = c+1;
		int x = r+1;
		while (x < board.length && y < board.length){
		    board[x][y]--;
		    y++;
		    x++;
		}
	    }
	    int z = r-1;
	    for (int x = c+1; x < board.length; x++){
		if (z > -1){
		    board[z][x]--;
		    z--;
		}
	    }	    
	    return true;
	}
	return false;
    }

    //-1 represents a queen, any other number is an empty square
    public String toString(){
	String output = "";
	for (int j = 0; j < board.length; j++){
	    for (int k = 0; k < board.length; k++){
		if (board[j][k] == -1){
		    output+="Q ";
		}
		else{output+="_ ";}
	    }
	    output+="\n";
	}
	return output;
    }

    public boolean solve(){
	for (int j = 0; j < board.length; j++){
	    for (int k = 0; k < board.length; k++){
		if (board[j][k] != 0){
		    throw new IllegalStateException("The board is not empty");
		}
	    }
	}
	return helper(0);
    }

    public boolean helper(int col){
        if (col >= board.length){
	    return true;
	}
	for (int x = 0; x < board.length; x++){
	    if (addQueen(x, col) && helper(col + 1)){
		return true;
	    }
	    removeQueen(x, col);
	}
	return false;
    }

    public int countSolutions(){
	for (int j = 0; j < board.length; j++){
	    for (int k = 0; k < board.length; k++){
		if (board[j][k] != 0){
		    throw new IllegalStateException("The board is not empty");
		}
	    }
	}
	return helperc(0, 0);
    }

    public int helperc(int col, int numSolutions){
	if(col == board.length){
	    numSolutions++;
	    return numSolutions;
	}
	for(int j = 0; j < board.length; j++){
	    if(addQueen(j, col)){
		numSolutions = helperc(col + 1, numSolutions);
		removeQueen(j,col);
	    }
	}
	return numSolutions;
    }

    public static void main(String[]args){
	for (int x = 0; x < 11; x++){
	    QueenBoard b = new QueenBoard(x);
	    System.out.println(x+": "+b.countSolutions());
	}
    }
}
