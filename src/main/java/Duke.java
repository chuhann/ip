import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    /**
     * Prints out all the items in the inventory
     *
     * @param inventory inventory of items added
     */
    public static void listInventory(ArrayList<String> inventory){
        for(int i = 0; i < inventory.size(); i++){
            System.out.println(i+1 +". "+inventory.get(i));
        }
    }

    public static void main(String[] args) {
        String intro = "Hello! I'm Duke\n" +
                "What can I do for you?\n";
        String bye = "Bye. Hope to see you again soon!\n";
        ArrayList<String> inventory = new ArrayList<String>(100);

        System.out.println(intro);
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        // Takes in user input until "bye" is entered by user
        while (!line.equals("bye")){
            // List inventory
            if (line.equals("list")){
                listInventory(inventory);
            }else{
                // Add items to list
                inventory.add(line);
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
