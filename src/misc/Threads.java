class ThreadDemo implements Runnable  {

    @Override
    public void run() {
        // TODO Auto-generated method stub
        Thread t = Thread.currentThread();
        int i = 0;
        try {
            while (true) {
                System.out.println(i);
                t.sleep(1500);
                i+=2;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

class ThreadDemo1 implements Runnable {

    @Override
    public void run() {
        // TODO Auto-generated method stub
        Thread t = Thread.currentThread();
        int i = 1;
        try {
            while (true) {
                System.out.println(i);
                t.sleep(1000);
                i+=2;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class Threads{
    public static void main(String[] args) {
        Thread t = new Thread(new ThreadDemo());
        Thread t1 = new Thread(new ThreadDemo1());

        t.start();
        t1.start();
    }
}