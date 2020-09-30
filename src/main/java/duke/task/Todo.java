package duke.task;

import duke.task.Task;

public class Todo extends Task {
    protected String description;
    protected String tag;

    public Todo(String description){
        super(description, "T", null);
        this.description = description;
    }

    @Override
    public String toString(){
        return "[T]" + super.toString();
    }
}
