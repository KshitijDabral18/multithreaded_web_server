package org.example.entities;
import java.util.List;
public class User {
    private String name;
    private String password;
    private String hashedPassword;
    private List<Ticket> ticketBooked;
    private String userId;

    public User(String name,String password, String hashedPassword,List<Ticket> ticketBooked,String userId) {
        this.name=name;
        this.password=password;
        this.hashedPassword=hashedPassword;
        this.ticketBooked= ticketBooked;
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
    public List<Ticket> getTicketBooked(){
        return ticketBooked;
    }
    public void printTickets(){
        for(int i =0; i<ticketBooked.size();i++){
            System.out.println(ticketBooked.get(i).getTicketInfo());
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
    public void setTicketBooked(){
        this.ticketBooked=ticketBooked;
    }


 }
