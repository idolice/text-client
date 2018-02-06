package ai.api.examples.model;

import java.io.Serializable;

public class MessageResponseDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String message;
    private String intent;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }
    @Override
    public String toString(){
        return "message: "+this.message + "\nintent:" + this.intent;
    }
}
