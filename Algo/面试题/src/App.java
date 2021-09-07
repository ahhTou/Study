import sun.misc.Unsafe;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class App extends PhantomReference<String> {


    public void clean() {
        System.out.println("清除了");
        super.clear();
    }

    /**
     * Creates a new phantom reference that refers to the given object and
     * is registered with the given queue.
     *
     * <p> It is possible to create a phantom reference with a <tt>null</tt>
     * queue, but such a reference is completely useless: Its <tt>get</tt>
     * method will always return null and, since it does not have a queue, it
     * will never be enqueued.
     *
     * @param referent the object the new phantom reference will refer to
     * @param q        the queue with which the reference is to be registered,
     */
    public App(String referent, ReferenceQueue<? super String> q) {
        super(referent, q);
    }

    public static void main(String[] args) throws InterruptedException {
        ReferenceQueue<String> queue = new ReferenceQueue<>();

        String a = "hello world";

        App app = new App(a, queue);


        // 从队列中 获取无用的软引用对象，并移除
        queue.poll();

        // a = null;

        // System.gc();


        // Thread.sleep(500);
    }


}
