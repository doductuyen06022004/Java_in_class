package com.vti.backend.datalayer;



import com.vti.backend.DepartmentDao;
import com.vti.entity.Account;
import com.vti.entity.Group;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;


public class AccountRepository implements IAccountRepository  {
    private final String url = "jdbc:mysql://localhost:3306/testing_system";
    private final String user = "root";
    private final String password = "tuyen06022004";


    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    @Override
    public List<Account> getListAccounts() throws SQLException {
        List<Account> accounts = new ArrayList<>();

        String sql = """
            SELECT a.AccountID, a.Username, a.Email, a.FullName,
                   g.GroupID, g.GroupName
            FROM Account a
            LEFT JOIN `Group` g ON a.GroupID = g.GroupID
        """;

        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()) {
            Group group = new Group(
                    rs.getInt("GroupID"),
                    rs.getString("GroupName")
            );

            Account account = new Account(
                    rs.getInt("AccountID"),
                    rs.getString("Username"),
                    rs.getString("Email"),
                    rs.getString("FullName"),
                    group.toString()
            );

            accounts.add(account);
        }


        return accounts;
    }
}
