package Commands.MemeCommand;

public class MemeQuestion {
    String title;
    String body;
    String url;
    String image;

    MemeQuestion() {
        title = "";
        body = "";
        url = "";
        image = "";
    }

    public MemeQuestion(String title, String body, String url, String image) {
        this.title = title;
        this.body = body;
        this.url = url;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "MemeQuestion{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", url='" + url + '\'' +
                ", image=" + image +
                '}';
    }

}
