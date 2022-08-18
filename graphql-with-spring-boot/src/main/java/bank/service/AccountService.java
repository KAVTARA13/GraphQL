package bank.service;

import bank.dao.entity.Account;
import bank.dao.entity.Client;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AccountService {
    List<Account> accounts=new ArrayList<Account>();

    @PostConstruct
    public void fillAccounts() {
        accounts.add(new Account(1,"bsdgvgh626",1,19));
        accounts.add(new Account(2,"bsvgh626",1,1));
        accounts.add(new Account(3,"bsdgvgh66",3,9));
    }

    public Account createAccount(final String address,final int clientId, final float amount) {
        final Account account = new Account();
        account.setAddress(address);
        account.setClientId(clientId);
        account.setAmount(amount);
        account.setId(accounts.size()+1);

        accounts.add(account);
        return account ;
    }

    public List<Account> getAccounts(final int clientId) {
        return accounts.stream().filter(obj -> obj.getClientId() == clientId).collect(Collectors.toList());
    }

    public Account transaction(final String addressFrom, final String addressTo, final float amount){
        Account account = null;
        for(Account accountFrom : accounts){
            if (Objects.equals(accountFrom.getAddress(), addressFrom) && accountFrom.getAmount()>amount){
                for(Account accountTo : accounts){
                    if (Objects.equals(accountTo.getAddress(), addressTo)){
                        account = accountFrom;
                        accountFrom.setAmount(accountFrom.getAmount() - amount);
                        accountTo.setAmount(accountTo.getAmount() + amount);
                    }
                }
            }
        }
        return account;
    }

    List<Client> clientList=new ArrayList<Client>();


    @PostConstruct
    public void fillClients() {
        clientList.add(new Client(1,"Luka"));
        clientList.add(new Client(2,"Vako"));
        clientList.add(new Client(3,"Nika"));
    }




    public Client createClient(final String name) {
        final Client client = new Client();
        client.setName(name);
        client.setId(clientList.size()+1);
        clientList.add(client);

        return client ;
    }


    public Client getClient(final int id) {
        final Client client = new Client();
        final List<Account> newAccounts=new ArrayList<Account>();
        for (Client client1:clientList){
            if (client1.getId()==id){
                client.setId(id);
                client.setName(client1.getName());
                for (Account account: accounts){
                    if (account.getClientId()==id){
                        newAccounts.add(account);
                    }
                }
                client.setAccount(newAccounts);
            }
        }
        return client;
    }
}
