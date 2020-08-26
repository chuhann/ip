public class Task {
    private String items;
    private Boolean isChecked;

    public Task(String items, Boolean isChecked){
        this.items = items;
        this.isChecked = isChecked;
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
}

