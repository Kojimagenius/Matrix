public class MyMatrix extends Thread {



    static int count; // кол-во исполняющих потоков
    int m = 4,q=4,n=2;
    int [][] mat = new int [m][n];
    int [][] mat1 = new int [n][q];
    static int [][] result ;

    int id ; //Номер потока начинается с 0

    MyMatrix(int count){
        fill();
        this.count = count;
        result = new int [m][q];

    }
    private void fill(){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = j + 1;
            }

        }
        for (int i = 0; i <mat1.length ; i++) {
            for(int j = 0; j< mat1[0].length; j++){
                mat1[i][j] = i+1;
            }
        }
    }

    private void printResult(){
        for(int r=0; r<result.length; r++) {
            for(int c=0; c < result[r].length; c++)
                System.out.print(result[r][c] + " ");
            System.out.println();
        }

    }

    @Override
    public void run() {
        id = (int) (Thread.currentThread().getId() % 2);
        int its = mat.length / count; // кол-во необходимых итераций для каждого потока
        int start = id * its;
        int end = (id+1)* its;


        for (int i = start; i < end; i++) {
            for (int j = 0; j < mat1[0].length; j++) {
                int sum = 0;
                for (int r = 0; r < n; r++) {
                    sum += mat[i][r] * mat1[r][j];
                }
                result[i][j] = sum;
            }

        }
        if(id == 0)
        printResult();

    }
}