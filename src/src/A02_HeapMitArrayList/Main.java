package src.A02_HeapMitArrayList;

public class Main {
    public static void main(String[] args) {

        TaskList tl = new TaskList();
        tl.insert(new Task(34));
        tl.insert(new Task(45));
        tl.insert(new Task(12));
        tl.insert(new Task(98));
        tl.insert(new Task(43));

        while(true){
            Task remove = tl.remove();
            if(remove == null){
                break;
            }
            System.out.println(remove);
        }
    }
}
