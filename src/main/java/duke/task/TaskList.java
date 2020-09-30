package duke.task;

import duke.ui.Ui;
import duke.exception.TaskException;
import duke.storage.Storage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;


    public class TaskList {
        private ArrayList<Task> inventory;
        private Storage storage;
        private Ui ui = new Ui();

        public TaskList(Storage storage) {
            this.storage = storage;
            inventory = new ArrayList<Task>(100);
            inventory = storage.readFromFile(inventory);
        }

        /**
         * Prints out all the items in the inventory
         */
        public void listInventory() {
            for (int i = 0; i < inventory.size(); i++) {
                System.out.print(i + 1 + ".");
                System.out.println(inventory.get(i));
            }
            System.out.println();
        }

        /**
         * Mark item in the inventory as checked
         *
         * @param line line of command string
         */
        public void checkInventory(String line) {
            try {
                line = line.replace("done ", "");
                int index = Integer.parseInt(line) - 1;
                inventory.get(index).setIsChecked(true);
                System.out.println("Nice! I've marked this task as done: ");
                System.out.println(inventory.get(index) + "\n");
            } catch (IndexOutOfBoundsException e) {
               ui.printItemNotInlist();
            } catch (NumberFormatException e) {
               ui.printValidNumber();
            }
            storage.saveToFile(inventory);
        }

        /***
         * Remove item from the inventory
         *
         * @param line line of command string
         */
        public void deleteItem(String line) {
            try {
                line = line.replace("delete ", "");
                int index = Integer.parseInt(line) - 1;
                inventory.get(index);
                System.out.println("Noted. I've removed this task:");
                System.out.println(inventory.get(index));
                inventory.remove(index);
                System.out.println("Now you have " + inventory.size() + " tasks in the list.\n");
            } catch (IndexOutOfBoundsException e) {
                ui.printItemNotInlist();
            } catch (NumberFormatException e) {
                ui.printValidNumber();
            }
            storage.saveToFile(inventory);
        }

        /**
         * Add todo item into inventory
         *
         * @param line line of command string
         */
        public void todoTask(String line) {
            try {
                // Add items to Todo list
                line = line.replace("todo", "").trim();
                if (line.equals("")) {
                    throw new TaskException();
                }
                Todo todo = new Todo(line);
                inventory.add(todo);
                System.out.println("Got it. I've added this task: ");
                System.out.println(todo);
                System.out.println("Now you have " + inventory.size() + " tasks in the list.\n");
            } catch (TaskException e) {
                ui.printTodoDescriptionEmpty();
            }
            storage.saveToFile(inventory);
        }

        /**
         * Add deadline task to inventory
         *
         * @param line line of command string
         */
        public void deadlineTask(String line) {
            try {
                String by;
                line = line.replace("deadline", "").trim();

                if (line.equals("")) {
                    throw new TaskException();
                }

                by = line.substring(line.lastIndexOf("/by") + 1);
                line = line.substring(0, line.lastIndexOf("/by "));
                by = by.replace("by ", "");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate localDate = LocalDate.parse(by, formatter);
                Deadline deadline = new Deadline(line, localDate);
                inventory.add(deadline);
                System.out.println("Got it. I've added this task: ");
                System.out.println(deadline);
                System.out.println("Now you have " + inventory.size() + " tasks in the list.\n");
            } catch (TaskException e) {
                ui.printDeadlineDescriptionEmpty();
            } catch (StringIndexOutOfBoundsException e) {
                ui.printMissingByParameter();
            }catch (DateTimeParseException e){
                ui.printInvalidDateFormat();
            }
            storage.saveToFile(inventory);
        }

        /**
         * Add event task to inventory
         *
         * @param line line of command string
         */
        public void eventTask(String line) {
            try {
                String at;
                line = line.replace("event", "").trim();
                if (line.equals("")) {
                    throw new TaskException();
                }
                at = line.substring(line.lastIndexOf("/at ") + 1);
                line = line.substring(0, line.lastIndexOf("/at "));
                at = at.replace("at ", "");


                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate localDate = LocalDate.parse(at, formatter);

                Event event = new Event(line, localDate);
                inventory.add(event);
                System.out.println("Got it. I've added this task: ");
                System.out.println(event);
                System.out.println("Now you have " + inventory.size() + " tasks in the list.\n");
            } catch (TaskException e) {
                ui.printEventDescriptionEmpty();
            } catch (StringIndexOutOfBoundsException e) {
                ui.printMissingAtParameter();
            } catch (DateTimeParseException e){
                ui.printInvalidDateFormat();
            }
            storage.saveToFile(inventory);
        }

        /**
         * Find a task by searching for a keyword
         * @param line
         */
        public void findItem(String line) {
            int count = 1;
            System.out.println("Here are the matching tasks in your list: ");
            line = line.replace("find", "").trim();
            for (int i = 0; i < inventory.size(); i++) {
                if (inventory.get(i).getItems().contains(line)) {
                    System.out.print(count + ".");
                    System.out.println(inventory.get(i));
                    count ++;
                }

            }
            System.out.println();
        }
    }


