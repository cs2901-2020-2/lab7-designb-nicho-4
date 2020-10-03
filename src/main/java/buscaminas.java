import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

public class buscaminas {

    static final Logger logger = Logger.getLogger(buscaminas.class.getName());
    //tablero de booleanos
    public static boolean [][] tablaminada;
    public boolean [][] vistapantalla;
    public static int tamano;
    //un booleano que determina el estado del jugador
    public boolean stadojugador=false;

    public buscaminas(int tam){
        tamano =tam;
        tablaminada = new boolean[tam][tam];
        vistapantalla = new boolean[tam][tam];
        for (int i = 0; i < tam; i++){
            for (int j = 0; j < tam; j++){
                tablaminada[i][j] = false;
                vistapantalla[i][j]=false;
            }
        }
        set_minas(tablaminada,tam);
    }

    public static void set_minas(boolean[][] tabla, int n){
        Random rand = new Random();
        int cant_minas = rand.nextInt(n*2);
        int rand_x = rand.nextInt(n);
        int rand_y = rand.nextInt(n);
        for (int i = 0; i < cant_minas; i++){
            if (!(tabla[rand_x][rand_y])) {
                tabla[rand_x][rand_y] = true;
            }
            else {
                rand_x = rand.nextInt(n);
                rand_y = rand.nextInt(n);
                i--;
            }
        }
    }

//    public void print(boolean[][] tablajuego){
//        for(int i = 0; i < tamano; i++){
//            for(int j = 0; j < tamano; j++){
//                logger.info(String.valueOf(tablajuego[i][j]));
//            }
//            logger.info("\n");
//        }
//    }

    public void escoger_casilla(int pos_x, int pos_y){
        //print(vistapantalla);
//        while (pos_x >= tamano || pos_y >= tamano){
//            logger.info("Ingresa coordenadas validas: ");
//            Scanner val_xn= new Scanner(System.in);
//            Scanner val_yn= new Scanner(System.in);
//            pos_x = val_xn.nextInt();
//            pos_y = val_yn.nextInt();
//        }
        //logger.info("coordenadas seleccionadas:");
        //logger.info(String.valueOf(pos_x));
        //logger.info(String.valueOf(pos_y));
        if (tablaminada[pos_x][pos_y]){
            logger.info("Posicion seleccionada minada, usted perdio");
            stadojugador=true;
            //print(tablaminada);
        }
        else{
            logger.info("continue jugando");
        }
    }

}
