package ThreadTermonationandDeamonThreads;

public class DaemonInterruptExample {
    public static void main(String[] agrs){
        //Tạo 1 thread chạy nền
        Thread demonThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true){
                        System.out.println("Deamon thread is working...");
                        Thread.sleep(500);
                    }
                } catch (InterruptedException e){
                    System.out.println("Deamon thread was interrupted and is stopping...");
                }
            }
        });
        demonThread.setDaemon(true);
        demonThread.start();

        Thread workerThread = new Thread(() -> {
            System.out.println("Worker thread is working...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Worker thread was interrupted!");
            }
        });
        workerThread.start();
        try{
            Thread.sleep(2000);
            System.out.println("Main thread: interrupting the worker thread...");
            workerThread.interrupted();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        // Cho thread chính chờ thêm một chút trước khi kết thúc
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread is done!");
    }
}
