package Services;

import Dao.ExpenseDao;
import Model.Expense;

public class ExpenseServices {
    static ExpenseDao expenseDao = new ExpenseDao();
    public static void addExpense(Expense expense) {
        expenseDao.addExpense(expense);
    }

    public static void updateExpense(Expense expense) {
        expenseDao.upadteExpense(expense);
    }

    public void deleteExpense(int expenseId) {
        expenseDao.deleteExpense(expenseId);
    }
}

