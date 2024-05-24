package Controller;

import Model.Expense;
import Services.ExpenseServices;

public class ExpenseController {

    ExpenseServices expenseServices = new ExpenseServices();

    public void addExpense(Expense expense) {
        expenseServices.addExpense(expense);
    }

    public void updateExpense(Expense expense) {
        expenseServices.updateExpense(expense);
    }

    public void deleteExpense(int expense_id) {
        expenseServices.deleteExpense(expense_id);
    }
}
