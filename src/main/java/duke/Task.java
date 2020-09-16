package duke;

public class Task {
    protected String items;
    protected Boolean isChecked;
    protected String tag;

    public Task(String items, String tag){
        this.items = items;
        this.isChecked = false;
        this.tag = tag;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public Boolean getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Boolean isChecked) {
        this.isChecked = isChecked;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString(){
        if (isChecked){
            return "[✓] " + this.items;
        }else{
            return "[✗] " + this.items;
        }

    }
}

