package duke.task;

import java.time.LocalDate;

public class Deadline extends Task {

    protected LocalDate by;

    public Deadline(String description, LocalDate  by) {
        super(description, "D", by);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + "(by: " + by + ")";
    }
}