package fr.friquerette.gradlews.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import fr.friquerette.gradlews.model.Person;

public class MongoDbDAO {

	// Since 2.10.0, uses MongoClient
	private static MongoDatabase database = null;
	private MongoClient mongo;
	private final static String PERSONS = "persons";

	private MongoDatabase getDatabase() {
		if (database == null) {
			mongo = new MongoClient("localhost", 27017);
			database = mongo.getDatabase("MyDataBase");
		}
		return database;
	}

	public void addPersonne(Person person) {
		MongoCollection<Document> collection = getDatabase().getCollection(PERSONS);
		Document doc = new Document("lastName", person.getLastName());
		doc.append("firstName", person.getFirstName());
		collection.insertOne(doc);
		close();
	}

	public void findPersonne() {
	}

	public void deletePersonne() {

	}

	public List<Document> findAllPersonne() {
		MongoCollection<Document> collection = getDatabase().getCollection(PERSONS);
		MongoCursor<Document> cursor = collection.find().iterator();
		List<Document> persons = new ArrayList<Document>();
		while (cursor.hasNext()) {
			Document document = cursor.next();
			persons.add(document);
		}
		close();
		return persons;
	}

	public void updatePersonne() {

	}

	public void close() {
		if (mongo == null) {
			mongo.close();
		}
	}

}
