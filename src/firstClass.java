import java.util.ArrayList;
import java.util.Arrays;

public class firstClass {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.set(1,0);
        a.set(1,1);
        a.set(1,2);

       /*
        int[][] a = {{1,2,3},{4,5,6}};
        int[][] b = {{1,2,3},{4,5,6}};
        int[][] c = matrixAdd(a,b);
        System.out.println(Arrays.deepToString(c));
*/





    }
    public static int[][] matrixAdd(int[][] a,int[][] b){
        int[][] c = new int[a.length][a[0].length];
        for (int r=0; r<c.length; r++){
            for (int col = 0; col<c[0].length; col++){
                c[r][col]=a[r][col]+b[r][col];
            }
        }

        return c;

    }
}
/*
    public static int[][] matrixAdd(int[][] a,int[][] b){
        int[][] c = a;
        for (int r=0; r<c.length; r++){
            for (int col = 0; col<c[0].length; col++){
                c[r][col]=a[r][col]+b[r][col];
            }
        }

        return c;

    }

*/










