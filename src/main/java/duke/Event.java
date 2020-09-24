package duke;

import java.time.LocalDate;

public class Event extends Task {

    protected LocalDate  at;
    //protected String tag;

    public Event(String description, LocalDate at) {
        super(description,"E", at);
        this.at = at;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(at: " + at + ")";
    }
}