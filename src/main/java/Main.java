import javafx.application.Application;
import model.Budgeting;
import model.Expense;
import model.Income;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {

        Application.launch(BudgetingApplication.class, args);

/*        Income inc1 = new Income("salary", 2000, new Date());
        Income inc2 = new Income("apartment letting", 500, new Date());

        Expense expns1 = new Expense("bills", 200, new Date());
        Expense expns2 = new Expense("loan", 250, new Date());
        Expense expns3 = new Expense("petrol", 150, new Date());
        Expense expns4 = new Expense("food", 500, new Date());

        Budgeting budget1 = new Budgeting("Zsolt", 10.0);
        budget1.addIncome(inc1);
        budget1.addIncome(inc2);
        budget1.addExpense(expns1);
        budget1.addExpense(expns2);
        budget1.addExpense(expns3);
        budget1.addExpense(expns4);
        budget1.addExpense(new Expense("clothes", 100, new Date()));

        File bud1 = new File("budget1.json");
        budget1.saveToJsonFile(bud1);

        Budgeting bud2 = Budgeting.loadFromJsonFile(bud1);
        System.out.println("Ez a jó: " + bud2);*/
    }
}
