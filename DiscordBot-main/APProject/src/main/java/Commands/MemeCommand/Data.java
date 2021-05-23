package Commands.MemeCommand;

public class Data {
    public MemeQuestion data;
    Boolean success = true;

    public Data() {

    }

    public Data(Boolean success, MemeQuestion data) {
        this.success = success;
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public MemeQuestion getData() {
        return data;
    }

    public void setData(MemeQuestion data) {
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
