package com.mongo;

import java.util.Iterator;

import org.bson.Document;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

/**
 * Created by tancw on 2016/6/2.
 */
public class BaseMongo {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

        // 连接到数据库
        MongoDatabase mongoDatabase = mongoClient.getDatabase("mydb");
        System.out.println("Connect to database successfully");
        MongoIterable<String> collections = mongoDatabase.listCollectionNames();
        JSONObject jsonObject = new JSONObject();
        for (Iterator iterator = collections.iterator(); iterator.hasNext(); ) {
            String colname = (String) iterator.next();
            MongoCollection<org.bson.Document> cos = mongoDatabase.getCollection(colname);
            FindIterable<Document> findIterable = cos.find();
            MongoCursor<Document> mongoCursor = findIterable.iterator();
            JSONArray jsonArray = new JSONArray();
            while(mongoCursor.hasNext()){
                String cl = mongoCursor.next().toJson();
                System.out.println(cl);
                jsonArray.add(cl);
            }
            jsonObject.put(colname,jsonArray);
        }
        System.out.println(jsonObject);
    }
}
