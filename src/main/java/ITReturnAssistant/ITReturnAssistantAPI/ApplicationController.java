package ITReturnAssistant.ITReturnAssistantAPI;

import ITReturnAssistant.ITReturnAssistantAPI.config.MongoConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

    private MongoOperations db = (MongoOperations) new AnnotationConfigApplicationContext(MongoConfig.class).getBean("mongoTemplate");


}