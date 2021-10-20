/*************************************************************************************************************
Vista.java
Autor: Jeremy Mejía
Fecha de Creación: Octubre de 2021
Última Modificación: Octubre de 2021

Ejercicio No. 5
Vista
*************************************************************************************************************/

/*************************************************************************************************************
Librería
*************************************************************************************************************/

import java.util.Scanner;
import java.util.Random;


/*************************************************************************************************************
Clase Vista
*************************************************************************************************************/

class Vista{


/*************************************************************************************************************
Variables globales
*************************************************************************************************************/

    Scanner scan = new Scanner(System.in);

    private int op;
    private int ope;
    private int golp;
    private int enem; 
    private int cantJuga;
    private int ser;
    int varEnemigo = (int)(Math.random()*3+1);
    int varEnemigo2 = (int)(Math.random()*2+1);
	int var = (int)(Math.random()*2+1);
    int jugador = (int)(Math.random()*3+1);

    public void vista(){
        do{
            System.out.println("\nBienvenido a la batalla." +
            "\n¿Deseas iniciar el juego? \n 1. Si \n 2. No \n"  +
            "Selecciona un número: ");
            ope = scan.nextInt();
            
            if (ope > 2 || ope < 1){
                System.out.println("\nHaz marcado una opción inválida, intenta de nuevo");
            }   
        }while(ope > 2 || ope < 1);

        if(ope == 2){
            System.out.println("\n***** Hasta pronto *****");
        }
        
        do{
            if(ope == 1){
                System.out.println("\nElige la cantidad de jugadores:");
                System.out.println("1. Un jugador");
                System.out.println("2. Dos jugadores");
                System.out.println("3. Tres jugadores");
                System.out.println("Selecciona un número");
                cantJuga = scan.nextInt();

                if (cantJuga > 3 || cantJuga < 1){
                    System.out.println("\nHaz marcado una opción inválida, intenta de nuevo");
                }
            }
            
        }while(cantJuga > 3 || cantJuga < 1);

        do{
            if (cantJuga == 1){
                System.out.println("\nElige que deseas ser:");
                System.out.println("1. Cazador");
                System.out.println("2. Guerrero");
                System.out.println("3. Explorador");
                ser = scan.nextInt(); 
            }
            if (ser > 3 || ser < 1){
                System.out.println("\nHaz marcado una opción inválida, intenta de nuevo");
            }
        }while(ser > 3 || ser < 1);

        if (ser == 1){
            Cazador caz = new Cazador();
            int vidaCazador = caz.vidasCazador();
            String nombreCazador = caz.NombreCazador();
            String mascota = caz.Acompanante();
            String poderCazador = caz.PoderesCazador();
            System.out.println("\nEmpezarás como " +  nombreCazador + " y cuentas con " + vidaCazador + " vidas,"
            + " tendrás ayuda de un acompañante, " + mascota);
            System.out.println(poderCazador);
            do{
                System.out.println("\nPresiona 1 para continuar: ");
                op = scan.nextInt(); 
                if (op > 1 || op < 1){
                    System.out.println("\nHaz marcado una opción inválida, intenta de nuevo");
                }  
            }while(op > 1 || op < 1);

            do{
                Enemigo Enem = new Enemigo();
                EnemigoJefe enemJefe = new EnemigoJefe();
                EnemigoJefeRegular enemJefeR = new EnemigoJefeRegular();
                int vidaEnemigo =  Enem.vidasEnemigo(); 
                int vidaEnemigoJefe = enemJefe.vidasEnemigoJefe();
                String nombreEnemigoJefe = enemJefe.NombreEnemigoJefe();
                int vidaEnemigoJefeRegular = enemJefeR.vidasEnemigoJefeRegular();


                System.out.println("\nEstás en una batalla con el " + nombreEnemigoJefe +" acompañado de " + jugador + " enemigos o enemigos jefes regulares, lo único que puedes hacer es golpear y lanzar a tu mascota" +
                "\nCada enemigo cuenta con "+ vidaEnemigo +" vidas, cada enemigo jefe regular cuenta con " + vidaEnemigoJefeRegular + " vidas y el Enemigo Jefe cuenta con " + vidaEnemigoJefe + " vidas"  +
                " ¿Qué deseas hacer?" 
                + "\n1. Golpear \n2. Lanzar mascota \nSelecciona un número:"); 
                enem = scan.nextInt(); 
                if (enem > 2 || enem < 1){
                    System.out.println("\nHaz marcado una opción inválida, intenta de nuevo");
                } 
            }while(enem > 2 || enem < 1);
            do{
                System.out.println("\nSelecciona con un número al enemigo que deseas atacar:");
                golp = scan.nextInt();

                if (golp > jugador || golp < 1){
                    System.out.println("\nHaz marcado una opción inválida, intenta de nuevo");
                } 
            }while(golp > jugador || golp < 1);

            if (enem == 1){
                if (golp == 1){
                    Enemigo Enem = new Enemigo();
                    int vidaEnemigo = Enem.vidasEnemigo();
                    vidaEnemigo = vidaEnemigo - 1; 
                    System.out.println("\nEl enemigo " + golp + " ahora tiene " + vidaEnemigo  + " vidas");
    
                    if(varEnemigo == 1){
                        vidaCazador = vidaCazador - 1;
                        System.out.println("\nEl Jefe de los enemigos te ha herido dando veneno ahora tienes " + vidaCazador + " vidas");
                    }
                    if(varEnemigo == 2){
                        vidaCazador = vidaCazador - 2;
                        System.out.println("\nEl Jefe de los enemigos te ha golpeado muy fuerte ahora tienes " + vidaCazador + " vidas");
                    }
                    if(varEnemigo == 3){
                        vidaCazador = vidaCazador - 3;
                        System.out.println("\nEl Jefe de los enemigos te ha matado ahora tienes " + vidaCazador + " vidas");
                        
                        Vista vs = new Vista();
                        vs.Game();
                    }
                    do{
                        System.out.println("Aún tienes una batalla con " + jugador + " enemigos ¿que deseas hacer?" +
                        "\nEl enemigo " + golp + " tiene " + vidaEnemigo + " vidas aún"
                        + "\n1. Golpear \n2. Lanzar mascota \nSelecciona un número:");
                        enem = scan.nextInt();
                        if (enem > 2 || enem < 1){
                            System.out.println("\nHaz marcado una opción inválida, intenta de nuevo");
                        } 
                    }while(enem > 2 || enem < 1);
                    System.out.println("\nBien hecho");
                    Vista vs = new Vista();
                    vs.Game();
                }
                if (golp == 2){
                    EnemigoJefeRegular enemJefeR = new EnemigoJefeRegular();
                    int vidaEnemigoJefeRegular = enemJefeR.vidasEnemigoJefeRegular();
                    vidaEnemigoJefeRegular = vidaEnemigoJefeRegular - 1; 
                    System.out.println("\nEl enemigo jefe regular " + golp + " ahora tiene " + vidaEnemigoJefeRegular  + " vidas");
    
                    if(varEnemigo == 1){
                        vidaCazador = vidaCazador - 1;
                        System.out.println("\nEl Jefe de los enemigos te ha herido dando veneno ahora tienes " + vidaCazador + " vidas");
                    }
                    if(varEnemigo == 2){
                        vidaCazador = vidaCazador - 2;
                        System.out.println("\nEl Jefe de los enemigos te ha golpeado muy fuerte ahora tienes " + vidaCazador + " vidas");
                    }
                    if(varEnemigo == 3){
                        vidaCazador = vidaCazador - 3;
                        System.out.println("\nEl Jefe de los enemigos te ha matado ahora tienes " + vidaCazador + " vidas");
                        
                        Vista vs = new Vista();
                        vs.Game();
                    }
                    do{
                        System.out.println("Aún tienes una batalla con " + jugador + " enemigos ¿que deseas hacer?" +
                        "\nEl enemigo jefe  regular " + golp + " tiene " + vidaEnemigoJefeRegular + " vidas aún"
                        + "\n1. Golpear \n2. Lanzar mascota \nSelecciona un número:");
                        enem = scan.nextInt();
                        if (enem > 2 || enem < 1){
                            System.out.println("\nHaz marcado una opción inválida, intenta de nuevo");
                        } 
                    }while(enem > 2 || enem < 1);
                    System.out.println("\nBien hecho");
                    Vista vs = new Vista();
                    vs.Game();
                }
                if (golp == 3){
                    EnemigoJefe enemJefe = new EnemigoJefe();
                    int vidaEnemigoJefe = enemJefe.vidasEnemigoJefe();
                    vidaEnemigoJefe = vidaEnemigoJefe - 1; 
                    System.out.println("\nEl enemigo jefe regular " + golp + " ahora tiene " + vidaEnemigoJefe  + " vidas");
    
                    if(varEnemigo == 1){
                        vidaCazador = vidaCazador - 1;
                        System.out.println("\nEl Jefe de los enemigos te ha herido dando veneno ahora tienes " + vidaCazador + " vidas");
                    }
                    if(varEnemigo == 2){
                        vidaCazador = vidaCazador - 2;
                        System.out.println("\nEl Jefe de los enemigos te ha golpeado muy fuerte ahora tienes " + vidaCazador + " vidas");
                    }
                    if(varEnemigo == 3){
                        vidaCazador = vidaCazador - 3;
                        System.out.println("\nEl Jefe de los enemigos te ha matado ahora tienes " + vidaCazador + " vidas");
                        
                        Vista vs = new Vista();
                        vs.Game();
                    }
                    do{
                        System.out.println("Aún tienes una batalla con " + jugador + " enemigos ¿que deseas hacer?" +
                        "\nEl enemigo jefe " + golp + " tiene " + vidaEnemigoJefe + " vidas aún"
                        + "\n1. Golpear \n2. Lanzar mascota \nSelecciona un número:");
                        enem = scan.nextInt();
                        if (enem > 2 || enem < 1){
                            System.out.println("\nHaz marcado una opción inválida, intenta de nuevo");
                        } 
                    }while(enem > 2 || enem < 1);
                    System.out.println("\nBien hecho");
                    Vista vs = new Vista();
                    vs.Game();
                }
            }
            if (enem == 2){
                if (golp == 1){
                    Enemigo Enem = new Enemigo();
                    int vidaEnemigo = Enem.vidasEnemigo();
                    vidaEnemigo = vidaEnemigo - 2; 
                    System.out.println("\nEl enemigo " + golp + " ahora tiene " + vidaEnemigo  + " vidas");
    
                    if(varEnemigo == 1){
                        vidaCazador = vidaCazador - 1;
                        System.out.println("\nEl Jefe de los enemigos te ha herido dando veneno ahora tienes " + vidaCazador + " vidas");
                    }
                    if(varEnemigo == 2){
                        vidaCazador = vidaCazador - 2;
                        System.out.println("\nEl Jefe de los enemigos te ha golpeado muy fuerte ahora tienes " + vidaCazador + " vidas");
                    }
                    if(varEnemigo == 3){
                        vidaCazador = vidaCazador - 3;
                        System.out.println("\nEl Jefe de los enemigos te ha matado ahora tienes " + vidaCazador + " vidas");
                        
                        Vista vs = new Vista();
                        vs.Game();
                    }
                    do{
                        System.out.println("Aún tienes una batalla con " + jugador + " enemigos ¿que deseas hacer?" +
                        "\nEl enemigo " + golp + " tiene " + vidaEnemigo + " vidas aún"
                        + "\n1. Golpear \n2. Lanzar mascota \nSelecciona un número:");
                        enem = scan.nextInt();
                        if (enem > 2 || enem < 1){
                            System.out.println("\nHaz marcado una opción inválida, intenta de nuevo");
                        } 
                    }while(enem > 2 || enem < 1);
                    System.out.println("\nBien hecho");
                    Vista vs = new Vista();
                    vs.Game();
                }
                if (golp == 2){
                    EnemigoJefeRegular enemJefeR = new EnemigoJefeRegular();
                    int vidaEnemigoJefeRegular = enemJefeR.vidasEnemigoJefeRegular();
                    vidaEnemigoJefeRegular = vidaEnemigoJefeRegular - 2; 
                    System.out.println("\nEl enemigo jefe regular " + golp + " ahora tiene " + vidaEnemigoJefeRegular  + " vidas");
    
                    if(varEnemigo == 1){
                        vidaCazador = vidaCazador -1;
                        System.out.println("\nEl Jefe de los enemigos te ha herido dando veneno ahora tienes " + vidaCazador + " vidas");
                    }
                    if(varEnemigo == 2){
                        vidaCazador = vidaCazador - 2;
                        System.out.println("\nEl Jefe de los enemigos te ha golpeado muy fuerte ahora tienes " + vidaCazador + " vidas");
                    }
                    if(varEnemigo == 3){
                        vidaCazador = vidaCazador - 3;
                        System.out.println("\nEl Jefe de los enemigos te ha matado ahora tienes " + vidaCazador + " vidas");
                        
                        Vista vs = new Vista();
                        vs.Game();
                    }
                    do{
                        System.out.println("Aún tienes una batalla con " + jugador + " enemigos ¿que deseas hacer?" +
                        "\nEl enemigo jefe  regular " + golp + " tiene " + vidaEnemigoJefeRegular + " vidas aún"
                        + "\n1. Golpear \n2. Lanzar mascota \nSelecciona un número:");
                        enem = scan.nextInt();
                        if (enem > 2 || enem < 1){
                            System.out.println("\nHaz marcado una opción inválida, intenta de nuevo");
                        } 
                    }while(enem > 2 || enem < 1);
                    System.out.println("\nBien hecho");
                    Vista vs = new Vista();
                    vs.Game();
                }
                if (golp == 3){
                    EnemigoJefe enemJefe = new EnemigoJefe();
                    int vidaEnemigoJefe = enemJefe.vidasEnemigoJefe();
                    vidaEnemigoJefe = vidaEnemigoJefe - 2; 
                    System.out.println("\nEl enemigo jefe regular " + golp + " ahora tiene " + vidaEnemigoJefe  + " vidas");
    
                    if(varEnemigo == 1){
                        vidaCazador = vidaCazador - 1;
                        System.out.println("\nEl Jefe de los enemigos te ha herido dando veneno ahora tienes " + vidaCazador + " vidas");
                    }
                    if(varEnemigo == 2){
                        vidaCazador = vidaCazador - 2;
                        System.out.println("\nEl Jefe de los enemigos te ha golpeado muy fuerte ahora tienes " + vidaCazador + " vidas");
                    }
                    if(varEnemigo == 3){
                        vidaCazador = vidaCazador - 3;
                        System.out.println("\nEl Jefe de los enemigos te ha matado ahora tienes " + vidaCazador + " vidas");
                        
                        Vista vs = new Vista();
                        vs.Game();
                    }
                    do{
                        System.out.println("Aún tienes una batalla con " + jugador + " enemigos ¿que deseas hacer?" +
                        "\nEl enemigo jefe " + golp + " tiene " + vidaEnemigoJefe + " vidas aún"
                        + "\n1. Golpear \n2. Lanzar mascota \nSelecciona un número:");
                        enem = scan.nextInt();
                        if (enem > 2 || enem < 1){
                            System.out.println("\nHaz marcado una opción inválida, intenta de nuevo");
                        } 
                    }while(enem > 2 || enem < 1);
                    System.out.println("\nBien hecho");
                    Vista vs = new Vista();
                    vs.Game();
                }
            }
        }
        
        if (ser == 2){
            Guerrero Gue = new Guerrero();
            int vidaGuerrero = Gue.vidasGuerrero();
            String nombreGuerrero = Gue.NombreGuerrero();
            String mascota = Gue.Acompanante();
            String poderGuerrero = Gue.PoderesGuerrero();
            System.out.println("\nEmpezarás como " +  nombreGuerrero + " y cuentas con " + vidaGuerrero + " vidas,"
            + " tendrás ayuda de un acompañante, " + mascota);
            System.out.println(poderGuerrero);
            do{
                System.out.println("\nPresiona 1 para continuar: ");
                op = scan.nextInt(); 
                if (op > 1 || op < 1){
                    System.out.println("\nHaz marcado una opción inválida, intenta de nuevo");
                }  
            }while(op > 1 || op < 1);

            do{
                Enemigo Enem = new Enemigo();
                EnemigoJefe enemJefe = new EnemigoJefe();
                EnemigoJefeRegular enemJefeR = new EnemigoJefeRegular();
                int vidaEnemigo =  Enem.vidasEnemigo(); 
                int vidaEnemigoJefe = enemJefe.vidasEnemigoJefe();
                String nombreEnemigoJefe = enemJefe.NombreEnemigoJefe();
                int vidaEnemigoJefeRegular = enemJefeR.vidasEnemigoJefeRegular();


                System.out.println("\nEstás en una batalla con el " + nombreEnemigoJefe +" acompañado de " + jugador + " enemigos o enemigos jefes regulares, lo único que puedes hacer es golpear y lanzar a tu mascota" +
                "\nCada enemigo cuenta con "+ vidaEnemigo +" vidas, cada enemigo jefe regular cuenta con " + vidaEnemigoJefeRegular + " vidas y el Enemigo Jefe cuenta con " + vidaEnemigoJefe + " vidas"  +
                " ¿Qué deseas hacer?" 
                + "\n1. Golpear \n2. Herir \nSelecciona un número:"); 
                enem = scan.nextInt(); 
                if (enem > 2 || enem < 1){
                    System.out.println("\nHaz marcado una opción inválida, intenta de nuevo");
                } 
            }while(enem > 2 || enem < 1);
            do{
                System.out.println("\nSelecciona con un número al enemigo que deseas atacar:");
                golp = scan.nextInt();

                if (golp > jugador || golp < 1){
                    System.out.println("\nHaz marcado una opción inválida, intenta de nuevo");
                } 
            }while(golp > jugador || golp < 1);

            if (enem == 1){
                if (golp == 1){
                    Enemigo Enem = new Enemigo();
                    int vidaEnemigo = Enem.vidasEnemigo();
                    vidaEnemigo = vidaEnemigo - 2; 
                    System.out.println("\nEl enemigo " + golp + " ahora tiene " + vidaEnemigo  + " vidas");
    
                    if(varEnemigo == 1){
                        vidaGuerrero = vidaGuerrero - 1;
                        System.out.println("\nEl Jefe de los enemigos te ha herido dando veneno ahora tienes " + vidaGuerrero + " vidas");
                    }
                    if(varEnemigo == 2){
                        vidaGuerrero = vidaGuerrero - 2;
                        System.out.println("\nEl Jefe de los enemigos te ha golpeado muy fuerte ahora tienes " + vidaGuerrero + " vidas");
                    }
                    if(varEnemigo == 3){
                        vidaGuerrero = vidaGuerrero - 3;
                        System.out.println("\nEl Jefe de los enemigos te ha matado ahora tienes " + vidaGuerrero + " vidas");
                        
                        Vista vs = new Vista();
                        vs.Game();
                    }
                    do{
                        System.out.println("Aún tienes una batalla con " + jugador + " enemigos ¿que deseas hacer?" +
                        "\nEl enemigo " + golp + " tiene " + vidaEnemigo + " vidas aún"
                        + "\n1. Golpear \n2. Herir \nSelecciona un número:");
                        enem = scan.nextInt();
                        if (enem > 2 || enem < 1){
                            System.out.println("\nHaz marcado una opción inválida, intenta de nuevo");
                        } 
                    }while(enem > 2 || enem < 1);
                    System.out.println("\nBien hecho");
                    Vista vs = new Vista();
                    vs.Game();
                }
                if (golp == 2){
                    EnemigoJefeRegular enemJefeR = new EnemigoJefeRegular();
                    int vidaEnemigoJefeRegular = enemJefeR.vidasEnemigoJefeRegular();
                    vidaEnemigoJefeRegular = vidaEnemigoJefeRegular - 2; 
                    System.out.println("\nEl enemigo jefe regular " + golp + " ahora tiene " + vidaEnemigoJefeRegular  + " vidas");
    
                    if(varEnemigo == 1){
                        vidaGuerrero = vidaGuerrero - 1;
                        System.out.println("\nEl Jefe de los enemigos te ha herido dando veneno ahora tienes " + vidaGuerrero + " vidas");
                    }
                    if(varEnemigo == 2){
                        vidaGuerrero = vidaGuerrero - 2;
                        System.out.println("\nEl Jefe de los enemigos te ha golpeado muy fuerte ahora tienes " + vidaGuerrero + " vidas");
                    }
                    if(varEnemigo == 3){
                        vidaGuerrero = vidaGuerrero - 3;
                        System.out.println("\nEl Jefe de los enemigos te ha matado ahora tienes " + vidaGuerrero + " vidas");
                        
                        Vista vs = new Vista();
                        vs.Game();
                    }
                    do{
                        System.out.println("Aún tienes una batalla con " + jugador + " enemigos ¿que deseas hacer?" +
                        "\nEl enemigo jefe  regular " + golp + " tiene " + vidaEnemigoJefeRegular + " vidas aún"
                        + "\n1. Golpear \n2. Herir \nSelecciona un número:");
                        enem = scan.nextInt();
                        if (enem > 2 || enem < 1){
                            System.out.println("\nHaz marcado una opción inválida, intenta de nuevo");
                        } 
                    }while(enem > 2 || enem < 1);
                    System.out.println("\nBien hecho");
                    Vista vs = new Vista();
                    vs.Game();
                }
                if (golp == 3){
                    EnemigoJefe enemJefe = new EnemigoJefe();
                    int vidaEnemigoJefe = enemJefe.vidasEnemigoJefe();
                    vidaEnemigoJefe = vidaEnemigoJefe - 2; 
                    System.out.println("\nEl enemigo jefe regular " + golp + " ahora tiene " + vidaEnemigoJefe  + " vidas");
    
                    if(varEnemigo == 1){
                        vidaGuerrero = vidaGuerrero - 1;
                        System.out.println("\nEl Jefe de los enemigos te ha herido dando veneno ahora tienes " + vidaGuerrero + " vidas");
                    }
                    if(varEnemigo == 2){
                        vidaGuerrero = vidaGuerrero - 2;
                        System.out.println("\nEl Jefe de los enemigos te ha golpeado muy fuerte ahora tienes " + vidaGuerrero + " vidas");
                    }
                    if(varEnemigo == 3){
                        vidaGuerrero = vidaGuerrero - 3;
                        System.out.println("\nEl Jefe de los enemigos te ha matado ahora tienes " + vidaGuerrero + " vidas");
                        
                        Vista vs = new Vista();
                        vs.Game();
                    }
                    do{
                        System.out.println("Aún tienes una batalla con " + jugador + " enemigos ¿que deseas hacer?" +
                        "\nEl enemigo jefe " + golp + " tiene " + vidaEnemigoJefe + " vidas aún"
                        + "\n1. Golpear \n2. Herir \nSelecciona un número:");
                        enem = scan.nextInt();
                        if (enem > 2 || enem < 1){
                            System.out.println("\nHaz marcado una opción inválida, intenta de nuevo");
                        } 
                    }while(enem > 2 || enem < 1);
                    System.out.println("\nBien hecho");
                    Vista vs = new Vista();
                    vs.Game();
                }
            }
            if (enem == 2){
                if (golp == 1){
                    Enemigo Enem = new Enemigo();
                    int vidaEnemigo = Enem.vidasEnemigo();
                    vidaEnemigo = vidaEnemigo - 3; 
                    System.out.println("\nEl enemigo " + golp + " ahora tiene " + vidaEnemigo  + " vidas");
    
                    if(varEnemigo == 1){
                        vidaGuerrero = vidaGuerrero - 1;
                        System.out.println("\nEl Jefe de los enemigos te ha herido dando veneno ahora tienes " + vidaGuerrero + " vidas");
                    }
                    if(varEnemigo == 2){
                        vidaGuerrero = vidaGuerrero - 2;
                        System.out.println("\nEl Jefe de los enemigos te ha golpeado muy fuerte ahora tienes " + vidaGuerrero + " vidas");
                    }
                    if(varEnemigo == 3){
                        vidaGuerrero = vidaGuerrero - 3;
                        System.out.println("\nEl Jefe de los enemigos te ha matado ahora tienes " + vidaGuerrero + " vidas");
                        
                        Vista vs = new Vista();
                        vs.Game();
                    }
                    do{
                        System.out.println("Aún tienes una batalla con " + jugador + " enemigos ¿que deseas hacer?" +
                        "\nEl enemigo " + golp + " tiene " + vidaEnemigo + " vidas aún"
                        + "\n1. Golpear \n2. Herir \nSelecciona un número:");
                        enem = scan.nextInt();
                        if (enem > 2 || enem < 1){
                            System.out.println("\nHaz marcado una opción inválida, intenta de nuevo");
                        } 
                    }while(enem > 2 || enem < 1);
                    System.out.println("\nBien hecho");
                    Vista vs = new Vista();
                    vs.Game();
                }
                if (golp == 2){
                    EnemigoJefeRegular enemJefeR = new EnemigoJefeRegular();
                    int vidaEnemigoJefeRegular = enemJefeR.vidasEnemigoJefeRegular();
                    vidaEnemigoJefeRegular = vidaEnemigoJefeRegular - 3; 
                    System.out.println("\nEl enemigo jefe regular " + golp + " ahora tiene " + vidaEnemigoJefeRegular  + " vidas");
    
                    if(varEnemigo == 1){
                        vidaGuerrero = vidaGuerrero -1;
                        System.out.println("\nEl Jefe de los enemigos te ha herido dando veneno ahora tienes " + vidaGuerrero + " vidas");
                    }
                    if(varEnemigo == 2){
                        vidaGuerrero = vidaGuerrero - 2;
                        System.out.println("\nEl Jefe de los enemigos te ha golpeado muy fuerte ahora tienes " + vidaGuerrero + " vidas");
                    }
                    if(varEnemigo == 3){
                        vidaGuerrero = vidaGuerrero - 3;
                        System.out.println("\nEl Jefe de los enemigos te ha matado ahora tienes " + vidaGuerrero + " vidas");
                        
                        Vista vs = new Vista();
                        vs.Game();
                    }
                    do{
                        System.out.println("Aún tienes una batalla con " + jugador + " enemigos ¿que deseas hacer?" +
                        "\nEl enemigo jefe  regular " + golp + " tiene " + vidaEnemigoJefeRegular + " vidas aún"
                        + "\n1. Golpear \n2. Herir \nSelecciona un número:");
                        enem = scan.nextInt();
                        if (enem > 2 || enem < 1){
                            System.out.println("\nHaz marcado una opción inválida, intenta de nuevo");
                        } 
                    }while(enem > 2 || enem < 1);
                    System.out.println("\nBien hecho");
                    Vista vs = new Vista();
                    vs.Game();
                }
                if (golp == 3){
                    EnemigoJefe enemJefe = new EnemigoJefe();
                    int vidaEnemigoJefe = enemJefe.vidasEnemigoJefe();
                    vidaEnemigoJefe = vidaEnemigoJefe - 3; 
                    System.out.println("\nEl enemigo jefe regular " + golp + " ahora tiene " + vidaEnemigoJefe  + " vidas");
    
                    if(varEnemigo == 1){
                        vidaGuerrero = vidaGuerrero - 1;
                        System.out.println("\nEl Jefe de los enemigos te ha herido dando veneno ahora tienes " + vidaGuerrero + " vidas");
                    }
                    if(varEnemigo == 2){
                        vidaGuerrero = vidaGuerrero - 2;
                        System.out.println("\nEl Jefe de los enemigos te ha golpeado muy fuerte ahora tienes " + vidaGuerrero + " vidas");
                    }
                    if(varEnemigo == 3){
                        vidaGuerrero = vidaGuerrero - 3;
                        System.out.println("\nEl Jefe de los enemigos te ha matado ahora tienes " + vidaGuerrero + " vidas");
                        
                        Vista vs = new Vista();
                        vs.Game();
                    }
                    do{
                        System.out.println("Aún tienes una batalla con " + jugador + " enemigos ¿que deseas hacer?" +
                        "\nEl enemigo jefe " + golp + " tiene " + vidaEnemigoJefe + " vidas aún"
                        + "\n1. Golpear \n2. Herir \nSelecciona un número:");
                        enem = scan.nextInt();
                        if (enem > 2 || enem < 1){
                            System.out.println("\nHaz marcado una opción inválida, intenta de nuevo");
                        } 
                    }while(enem > 2 || enem < 1);
                    System.out.println("\nBien hecho");
                    Vista vs = new Vista();
                    vs.Game();
                }
            }
        }

        if (ser == 3){
            Explorador ex = new Explorador();
            int vidaExplorador = ex.vidasExplorador();
            String nombreExplorador = ex.NombreExplorador();
            String mascota = ex.Acompanante();
            String poderExplorador = ex.PoderesExplorador();
            System.out.println("\nEmpezarás como " +  nombreExplorador + " y cuentas con " + vidaExplorador + " vidas,"
            + " tendrás ayuda de un acompañante, " + mascota);
            System.out.println(poderExplorador);
            do{
                System.out.println("\nPresiona 1 para continuar: ");
                op = scan.nextInt(); 
                if (op > 1 || op < 1){
                    System.out.println("\nHaz marcado una opción inválida, intenta de nuevo");
                }  
            }while(op > 1 || op < 1);

            do{
                Enemigo Enem = new Enemigo();
                EnemigoJefe enemJefe = new EnemigoJefe();
                EnemigoJefeRegular enemJefeR = new EnemigoJefeRegular();
                int vidaEnemigo =  Enem.vidasEnemigo(); 
                int vidaEnemigoJefe = enemJefe.vidasEnemigoJefe();
                String nombreEnemigoJefe = enemJefe.NombreEnemigoJefe();
                int vidaEnemigoJefeRegular = enemJefeR.vidasEnemigoJefeRegular();


                System.out.println("\nEstás en una batalla con el " + nombreEnemigoJefe +" acompañado de " + jugador + " enemigos o enemigos jefes regulares, lo único que puedes hacer es golpear y lanzar a tu mascota" +
                "\nCada enemigo cuenta con "+ vidaEnemigo +" vidas, cada enemigo jefe regular cuenta con " + vidaEnemigoJefeRegular + " vidas y el Enemigo Jefe cuenta con " + vidaEnemigoJefe + " vidas"  +
                " ¿Qué deseas hacer?" 
                + "\n1. Golpear \n2. Herir \n3. Matar \nSelecciona un número:"); 
                enem = scan.nextInt(); 
                if (enem > 2 || enem < 1){
                    System.out.println("\nHaz marcado una opción inválida, intenta de nuevo");
                } 
            }while(enem > 2 || enem < 1);
            do{
                System.out.println("\nSelecciona con un número al enemigo que deseas atacar:");
                golp = scan.nextInt();

                if (golp > jugador || golp < 1){
                    System.out.println("\nHaz marcado una opción inválida, intenta de nuevo");
                } 
            }while(golp > jugador || golp < 1);

            if (enem == 1){
                if (golp == 1){
                    Enemigo Enem = new Enemigo();
                    int vidaEnemigo = Enem.vidasEnemigo();
                    vidaEnemigo = vidaEnemigo - 2; 
                    System.out.println("\nEl enemigo " + golp + " ahora tiene " + vidaEnemigo  + " vidas");
    
                    if(varEnemigo == 1){
                        vidaExplorador = vidaExplorador - 1;
                        System.out.println("\nEl Jefe de los enemigos te ha herido dando veneno ahora tienes " + vidaExplorador + " vidas");
                    }
                    if(varEnemigo == 2){
                        vidaExplorador = vidaExplorador - 2;
                        System.out.println("\nEl Jefe de los enemigos te ha golpeado muy fuerte ahora tienes " + vidaExplorador + " vidas");
                    }
                    if(varEnemigo == 3){
                        vidaExplorador = vidaExplorador - 3;
                        System.out.println("\nEl Jefe de los enemigos te ha matado ahora tienes " + vidaExplorador + " vidas");
                        
                        Vista vs = new Vista();
                        vs.Game();
                    }
                    do{
                        System.out.println("Aún tienes una batalla con " + jugador + " enemigos ¿que deseas hacer?" +
                        "\nEl enemigo " + golp + " tiene " + vidaEnemigo + " vidas aún"
                        + "\n1. Golpear \n2. Herir  \n3. Matar \nSelecciona un número:");
                        enem = scan.nextInt();
                        if (enem > 2 || enem < 1){
                            System.out.println("\nHaz marcado una opción inválida, intenta de nuevo");
                        } 
                    }while(enem > 2 || enem < 1);
                    System.out.println("\nBien hecho");
                    Vista vs = new Vista();
                    vs.Game();
                }
                if (golp == 2){
                    EnemigoJefeRegular enemJefeR = new EnemigoJefeRegular();
                    int vidaEnemigoJefeRegular = enemJefeR.vidasEnemigoJefeRegular();
                    vidaEnemigoJefeRegular = vidaEnemigoJefeRegular - 2; 
                    System.out.println("\nEl enemigo jefe regular " + golp + " ahora tiene " + vidaEnemigoJefeRegular  + " vidas");
    
                    if(varEnemigo == 1){
                        vidaExplorador = vidaExplorador - 1;
                        System.out.println("\nEl Jefe de los enemigos te ha herido dando veneno ahora tienes " + vidaExplorador + " vidas");
                    }
                    if(varEnemigo == 2){
                        vidaExplorador = vidaExplorador - 2;
                        System.out.println("\nEl Jefe de los enemigos te ha golpeado muy fuerte ahora tienes " + vidaExplorador + " vidas");
                    }
                    if(varEnemigo == 3){
                        vidaExplorador = vidaExplorador - 3;
                        System.out.println("\nEl Jefe de los enemigos te ha matado ahora tienes " + vidaExplorador + " vidas");
                        
                        Vista vs = new Vista();
                        vs.Game();
                    }
                    do{
                        System.out.println("Aún tienes una batalla con " + jugador + " enemigos ¿que deseas hacer?" +
                        "\nEl enemigo jefe  regular " + golp + " tiene " + vidaEnemigoJefeRegular + " vidas aún"
                        + "\n1. Golpear \n2. Herir \n3. Matar \nSelecciona un número:");
                        enem = scan.nextInt();
                        if (enem > 2 || enem < 1){
                            System.out.println("\nHaz marcado una opción inválida, intenta de nuevo");
                        } 
                    }while(enem > 2 || enem < 1);
                    System.out.println("\nBien hecho");
                    Vista vs = new Vista();
                    vs.Game();
                }
                if (golp == 3){
                    EnemigoJefe enemJefe = new EnemigoJefe();
                    int vidaEnemigoJefe = enemJefe.vidasEnemigoJefe();
                    vidaEnemigoJefe = vidaEnemigoJefe - 2; 
                    System.out.println("\nEl enemigo jefe regular " + golp + " ahora tiene " + vidaEnemigoJefe  + " vidas");
    
                    if(varEnemigo == 1){
                        vidaExplorador = vidaExplorador - 1;
                        System.out.println("\nEl Jefe de los enemigos te ha herido dando veneno ahora tienes " + vidaExplorador + " vidas");
                    }
                    if(varEnemigo == 2){
                        vidaExplorador = vidaExplorador - 2;
                        System.out.println("\nEl Jefe de los enemigos te ha golpeado muy fuerte ahora tienes " + vidaExplorador + " vidas");
                    }
                    if(varEnemigo == 3){
                        vidaExplorador = vidaExplorador - 3;
                        System.out.println("\nEl Jefe de los enemigos te ha matado ahora tienes " + vidaExplorador + " vidas");
                        
                        Vista vs = new Vista();
                        vs.Game();
                    }
                    do{
                        System.out.println("Aún tienes una batalla con " + jugador + " enemigos ¿que deseas hacer?" +
                        "\nEl enemigo jefe " + golp + " tiene " + vidaEnemigoJefe + " vidas aún"
                        + "\n1. Golpear \n2. Herir \nSelecciona un número:");
                        enem = scan.nextInt();
                        if (enem > 2 || enem < 1){
                            System.out.println("\nHaz marcado una opción inválida, intenta de nuevo");
                        } 
                    }while(enem > 2 || enem < 1);
                    System.out.println("\nBien hecho");
                    Vista vs = new Vista();
                    vs.Game();
                }
            }
            if (enem == 2){
                if (golp == 1){
                    Enemigo Enem = new Enemigo();
                    int vidaEnemigo = Enem.vidasEnemigo();
                    vidaEnemigo = vidaEnemigo - 3; 
                    System.out.println("\nEl enemigo " + golp + " ahora tiene " + vidaEnemigo  + " vidas");
    
                    if(varEnemigo == 1){
                        vidaExplorador = vidaExplorador - 1;
                        System.out.println("\nEl Jefe de los enemigos te ha herido dando veneno ahora tienes " + vidaExplorador + " vidas");
                    }
                    if(varEnemigo == 2){
                        vidaExplorador = vidaExplorador - 2;
                        System.out.println("\nEl Jefe de los enemigos te ha golpeado muy fuerte ahora tienes " + vidaExplorador + " vidas");
                    }
                    if(varEnemigo == 3){
                        vidaExplorador = vidaExplorador - 3;
                        System.out.println("\nEl Jefe de los enemigos te ha matado ahora tienes " + vidaExplorador + " vidas");
                        
                        Vista vs = new Vista();
                        vs.Game();
                    }
                    do{
                        System.out.println("Aún tienes una batalla con " + jugador + " enemigos ¿que deseas hacer?" +
                        "\nEl enemigo " + golp + " tiene " + vidaEnemigo + " vidas aún"
                        + "\n1. Golpear \n2. Herir \n3. Matar \nSelecciona un número:");
                        enem = scan.nextInt();
                        if (enem > 2 || enem < 1){
                            System.out.println("\nHaz marcado una opción inválida, intenta de nuevo");
                        } 
                    }while(enem > 2 || enem < 1);
                    System.out.println("\nBien hecho");
                    Vista vs = new Vista();
                    vs.Game();
                }
                if (golp == 2){
                    EnemigoJefeRegular enemJefeR = new EnemigoJefeRegular();
                    int vidaEnemigoJefeRegular = enemJefeR.vidasEnemigoJefeRegular();
                    vidaEnemigoJefeRegular = vidaEnemigoJefeRegular - 3; 
                    System.out.println("\nEl enemigo jefe regular " + golp + " ahora tiene " + vidaEnemigoJefeRegular  + " vidas");
    
                    if(varEnemigo == 1){
                        vidaExplorador = vidaExplorador -1;
                        System.out.println("\nEl Jefe de los enemigos te ha herido dando veneno ahora tienes " + vidaExplorador + " vidas");
                    }
                    if(varEnemigo == 2){
                        vidaExplorador = vidaExplorador - 2;
                        System.out.println("\nEl Jefe de los enemigos te ha golpeado muy fuerte ahora tienes " + vidaExplorador + " vidas");
                    }
                    if(varEnemigo == 3){
                        vidaExplorador = vidaExplorador - 3;
                        System.out.println("\nEl Jefe de los enemigos te ha matado ahora tienes " + vidaExplorador + " vidas");
                        
                        Vista vs = new Vista();
                        vs.Game();
                    }
                    do{
                        System.out.println("Aún tienes una batalla con " + jugador + " enemigos ¿que deseas hacer?" +
                        "\nEl enemigo jefe  regular " + golp + " tiene " + vidaEnemigoJefeRegular + " vidas aún"
                        + "\n1. Golpear \n2. Herir \n3. Matar \nSelecciona un número:");
                        enem = scan.nextInt();
                        if (enem > 2 || enem < 1){
                            System.out.println("\nHaz marcado una opción inválida, intenta de nuevo");
                        } 
                    }while(enem > 2 || enem < 1);
                    System.out.println("\nBien hecho");
                    Vista vs = new Vista();
                    vs.Game();
                }
                if (golp == 3){
                    EnemigoJefe enemJefe = new EnemigoJefe();
                    int vidaEnemigoJefe = enemJefe.vidasEnemigoJefe();
                    vidaEnemigoJefe = vidaEnemigoJefe - 3; 
                    System.out.println("\nEl enemigo jefe regular " + golp + " ahora tiene " + vidaEnemigoJefe  + " vidas");
    
                    if(varEnemigo == 1){
                        vidaExplorador = vidaExplorador - 1;
                        System.out.println("\nEl Jefe de los enemigos te ha herido dando veneno ahora tienes " + vidaExplorador + " vidas");
                    }
                    if(varEnemigo == 2){
                        vidaExplorador = vidaExplorador - 2;
                        System.out.println("\nEl Jefe de los enemigos te ha golpeado muy fuerte ahora tienes " + vidaExplorador + " vidas");
                    }
                    if(varEnemigo == 3){
                        vidaExplorador = vidaExplorador - 3;
                        System.out.println("\nEl Jefe de los enemigos te ha matado ahora tienes " + vidaExplorador + " vidas");
                        
                        Vista vs = new Vista();
                        vs.Game();
                    }
                    do{
                        System.out.println("Aún tienes una batalla con " + jugador + " enemigos ¿que deseas hacer?" +
                        "\nEl enemigo jefe " + golp + " tiene " + vidaEnemigoJefe + " vidas aún"
                        + "\n1. Golpear \n2. Herir \n3. Matar \nSelecciona un número:");
                        enem = scan.nextInt();
                        if (enem > 2 || enem < 1){
                            System.out.println("\nHaz marcado una opción inválida, intenta de nuevo");
                        } 
                    }while(enem > 2 || enem < 1);
                    System.out.println("\nBien hecho");
                    Vista vs = new Vista();
                    vs.Game();
                }
            }
            
        }
    }

    public void Game(){
        System.out.println("\nEl juego a terminado");
        System.out.println("\nVolvemos al inicio");
        Vista vs = new Vista();
        vs.vista();
    }
}