package bank.dao.entity;

import java.io.Serializable;

public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;

    private String address;

    private int clientId;

    private float amount;

    public Account() {

    }

    public Account(int id, String address,int clientId,float amount) {
        this.id = id;
        this.address = address;
        this.clientId=clientId;
        this.amount=amount;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
