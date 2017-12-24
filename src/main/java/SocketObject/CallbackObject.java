package SocketObject;

import java.util.UUID;

/**
 * Created by teenik on 02.12.2017.
 */
public class CallbackObject {
    UUID id;
    boolean ok;

    public CallbackObject() {
    }

    public CallbackObject(UUID id, boolean ok) {
        this.id = id;
        this.ok = ok;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }
}
