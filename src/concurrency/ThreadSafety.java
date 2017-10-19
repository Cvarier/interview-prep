package concurrency;

public class ThreadSafety {
    
    // The Thread Control Escape Rule:
 /* If a resource is created, used and disposed within
    the control of the same thread,
    and never escapes the control of this thread,
    the use of that resource is thread safe. */
    
    public class NotThreadSafe{
        StringBuilder builder = new StringBuilder();

        public void add(String text){
            this.builder.append(text);
            System.out.println(builder.toString());
        }
    }
    
    public class CoolRunnable implements Runnable{
        NotThreadSafe instance = null;
        public CoolRunnable(NotThreadSafe instance) {
            this.instance = instance;
        }
        @Override
        public void run() {
            instance.add("Suck my balls Mr. Garrisooooon");
        }
    }
    
    public static void main(String args[]) {
        ThreadSafety tS = new ThreadSafety();
        // with race condition
/*      NotThreadSafe sharedInstance = tS.new NotThreadSafe();
        new Thread(tS.new CoolRunnable(sharedInstance)).start();
        new Thread(tS.new CoolRunnable(sharedInstance)).start();*/
        
        // without race condition
        new Thread(tS.new CoolRunnable(tS.new NotThreadSafe())).start();
        new Thread(tS.new CoolRunnable(tS.new NotThreadSafe())).start();
    }
}
