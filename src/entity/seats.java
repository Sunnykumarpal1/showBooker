public class seats {
    int seat_id;
    int shows_id;
    int seat_no;
    boolean isSeatBooked;

    public seats(int seat_id, int shows_id, int seat_no, boolean isSeatBooked) {
        this.seat_id = seat_id;
        this.shows_id = shows_id;
        this.seat_no = seat_no;
        this.isSeatBooked = isSeatBooked;
    }

    public int getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(int seat_id) {
        this.seat_id = seat_id;
    }

    public int getShows_id() {
        return shows_id;
    }

    public void setShows_id(int shows_id) {
        this.shows_id = shows_id;
    }

    public int getSeat_no() {
        return seat_no;
    }

    public void setSeat_no(int seat_no) {
        this.seat_no = seat_no;
    }

    public boolean isSeatBooked() {
        return isSeatBooked;
    }

    public void setSeatBooked(boolean seatBooked) {
        isSeatBooked = seatBooked;
    }

    @Override
    public String toString() {
        return "seats{" +
                "seat_id=" + seat_id +
                ", shows_id=" + shows_id +
                ", seat_no=" + seat_no +
                ", isSeatBooked=" + isSeatBooked +
                '}';
    }
}
