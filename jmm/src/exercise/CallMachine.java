package exercise;

/**
 * 叫号机dome
 * （要求：多个窗口叫号，不重号、不跳号）
 */
public class CallMachine extends Thread {

    private static int index = 1;

    private static final int MAX = 50;

    @Override
    public void run() {

        try {
            synchronized (this){
                while (index <= MAX){
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + ":" + this.index++);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CallMachine t1 = new CallMachine();
        CallMachine t2 = new CallMachine();
        CallMachine t3 = new CallMachine();
        CallMachine t4 = new CallMachine();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
