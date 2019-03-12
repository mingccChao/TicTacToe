import Board;
public class TicTacToe {
	private String currentStage = "";
	private int emptyCells = 9;
	//private boolean gameover = false;
	//private int previous_move;
	private String O_stage = "";
	private String X_stage = "";
	private String winner = "";
	private String firstStage = "";
	/**
	 * constructor
	 */
	public TicTacToe(){
	}
	
	/**
	 * This method sets who is O and who is X
	 * @param user1 representing the player who is O
	 * @param user2 representing the player who is X
	 */
	public void setStages(User player1, User player2){
		O_stage = player1.getName();
		X_stage = player2.getName();
	}
	
	/**
	 * This method sets who goes first, then sets current stage = the firsStage.
	 * @param stage indicating the stage that goes first.
	 */
	public void setFirstStage(String stage){
		if(stage == "O") {
			firstStage = O_stage;	
			currentStage = O_stage;
		}
		else {
			firstStage = X_stage;
			currentStage = X_stage;
		}
	}
	/**
	 * Implements changePlayer()
	 * This method changes the currentStage variable from either O to X or X to O.
	 */
	private void changeplayer(){
		if(currentStage == O_stage)
			currentStage = X_stage;
		else
			currentStage = O_stage;
	}
	/**
	 * returns the currentStage variable
	 * @return String, the currenStage variable indicating who is supposed to make a move.
	 */
	public String getCurrentStage(){
		return currentStage;
	}
	
	/**
	 * This method checks if the move representing by one of the 9 indexes is a valid
	 * move. 
	 * returns true is valid, false otherwise.
	 * @param int the row index
	 * @param int the column index
	 * @return a boolean, true for valid, false otherwise
	 */
	public boolean isValid(int rowIndex, int columnIndex){
		if(outOfBoundary(rowIndex, columnIndex))
			return false;
		
		if(cellIsEmpty(rowIndex, columnIndex))
			return true;
		else
			return false;
	}
	
	/**
	 * checks if the indexes is out of boundary of the 3x3 int[][].
	 * @param rowIndex row index of 3x3 int[][].
	 * @param columnIndex column index of 3x3 int[][].
	 * @return true if the indexes are out of boundary, false otherwise.
	 */
	private boolean outOfBoundary(int rowIndex, int columnIndex){
		if(rowIndex < 0 || rowIndex > 2 || columnIndex < 0 || columnIndex > 2)
			return true;
		return false;
	}
	
	/**
	 * takes in indexes and check if the cell is empty.
	 * @param rowIndex row index in the 3x3 int[][].
	 * @param columnIndex column index in the 3x3 int[][].
	 * @return true if the cell is empty, false otherwise.
	 */
	private boolean cellIsEmpty(int index1, int index2){
		if(Board.getBoard[index1][index2] == "'")
			return true;
		else 
			return false;
	}
	
	/**
	 * This method makes a move based on user input.
	 * @param rowIndex row index in the 3x3 int[][].
	 * @param columnIndex column index in the 3x3 int[][].
	 * @param mark an int representing either player
	 */
	public void makeMove(int rowIndex, int columnIndex, User player){
		isValid(rowIndex, columnIndex);
		B.updateBoard(B.getBoard[rowIndex][columnIndex]) = player.getName();
		emptyCells --;
		checkWinner(player.getName());
		//previous_move = Nextmove;
		changeplayer();
	}
	
	private void checkWinner(String playername){
		if(Board.getBoard[0][0] == playername && Board.getBoard[1][0] == playername && Board.getBoard[2][0] == playername){
			winner = playername;}
		else if(Board.getBoard[0][1] == playername && Board.getBoard[1][1] == playername && Board.getBoard[2][1] == playername){
			winner = playername;}
		else if(Board.getBoard[0][2] == playername && Board.getBoard[1][2] == playername && Board.getBoard[2][2] == playername){
			winner = playername;}
		else if(Board.getBoard[0][0] == playername && Board.getBoard[0][1] == playername && Board.getBoard[0][2] == playername){
			winner = playername;}
		else if(Board.getBoard[1][0] == playername && Board.getBoard[1][1] == playername && Board.getBoard[1][2] == playername){
			winner = playername;}
		else if(Board.getBoard[2][0] == playername && Board.getBoard[2][1] == playername && Board.getBoard[2][2] == playername){
			winner = playername;}
		else if(Board.getBoard[0][0] == playername && Board.getBoard[1][1] == playername && Board.getBoard[2][2] == playername){
			winner = playername;}
		else if(Board.getBoard[2][0] == playername && Board.getBoard[1][1] == playername && Board.getBoard[0][2] == playername){
			winner = playername;}
		else if(emptyCells == 0)
			winner = "draw";
	}
	
	/**
	 * This method indicates whether a game is over
	 * @return boolean true for game over, otherwise false. 
	 */
	public boolean isGameOver() {
		if(emptyCells == 0)
			return true;
		else 
			return false;
	}
	
	/**
	 * returns the winner variable
	 * @return String, winner variable representing who is the winner.
	 */
	public String getWinner(){
		return winner;
	}
	/**
	 * This method sets currentStage to a User
	 * This method is currently not in use.
	 * @param Cur a User class indicating a player
	 */
	public void setCurrentStage(String Cur){
		currentStage = Cur;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
