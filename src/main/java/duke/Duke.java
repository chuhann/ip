package duke;

import java.util.Scanner;

public class Duke {
    private TaskList tasks;
    private Storage storage;
    private Ui ui;
    private Parser parser;

    public Duke(String filePath){
        storage = new Storage(filePath);
        tasks = new TaskList(storage);
        ui = new Ui();
        parser = new Parser(tasks);
    }

    public void run (){
        ui.showWelcome();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        // Takes in user input until "bye" is entered by user
        while (!line.equals("bye")) {
            parser.parser(line);
            line = in.nextLine();
        }

        // Exit message todo “Answer CS2113 tutorial questions” todo “Answer CS2113 tutorial questions”
        ui.printEnd();
    }
    public static void main(String[] args) {
        new Duke("C:\\Users\\chuha\\Documents\\ip\\filename.txt").run();
    }
}
