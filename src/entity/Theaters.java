public class Theaters {
    int theaters_id;
    String th_name;
    String city;


    public Theaters(String th_name, String city, int theaters_id) {
        this.th_name = th_name;
        this.city = city;
        this.theaters_id = theaters_id;
    }


    public int getTheaters_id() {
        return theaters_id;
    }

    public void setTheaters_id(int theaters_id) {
        this.theaters_id = theaters_id;
    }

    public String getTh_name() {
        return th_name;
    }

    public void setTh_name(String th_name) {
        this.th_name = th_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Theaters{" +
                "theaters_id=" + theaters_id +
                ", th_name='" + th_name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
