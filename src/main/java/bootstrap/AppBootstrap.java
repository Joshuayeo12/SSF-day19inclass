package bootstrap;


import jakarta.json.JsonReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import service.ToDoService;

@Component
public class AppBootstrap implements CommandLineRunner {
    @Autowired
    private ToDoService todoService;

    @Override
    public void run(String... args) throws Exception {
        todoService.saveDataFromJson();

    }
}




