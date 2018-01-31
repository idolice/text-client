package ai.api.examples.service;

import ai.api.AIDataService;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    @Autowired
    AIDataService aiDataService;

    public AIResponse sendMessage(AIRequest message) {

        try {
            AIResponse response = aiDataService.request(message);

            if (response.getStatus().getCode() == 200) {
                System.out.println(response.getResult().getFulfillment().getSpeech());
            } else {
                System.err.println(response.getStatus().getErrorDetails());
            }
            return response;
        } catch (Exception ex) {
            ex.printStackTrace();
            return new AIResponse();
        }
    }
}
