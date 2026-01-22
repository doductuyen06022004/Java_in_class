package com.vti.backend.businesslayer;

import com.vti.backend.datalayer.AccountRepository;
import com.vti.entity.Account;

import java.sql.SQLException;
import java.util.List;

public class AccountService extends IAccountService {

    private AccountRepository repository = new AccountRepository();
    @Override
   public List<Account> getListAccounts() throws SQLException {
       return repository.getListAccounts();
   }
}
