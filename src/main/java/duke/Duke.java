package duke;

import java.io.*;
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
            System.out.println("Item is not in List ! Please try with another valid index\n");
        }catch(NumberFormatException e){
            System.out.println("Please enter a valid number !\n");
        }
    }

    /***
     * Remove item from the inventory
     *
     * @param line line of command string
     * @param inventory inventory of all items
     */
    public static void deleteItem(String line, ArrayList<Task> inventory){
        try {
            line = line.replace("delete ","");
            int index = Integer.parseInt(line) -1;
            inventory.get(index);
            System.out.println("Noted. I've removed this task:");
            System.out.println(inventory.get(index));
            inventory.remove(index);
            System.out.println("Now you have "+inventory.size()+" tasks in the list.\n");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Item is not in List ! Please try with another valid index\n");
        }catch(NumberFormatException e){
            System.out.println("Please enter a valid number !\n");
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
            System.out.println("☹ OOPS!!! The description of a todo cannot be empty.\n");
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
            System.out.println("☹ OOPS!!! The description of a deadline cannot be empty.\n");
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("Please use '/by' to specify date\n");
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
            System.out.println("☹ OOPS!!! The description of a event cannot be empty.\n");
        } catch (StringIndexOutOfBoundsException e){
            System.out.println("Please use '/at' to specify date\n");
        }
    }

    /**
     * Saves record to a file
     *
     * @param inventory inventory of all items
     */
    public static void saveToFile(ArrayList<Task> inventory){
        String records = "";
        for(int i = 0; i < inventory.size(); i++){
            records += inventory.get(i).getTag() +" | ";
            records += (boolean)inventory.get(i).getIsChecked()+" | ";
            records += inventory.get(i).getItems();
            if(inventory.get(i).getTag().equals("D") || inventory.get(i).getTag().equals("E")){
                records += " | "+inventory.get(i).getDuration();
            }
            records += "\n";
        }
        try {
            System.out.println(records);
            File file = new File("C:\\Users\\chuha\\Documents\\ip\\filename.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(records);
            System.out.println("Records saved in :"+file.getName());
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found !\n");
        } catch (IOException e) {
            System.out.println("File cannot be opened !\n");
        }
    }

    /**
     * Reads record from a file
     *
     * @param inventory inventory of all items
     * @return updated inventory
     */
    public static ArrayList<Task> readFromFile(ArrayList<Task> inventory){
        File file = new File("C:\\Users\\chuha\\Documents\\ip\\filename.txt");
        if(file.exists()){
            try {
                String strCurrentLine;

                BufferedReader reader = new BufferedReader(new FileReader(file));
                while ((strCurrentLine = reader.readLine()) != null) {
                    String record [] = strCurrentLine.split(" \\| ");
                    if(record[0].equals("T")){
                        Todo todo = new Todo(record[2]);
                        todo.isChecked = Boolean.parseBoolean(record[1]);
                        inventory.add(todo);
                    }else if(record[0].equals("D")){
                        Deadline deadline = new Deadline(record[2], record[3]);
                        deadline.isChecked = Boolean.parseBoolean(record[1]);
                        inventory.add(deadline);
                    }else if(record[0].equals("E")){
                        Event event = new Event(record[2], record[3]);
                        event.isChecked = Boolean.parseBoolean(record[1]);
                        inventory.add(event);
                    }

                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found !\n");
            }catch (IOException e) {
                System.out.println("File cannot be opened !\n");
            }
        }
        return inventory;
    }
    public static void main(String[] args) {
        String intro = "Hello! I'm Duke\n" +
                "What can I do for you?\n";
        String bye = "Bye. Hope to see you again soon!\n";
        ArrayList<Task> inventory = new ArrayList<Task>(100);
        inventory = readFromFile(inventory);
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
                }else if (line.startsWith("delete")){
                    //Delete items in Inventory
                    deleteItem(line, inventory);
                }else if(line.equals("save")){
                    //Save records to file
                    saveToFile(inventory);
                }
                else{
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
