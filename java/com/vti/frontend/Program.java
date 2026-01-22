package com.vti.frontend;

import com.vti.backend.presentationlayer.AccountController;
import com.vti.entity.Account;

import java.sql.SQLException;
import java.util.List;

public class Program {
    public static void main(String[] args) throws SQLException {

        AccountController controller = new AccountController();
        List<Account> accounts = controller.getListAccounts();

        accounts.forEach(System.out::println);
    }
}
