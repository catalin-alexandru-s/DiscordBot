package Commands.JokeCommand;

public class JokeQuestion {
    String title;
    String body;
    String url;

    public JokeQuestion() {
        title = "";
        body = "";
        url = "";
    }

    public JokeQuestion(String title, String body, String url) {
        this.title = title;
        this.body = body;
        this.url = url;
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

    @Override
    public String toString() {
        return "JokeQuestion{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

}
