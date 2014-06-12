package org.tkm.backingbeans;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

public class MongoCRUD implements CRUD {
	
	DBCollection collection;
	
	public boolean createconn(){
		try{
		DB db;
		MongoClient mongo;
		mongo = new MongoClient( "localhost" , 27017 );
		db=mongo.getDB("awdb");
		collection = db.getCollectionFromString("mycollection");
		}catch(UnknownHostException e) {
			e.printStackTrace();
	    } catch (MongoException e) {
	    	e.printStackTrace();
	    }
		if(collection!=null)
			return true;
		else
			return false;
	}

	public boolean create(Device d) {
		BasicDBObject document = new BasicDBObject();
		document.put("UDID",d.udid);
		document.put("name", d.friendlyName);
		document.put("Serial", d.serialnum);
		document.put("Manf", d.manDate);
		collection.insert(document);
		return true;
	}

	public Device read(String UDID) {
		DBCursor cursor;
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("UDID", UDID);
    	cursor = collection.find(searchQuery);
    	Device d=new Device();
       	while (cursor.hasNext()) {
    		DBObject buff=cursor.next();
    		d.udid=UDID;
    		d.friendlyName = (String) buff.get( "name" );
    		d.serialnum = (String)buff.get( "Serial" );
    		d.manDate = (String) buff.get( "Manf" );
    	}
        return d;
	}

	public boolean delete(String UDID) {
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("UDID", UDID);
        collection.remove(searchQuery);
        return true;	
	}

	public boolean update(Device d) {
		BasicDBObject searchQuery = new BasicDBObject();
		BasicDBObject document = new BasicDBObject();
		searchQuery = new BasicDBObject().append("UDID", d.udid);
		document.append("$set", new BasicDBObject().append("name", d.friendlyName).append("Serial",d.serialnum).append("Manf",d.manDate));
//		collection.update(searchQuery, document);
//		document.append("$set", new BasicDBObject().append("Serial",d.sn));
//		collection.update(searchQuery, document);
//		document.append("$set", new BasicDBObject().append("Serial",d.sn));				        			    	     
    	collection.update(searchQuery, document);
		return true;
	}
	
		
	

}
