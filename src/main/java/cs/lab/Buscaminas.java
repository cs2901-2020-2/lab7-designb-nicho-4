package cs.lab;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

public class Buscaminas {

    static final Logger logger = Logger.getLogger(Buscaminas.class.getName());
    boolean [][] tablaminada;
    boolean [][] vistapantalla;
    static int tamano;
    public boolean stadojugador=false;

    public Buscaminas(int tam) throws NoSuchAlgorithmException {
        tamano = tam;
        tablaminada = new boolean[tam][tam];
        vistapantalla = new boolean[tam][tam];
        for (int i = 0; i < tam; i++){
            for (int j = 0; j < tam; j++){
                tablaminada[i][j] = false;
                vistapantalla[i][j]=false;
            }
        }
        Random rand = SecureRandom.getInstanceStrong();
        setMinas(tablaminada,tam, rand);
    }

    public static void setMinas(boolean[][] tabla, int n, Random rand){
        int cantMinas = rand.nextInt(n*2);
        int randX = rand.nextInt(n);
        int randY = rand.nextInt(n);
        for (int i = 0; i < cantMinas; i++){
            if (!(tabla[randX][randY])) {
                tabla[randX][randY] = true;
            }
            else {
                randX = rand.nextInt(n);
                randY = rand.nextInt(n);
                i--;
            }
        }
    }

    public void escogerCasilla(int posX, int posY){
        while (posX >= tamano || posY >= tamano){
            logger.info("Ingresa coordenadas validas: ");
            Scanner valxn= new Scanner(System.in);
            Scanner valyn= new Scanner(System.in);
            posX = valxn.nextInt();
            posY = valyn.nextInt();
        }
        if (tablaminada[posX][posY]){
            stadojugador=true;
            logger.info("Posicion seleccionada minada, usted perdio");
        }
        else{
            logger.info("continue jugando");
        }
    }

}
