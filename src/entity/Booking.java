import java.util.List;

public class Booking {
    private  int book_id;
    private int shows_id;
    private int user_id;
    private List<String> seats_booked;
    private int price;

    public Booking(int book_id, int shows_id, int user_id, List<String> seats_booked, int price) {
        this.book_id = book_id;
        this.shows_id = shows_id;
        this.user_id = user_id;
        this.seats_booked = seats_booked;
        this.price = price;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getShows_id() {
        return shows_id;
    }

    public void setShows_id(int shows_id) {
        this.shows_id = shows_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public List<String> getSeats_booked() {
        return seats_booked;
    }

    public void setSeats_booked(List<String> seats_booked) {
        this.seats_booked = seats_booked;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Booking{" +
                "book_id=" + book_id +
                ", shows_id=" + shows_id +
                ", user_id=" + user_id +
                ", seats_booked=" + seats_booked +
                ", price=" + price +
                '}';
    }
}
