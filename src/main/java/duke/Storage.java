package duke;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;


public class Storage {
    private String filePath;
    private Ui ui = new Ui();

    public Storage(String filePath){
        this.filePath = filePath;
    }
    /**
     * Saves record to a file
     *
     * @param inventory inventory of all items
     */
    public void saveToFile(ArrayList<Task> inventory){
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
            File file = new File(filePath);
            if(!file.exists()){
                file.createNewFile();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(records);
            writer.close();
        } catch (FileNotFoundException e) {
            ui.printFileNotFound();
        } catch (IOException e) {
            ui.printFileNotOpened();
        }
    }

    /**
     * Reads record from a file
     *
     * @param inventory inventory of all items
     * @return updated inventory
     */
    public ArrayList<Task> readFromFile(ArrayList<Task> inventory) {
        File file = new File(filePath);

        try {
            if (file.exists()) {
                String strCurrentLine;

                BufferedReader reader = new BufferedReader(new FileReader(file));
                while ((strCurrentLine = reader.readLine()) != null) {
                    String record[] = strCurrentLine.split(" \\| ");
                    if (record[0].equals("T")) {
                        Todo todo = new Todo(record[2]);
                        todo.isChecked = Boolean.parseBoolean(record[1]);
                        inventory.add(todo);
                    } else if (record[0].equals("D")) {
                        Deadline deadline = new Deadline(record[2], LocalDate.parse(record[3]));
                        deadline.isChecked = Boolean.parseBoolean(record[1]);
                        inventory.add(deadline);
                    } else if (record[0].equals("E")) {
                        Event event = new Event(record[2], LocalDate.parse(record[3]));
                        event.isChecked = Boolean.parseBoolean(record[1]);
                        inventory.add(event);
                    }

                }
            } else {
                System.out.println(filePath);
                file.createNewFile();
            }

        } catch (FileNotFoundException e) {
            ui.printFileNotFound();
        } catch (IOException e) {
            ui.printFileNotOpened();
        }

        return inventory;
    }
}

