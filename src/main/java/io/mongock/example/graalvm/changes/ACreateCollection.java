package io.mongock.example.graalvm.changes;

import com.mongodb.client.MongoDatabase;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;

@ChangeUnit(id = "create-collection", order = "1", transactional = false)
public class ACreateCollection {

    @Execution
    public void execution(MongoDatabase mongoDatabase) {
        mongoDatabase.createCollection("clientCollection");
    }

    @RollbackExecution
    public void rollBack() {
    }
}
