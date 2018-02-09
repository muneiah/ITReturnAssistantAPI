package ITReturnAssistant.ITReturnAssistantAPI;

import ITReturnAssistant.ITReturnAssistantAPI.config.MongoConfig;
import ITReturnAssistant.ITReturnAssistantAPI.modal.FinancialYear;
import ITReturnAssistant.ITReturnAssistantAPI.modal.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApplicationController {

    private MongoOperations db = (MongoOperations) new AnnotationConfigApplicationContext(MongoConfig.class).getBean("mongoTemplate");

    @GetMapping("/admin/getYears")
    public List<FinancialYear> getYears() {
        return db.find(new Query(), FinancialYear.class);
    }

    @GetMapping("/admin/getUser/{id}")
    public User getUser(@RequestParam(value="id") String id, @RequestBody String password) {
        return db.findOne(new Query(Criteria.where("id").is(id)), User.class);
    }

}