package bank.dao.entity;

import java.io.Serializable;
import java.util.List;

public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;

    private String name;

    private List<Account> accounts;


    public Client() {

    }

    public Client(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setAccount(List<Account> account) {
        this.accounts=(account);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
