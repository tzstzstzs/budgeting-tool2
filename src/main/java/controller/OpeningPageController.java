package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Budgeting;

import java.io.IOException;

public class OpeningPageController {

    @FXML
    private AnchorPane root;

    @FXML
    private Button createButton;

    @FXML
    private TextField newBudgetName;

    @FXML
    private TextField newBudgetGoal;

/*    @FXML
    private void switchToBudgetingPage(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/second.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }*/
    private void switchToBudgetingPage(ActionEvent event, Budgeting newBudget) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/budgeting.fxml"));
            Parent root = loader.load();
            BudgetingController controller = loader.getController();
            //Budgeting budget = null;
            controller.setModel(newBudget); // pass the budget to the controller
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void createNewBudget(ActionEvent actionEvent)  {
        Budgeting newBudget = new Budgeting(newBudgetName.getText(), Double.parseDouble(newBudgetGoal.getText()));
        switchToBudgetingPage(actionEvent, newBudget);
    }


}