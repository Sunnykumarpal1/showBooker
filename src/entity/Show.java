public class Show {
    int shows_Id;
    int movies_Id;
    int theaters_id;
    String duration;
    int available_seat;

    public Show(int movies_Id, int shows_Id, int theaters_id, String duration, int available_seat) {
        this.movies_Id = movies_Id;
        this.shows_Id = shows_Id;
        this.theaters_id = theaters_id;
        this.duration = duration;
        this.available_seat = available_seat;
    }

    public int getShows_Id() {
        return shows_Id;
    }

    public void setShows_Id(int shows_Id) {
        this.shows_Id = shows_Id;
    }

    public int getMovies_Id() {
        return movies_Id;
    }

    public void setMovies_Id(int movies_Id) {
        this.movies_Id = movies_Id;
    }

    public int getTheaters_id() {
        return theaters_id;
    }

    public void setTheaters_id(int theaters_id) {
        this.theaters_id = theaters_id;
    }

    public int getAvailable_seat() {
        return available_seat;
    }

    public void setAvailable_seat(int available_seat) {
        this.available_seat = available_seat;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Show{" +
                "shows_Id=" + shows_Id +
                ", movies_Id=" + movies_Id +
                ", theaters_id=" + theaters_id +
                ", duration='" + duration + '\'' +
                ", available_seat=" + available_seat +
                '}';
    }
}
