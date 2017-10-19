package concurrency;

public class ThreadSandbox {
    public static class CoolRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println("Concurrent programming is awesome");
            Thread currentThread = Thread.currentThread();
            System.out.println("Thread " + currentThread.getName() + " is running");
        }
    }
    public static void main(String args[]) {
        Thread coolThread = new Thread(new CoolRunnable(), "hihihi");
        coolThread.start();
        
        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                
            }
        };
        
        Thread someOtherThread = new Thread(myRunnable);
        someOtherThread.start();
    }
}
