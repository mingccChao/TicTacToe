package TicTacToe;

 class TicTacToe {
     User currentTurn,player1,player2;
    private String currentStage = "";
    private int emptyCells = 9;
    //private boolean gameover = false;
    //private int previous_move;
    private String O_stage = "";
    private String X_stage = "";
    private String winner = "";
    private String firstStage = "";
    Board board;

    /**
     * constructor
     */
    public TicTacToe(){
        board = new Board(3,3);
    }

//    public void reset(){
//        this.currentTurn = null;
//        this.player1 = null;
//        this.player2 = null;
//        this.currentStage = "";
//        this.O_stage = "";
//        this.X_stage = "";
//        this.winner = "";
//        this.firstStage = "";
//        board.resetBoard();
//    }

    public String getCurrentSymbol(){
        if(this.currentStage.equals(O_stage)) {
            return "0";
        }
        else if(this.currentStage.equals(X_stage)){
            return "X";
        }
        return "'";
    }

    public void setStages(User player1, User player2){
        O_stage = player1.getName();
        player1.setSymbol("0");
        this.player1 = player1;


        X_stage = player2.getName();
        player2.setSymbol("X");
        this.player2 = player2;

    }




    /**
     * This method sets who goes first, then sets current stage = the firsStage.
     * @param stage indicating the stage that goes first.
     */
    public void setFirstStage(String stage, User user){
        if(stage == "O") {
            firstStage = O_stage;
            currentStage = O_stage;
        }
        else {
            firstStage = X_stage;
            currentStage = X_stage;
        }
        currentTurn = user;
    }
    /**
     * Implements changePlayer()
     * This method changes the currentStage variable from either O to X or X to O.
     */
    private void changeplayer(){
        if(currentStage == O_stage){
            currentStage = X_stage;
        }
        else
            currentStage = O_stage;
        if(currentTurn.equals(this.player1)){
            this.currentTurn = this.player2;
        }
        else{
            this.currentTurn = this.player1;
        }
    }
    /**
     * returns the currentStage variable
     * @return String, the currenStage variable indicating who is supposed to make a move.
     */
    public String getCurrentStage(){
        return currentStage;
    }

    public User getCurrentTurn(){
        return this.currentTurn;
    }

    /**
     * This method checks if the move representing by one of the 9 indexes is a valid
     * move.
     * returns true is valid, false otherwise.
//     * @param int the row index
//     * @param int the column index
     * @return a boolean, true for valid, false otherwise
     */
    public boolean isValid(int rowIndex, int columnIndex){

        if(outOfBoundary(rowIndex, columnIndex)){
            System.out.println("INVALID");
            return false;
        }

        if(cellIsEmpty(rowIndex, columnIndex))
            return true;
        else{
            System.out.println("INVALID");
            return false;

        }
    }

    /**
     * checks if the indexes is out of boundary of the 3x3 int[][].
     * @param rowIndex row index of 3x3 int[][].
     * @param columnIndex column index of 3x3 int[][].
     * @return true if the indexes are out of boundary, false otherwise.
     */
    private boolean outOfBoundary(int rowIndex, int columnIndex){
        return rowIndex < 0 || rowIndex > 2 || columnIndex < 0 || columnIndex > 2;
    }

    /**
     * takes in indexes and check if the cell is empty.
//     * @param rowIndex row index in the 3x3 int[][].
//     * @param columnIndex column index in the 3x3 int[][].
     * @return true if the cell is empty, false otherwise.
     */
    private boolean cellIsEmpty(int index1, int index2){
        return board.getBoard().get(index1).get(index2) == "'";
    }


    /**
     * This method makes a move based on user input.
//     * @param rowIndex row index in the 3x3 int[][].
//     * @param columnIndex column index in the 3x3 int[][].
//     * @param mark an int representing either player
     */
    public void makeMove(int rowIndex, int columnIndex, User player){
//        System.out.println("Making Move");
        System.out.println("Current Player: " + this.currentTurn);
//        System.out.println("Current Stage: " + this.currentStage);
//        System.out.println("0 Stage: " + this.O_stage);
//        System.out.println("X Stage: " + this.X_stage);
//        System.out.println("First Stage: " + this.firstStage);

        if(!isValid(rowIndex, columnIndex)){
            return;
        }
        board.getBoard().get(rowIndex).set(columnIndex,player.getName());
//        System.out.println(board.getBoard().get(rowIndex).get(columnIndex));
//        board.updateBoard();
        emptyCells --;
        checkWinner(player.getName());
        if(!winner.isEmpty()){
            System.out.println("WINNER: " + winner);
            return;
        }
        //previous_move = Nextmove;
        changeplayer();
//        board.printBoard();
    }

    private void checkWinner(String playername){
        if(board.getBoard().get(0).get(0).equals(playername) && board.getBoard().get(1).get(0).equals(playername) && board.getBoard().get(2).get(0).equals(playername)){
            winner = playername;}
        else if(board.getBoard().get(0).get(1).equals(playername) && board.getBoard().get(1).get(1).equals(playername) && board.getBoard().get(2).get(1).equals(playername)){
            winner = playername;}
        else if(board.getBoard().get(0).get(2).equals(playername) && board.getBoard().get(1).get(2).equals(playername) && board.getBoard().get(2).get(2).equals(playername)){
            winner = playername;}
        else if(board.getBoard().get(0).get(0).equals(playername) && board.getBoard().get(0).get(1).equals(playername) && board.getBoard().get(0).get(2).equals(playername)){
            winner = playername;}
        else if(board.getBoard().get(1).get(0).equals(playername) && board.getBoard().get(1).get(1).equals(playername) && board.getBoard().get(1).get(2).equals(playername)){
            winner = playername;}
        else if(board.getBoard().get(2).get(0).equals(playername) && board.getBoard().get(2).get(1).equals(playername) && board.getBoard().get(2).get(2).equals(playername)){
            winner = playername;}
        else if(board.getBoard().get(0).get(0).equals(playername) && board.getBoard().get(1).get(1).equals(playername) && board.getBoard().get(2).get(2).equals(playername)){
            winner = playername;}
        else if(board.getBoard().get(2).get(0).equals(playername) && board.getBoard().get(1).get(1).equals(playername) && board.getBoard().get(0).get(2).equals(playername)){
            winner = playername;}
        else if(emptyCells == 0)
            winner = "draw";
    }

    /**
     * This method indicates whether a game is over
     * @return boolean true for game over, otherwise false.
     */
    public boolean isGameOver() {
        return emptyCells == 0;
    }

    /**
     * returns the winner variable
     * @return String, winner variable representing who is the winner.
     */
    public String getWinner(){
        return winner;
    }
    /**
     * This method sets currentStage to a TicTacToe.User
     * This method is currently not in use.
     * @param Cur a TicTacToe.User class indicating a player
     */
    public void setCurrentStage(String Cur){
        currentStage = Cur;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }


}
