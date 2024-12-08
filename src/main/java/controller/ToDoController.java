package controller;


import jakarta.servlet.http.HttpSession;
import model.TodoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.ToDoService;

import java.util.List;

@Controller
@RequestMapping("/listings")
public class ToDoController {

    @Autowired
    public ToDoService toDoService;

    @GetMapping
    public String showListings(Model model) {
        // Fetch the list of tasks from the service
        List<TodoModel> todoModelList = toDoService.getAllTasks();
        //Add the list to the model
        model.addAttribute("todoList", todoModelList);
        return "listing";
    }
}
