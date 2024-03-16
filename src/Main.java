public class Main {

    private static final int[] numbers = {1, 3, 5, 6, 2, 7, 8, 0, 4, 3, 9, 2, 8, 1, 0, 5, 7, 4, 6, 9, 3, 2, 1, 8, 4, 0, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0};

    public static void main(String[] args) {

        final int[] sum = {0};
        final int[] max = {0};

        Thread sumThread = new Thread(() -> {
            for (int number : numbers) {
                sum[0] += number;
            }
        });

        Thread maxThread = new Thread(() -> {
            for (int number : numbers) {
                if (number > max[0]) {
                    max[0] = number;
                }
            }
        });

        sumThread.start();
        maxThread.start();

        try {
            sumThread.join();
            maxThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Phần tử lớn nhất trong mảng là: " + max[0]);
        System.out.println("Tổng của các phần tử trong mảng là: " + sum[0]);
    }
}
