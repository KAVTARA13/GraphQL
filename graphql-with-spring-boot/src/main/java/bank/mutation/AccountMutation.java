package bank.mutation;

import bank.dao.entity.Account;
import bank.service.AccountService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountMutation implements GraphQLMutationResolver {
    @Autowired
    private AccountService accountService;

    public Account createAccount(final String address, final int clientId, final float amount) {
        return accountService.createAccount(address,clientId,amount);
    }

}
