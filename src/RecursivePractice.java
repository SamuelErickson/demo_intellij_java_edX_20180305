public class RecursivePractice {
    public static void main(String[] args){
        int n1 = 3;
        //mystery1(n1);
     //   System.out.println(starString2(n1));

        //String str = "hi ";
        //System.out.println(repeat(str,n1));
    }
    public static String starString(int n){
        if (n<0){
            throw new IllegalArgumentException(Integer.toString(n));
        } else if (n==0) {
                return "*";
        } else {
            return "*";
        }
    }

 //   public static String starString2(int n) {
   //     int i = 0;
    //    if (n < 0) {
       /*     throw new IllegalArgumentException(Integer.toString(n));
       // } else if (n ==0){
        //    int i = i + 1;
        //} else if (n==1){
         //   return "*"+starString2(n-1);
        //} else {
            return "*"+starString2(n-1)+starString2(n-2);
        }
        */




    //}

    public static String repeat(String s, int n) {
        if (n < 0) {
            throw new IllegalArgumentException(Integer.toString(n));
        } else if (n == 0) {
            return ("");
        } else {
            return (s + repeat(s, n - 1));
        }
    }

    public static void mystery1(int n) {
        if (n <= 1) {
            System.out.print(n);
        } else {
            mystery1(n / 2);
            System.out.print(", " + n);
        }
    }

}
