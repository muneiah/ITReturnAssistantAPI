package ITReturnAssistant.ITReturnAssistantAPI;

import ITReturnAssistant.ITReturnAssistantAPI.config.MongoConfig;
import ITReturnAssistant.ITReturnAssistantAPI.modal.FinancialYear;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApplicationController {

    private MongoOperations db = (MongoOperations) new AnnotationConfigApplicationContext(MongoConfig.class).getBean("mongoTemplate");

    @GetMapping("/admin/getYears")
    public List<FinancialYear> getYears() {
        return db.find(new Query(), FinancialYear.class);
    }

}