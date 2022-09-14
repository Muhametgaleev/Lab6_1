package Server.tools;

import java.io.Serializable;

public class ServerAnswer implements Serializable {
    private String message;

    public String getMessage() {
        return message;
    }

    public ServerAnswer(String message){
        this.message = message;
    }
}
