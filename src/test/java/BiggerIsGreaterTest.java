import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class BiggerIsGreaterTest {

    @Test
    public void biggerIsGreater() {
        ClassLoader classLoader = getClass().getClassLoader();


        File fileInput = new File((classLoader.getResource("biggerIsGreaterInput.properties")).getFile());
        File fileOutput = new File((classLoader.getResource("biggerIsGreaterOutput.properties")).getFile());


        Scanner scannerInput = null;
        Scanner scannerOutput = null;
        try {
            scannerInput = new Scanner(fileInput);
            scannerOutput = new Scanner(fileOutput);
            int T = scannerInput.nextInt();
            scannerInput.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            scannerOutput.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int TItr = 0; TItr < T; TItr++) {
                String w = scannerInput.nextLine();
                String expected = scannerOutput.nextLine();

//                System.out.println(expected+ " "+w);

                assertEquals("testing "+w,expected , BiggerIsGreater.biggerIsGreater(w));


            }
            scannerInput.close();
            scannerOutput.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}