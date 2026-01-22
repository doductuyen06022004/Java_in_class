package com.vti.backend.presentationlayer;

import com.vti.backend.businesslayer.AccountService;
import com.vti.entity.Account;

import java.sql.SQLException;
import java.util.List;

public class AccountController {

    private AccountService service = new AccountService();

    public List<Account> getListAccounts() throws SQLException {
        return service.getListAccounts();
    }
}
