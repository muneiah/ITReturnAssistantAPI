package ITReturnAssistant.ITReturnAssistantAPI.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
@PropertySource("classpath:application.properties")
public class MongoConfig extends AbstractMongoConfiguration {

    @Value("${mongodb.name}")
    private String mongoDbName;
    
    @Value("${mongodb.uri}")
    private String mongoDbUri;
    
    @Override
    public String getDatabaseName() {
        if (System.getenv("DBNAME") != null) {
            mongoDbName = System.getenv("DBNAME");
        }
        return mongoDbName;
    }

    @Override
    @Bean
    public Mongo mongo() throws Exception {
        if (System.getenv("DBURI") != null) {
            mongoDbUri = System.getenv("DBURI");
        }
        MongoClientURI uri = new MongoClientURI(mongoDbUri);
        return new MongoClient(uri);
    }
}
