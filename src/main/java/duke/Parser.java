package duke;

public class Parser {

    private TaskList tasks;
    private Ui ui = new Ui();

    public Parser(TaskList tasks) {
        this.tasks = tasks;
    }

    /**
     * Parses the input by user to specific commands
     * @param line line input from user
     */
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
        }else if (line.startsWith("find")){
            command = "find";
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
                case "find":
                    tasks.findItem(line);
                    break;
                default:
                    throw new DukeException();
            }
        } catch (DukeException e) {
            ui.printInvalidCommand();
        }
    }
}

