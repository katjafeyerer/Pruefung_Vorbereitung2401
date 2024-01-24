package src.A02_HeapMitArrayList;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks =new ArrayList<>();

    public TaskList() {
        this.tasks = tasks;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "TaskList{" +
                "tasks=" + tasks +
                '}';
    }
    public void insert(Task t){
        tasks.add(t);
        heapifyUp(tasks.size()-1);
    }
    public void heapifyUp(int index){
        while(index>0) {
            int parentIndex = (index - 1) / 2;

            if (tasks.get(index).compareTo(tasks.get(parentIndex)) > 0) {
                swap(index, parentIndex);
                index = parentIndex;
                //parentIndex = (index-1)/2;
            }
            else{
                break;
            }
        }
    }
    public void swap(int index1, int index2){
        Task temp = tasks.get(index1);
        tasks.set(index1, tasks.get(index2));
        tasks.set(index2, temp);
    }
    public Task remove(){
        if(tasks.isEmpty()){
            return null;
        }
        Task root = tasks.get(0);
        Task lastTask = tasks.remove(tasks.size()-1);

        if(!tasks.isEmpty()){
            tasks.set(0, lastTask);
            heapifyDown(0);
        }
        return root;
    }
    public void heapifyDown(int index){
        int leftChildindex;
        int rightChildindex;
        int largestIndex;

        while(true){
            leftChildindex = index*2+1;
            rightChildindex = index*2+2;
            largestIndex =  index;

            while(leftChildindex < tasks.size() && tasks.get(leftChildindex).compareTo(tasks.get(largestIndex))>0){
                largestIndex = leftChildindex;
            }
            while(rightChildindex <tasks.size() && tasks.get(rightChildindex).compareTo(tasks.get(largestIndex))>0){
                largestIndex = rightChildindex;
            }
            if(largestIndex != index){
                swap(index, largestIndex);
                index = largestIndex;
            }
            else{
                break;
            }
        }

    }
}
