import java.util.concurrent.Callable;

class MyCallable extends Thread implements Callable<Integer> {

    Integer printCount = 0;

    public MyCallable(String name) {
        super(name);
    }

    @Override
    public Integer call() {
        for(int i = 2; i > 0; i--) {
            printCount++;
            System.out.println("Я поток " + this.getName() + ". Всем привет!");
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Поток " + this.getName() + " остановлен");
                break;
            }
        }
        return printCount;
    }
}

