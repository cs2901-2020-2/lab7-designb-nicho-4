import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

@Test
public class BuscaminasTest {
    @Test
    public void testcaseprueba(){
        int size=3;
        buscaminas prueba=new buscaminas(size);
        while (!prueba.stadojugador){
            Random rand = new Random();
            int rand_x=rand.nextInt(size);
            int rand_y=rand.nextInt(size);
            prueba.escoger_casilla(rand_x,rand_y);
        }
    }

    @Test(invocationCount = 2, threadPoolSize = 2)
    public void testTime() throws Exception {
        long startTime = System.currentTimeMillis();
        int size=3;
        buscaminas prueba=new buscaminas(size);
        while (!prueba.stadojugador){
            Random rand = new Random();
            int rand_x=rand.nextInt(size);
            int rand_y=rand.nextInt(size);
            prueba.escoger_casilla(rand_x,rand_y);
        }
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        Assert.assertTrue(time <= 400);
    }

    private void generic(int i) throws IOException {
        int n = readInput(i);
        List<String> expectedOutput = readOutput(i);
    }

    private int readInput(int testNumber){
        List<String> lines = readFile(testNumber, "input");
        int n = Integer.parseInt(lines.get(0));
        return n;
    }

    private List<String> readOutput(int testNumber){
        List<String> lines = readFile(testNumber, "output");
        return lines;
    }

    public List<String> readFile(int testNumber, String type){
        String fileName = "test_case<testNumber>_<type>";
        fileName = fileName.replace("<testNumber>", Integer.toString(testNumber));
        fileName = fileName.replace("<type>", type);
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        Scanner scan = new Scanner(is);
        List<String> lines = new ArrayList<String>();
        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            lines.add(line);
        }
        return lines;
    }
}
