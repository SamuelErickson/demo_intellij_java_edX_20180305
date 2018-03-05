import java.util.*;


public class OOPPractice {
    public static void main(String[] args) {
        /*
        ArrayList<String> a = new ArrayList<String>();
        a.add("what" );
        a.add("what2" );
        a.add("what23");
        a.add("what234");
        a.add("what235");
        System.out.println(a);
        //System.out.println(a.size());
        ArrayList<String> result = removeEvenLength(a);
        System.out.println(result);
        */


        ArrayList<Integer> myList = new ArrayList<Integer>();
      //  myList.add(0);
        //myList.add(0);
        //myList.add(0);
       // myList.add(0);
        myList.add(-1);
        myList.add(-1);
        myList.add(-1);
        myList.add(-1);
        int staticSize = myList.size();
        for (int i = 0; i < staticSize; i++) {
            if (myList.get(i) == 0) {
                myList.remove(i);
                staticSize--;
            } else if (myList.get(i) == -1) {
                myList.add(-1);
                staticSize++;
            }
        }
        System.out.println(myList);

    }


    public static int maxLength(ArrayList<String> al){
        int maxStrLength = 0;
        for (int i=0;i<al.size();i++){
            if (al.get(i).length() > maxStrLength){
                maxStrLength = al.get(i).length();
            }
        }

        return(maxStrLength);
    }



    public static ArrayList<String> removeEvenLength(ArrayList<String> al){
        int staticSize = al.size();
        int i = 0;
        while (i<staticSize) {
            if (al.get(i).length()%2==0) {
                al.remove(i);
                staticSize--;
            } else {
                i++;
            }
        }
        return (al);
    }
}

