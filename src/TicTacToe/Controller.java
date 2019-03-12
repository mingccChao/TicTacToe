package TicTacToe;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Controller {
    TicTacToe game;
    User player1, player2;
    private int turn = 0;
    public Button b1;
    public Button b2;
    public Button b3;
    public Button b4;
    public Button b5;
    public Button b6;
    public Button b7;
    public Button b8;
    public Button b9;

    public Controller() {
        System.out.println("TicTacToe was initialized!");
        // Initialize Players
        game = new TicTacToe();
        player1 = new User("Kenny");
        player2 = new User("Gev");
        game.setStages(player1, player2);
        game.setFirstStage("0", player1);
    }

    public void handleButtonClicked(Event event) {
        Button source = (Button) event.getSource();
        if (source.equals(b1)) {
            if (game.isValid(0, 0)) {
                game.makeMove(0, 0, game.currentTurn);
                handleMove(source);
                System.out.println("Made Move!");
                switchMove();


            }
        }
        if (source.equals(b2)) {
            if (game.isValid(0, 1)) {
                game.makeMove(0, 1, game.currentTurn);
                handleMove(source);
                System.out.println("Made Move!");
                switchMove();


            }
        }
        if (source.equals(b3)) {
            if (game.isValid(0, 2)) {
                game.makeMove(0, 2, game.currentTurn);
                handleMove(source);
                System.out.println("Made Move!");
                switchMove();


            }
        }
        if (source.equals(b4)) {
            if (game.isValid(1, 0)) {
                game.makeMove(1, 0, game.currentTurn);
                handleMove(source);
                System.out.println("Made Move!");
                switchMove();


            }
        }
        if (source.equals(b5)) {
            if (game.isValid(1, 1)) {
                game.makeMove(1, 1, game.currentTurn);
                handleMove(source);
                System.out.println("Made Move!");
                switchMove();


            }
        }
        if (source.equals(b6)) {
            if (game.isValid(1, 2)) {
                game.makeMove(1, 2, game.currentTurn);
                handleMove(source);
                System.out.println("Made Move!");
                switchMove();



            }
        }
        if (source.equals(b7)) {
            if (game.isValid(2, 0)) {
                game.makeMove(2, 0, game.currentTurn);
                handleMove(source);
                System.out.println("Made Move!");
                switchMove();


            }
        }
        if (source.equals(b8)) {
            if (game.isValid(2, 1)) {
                game.makeMove(2, 1, game.currentTurn);
                handleMove(source);
                System.out.println("Made Move!");
                switchMove();


            }
        }
        if (source.equals(b9)) {
            if (game.isValid(2, 2)) {
                game.makeMove(2, 2, game.currentTurn);
                handleMove(source);
                System.out.println("Made Move!");
                switchMove();


            }
        }
        if (!game.getWinner().isEmpty() || game.isGameOver()) {
            System.out.println("GAME IS OVER");
            this.createEndGame();
            return;
        }

    }

    public void handleMove(Button button) {
        if (this.turn == 0) {
            button.setStyle("-fx-text-fill: red");
            button.setText("0");
        } else if (this.turn == 1) {
            button.setStyle("-fx-text-fill: blue");
            button.setText("X");
        }
    }

    public void switchMove() {
        if (this.turn == 0) {
            this.turn = 1;
        } else if (this.turn == 1) {
            this.turn = 0;
        }
    }

    public void handleActionQuit() {
        Platform.exit();
    }

    private void createEndGame() {
        final Stage dialog = new Stage();

        Button quitBtn = new Button();
        quitBtn.setText("Quit!");
        quitBtn.setOnAction((e) -> Platform.exit());


        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(Main.primStage);
        dialog.setTitle("Game Over!");
        VBox dialogVbox = new VBox(20);
        dialogVbox.getChildren().add(new Text(winnerOrTie()));
        dialogVbox.getChildren().add(quitBtn);
        Scene dialogScene = new Scene(dialogVbox, 300, 200);
        dialog.setScene(dialogScene);
        dialog.show();
    }

//    private void createStartGame(){
//        final Stage dialog = new Stage();
//
//        TextField textField = new TextField();
//
//        dialog.initModality(Modality.APPLICATION_MODAL);
//        dialog.initOwner(Main.primStage);
//        dialog.setTitle("Game Settings");
//        VBox dialogVbox = new VBox(20);
//        dialogVbox.getChildren().add(new Text(winnerOrTie()));
//        dialogVbox.getChildren().add(textField);
//        Scene dialogScene = new Scene(dialogVbox, 300, 200);
//        dialog.setScene(dialogScene);
//        dialog.show();
//    }

    public String winnerOrTie() {
        if (!game.getWinner().isEmpty()) {
            return "Winner!: " + game.getWinner();
        } else if (game.isGameOver()) {
            return "Game was a tie!";
        }
        return "";
    }

}
