package principal;
import java.util.*;
public class Main {

    public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in); //inicializamos el escaner
        int opcion;
        char seguir;
        do{
            //leerOpcion
            do {//nos aseguramos que elija una opcion correcta
                System.out.println("Elija una de las siguientes opciones: \n1.-Dibujar figura geométrica\n2.-Calcular si un número es ambicioso \n3.-Jugar a los dados");
                opcion=sc.nextInt();
                if(opcion<1||opcion>3) {
                    System.out.println("Esa opcion no es disponible, elija otra");
                }
            }while(opcion<1||opcion>3);
            switch (opcion){//creamos un selecetor para las tres opciones
                //Opcion 1
                case 1:
                    //pedirDatosCorrectos
                    int tamano, inpar;
                    char caracter;
                    do{//nos aseguramos que el tamaño introducido es correcto
                        System.out.println("Numero de filas y columna(el numero debe ser entero impar y estar entre 5 y 30):");
                        tamano=sc.nextInt();
                        inpar=tamano%2;
                        if(tamano<5||tamano>30||inpar==0){
                            System.out.println("el numero introducido no cumple los requisitos");
                        }
                    }while(tamano<5||tamano>30||inpar==0);
                    do{//nos aseguramos que el caracter introducido es correcto
                        System.out.println("Escriba el caracter a usar(debe ser '*', 'a' o 'z':");
                        caracter= sc.next().charAt(0);
                        if(caracter!='*'&&caracter!='a'&&caracter!='z'){
                            System.out.println("caracter no disponible");
                        }
                    }while (caracter!='*'&&caracter!='a'&&caracter!='z');
                    //enConstruccion
                    System.out.println("En construccion");
                break;
                case 2:
                    //enConstruccion
                    System.out.println("Esta en construcion");
                break;
                case 3:
                    int rondas, dobles, rondasganadasmaquina=0, rondasganadasjugador=0;
                    double dado1, dado2, puntuacionmaquina, puntuacionjugador;
                    char continuar;
                    //leerNumeroRodas
                    do {//nos aseguramos que se introduzcan valores positivos
                        System.out.println("Cuantas rondas desea que tenga la partida?");
                        rondas= sc.nextInt();
                        if(rondas<=0){
                            System.out.println("Porfavor, introduzca numeros positvos");
                        }
                    }while(rondas<=0);
                    //repetirRondasVeces
                    for(int cont=1;cont<=rondas;++cont){
                        //simularDadosMaquina
                        puntuacionmaquina=0;
                        dobles=0;
                        System.out.println("Es mi turno, veamos si hay suerte");
                        do{//comprobarSiDobles
                            System.out.println("Escriba cualquier caracter para continuar");//utilizamos separadores para que no escriba todo junto
                            continuar=sc.next().charAt(0);
                            System.out.println("Tirando primer dado");
                            dado1=Math.floor(1+Math.random()*6);//generamos un numero aleatoria entre el 1 y el 6
                            System.out.println("Salio un "+dado1);
                            System.out.println("Escriba cualquier caracter para continuar");
                            continuar=sc.next().charAt(0);
                            System.out.println("Tirando el segundo dado");
                            dado2=Math.floor(1+Math.random()*6);//generamos un numero aleatoria entre el 1 y el 6
                            System.out.println("Salio un "+dado2);
                            //contarPuntuacion
                            puntuacionmaquina=puntuacionmaquina+dado1+dado2;
                            if(dado1==dado2){//hacemos las comprobaciones necesarias para que funcione los dobles
                                dobles=dobles+1;
                                System.out.println("Vaya, parece que saque dobles");
                            }else{
                                dobles=0;
                            }
                            if(dobles==3){
                                puntuacionmaquina=0;
                            }
                        }while(dobles>=1&&dobles<3);
                        System.out.println("Consegui una puntuacion de: "+puntuacionmaquina);
                        //simularDadosJugador
                        dobles=0;
                        System.out.println("Es tu turno, seurte");
                        puntuacionjugador=0;
                        do{//comprobarSiDobles
                            System.out.println("Escriba cualquier caracter para continuar");
                            continuar=sc.next().charAt(0);
                            System.out.println("Tiras el primer dado");
                            dado1=Math.floor(1+Math.random()*6);//generamos un numero aleatoria entre el 1 y el 6
                            System.out.println("Salio un "+dado1);
                            System.out.println("Escriba cualquier caracter para continuar");
                            continuar=sc.next().charAt(0);
                            System.out.println("Tiras el segundo dado");
                            dado2=Math.floor(1+Math.random()*6);//generamos un numero aleatoria entre el 1 y el 6
                            System.out.println("Salio un "+dado2);
                            //contarPuntuacion
                            puntuacionjugador=puntuacionjugador+dado1+dado2;
                            if(dado1==dado2){//hacemos las comprobaciones necesarias para que funcione los dobles
                                dobles=dobles+1;
                                System.out.println("Vaya, parece que sacaste dobles");
                            }else{
                                dobles=0;
                            }
                            if(dobles==3){
                                puntuacionjugador=0;
                            }
                        }while(dobles>=1&&dobles<3);
                        System.out.println("Conseguiste una puntuacion de: "+puntuacionjugador);
                        System.out.println("Escriba cualquier caracter para continuar");
                        continuar=sc.next().charAt(0);
                        //compararPuntuacion
                        if (puntuacionmaquina==puntuacionjugador){
                            System.out.println("Vaya, empatamos");
                        }else if(puntuacionmaquina>puntuacionjugador){
                            System.out.println("sacaste menos puntuacion que yo, gane la ronda");
                            rondasganadasmaquina=rondasganadasmaquina+1;
                        }else{
                            System.out.println("Sacaste mas puntuacion que yo, ganaste la ronda :/");
                            rondasganadasjugador=rondasganadasjugador+1;
                        }
                        //rondasGanadas
                        System.out.println("Llevas "+rondasganadasjugador+" rondas ganadas, yo llevo "+rondasganadasmaquina+" rondas ganadas");
                    }
                    //compararRondasGanasYEcribirGanador
                    System.out.println("Pulse cualquier tecla para continuar");
                    continuar=sc.next().charAt(0);
                    System.out.println("Se acabaron las rondas, veamos quien es el ganador");
                    if(rondasganadasmaquina==rondasganadasjugador){
                        System.out.println("EMPATE");
                    }else if (rondasganadasmaquina>rondasganadasjugador){
                        System.out.println("GANE");
                    }else{
                        System.out.println("Ganeste, enorabuena");
                    }
            }
            //seguir?
            System.out.println("Desea que realize otra opcion?");
            seguir=sc.next().charAt(0);
        }while (seguir=='s');

    }
}
