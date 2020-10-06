import cs.lab.Buscaminas;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Random;

@Test
public class BuscaminasTest {
    @Test
    public void testcaseprueba() throws Exception{
        int size=3;
        Buscaminas prueba=new Buscaminas(size);
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
        Buscaminas prueba=new Buscaminas(size);
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

}
