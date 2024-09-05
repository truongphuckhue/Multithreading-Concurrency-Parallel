package JoiningThreads;

public class JoinExample {
    public static void main(String[] agrs){
        Thread thread1 = new Thread(() -> {
            for(int i = 0 ; i < 5 ; i++){
                System.out.println("Thread 1 : " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for(int i = 0 ; i < 5 ; i++){
                System.out.println("Thread 2 : " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            System.out.println("Thread 1 has finished. Now back to main thread.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            thread2.join();
            System.out.println("Thread 2 has finished. Now back to main thread.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Main thread is done!");

    }
}
