package at.refugeescode.mp16mypersonaltodolistui.controller;

import at.refugeescode.mp16mypersonaltodolistui.model.Task;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class TaskController {

    @Value("${todo.url}")
    private String todoUrl;

    private RestTemplate restTemplate;

    public TaskController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Task> getTasks() {
        Task[] tasks = restTemplate.getForObject(todoUrl, Task[].class);
        return Arrays.asList(tasks);
    }

    public void add(Task task) {
        restTemplate.postForObject(todoUrl, task, Task.class);
    }

    public void done(String id) {
        String doneUrl = todoUrl + "/" + id + "/done";
        restTemplate.put(doneUrl, Task.class);

    }

    public void delete(String id) {
        String deleteUrl = todoUrl + "/" + id;
        restTemplate.delete(deleteUrl);
    }
}
