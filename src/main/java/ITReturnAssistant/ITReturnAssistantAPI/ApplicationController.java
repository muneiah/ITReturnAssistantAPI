package ITReturnAssistant.ITReturnAssistantAPI;

import ITReturnAssistant.ITReturnAssistantAPI.config.MongoConfig;
import ITReturnAssistant.ITReturnAssistantAPI.modal.FinancialYear;
import ITReturnAssistant.ITReturnAssistantAPI.modal.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApplicationController {

    private MongoOperations db = (MongoOperations) new AnnotationConfigApplicationContext(MongoConfig.class).getBean("mongoTemplate");

    @GetMapping("/getYears")
    public List<FinancialYear> getYears() {
        return db.find(new Query(), FinancialYear.class);
    }

    @GetMapping("/getUser/{id}")
    public User getUser(@RequestParam(value="id") String id, @RequestBody String password) {
        User user = db.findOne(new Query(Criteria.where("id").is(id)), User.class);
        if (user == null) {
            user = new User();
            user.setId(id);
            user.setPassword(password);
        }
        return user;
    }

    @PostMapping("/saveUser")
    public boolean getUser(@RequestBody User user) {
        db.save(user);
        return true;
    }
}