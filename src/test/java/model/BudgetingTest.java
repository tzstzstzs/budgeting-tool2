package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Date;

class BudgetingTest {
    Budgeting underTest;

    @BeforeEach
    void setUp() {
        Income inc1 = new Income("salary", 2000, new Date());
        Income inc2 = new Income("apartment letting", 500, new Date());

        Expense expns1 = new Expense("bills", 200, new Date());
        Expense expns2 = new Expense("loan", 250, new Date());
        Expense expns3 = new Expense("petrol", 150, new Date());
        Expense expns4 = new Expense("food", 500, new Date());
        underTest = new Budgeting("Zsolt", 10.0);
        underTest.addIncome(inc1);
        underTest.addIncome(inc2);
        underTest.addExpense(expns1);
        underTest.addExpense(expns2);
        underTest.addExpense(expns3);
        underTest.addExpense(expns4);
        underTest.addExpense(new Expense("clothes", 100, new Date()));

    }

    @Test
    void testGetTotalExpenses() {
        assertEquals(1200, underTest.getTotalExpenses());
    }

    @Test
    void testGetTotalIncomes() {
        assertEquals(2500, underTest.getTotalIncomes());
    }

    @Test
    void testGetRemainingAmount() {
        assertEquals(1300, underTest.getRemainingAmount());
    }

    @Test
    void testGetName() {
        assertEquals("Zsolt", underTest.getName());
    }

    @Test
    void testGetGoal() {
        assertEquals(10.0, underTest.getGoal());
    }
}