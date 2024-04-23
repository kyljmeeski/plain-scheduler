[![Java](https://img.shields.io/badge/Java-8%2B-orange)](https://www.oracle.com/java/)
![Lines of Code](https://img.shields.io/badge/lines_of_code-1151-green)
![License](https://img.shields.io/badge/license-MIT-blue)

**Plain Scheduler** is a simple and lightweight library to schedule tasks.

How to use:
```xml
<dependency>
    <groupId>io.github.kyljmeeski</groupId>
    <artifactId>plain-scheduler</artifactId>
    <version>0.0.1</version>
</dependency>
```

## Task
```java
Task task = new PlainTask(() -> {
    System.out.println("hello");
}, TaskFrequency.everySeconds(1));
```

To create a task you have to specify:
- task itself: a runnable
- execution frequency: an object of TaskFrequency class
- 
## Task Frequency
```java
TaskFrequency every15seconds = TaskFrequency.everySeconds(15);
TaskFrequency every10minutes = TaskFrequency.everyMinutes(10);
TaskFrequency everyHour = TaskFrequency.everyHours(1);
```

Task can be executed every n seconds, minutes, and hours.

## Scheduler
```java
Scheduler scheduler = new PlainScheduler();
```

## Schedule a Task
```java
scheduler.schedule(task);
```

## Pause and Resume Task
```java
scheduler.pause(task);
scheduler.resume(task);
```

You can pause and resume task.

## Multiple Tasks
```java
Task firstTask = new PlainTask(() -> {
    System.out.println("first task");
}, TaskFrequency.everySeconds(10));
Task secondTask = new PlainTask(() -> {
    System.out.println("second task");
}, TaskFrequency.everyMinutes(5));

scheduler.schedule(firstTask);
scheduler.schedule(secondTask);
```

You can schedule as many tasks as you want.

## Shutdown
```java
scheduler.shutdown();
```

This will shut down all scheduled tasks.