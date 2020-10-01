import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

public class buscaminas {

    static final Logger logger = Logger.getLogger(buscaminas.class.getName());

    public static void creartablas(int[][] tabla, String[][] tablajuego , int n){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                tabla[i][j] = 0;
                tablajuego[i][j] = "o";
            }
        }
        set_minas(tabla, tablajuego, n);
    }

    public static void set_minas(int[][] tabla, String [][] tablajuego, int n){
        Random rand = new Random();
        int cant_minas = rand.nextInt(n+1);
        int rand_x = rand.nextInt(n);
        int rand_y = rand.nextInt(n);
        for (int i = 0; i < cant_minas; i++){
            if (tabla[rand_x][rand_y] == 0)
                tabla[rand_x][rand_y] = 1;
            else
                rand_x = rand.nextInt(n);
                rand_y = rand.nextInt(n);
        }
        imprimirtabla(tabla, tablajuego, n);
        escoger_casilla(tabla, tablajuego, n);
    }

    public static void imprimirtabla(int [][] tabla,String[][] tablajuego, int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                logger.info(tablajuego[i][j]);
            }
            logger.info("\n");
        }
    }

    public static void escoger_casilla(int[][] tabla, String[][] tablajuego, int n){
        logger.info("Ingresa coordenadas en x: ");
        Scanner value_x= new Scanner(System.in);
        logger.info("Ingresa coordenadas en y: ");
        Scanner value_y= new Scanner(System.in);
        int x = value_x.nextInt();
        int y = value_y.nextInt();

        while (x >= n || y >= n){
            logger.info("Ingresa coordenadas validas: ");
            Scanner value_xn= new Scanner(System.in);
            Scanner value_yn= new Scanner(System.in);
            x = value_xn.nextInt();
            y = value_yn.nextInt();
        }
        if (tabla[x][y] == 0){
            tablajuego[x][y] = "x";
            imprimirtabla(tabla, tablajuego,n);
            escoger_casilla(tabla, tablajuego, n);
        } else {
            logger.info("Perdiste");
            imprimirtabla(tabla, tablajuego, n);
        }
    }


    public static void main(String[] args){
        logger.info("Ingresa el tamaño de la tabla: ");
        Scanner scannerObj = new Scanner(System.in);

        int n = scannerObj.nextInt();

        int[][] tabla = new int[n][n];
        String[][] tablajuego = new String[n][n];
        creartablas(tabla, tablajuego, n);

        logger.info("Fin del juego...");
    }

}

