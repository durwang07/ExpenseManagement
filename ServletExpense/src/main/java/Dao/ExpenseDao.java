package Dao;

import Model.Expense;
import Util.ConnectionUtil;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDao<expense> {

    @SneakyThrows
    public static void addExpense(Expense expense) {

        Connection connection = ConnectionUtil.getConnection();
        String sqlQuery = "insert into student.Expenses(expenses_id, expense_name, expense_description, expense_amount) values(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

        preparedStatement.setInt(1, expense.getExpense_id());
        preparedStatement.setString(2, expense.getExpense_name());
        preparedStatement.setString(3, expense.getExpense_description());
        preparedStatement.setInt(4, expense.getExpense_amount());

        preparedStatement.executeUpdate();
        connection.close();
        System.out.println("Expenses Added");
    }

    @SneakyThrows
    public void upadteExpense(Expense expense_id) {
        Connection connection = ConnectionUtil.getConnection();
        String query = "update Expenses set expense_name=?, expense_description=?, expense_amount=? where expense_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, expense_id.getExpense_name());
        preparedStatement.setString(2, expense_id.getExpense_description());
        preparedStatement.setInt(3, expense_id.getExpense_amount());

        preparedStatement.setInt(4, expense_id.getExpense_id());
        preparedStatement.executeUpdate();
        System.out.println("Expense updated");
        connection.close();
    }

    @SneakyThrows
    public void deleteExpense(int expenseId) {
        Connection connection = ConnectionUtil.getConnection();
        String query = "delete from Expenses where expense_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, expenseId);
        preparedStatement.executeUpdate();
        System.out.println("Expense deleted successfully");
        connection.close();
    }
    @SneakyThrows
    public List<expense> findAll(){
        List<expense> expenseList = new ArrayList<>();
        Connection connection = ConnectionUtil.getConnection();
        Statement statement = connection.createStatement();
        String query = "select * from Expenses";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            Expense expense =  Expense.builder()
                    .expense_id(resultSet.getInt("expense_id"))
                    .expense_name(resultSet.getString("expense_name"))
                    .expense_description(resultSet.getString("expense_description"))
                    .expense_amount(resultSet.getInt("expense_amount"))

                    .build();
            expenseList.add((expense) expense);
        }
        connection.close();
        return expenseList;


    }




}
