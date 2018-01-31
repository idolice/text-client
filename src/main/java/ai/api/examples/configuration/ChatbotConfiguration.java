package ai.api.examples.configuration;

import ai.api.AIConfiguration;
import ai.api.AIDataService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatbotConfiguration {
    @Bean
    public AIDataService aiDataService() {
        AIConfiguration configuration = new AIConfiguration("85556213d7724b46a57480ead81ec6ed");
        return new AIDataService(configuration);
    }
}
