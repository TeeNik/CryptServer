package SocketObject;

import java.util.UUID;

/**
 * Created by teenik on 02.12.2017.
 */
public class AccountObject {
    String name;
    UUID id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
