package duke;

import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    /**
     * Prints out all the items in the inventory
     *
     * @param inventory inventory of items added
     */
    public static void listInventory(ArrayList<Task> inventory){
        for(int i = 0; i < inventory.size(); i++){
            System.out.print(i+1 +".");
            System.out.println(inventory.get(i));
        }
        System.out.println();
    }

    /**
     * Mark item in the inventory as checked
     *
     * @param line line of command string
     * @param inventory inventory of all items
     */
    public static void checkInventory(String line, ArrayList<Task> inventory){
        try {
            line = line.replace("done ","");
            int index = Integer.parseInt(line) -1;
            inventory.get(index).setIsChecked(true);
            System.out.println("Nice! I've marked this task as done: ");
            System.out.println(inventory.get(index)+"\n");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Item is not in List ! Please try with another valid index");
        }catch(NumberFormatException e){
            System.out.println("Please enter a valid number !");
        }
    }

    /**
     * Add todo item into inventory
     *
     * @param line line of command string
     * @param inventory inventory of all items
     */
    public static void todoTask(String line, ArrayList<Task> inventory){
        try {
            // Add items to Todo list
            line = line.replace("todo","").trim();
            if(line.equals("")){
                throw new TaskException();
            }
            Todo todo = new Todo(line);
            inventory.add(todo);
            System.out.println("Got it. I've added this task: ");
            System.out.println(todo);
            System.out.println("Now you have "+inventory.size()+" tasks in the list.\n");
        } catch (TaskException e) {
            System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
        }
    }

    /**
     * Add deadline task to inventory
     *
     * @param line line of command string
     * @param inventory inventory of all items
     */
    public static void deadlineTask(String line, ArrayList<Task> inventory){
        try {
            String by;
            line = line.replace("deadline","").trim();

            if(line.equals("")){
                throw new TaskException();
            }

            by = line.substring(line.lastIndexOf("/by") + 1);
            line = line.substring(0,line.lastIndexOf("/by "));
            by = by.replace("by ","");

            Deadline deadline = new Deadline(line, by);
            inventory.add(deadline);
            System.out.println("Got it. I've added this task: ");
            System.out.println(deadline);
            System.out.println("Now you have "+inventory.size()+" tasks in the list.\n");
        } catch (TaskException e) {
            System.out.println("☹ OOPS!!! The description of a deadline cannot be empty.");
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("Please use '/by' to specify date");
        }
    }

    /**
     * Add event task to inventory
     *
     * @param line line of command string
     * @param inventory inventory of all items
     */
    public static void eventTask(String line, ArrayList<Task> inventory){
        try {
            String at;
            line = line.replace("event","").trim();
            if(line.equals("")){
                throw new TaskException();
            }
            at = line.substring(line.lastIndexOf("/at ") + 1);
            line = line.substring(0,line.lastIndexOf("/at "));
            at = at.replace("at ","");

            Event event = new Event(line, at);
            inventory.add(event);
            System.out.println("Got it. I've added this task: ");
            System.out.println(event);
            System.out.println("Now you have "+inventory.size()+" tasks in the list.\n");
        } catch (TaskException e) {
            System.out.println("☹ OOPS!!! The description of a event cannot be empty.");
        } catch (StringIndexOutOfBoundsException e){
            System.out.println("Please use '/at' to specify date");
        }
    }

    public static void main(String[] args) {
        String intro = "Hello! I'm Duke\n" +
                "What can I do for you?\n";
        String bye = "Bye. Hope to see you again soon!\n";
        ArrayList<Task> inventory = new ArrayList<Task>(100);

        System.out.println(intro);
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        // Takes in user input until "bye" is entered by user
        while (!line.equals("bye")){
            try {
                if (line.equals("list")){
                    // List inventory
                    listInventory(inventory);
                }else if(line.startsWith("done")){
                    // check items
                    checkInventory(line, inventory);
                } else if(line.startsWith("todo")){
                    // Add items to Todo list
                    todoTask(line, inventory);
                } else if (line.startsWith("deadline")){
                    //Add items to Deadline list
                    deadlineTask(line, inventory);
                } else if (line.startsWith("event")){
                    //Add items to Event list
                    eventTask(line, inventory);
                }else{
                    //Invalid command
                    throw new DukeException();
                }

            } catch (DukeException e) {
                System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
            }
            line = in.nextLine();
        }

        // Exit message todo “Answer CS2113 tutorial questions” todo “Answer CS2113 tutorial questions”
        if(line.equals("bye")){
            System.out.println(bye);
        }

    }
}
