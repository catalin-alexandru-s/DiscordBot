package Commands.JokeCommand;

public class Data {
    public JokeQuestion data;
    Boolean success = true;

    public Data() {

    }

    public Data(Boolean success, JokeQuestion data) {
        this.success = success;
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public JokeQuestion getData() {
        return data;
    }

    public void setData(JokeQuestion data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JokeResult{" +
                "success=" + success +
                ", data=" + data +
                '}';
    }
}
