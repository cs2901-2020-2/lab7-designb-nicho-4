import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

public class buscaminas {

    static final Logger logger = Logger.getLogger(buscaminas.class.getName());
    public static boolean [][] tablaminada;
    public boolean [][] vistapantalla;
    public static int tamano;
    public boolean stadojugador=false;

    public buscaminas(int tam) throws NoSuchAlgorithmException {
        tamano =tam;
        tablaminada = new boolean[tam][tam];
        vistapantalla = new boolean[tam][tam];
        for (int i = 0; i < tam; i++){
            for (int j = 0; j < tam; j++){
                tablaminada[i][j] = false;
                vistapantalla[i][j]=false;
            }
        }
        Random rand = SecureRandom.getInstanceStrong();
        set_minas(tablaminada,tam, rand);
    }

    public static void set_minas(boolean[][] tabla, int n, Random rand){
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

    public void escoger_casilla(int pos_x, int pos_y){
        while (pos_x >= tamano || pos_y >= tamano){
            logger.info("Ingresa coordenadas validas: ");
            Scanner val_xn= new Scanner(System.in);
            Scanner val_yn= new Scanner(System.in);
            pos_x = val_xn.nextInt();
            pos_y = val_yn.nextInt();
        }
        if (tablaminada[pos_x][pos_y]){
            stadojugador=true;
            logger.info("Posicion seleccionada minada, usted perdio");
        }
        else{
            logger.info("continue jugando");
        }
    }

}
