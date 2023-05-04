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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Budgeting;

import java.io.File;
import java.io.IOException;

public class OpeningPageController {

    @FXML
    public AnchorPane root;

    @FXML
    public Button createButton;

    @FXML
    private TextField newBudgetName;

    @FXML
    private TextField newBudgetGoal;

    private void switchToBudgetingPage(ActionEvent event, Budgeting budgetToOpen, File selectedFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/budgeting.fxml"));
            Parent root = loader.load();
            BudgetingController controller = loader.getController();
            //Budgeting budget = null;
            controller.setModel(budgetToOpen); // pass the budget to the controller
            controller.setCurrentFile(selectedFile);
            setAllLabels(controller, budgetToOpen);
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setAllLabels(BudgetingController controller, Budgeting budgetToOpen){
        controller.nameOfBudgetOwner.setText(budgetToOpen.getName() + "'s budget");
        controller.remainingAmount.setText(String.valueOf(budgetToOpen.getRemainingAmount()));
        controller.totalIncome.setText(String.valueOf(budgetToOpen.getTotalIncomes()));
        controller.totalExpense.setText(String.valueOf(budgetToOpen.getTotalExpenses()));
    }

    @FXML
    public void createNewBudget(ActionEvent actionEvent)  {
        Budgeting newBudget = new Budgeting(newBudgetName.getText(), Double.parseDouble(newBudgetGoal.getText()));
        switchToBudgetingPage(actionEvent, newBudget, null);
    }

    public void openBudget(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Budget File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JSON Files", "*.json"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        File selectedFile = fileChooser.showOpenDialog(((Node) actionEvent.getSource()).getScene().getWindow());

        if (selectedFile != null) {
            Budgeting model = Budgeting.loadFromJsonFile(selectedFile);
            switchToBudgetingPage(actionEvent, model, selectedFile);
        }
    }
}