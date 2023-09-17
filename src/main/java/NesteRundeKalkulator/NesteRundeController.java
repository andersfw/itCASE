package NesteRundeKalkulator;


import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NesteRundeController {

    Session session;
    
    @FXML Button newSessionButton, addUserButton, finishedButton, initialRound, beerButton, cocktailButton, shotButton, newRound, exit;
    @FXML TextField sessionName, addUser;
    @FXML Label finishedLabel, buyerLabel, Leaderboard;

    // BackgroundImage backgroundImage = new BackgroundImage( new Image( getClass().getResource("trond.jpg").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
    // Background background = new Background(backgroundImage);

    public void handleNewSession() {
        String name = sessionName.getText();
        this.session = new Session(name);

        newSessionButton.setVisible(false);
        sessionName.setVisible(false);
        addUserButton.setVisible(true);
        addUser.setVisible(true);
        finishedButton.setVisible(true);
        finishedLabel.setVisible(true);
    }


    public void handleAddUser() {
        String name = addUser.getText();
        User user = new User(name);
        session.addUser(user);
        addUser.clear();
    }

    public void handleFinished() {
        addUserButton.setVisible(false);
        addUser.setVisible(false);
        finishedButton.setVisible(false);
        finishedLabel.setVisible(false);
        initialRound.setVisible(true);
        // initialRound.setBackground(background);
    }

    public void handleInitialRound() {
        User user = session.getRandomUser();
        session.setBuyingUser(user);
        initialRound.setVisible(false);
        buyerLabel.setVisible(true);
        buyerLabel.setText(user.getName()+" kjøper første runde!");
        beerButton.setVisible(true);
        cocktailButton.setVisible(true);
        shotButton.setVisible(true);
        exit.setVisible(true);
        Leaderboard.setText("");
        String output = "";
        for (User user2 : session.getUsers()) {
            output += user2.getName()+ " har spandert " + user2.getBalance() +" ganger \n";
        }
        Leaderboard.setText(output);
    }

    public void handleBeerBuy(){
        session.getBuyingUser().setBalance(1);
        beerButton.setVisible(false);
        cocktailButton.setVisible(false);
        shotButton.setVisible(false);
        newRound.setVisible(true);
        buyerLabel.setText("Kos dere med ølen!");
        updateLeaderBoard();
        //Skrive til fil
    }

    public void handleCocktailBuy(){
        session.getBuyingUser().setBalance(2);
        beerButton.setVisible(false);
        cocktailButton.setVisible(false);
        shotButton.setVisible(false);
        newRound.setVisible(true);
        buyerLabel.setText("Kos dere med drinken!");
        updateLeaderBoard();

        //Skrive til fil
    }

    public void handleShotBuy(){
        session.getBuyingUser().setBalance(2);
        beerButton.setVisible(false);
        cocktailButton.setVisible(false);
        shotButton.setVisible(false);
        newRound.setVisible(true);
        buyerLabel.setText("Kos dere med shoten!");
        updateLeaderBoard();

        //Sktive til fil
    }

    public void handleNewRound() {
        User nextBuyer = session.suggestNextUser();
        session.setBuyingUser(nextBuyer);
        newRound.setVisible(false);
        buyerLabel.setVisible(true);
        buyerLabel.setText(nextBuyer.getName() + " kjøper neste runde!");
        beerButton.setVisible(true);
        cocktailButton.setVisible(true);
        shotButton.setVisible(true);
        updateLeaderBoard();
    }

    public void updateLeaderBoard() {
        Leaderboard.setText("");
        String output = "";
        for (User user2 : session.getUsers()) {
            output += user2.getName()+ " har spandert " + user2.getBalance() +" ganger \n";
        }
        Leaderboard.setText(output);
    }

    public void handleExit() {
        Alert alert = new Alert(AlertType.INFORMATION);
        //alert.setTitle("Ferdig for ikveld?");
        alert.setHeaderText("Ferdig for ikveld?");
        alert.setContentText("Trykk 'Lagre' for å avslutte og lagre til senere, eller 'Avslutt' uten å lagre");
    }

}
