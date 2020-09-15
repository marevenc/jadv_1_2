import java.util.concurrent.Callable;

class MyCallable implements Callable<Integer> {

    String name;

    Integer printCount = 0;

    public MyCallable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public Integer call() {
        for(int i = 2; i > 0; i--) {
            printCount++;
            System.out.println("Я задача " + this.getName() + ". Всем привет!");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Задача " + this.getName() + " остановлен");
                break;
            }
        }
        return printCount;
    }
}

