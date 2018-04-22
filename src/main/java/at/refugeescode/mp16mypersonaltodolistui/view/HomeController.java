package at.refugeescode.mp16mypersonaltodolistui.view;

import at.refugeescode.mp16mypersonaltodolistui.controller.TaskController;
import at.refugeescode.mp16mypersonaltodolistui.model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    private TaskController taskController;

    public HomeController(TaskController taskController) {
        this.taskController = taskController;
    }

    @ModelAttribute("newTask")
    Task newTask() {
        return new Task();
    }

    @ModelAttribute("tasks")
    List<Task> tasks() {
        return taskController.getTasks();
    }

    @PostMapping
    String addNewTask(Task task) {
        taskController.add(task);
        return "redirect:/";

    }

    @GetMapping("/done/{id}")
    String doneTask(@PathVariable String id) {
        taskController.done(id);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    String deleteTask(@PathVariable String id) {
        taskController.delete(id);
        return "redirect:/";
    }

    @GetMapping
    String page() {
        return "home";
    }
}
