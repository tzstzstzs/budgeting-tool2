package controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Budgeting;
import model.Expense;
import model.Income;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BudgetingController {
    @FXML
    private TextField incomeCategory;

    @FXML
    private TextField incomeAmount;

    @FXML
    private DatePicker incomeDate;

    @FXML
    private TextField expenseCategory;

    @FXML
    private TextField expenseAmount;

    @FXML
    private DatePicker expenseDate;

    @FXML
    private Label remainingAmount;

    @FXML
    public Label nameOfBudgetOwner;

    public Label getNameOfBudgetOwner() {
        return nameOfBudgetOwner;
    }

    @FXML
    Budgeting model;

    @FXML
    private void initialize() {
        model = new Budgeting();
    }

    public void setModel(Budgeting model) {
        this.model = model;
    }
/*
    public void loadBudgetFromJsonFile() throws IOException {
        File file = new File("budget2.json");
        model = Budgeting.loadFromJsonFile(file);
            nameOfBudgetOwner.setText(model.getName());
    }
*/

    public void saveBudgetToJsonFile(){
        File file1 = new File("budget3.json");
        try{
            model.saveToJsonFile(file1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addToBudget(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();

        if (button.getId().equals("addIncomeButton")) {
            model.addIncome(new Income(incomeCategory.getText(),
                    Double.parseDouble(incomeAmount.getText()),
                    DateConverter.localDateToDate(incomeDate.getValue())));
            System.out.println("Adding income");
        } else if (button.getId().equals("addExpenseButton")) {
            model.addExpense(new Expense(expenseCategory.getText(),
                    Double.parseDouble(expenseAmount.getText()),
                    DateConverter.localDateToDate(expenseDate.getValue())));
            System.out.println("Adding expense");
        }
        System.out.println(model);
    }
}
