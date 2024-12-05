package service;

import jakarta.json.*;
import model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.ToDoRepo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepo toDoRepo;

    public void saveDataFromJson() {
        JsonArray jArray;
        try (InputStream is = new FileInputStream("/Users/joshuayeo/Desktop/nuscoding/SSF/day19inclass/src/main/resources/static/todos.json")) {
            JsonReader jreader = Json.createReader(is);
            jArray = jreader.readArray();

            // insert the model into the List
            List<Todo> todoList = new ArrayList<>();
            for (int i = 0; i < jArray.size(); i++) {
                JsonObject jObject = jArray.getJsonObject(i);

                Todo todo = new Todo(
                        jObject.getString("id"),
                        jObject.getString("name"),
                        jObject.getString("description"),
                        jObject.getString("due_date"),
                        jObject.getString("priority_level"),
                        jObject.getString("status"),
                        jObject.getString("created_at"),
                        jObject.getString("updated_at")
                );

                todoList.add(todo);
            }
                toDoRepo.saveList(todoList);




        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
