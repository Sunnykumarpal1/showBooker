package service;

import config.DatabaseConfig;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class BookShowSystem {
    Connection con;
    BookShowSystem(){
        con= DatabaseConfig.getConnection();
    }
//    display movies
    void displayMovies(){
        try {
            Statement stmt=con.createStatement();
            String q="Select *  from movies";
            ResultSet rs = stmt.executeQuery(q);
            while(rs.next()){
                System.out.println(  "Movies{" +
                        "movies_id=" + rs.getString("movies_id")  +
                        ", title='" +  rs.getString("title")  + '\'' +
                        ", lang='" +  rs.getString("lang")  + '\'' +
                        ", category='" +  rs.getString("category")  + '\'' +
                        ", duration=" +  rs.getString("duration")  +
                        "}");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

//    Display movies in a particular city
void displayMoviesCity(String city){
    try {
        String q = "SELECT s.shows_id,s.movies_id,s.theaters_id,m.title,t.city from shows as s inner join  theaters as t on s.theaters_id=t.theaters_id inner join movies as m on m.movies_id=s.movies_id where  t.city=?";

        PreparedStatement  stmt=con.prepareStatement(q);
        stmt.setString(1,city);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            System.out.println("Shows{" +
                    "show_id=" + rs.getInt("shows_id") +
                    ", movies_id=" + rs.getInt("movies_id") +
                    ", theaters_id=" + rs.getInt("theaters_id") +
                    ", title='" + rs.getString("title") + '\'' +
                    ", city='" + rs.getString("city") + '\'' +
                    "}");
        }


    } catch (SQLException e) {
        e.printStackTrace();
    }

}
//    display theaters in a city
    public void displayTheater(String city){
        try{
            String query="select * from theaters where city=?";
            PreparedStatement pstmt=con.prepareStatement(query);
            pstmt.setString(1,city);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                System.out.println("Theaters{" +
                        "theaters_id=" + rs.getString("theaters_id") +
                        ", th_name='" + rs.getString("th_name") + '\''+
                        '}');
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

//    Displaying seat_no by showId
    public  void DisplaySeatsByShowId(int showId){
        try{
            String query="select * from seats where shows_Id=?";
            PreparedStatement pstmt=con.prepareStatement(query);
            pstmt.setInt(1,showId); 
            ResultSet rs=pstmt.executeQuery();
            System.out.println("The Available seats at this show is ");
            while(rs.next()){
                System.out.println( "Seat{" +
                        "shows_Id=" + rs.getInt("Shows_id") +
                        ", seat_no='" + rs.getString("seat_no") + '\'' +
                        ", isSeatBooked=" + rs.getBoolean("isSeatBooked")+
                        '}');
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
//    Display shows for the  movieid and theaterId
    public void displayShows(int movie_id,int theater_id){
        try{
            String query="select * from shows where movies_id=? and theaters_Id=?";
            PreparedStatement pstmt=con.prepareStatement(query);
            pstmt.setInt(1,movie_id);
            pstmt.setInt(2,theater_id);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                System.out.println( "Show{" +
                        "shows_Id=" + rs.getInt("Shows_id") +
                        ", duration='" + rs.getString("duration") + '\'' +
                        ", available_seat=" + rs.getInt("available_seat")+
                        '}');
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
//    book ticket
    public  void BookTicket(int userId, int showId, List<String>seats_booked){
        try{
//            we weill set the auto commit as false
            con.setAutoCommit(false);
            boolean alreadyBooked=false;
            for(String seat:seats_booked){
                String query="select * from seats where shows_id=? and seat_no=? ";
                PreparedStatement stmt=con.prepareStatement(query);
                stmt.setInt(1,showId);
                stmt.setString(2,seat);
                ResultSet rs = stmt.executeQuery();

//                System.out.println(showId+" "+seat);
                if(rs.next()){
//                    System.out.println(rs.getBoolean("isSeatBooked"));
                    if(rs.getBoolean("isSeatBooked")==true){
                        System.out.println("seat"+ seat+"is already booked");
                        alreadyBooked=true;
                    }
                }else{
                    System.out.println("this Seat cannot be booked it doesn't exist");
                    return;
                }

            }


            if(alreadyBooked){
                System.out.println("Any of the seats was previously booked so booking was not succesfull");
                con.rollback();
                return ;
            }
            CheckAvailableSeat(userId,showId,seats_booked);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void CheckAvailableSeat(int userId,int showId,List<String>seats_booked){
        try{
            String query="select * from shows where shows_id=?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1,showId);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int avilableSeats=rs.getInt("available_seat");
                if(avilableSeats<seats_booked.size()){
                    return ;
                }else{
//                update the status of the seats as booked
                    for(String s:seats_booked){
                        String seat_query="update seats set isSeatBooked=? where seat_no=?";
                        PreparedStatement seat_stmt=con.prepareStatement(seat_query);
                        seat_stmt.setBoolean(1,true);
                        seat_stmt.setString(2,s);
                        seat_stmt.executeUpdate();
                    }
            }
//                updateing no of seats avilabe in shows
                int r=avilableSeats-seats_booked.size();
                String q="update shows  set available_seat=? where shows_id=?";
                PreparedStatement pstmt=con.prepareStatement(q);
                pstmt.setInt(1,r);
                pstmt.setInt(2,showId);
                pstmt.executeUpdate();

              InsertBooking(userId,showId,seats_booked);
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
    void InsertBooking(int userId,int showId,List<String>seats_booked){
//        insert into bookings
        int totalPrice=200*seats_booked.size();
        String query1="insert into bookings(shows_id,user_id,seats_booked,price)values(?,?,?,?)";
        try {
            PreparedStatement stmt=con.prepareStatement(query1);
            stmt.setInt(1,showId);
            stmt.setInt(2,userId);
            stmt.setString(3,String.join(",",seats_booked));
            stmt.setInt(4,totalPrice);
            stmt.executeUpdate();
            System.out.println("Booking successful for seats: " + String.join(",", seats_booked));
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ;
    }

}
