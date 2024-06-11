import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Generic class representing a task with a deadline
class Task<T> {
    private T description;
    private LocalDate deadline;

    public Task(T description, LocalDate deadline) {
        this.description = description;
        this.deadline = deadline;
    }

    public T getDescription() {
        return description;
    }

    public void setDescription(T description) {
        this.description = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "Task{" +
                "description=" + description +
                ", deadline=" + deadline +
                '}';
    }
}

// Class representing a list of tasks
class TaskList<T> {
    private List<Task<T>> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    // Add a task to the list
    public void addTask(T description, LocalDate deadline) {
        Task<T> task = new Task<>(description, deadline);
        tasks.add(task);
    }

    // Update a task in the list
    public boolean updateTask(int index, T newDescription, LocalDate newDeadline) {
        if (index < 0 || index >= tasks.size()) {
            return false;
        }
        Task<T> task = tasks.get(index);
        task.setDescription(newDescription);
        task.setDeadline(newDeadline);
        return true;
    }

    // Modify a task's description
    public boolean modifyTaskDescription(int index, T newDescription) {
        if (index < 0 || index >= tasks.size()) {
            return false;
        }
        Task<T> task = tasks.get(index);
        task.setDescription(newDescription);
        return true;
    }

    // Modify a task's deadline
    public boolean modifyTaskDeadline(int index, LocalDate newDeadline) {
        if (index < 0 || index >= tasks.size()) {
            return false;
        }
        Task<T> task = tasks.get(index);
        task.setDeadline(newDeadline);
        return true;
    }

    // Get a task from the list
    public Optional<Task<T>> getTask(int index) {
        if (index < 0 || index >= tasks.size()) {
            return Optional.empty();
        }
        return Optional.of(tasks.get(index));
    }

    // Get all tasks
    public List<Task<T>> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    @Override
    public String toString() {
        return "TaskList{" +
                "tasks=" + tasks +
                '}';
    }

    public static void main(String[] args) {
        // Example usage
        TaskList<String> taskList = new TaskList<>();
        
        taskList.addTask("Finish project report", LocalDate.of(2024, 6, 15));
        taskList.addTask("Buy groceries", LocalDate.of(2024, 6, 12));

        System.out.println("Initial task list: " + taskList);

        taskList.updateTask(0, "Complete project report", LocalDate.of(2024, 6, 16));
        taskList.modifyTaskDescription(1, "Purchase groceries");
        taskList.modifyTaskDeadline(1, LocalDate.of(2024, 6, 13));

        System.out.println("Updated task list: " + taskList);

        taskList.getTask(0).ifPresent(task -> System.out.println("Task at index 0: " + task));
    }
}
