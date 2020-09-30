# User Guide
Duke is a **chat-bot application to assist you in task management (e.g. Todos, Deadlines, Events") via a Command Line Interface**.

* [Quick Start](#quick-start)
* [Features](#features)
    * [Add a new Todo task: `todo`](#adding-a-new-todo-task-todo)
    * [Add a new Deadline task: `deadline`](#adding-a-new-deadline-task-deadline)
    * [Add a new Event task: `event`](#adding-a-new-event-task-event)
    * [List all tasks: `list`](#listing-all-tasks-list)
    * [Marking a task as done: `done`](#marking-a-task-as-done-done)
    * [Deleting a task: `delete`](#deleting-a-task-delete)
    * [Finding a task: `find`](#finding-a-task-find)
    * [Exit the Duke: `bye`](#exiting-the-duke-bye)
    * [Save the data](#saving-the-data)
* [Command Summary](#command-summary)

## Quick Start 
1. Verify that you have Java 11 or above installed in your computer.
2. Download the latest `ip.jar`.
3. Copy the file to a folder where you want to run it from.
4. Using the terminal, navigate to the path of `ip.jar`.
5. Run `java -jar ip.jar`
6. If the setup is correct, you should see a welcome message. Then, it is now ready to go.

## Features

### Adding a new Todo task: `todo`
Adds a Todo to the task list.

Format: `todo <TASK_DESCRIPTION>`

Example:
`todo watch CS2113 webcast`

Expected output:
```
Got it. I've added this task: 
[T][✗] watch CS2113 webcast
Now you have 1 tasks in the list.
```

### Adding a new Deadline task: `deadline`
Adds a Deadline to the task list.

Format: `deadline DESCRIPTION /by <yyyy-MM-dd>`

Example:
`deadline CS2113 iP /by 2020-10-02`

Expected output:
```
Got it. I've added this task: 
[D][✗] CS2113 iP (by: 2020-10-02)
Now you have 2 tasks in the list.
```

### Adding a new Event task: `event`
Adds an Event to the task list.

Format: `event DESCRIPTION /at <yyyy-MM-dd>`

Example:
`event Visit Apple Store at Marina Bay Sands /at 2020-10-05`

Expected output:
```
Got it. I've added this task: 
[E][✗] Visit Apple Store at Marina Bay Sands (at: 2020-10-05)
Now you have 3 tasks in the list.
```

### Listing all tasks: `list`
Shows a list of all tasks.

Expected output:
```
Here are the tasks in your list:
1.[T][✗] watch CS2113 webcast
2.[D][✗] CS2113 iP (by: 2020-10-02)
3.[E][✗] Visit Apple Store at Marina Bay Sands (at: 2020-10-05)
```
### Marking a task as done: `done`
Marks the specified task as done.

Format: `done <TASK_INDEX>`

Example:
`done 2`

Expected output:
```
Nice! I've marked this task as done: 
[D][✓] CS2113 iP (by: 2020-10-02)
```

### Deleting a task: `delete`
Deletes the specified task from the task list.

Format: `delete <TASK_INDEX>`

Example:
`delete 1`

Expected output:
```
Noted. I've removed this task:
[D][✓] CS2113 iP (by: 2020-10-02)
Now you have 2 tasks in the list.
```

### Finding a task: `find`
Finds task which description contains any of the given keywords.

Format: `find <KEYWORD>`

Example:
`find CS2113`

Expected output:
```
Here are the matching tasks in your list: 
1.[T][✗] watch CS2113 webcast
```

### Exiting the Duke: `bye`
Terminates the program.

Expected output:
```
Bye. Hope to see you again soon!
```

### Saving the data:

Duke data are saved in the hard disk automatically.

### FAQ
Q: Where are the tasks stored ?
> The tasks are located in ./duke.txt of the directory you ran the program.

Q: How do I import existing tasks from other computers ?
> Export the duke.txt from other computer by copying the file and overwrite the existing duke.txt locally.

## Command Summary

**Action** | **Format, Examples**
------------ | -------------
**todo**|`todo [TASK_NAME]` <br>e.g., `todo cook dinner`
**deadline**|`deadline [TASK_NAME] /by [yyyy-MM-dd]` <br>e.g., `deadline Tutorial /by 2020-10-06`
**event**|`event [TASK_NAME] /at [yyyy-MM-dd]`<br>e.g., `event Countdown party /at 2020-12-31`
**list**|`list`
**done**|`done [INDEX]` <br>e.g., `done 1`
**delete**|`delete [INDEX]` <br>e.g., `delete 1`
**find**|`find [SEARCH_KEYWORD]`<br>e.g., `find tutorial`
**exit**|`bye`

## Support and comment
Email [here](kwekchuhan@gmail.com) for comments or suggestions