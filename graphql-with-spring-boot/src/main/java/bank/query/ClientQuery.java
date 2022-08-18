package bank.query;

import bank.dao.entity.Client;
import bank.service.AccountService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientQuery implements GraphQLQueryResolver {
    @Autowired
    private AccountService accountService;


    public Client getClient(final int id) {
        return accountService.getClient(id);
    }
}
