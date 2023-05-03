package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Budgeting;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class BudgetingControllerTest extends ApplicationTest {

    public BudgetingController controller;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/resources/fxml/budgeting.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        controller = loader.getController();
    }

    @Before
    public void setUp() throws IOException {
        Budgeting model = new Budgeting("Test Budget", 1000);
        File file = new File("test-budget.json");
        model.saveToJsonFile(file);
        controller.setModel(model);
        controller.loadBudgetFromJsonFile();
    }

/*    @AfterEach
    void tearDown() {
    }*/


    @Test
    public void testLoadBudgetFromJsonFile() {
        assertThat(controller.getNameOfBudgetOwner().getText(), equalTo("Test Budget"));
    }


/*    @Test
    void saveBudgetToJsonFile() {
        System.out.println("save");
    }

    @Test
    void getBudgetOwnersName() {
        System.out.println("getName");
    }

    @Test
    void addToBudget() {
        System.out.println("Add");
    }*/
}