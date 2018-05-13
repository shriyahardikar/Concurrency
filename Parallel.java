class MyThread implements Runnable {
    private Thread t;
    private String taskName;
    
    MyThread(String taskName) {
        this.taskName = taskName;
        System.out.println("Create task " + taskName);
    }
    
    public void run() {
        System.out.println("Running task " + taskName);
        try{
            for(int i = 4; i > 0; i--) {
                System.out.println("Task: " + taskName + ", " + i);
                Thread.sleep(50);
            }
        }
        catch(InterruptedException e){
            System.out.println("Task " + taskName + " interrupted.");
        }
        System.out.println("Task " + taskName + " exiting.");
    }
    
    public void start(){
        System.out.println("Starting task " + taskName );
        if(t == null) {
            t = new Thread (this, taskName);
            t.start ();
        }
    }

    // public static void main(String[] args){
    //     Parallel task1 = new Parallel("Create list");
    //     task1.start();

    //     Parallel task2 = new Parallel("Deploy list");
    //     task2.start();
    // }
}

//Executable class: user interaction 
class Parallel{
    public static void main(String[] args){
        MyThread task1 = new MyThread("Create list");
        task1.start();

        MyThread task2 = new MyThread("Deploy list");
        task2.start();
    }
}

 