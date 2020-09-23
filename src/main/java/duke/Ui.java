package duke;

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

}
