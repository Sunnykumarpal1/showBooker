public class Movies {
    int movies_id;
    String title;
    String lang;
    String category;
    int duration;

    public Movies(String title, int movies_id, int duration, String lang, String category) {
        this.title = title;
        this.movies_id = movies_id;
        this.duration = duration;
        this.lang = lang;
        this.category = category;
    }

    public int getMovies_id() {
        return movies_id;
    }

    public void setMovies_id(int movies_id) {
        this.movies_id = movies_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "movies_id=" + movies_id +
                ", title='" + title + '\'' +
                ", lang='" + lang + '\'' +
                ", category='" + category + '\'' +
                ", duration=" + duration +
                '}';
    }
}
