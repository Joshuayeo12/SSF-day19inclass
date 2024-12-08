package repo;

import java.util.ArrayList;
import java.util.List;

import model.TodoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ToDoRepo {

    @Autowired @Qualifier ("redis-object")
    private RedisTemplate<String, Object> createRedisTemplateObject;

    public List<TodoModel> getAllTask(){
        //fetch all tasks from Redis
        List<Object> objects = createRedisTemplateObject.opsForList().range("todos", 0, -1);

        //Convert Redis objects to TodoModel
        List <TodoModel> tasks = new ArrayList<>();
        if (objects != null) {
            for (Object obj : objects) {
                if (obj instanceof List) {
                    tasks.add((TodoModel) obj);
                }
            }
        }
   return tasks;
    }



    //List
public boolean saveList (List<TodoModel> tdl){
    for (int i = 0; i < tdl.size(); i++) {
        createRedisTemplateObject.opsForList().rightPush("todos",tdl.get(i));
    }
    return true;
}


}
