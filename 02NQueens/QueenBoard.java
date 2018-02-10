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
	    for (int x = 0; x < board.length; x++){
		if (board[x][c] != -1){
		    board[x][c]++;
		}
	    }
	    for (int x = c+1; x < board.length; x++){
		board[r][x]++;
	    }
	    int y = c+1;
	    for (int x = r+1; x < board.length; x++){
		board[x][y]++;
		y++;
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
	    for (int x = 0; x < board.length; x++){
		if (board[x][c] != 0){
		    board[x][c]--;
		}
	    }
	    for (int x = c+1; x < board.length; x++){
		board[r][x]--;
	    }
	    int y = c+1;
	    for (int x = r+1; x < board.length; x++){
		board[x][y]--;
		y++;
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
		else{output+=board[j][k]+" ";}
	    }
	    output+="\n";
	}
	return output;
    }

    public boolean solve(){
	for (int j = 0; j < board.length; j++){
	    for (int k = 0; k < board.length; k++){
		if (board[j][k] != 0){
		    throw new IllegalStateException();
		}
	    }
	}
	return helper(board, 0);
    }

    public boolean helper(int[][] board, int row){
        return true;
    }

    public int countSolutions(){
	return 0;
    }

    public static void main(String[]args){
	QueenBoard b = new QueenBoard(4);
	System.out.println(b.toString());
	System.out.println(b.addQueen(1,1));
	System.out.println(b.toString());
	System.out.println(b.removeQueen(1,1));
	System.out.println(b.toString());
    }
}
