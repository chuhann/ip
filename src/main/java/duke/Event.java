package duke;

public class Event extends Task {

    protected String at;
    //protected String tag;

    public Event(String description, String at) {
        super(description,"E");
        this.at = at;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(at: " + at + ")";
    }
}