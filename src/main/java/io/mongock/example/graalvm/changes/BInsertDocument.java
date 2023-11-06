package io.mongock.example.graalvm.changes;

import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import org.bson.Document;

@ChangeUnit(id = "insert-document", order = "2")
public class BInsertDocument {
    @Execution
    public void execution(MongoDatabase mongoDatabase, ClientSession clientSession) {
        MongoCollection<Document> collection = mongoDatabase.getCollection("clientCollection");
        collection.insertOne(clientSession, new Document().append("name", "Federico"));
    }

    @RollbackExecution
    public void rollBack() {
    }
}
