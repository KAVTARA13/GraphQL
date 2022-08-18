package bank.mutation;

import bank.service.AccountService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import bank.dao.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientMutation implements GraphQLMutationResolver {
    @Autowired
    private AccountService accountService;

    public Client createClient(final String name) {
        return accountService.createClient(name);
    }
}
