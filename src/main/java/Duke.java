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
     * @param index index of item in inventory
     * @param inventory inventory of all items
     */
    public static void checkInventory(int index, ArrayList<Task> inventory){
        inventory.get(index).setIsChecked(true);
        System.out.println("Nice! I've marked this task as done: ");
        System.out.println(inventory.get(index)+"\n");
    }

    public static void main(String[] args) {
        String intro = "Hello! I'm Duke\n" +
                "What can I do for you?\n";
        String bye = "Bye. Hope to see you again soon!\n";
        ArrayList<Task> inventory = new ArrayList<Task>(100);

        System.out.println(intro);
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String by;
        String at;

        // Takes in user input until "bye" is entered by user
        while (!line.equals("bye")){
            // List inventory
            if (line.equals("list")){
                listInventory(inventory);
            }else if(line.startsWith("done ")){
                // check items
                line = line.replace("done ","");
                try{
                    int index = Integer.parseInt(line) -1;
                    checkInventory(index, inventory);
                }catch(Exception e){
                    // Catch exception
                    System.out.println("Opps Error");
                }
            } else if(line.startsWith("todo ")){

                // Add items to list
                //Task task = new Task(line, false);
                line = line.replace("todo ","");
                Todo todo = new Todo(line);
                inventory.add(todo);
                System.out.println("Got it. I've added this task: ");
                System.out.println(todo);
                System.out.println("Now you have "+inventory.size()+" tasks in the list.\n");
            } else if (line.startsWith("deadline ")){
                line = line.replace("deadline ","");
                by = line.substring(line.lastIndexOf("/by") + 1);
                line = line.substring(0,line.lastIndexOf("/by "));
                by = by.replace("by ","");


                Deadline deadline = new Deadline(line, by);
                inventory.add(deadline);
                System.out.println("Got it. I've added this task: ");
                System.out.println(deadline);
                System.out.println("Now you have "+inventory.size()+" tasks in the list.\n");
            } else if (line.startsWith("event ")){
                line = line.replace("event ","");
                at = line.substring(line.lastIndexOf("/at ") + 1);
                line = line.substring(0,line.lastIndexOf("/at "));
                at = at.replace("at ","");

                Event event = new Event(line, at);
                inventory.add(event);
                System.out.println("Got it. I've added this task: ");
                System.out.println(event);
                System.out.println("Now you have "+inventory.size()+" tasks in the list.\n");
            }

            line = in.nextLine();
        }

        // Exit message
        if(line.equals("bye")){
            System.out.println(bye);
        }

    }
}
