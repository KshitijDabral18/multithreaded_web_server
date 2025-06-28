package org.example.entities;
import java.util.List;
public class User {
    private String name;
    private String password;
    private String hashedPassword;
    private List<Ticket> ticketsBooked;
    private String userId;

    public User(String name,String password, String hashedPassword,List<Ticket> ticketsBooked,String userId) {
        this.name=name;
        this.password=password;
        this.hashedPassword=hashedPassword;
        this.ticketsBooked= ticketsBooked;
        this.userId=userId;
    }
    public User(){}

    public String getName(){
        return name;
    }
    public String getPassword(){
        return password;
    }
    public String getHashedPassword(){
        return hashedPassword;
    }
    public String getUserId(){
        return userId;
    }
    public List<Ticket> getTicketsBooked(){
        return ticketsBooked;
    }
    public void printTickets(){
        for(int i =0; i<ticketsBooked.size();i++){
            System.out.println(ticketsBooked.get(i).getTicketInfo());
        }
    }

    public void setName(){
        this.name=name;
    }
    public void setUserId(){
        this.userId=userId;
    }
    public void setPassword(){
        this.password=password;
    }
    public void setHashedPassword(){
        this.hashedPassword=hashedPassword;
    }
    public void setTicketsBooked(){
        this.ticketsBooked=ticketsBooked;
    }


 }
