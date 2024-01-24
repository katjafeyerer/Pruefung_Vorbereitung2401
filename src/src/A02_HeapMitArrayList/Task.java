package src.A02_HeapMitArrayList;

public class Task implements Comparable<Task>{
    private int priority;

    public Task(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "priority=" + priority +
                '}';
    }

    @Override
    public int compareTo(Task o) {
        return Integer.compare(this.priority, o.priority);
    }
}
