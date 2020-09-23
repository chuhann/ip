package duke;

public class Parser {

    private TaskList tasks;

    public Parser(TaskList tasks) {
        this.tasks = tasks;
    }

    public void parser(String line) {
        String command = line;
        if (line.startsWith("done")) {
            command = "done";
        } else if (line.startsWith("todo")) {
            command = "todo";
        } else if (line.startsWith("deadline")) {
            command = "deadline";
        } else if (line.startsWith("event")) {
            command = "event";
        } else if (line.startsWith("delete")) {
            command = "delete";
        }
        try {
            switch(command){
                case "list":
                    tasks.listInventory();
                    break;
                case "done":
                    tasks.checkInventory(line);
                    break;
                case "todo":
                    tasks.todoTask(line);
                    break;
                case "deadline":
                    tasks.deadlineTask(line);
                    break;
                case "event":
                    tasks.eventTask(line);
                    break;
                case "delete":
                    tasks.deleteItem(line);
                    break;
                default:
                    throw new DukeException();
            }
            /*
            if (line.equals("list")) {
                tasks.listInventory();
            } else if (line.startsWith("done")) {
                tasks.checkInventory(line);
            } else if (line.startsWith("todo")) {
                tasks.todoTask(line);
            } else if (line.startsWith("deadline")) {
                tasks.deadlineTask(line);
            } else if (line.startsWith("event")) {
                tasks.eventTask(line);
            } else if (line.startsWith("delete")) {
                tasks.deleteItem(line);
            } else {
                throw new DukeException();
            }
            */
        } catch (DukeException e) {
            System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
    }
}

