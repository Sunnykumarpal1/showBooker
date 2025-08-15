package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookMyShowApp {
    public static void main(String[] args) {
        BookShowSystem bSyst=new BookShowSystem();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter city ");
        String city=sc.next();
        System.out.println("Theaters in the "+city+"are");
        bSyst.displayMoviesCity(city);
        System.out.println("select the movies_id , theaters_id  and show id from the list ");
        int movies_id=sc.nextInt();
        int theaters_id=sc.nextInt();
        int show_id=sc.nextInt();

        bSyst.displayShows(movies_id,theaters_id);

//        bSyst.BookTicket(1,show_id,"");
//        book ticket
       bSyst.DisplaySeatsByShowId(show_id);
        List<String>ls=new ArrayList<>();
        System.out.println();
        System.out.println("Add no of seats to booked");
        int noOfSeat=sc.nextInt();
        System.out.println("Enter the seats that you have to book");
        for(int i=0;i<noOfSeat;i++){
            String t=(sc.next());
            ls.add(t);
        }
        bSyst.BookTicket(3,show_id, ls);
    }
}
