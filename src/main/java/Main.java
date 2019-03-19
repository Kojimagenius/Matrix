public class Main {
    public static void main(String[] args) {
        MyMatrix matrix1 = new MyMatrix(2);
        MyMatrix matrix2 = new MyMatrix(2);//надо что-то придумать с ид
        matrix1.start();
        matrix2.start();
        int j = 0;
        try {
            matrix1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            matrix2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
