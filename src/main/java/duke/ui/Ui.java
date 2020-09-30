package duke.ui;

public class Ui {

    public Ui(){

    }

    public void showWelcome(){
        String intro = "Hello! I'm Duke\n" +
                "What can I do for you?\n";

        System.out.println(intro);
    }

    public void printEnd(){
        String bye = "Bye. Hope to see you again soon!\n";
        System.out.println(bye);
    }

    public void printFileNotFound(){
        System.out.println("File not found !\n");
    }

    public void printFileNotOpened(){
        System.out.println("File cannot be opened !\n");
    }

    public void printInvalidCommand(){
        System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
    }

    public void printItemNotInlist(){
        System.out.println("Item is not in List ! Please try with another valid index\n");
    }

    public void printValidNumber(){
        System.out.println("Please enter a valid number !\n");
    }

    public void printTodoDescriptionEmpty(){
        System.out.println("☹ OOPS!!! The description of a todo cannot be empty.\n");
    }

    public void printInvalidDateFormat(){
        System.out.println("Please enter a valid date");
    }

    public void printDeadlineDescriptionEmpty(){
        System.out.println("☹ OOPS!!! The description of a deadline cannot be empty.\n");
    }

    public void printMissingByParameter(){
        System.out.println("Please use '/by' to specify date\n");
    }

    public void printEventDescriptionEmpty(){
        System.out.println("☹ OOPS!!! The description of a event cannot be empty.\n");
    }

    public void printMissingAtParameter(){
        System.out.println("Please use '/at' to specify date\n");
    }
}
