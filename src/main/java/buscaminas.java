import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

public class buscaminas {

    static final Logger logger = Logger.getLogger(buscaminas.class.getName());

    public int [][] tabla;
    public int tamano;
    public int coordx, coordy;

    public buscaminas(int n){
        tabla = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                tabla[i][j] = 0;
            }
        }
        set_minas(tabla, n);
    }

    public static void set_minas(int[][] tabla, int n){
        Random rand = new Random();
        int cant_minas = rand.nextInt(n+1);
        int rand_x = rand.nextInt(n);
        int rand_y = rand.nextInt(n);
        for (int i = 0; i < cant_minas; i++){
            if (tabla[rand_x][rand_y] == 0) {
                tabla[rand_x][rand_y] = 1;
            }
            else {
                rand_x = rand.nextInt(n);
                rand_y = rand.nextInt(n);
                i--;
            }
        }
        escoger_casilla(tabla, n);
    }

    /*
    public static void imprimirtabla(int [][] tabla,String[][] tablajuego, int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                logger.info(tablajuego[i][j]);
            }
            logger.info("\n");
        }
    }
     */

    public static void escoger_casilla(int[][] tabla, int n, int coordx, int coordy){
        logger.info("Ingresa coordenadas en x: ");
        Scanner value_x= new Scanner(System.in);
        logger.info("Ingresa coordenadas en y: ");
        Scanner value_y= new Scanner(System.in);
        int x = value_x.nextInt();
        int y = value_y.nextInt();

        while (x >= n || y >= n){
            logger.info("Ingresa coordenadas validas: ");
            Scanner val_xn= new Scanner(System.in);
            Scanner val_yn= new Scanner(System.in);
            x = val_xn.nextInt();
            y = val_yn.nextInt();
        }

        if (tabla[x][y] == 0){
            //tablajuego[x][y] = "x";
            //imprimirtabla(tabla, tablajuego,n);
            escoger_casilla(tabla, n);
        } else {
            logger.info("Perdiste");
            //imprimirtabla(tabla, tablajuego, n);
        }
    }

    public void play(){

    }

}

