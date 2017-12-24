package SocketObject;

/**
 * Created by teenik on 02.12.2017.
 */
public class CallbackObject {
    int id;
    boolean ok;

    public CallbackObject() {
    }

    public CallbackObject(int id, boolean ok) {
        this.id = id;
        this.ok = ok;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }
}
