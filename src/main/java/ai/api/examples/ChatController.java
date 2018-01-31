package ai.api.examples;

import ai.api.examples.service.ChatService;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
    @Autowired
    ChatService chatService;
    @RequestMapping(value = "/say", method = RequestMethod.GET)
    public String speakToChatbot(@RequestHeader("message") String word) {
        AIRequest aiRequest = new AIRequest(word);
        AIResponse response = chatService.sendMessage(aiRequest);
        if(response.getResult().getMetadata().getIntentName().equals("buypolicy - yes")){
            return "go into buy home policy process";
        }
        return response.getResult().getFulfillment().getSpeech();
    }

}
