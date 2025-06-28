package org.example.services;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entities.Ticket;
import org.example.entities.User;
import org.example.util.UserServiceUtil;

import java.io.File;
import java.io.IOException;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;


public class UserBookingService {
    private User user;
    private List<User> userList;
    private static final String USER_FILE_PATH="app/src/main/java/org/example/localDb/users.json";
    private ObjectMapper objectMapper=new ObjectMapper();
    public UserBookingService(User user1) throws IOException {


        
        this.user=user1;

        File users=new File(USER_FILE_PATH);
        userList = objectMapper.readValue(users, new TypeReference<List<User>>(){});
    }
    public Boolean loginUser(){
        Optional<User> foundUser= userList.stream().filter(user1 -> {
            return user1.getName().equals(user.getName())&& UserServiceUtil.checkPassword(user.getPassword(),user1.getHashedPassword());
        }).findFirst();
        
        return foundUser.isPresent();
    }

    public Boolean signUp(User user1){
        try{userList.add(user1);
            saveUserListToFile();
            return Boolean.TRUE;

        }
        catch(IOException ex){
            return Boolean.FALSE;
        }
    }
    public void saveUserListToFile() throws IOException {
        File usersFile = new File(USER_FILE_PATH);
        objectMapper.writeValue(usersFile, userList);
    }
    
    public void fetchBooking(){
        user.printTickets();
    }
    public Boolean canceltickets(String ticketId){
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter Ticket ID you want to cancel:");
        ticketId= sc.next();

        if (ticketId==null||ticketId.isEmpty()){
            System.out.println("ticket id can not be null or empty");
            return Boolean.FALSE;
        }
        String finalticketid1= ticketId;
        boolean removed= user.getTicketsBooked().removeIf(Ticket->Ticket.getTicketId().equals(finalticketid1));

        String finalTicketId=ticketId;
        user.getTicketsBooked().removeIf(Ticket->Ticket.getTicketId().equals(finalTicketId));

        if(removed){
            System.out.println("Ticket with TicketID " + finalTicketId+ " has been removed");
            return Boolean.TRUE;
        }else{
            System.out.println("No ticket Found with TicketID "+ finalTicketId+" .");
        return Boolean.FALSE;}
    }
}
