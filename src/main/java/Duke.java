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
            System.out.print(i+1 +".[");
            if (inventory.get(i).getIsChecked()){
                System.out.print("✓");
            }else{
                System.out.print("✗");
            }
            System.out.print("]");
            System.out.println(inventory.get(i).getItems());
        }
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
        System.out.print("[✓]");
        System.out.println(inventory.get(index).getItems());
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
            } else{
                // Add items to list
                Task task = new Task(line, false);
                inventory.add(task);
                System.out.println("added: "+line);
            }

            line = in.nextLine();
        }

        // Exit message
        if(line.equals("bye")){
            System.out.println(bye);
        }

    }
}
