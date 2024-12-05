package repo;

import java.util.List;

import model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ToDoRepo {

    @Autowired @Qualifier ("redis-object")
    private RedisTemplate<String, Object> createRedisTemplateObject;

    //List
public boolean saveList (List<Todo> tdl){
    for (int i = 0; i < tdl.size(); i++) {
        createRedisTemplateObject.opsForList().rightPush("todos",tdl.get(i));
    }
    return true;
}



}
