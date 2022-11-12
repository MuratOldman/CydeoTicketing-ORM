package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TaskController {

//    private final TaskService taskService;
//    private final ProjectService projectService;
//    private final UserService userService;
//
//    public TaskController(TaskService taskService, ProjectService projectService, UserService userService) {
//        this.taskService = taskService;
//        this.projectService = projectService;
//        this.userService = userService;
//    }
//
//    @GetMapping("/create")
//    public String createTask(Model model) {
//
//        model.addAttribute("task", new TaskDTO());
//        model.addAttribute("projects", projectService.findAll());
//        model.addAttribute("employees", userService.findEmployees());
//        model.addAttribute("tasks", taskService.findAll());
//
//        return "task/create";
//    }
//
//    @PostMapping("/create")
//    public String insertTask(@Valid @ModelAttribute("task") TaskDTO task, BindingResult bindingResult, Model model) {
//
//        if (bindingResult.hasErrors()) {
//
//            model.addAttribute("projects", projectService.findAll());
//            model.addAttribute("employees", userService.findEmployees());
//            model.addAttribute("tasks", taskService.findAll());
//
//            return "/task/create";
//
//        }
//
//        taskService.save(task);
//
//        return "redirect:/task/create";
//    }
//
//    @GetMapping("/delete/{taskId}")
//    public String deleteTask(@PathVariable("taskId") Long taskId) {
//        taskService.deleteById(taskId);
//        return "redirect:/task/create";
//    }
//
//    @GetMapping("/update/{taskId}")
//    public String editTask(@PathVariable("taskId") Long taskId, Model model) {
//
//        model.addAttribute("task", taskService.findById(taskId));
//        model.addAttribute("projects", projectService.findAll());
//        model.addAttribute("employees", userService.findEmployees());
//        model.addAttribute("tasks", taskService.findAll());
//
//        return "task/update";
//
//    }
//
////    @PostMapping("/update/{taskId}")
////    public String updateTask(@PathVariable("taskId") Long taskId, TaskDTO task) {
////        task.setId(taskId);
////        taskService.update(task);
////        return "redirect:/task/create";
////    }
//
//    @PostMapping("/update/{id}")
//    public String updateTask(@Valid @ModelAttribute("task") TaskDTO task, BindingResult bindingResult, Model model) {
//
//        if (bindingResult.hasErrors()) {
//
//            model.addAttribute("projects", projectService.findAll());
//            model.addAttribute("employees", userService.findEmployees());
//            model.addAttribute("tasks", taskService.findAll());
//
//            return "/task/update";
//
//        }
//
//        taskService.update(task);
//        return "redirect:/task/create";
//    }
//
//    @GetMapping("/employee/pending-tasks")
//    public String employeePendingTasks(Model model) {
//        model.addAttribute("tasks", taskService.findAllTasksByStatusIsNot(Status.COMPLETE));
//        return "task/pending-tasks";
//    }
//
//    @GetMapping("/employee/edit/{id}")
//    public String employeeEditTask(@PathVariable("id") Long id, Model model) {
//
//        model.addAttribute("task", taskService.findById(id));
//        model.addAttribute("tasks", taskService.findAllTasksByStatusIsNot(Status.COMPLETE));
//        model.addAttribute("statuses", Status.values());
//
//        return "task/status-update";
//
//    }
//
//    @PostMapping("/employee/update/{id}")
//    public String employeeUpdateTask(@Valid @ModelAttribute("task") TaskDTO task, BindingResult bindingResult, Model model) {
//
//        if (bindingResult.hasErrors()) {
//
//            model.addAttribute("tasks", taskService.findAllTasksByStatusIsNot(Status.COMPLETE));
//            model.addAttribute("statuses", Status.values());
//
//            return "/task/status-update";
//
//        }
//
//        taskService.updateStatus(task);
//        return "redirect:/task/employee/pending-tasks";
//
//    }
//
//    @GetMapping("/employee/archive")
//    public String employeeArchivedTasks(Model model) {
//        model.addAttribute("tasks", taskService.findAllTasksByStatus(Status.COMPLETE));
//        return "task/archive";
//    }

}
