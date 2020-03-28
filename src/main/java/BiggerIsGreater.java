import java.io.*;
import java.util.*;

public class BiggerIsGreater {

    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {


        // Creating array and Storing the array
        // returned by toCharArray() 
        char[] ch = w.toCharArray();

        // loop through from right to left and swipe any letter that is larger than 
        // the current right most element in the loop

        int len = ch.length;

        int pos = len-1;

        String answer;
        boolean hasSwapped = false;

        for(int j = len-1; j>=0; j--)
        {

            for(int i = j-1; i >= 0; i--)
            {

                if(ch[pos]>ch[i]){
                    char temp = ch[pos];
                    // swap


                    ch[pos] = ch[i];
                    ch[i] = temp;
                    hasSwapped = true;
                    pos = i;
                    break;// break out of the inner loop

                }

            }
            if(hasSwapped) {
                break;// break out of the outer loop
            }  else {
                pos = j-1;
            }

        }



        if(!hasSwapped){
            return "no answer";
        } else {
            // sort everything right of pos in assending order
            int beg = pos + 1;
            int end = len; // for readability
            char[] subArr = Arrays.copyOfRange(ch, beg, end);

            Arrays.sort(subArr); // sorts in place

            String sortedRight = new String(subArr);

            // create left part
            String left = new String(Arrays.copyOfRange(ch, 0, beg));

            answer = left+sortedRight;

            return answer;


        }



    }


    public static void main(String[] args)  {
        ClassLoader classLoader = BiggerIsGreater.class.getClassLoader();


        File file = new File((classLoader.getResource("biggerIsGreaterInput.properties")).getFile());


        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            int T = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int TItr = 0; TItr < T; TItr++) {
                String w = scanner.nextLine();
                System.out.println(w);

                String result = biggerIsGreater(w);

//                System.out.println(result);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }





        scanner.close();

    }
}