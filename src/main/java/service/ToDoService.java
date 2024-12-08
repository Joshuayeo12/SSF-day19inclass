package service;

import ch.qos.logback.classic.pattern.DateConverter;
import jakarta.json.*;
import model.TodoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.ToDoRepo;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepo toDoRepo;

    public void saveDataFromJson() {

        try (InputStream is = new FileInputStream(
                "/Users/joshuayeo/Desktop/nuscoding/SSF/day19inclass/src/main/resources/static/todos.json")) {
            JsonReader jreader = Json.createReader(is);
            JsonArray jArray = jreader.readArray();

            // insert the model into the List
            List<TodoModel> todoList = new ArrayList<>();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            for (int i = 0; i < jArray.size(); i++) {
                JsonObject jObject = jArray.getJsonObject(i);

                String dueString = jObject.getString("due_date");
                LocalDate localDueDate = LocalDate.parse(dueString, formatter);
                Date dueDate = java.sql.Date.valueOf(localDueDate);

                TodoModel todo = new TodoModel(
                        jObject.getString("id"),
                        jObject.getString("name"),
                        jObject.getString("description"),
                        dueDate,
                        jObject.getString("priority_level"),
                        jObject.getString("status"),
                        java.sql.Date.valueOf(LocalDate.parse(jObject.getString("created_at"), formatter)),
                        java.sql.Date.valueOf(LocalDate.parse(jObject.getString("updated_at"), formatter))
                );

                todoList.add(todo);
            }
            toDoRepo.saveList(todoList);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<TodoModel> getAllTasks() {
        //retrieve all tasks from the respo
        return toDoRepo.getAllTask();
    }
}
