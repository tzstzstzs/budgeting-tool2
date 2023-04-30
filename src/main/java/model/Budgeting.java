package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Budgeting {
    private String name;
    private List<Expense> expenses;
    private List<Income> incomes;
    private double goal;
    //private ObjectMapper mapper;

    public Budgeting(String name, double goal) {
        this.name = name;
        this.expenses = new ArrayList<>();
        this.incomes = new ArrayList<>();
        this.goal = goal;
        //this.mapper = new ObjectMapper();

    }

    public void saveToJsonFile(File file) throws IOException {
        ObjectMapper mapper1 = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        mapper1.writeValue(file, this);
    }

    public static Budgeting loadFromJsonFile(File file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(file, Budgeting.class);
    }
    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public void addIncome(Income income) {
        incomes.add(income);
    }

    public double getTotalExpenses() {
        return expenses.stream().mapToDouble(Expense::getAmount).sum();
    }

    public double getTotalIncomes() {
        return incomes.stream().mapToDouble(Income::getAmount).sum();
    }

    public double getRemainingAmount() {
        return getTotalIncomes() - getTotalExpenses();
    }
}