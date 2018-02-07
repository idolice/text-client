package ai.api.examples;

import ai.api.examples.model.Message;
import ai.api.examples.model.MessageResponseDTO;
import ai.api.examples.service.ChatService;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
    @Autowired
    ChatService chatService;
    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public ResponseEntity<MessageResponseDTO> speakToChatbot(@RequestBody Message message) {
        AIRequest aiRequest = new AIRequest(message.getMessage());
        AIResponse response = chatService.sendMessage(aiRequest);
        MessageResponseDTO messageResponseDTO = new MessageResponseDTO();
        messageResponseDTO.setMessage(response.getResult().getFulfillment().getSpeech());
        messageResponseDTO.setIntent(response.getResult().getMetadata().getIntentName());
        ResponseEntity<MessageResponseDTO> responseDTOHttpEntity = new ResponseEntity<MessageResponseDTO>(messageResponseDTO, HttpStatus.OK);
        return responseDTOHttpEntity;
    }

}
