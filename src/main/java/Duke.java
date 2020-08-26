import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String intro = "Hello! I'm Duke\n" +
                "What can I do for you?\n";
        String bye = "Bye. Hope to see you again soon!\n";

        System.out.println(intro);
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        while (!line.equals("bye")){
            System.out.println(line);
            line = in.nextLine();
        }

        if(line.equals("bye")){
            System.out.println(bye);
        }

    }
}
