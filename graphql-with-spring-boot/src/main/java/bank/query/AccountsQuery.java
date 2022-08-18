package bank.query;

import bank.dao.entity.Account;
import bank.service.AccountService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountsQuery implements GraphQLQueryResolver {
    @Autowired
    private AccountService accountService;

    public List<Account> getAccounts(final int clientId) {
        return accountService.getAccounts(clientId);
    }
    public Account transaction(final String addressFrom, final String addressTo, final float amount) {
        return accountService.transaction(addressFrom,addressTo,amount);
    }
}
