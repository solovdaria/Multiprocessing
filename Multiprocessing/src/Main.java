//package main;

import java.util.Scanner;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import java.io.*;
import java.net.*;
import java.util.logging.*;


public class Main {
    public static Process processF;
    public static Process processG;

    public static void terminate() {
        processF.destroy();
        processG.destroy();
    }

    public static void resultsInZero(String funcName) {
        System.out.println(funcName + " finished with zero value. Process is terminated.");
        terminate();
        System.exit(0);
    }

  /*  public static int conj(int f, int g)
    {
        if (f==0 && g==0) return 0;
        else if (f==0 && g==1) return 0;
        else if (f==1 && g==0) return 0;
        else return 1;
    }

    public static int dis(int f, int g)
    {
        if (f==0 && g==0) return 0;
        else if (f==0 && g==1) return 1;
        else if (f==1 && g==0) return 1;
        else return 1;
    }*/

    public static void main(String[] args) {

        //int test = Integer.parseInt("6");
        Scanner console = new Scanner(System.in);
        int test = console.nextInt();

        System.out.println("Press '0' at any time to cancel computation.");
        KeyListener listener = null;

        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);
        logger.setUseParentHandlers(false);
        try {
            GlobalScreen.registerNativeHook();
            listener = new KeyListener();
            GlobalScreen.addNativeKeyListener(listener);
        } catch (NativeHookException ex) {
            System.err.println(ex.getMessage());
        }

        try {
            ServerSocket manager = new ServerSocket(2323);

            ProcessBuilder pbF = new ProcessBuilder("java", "FuncF");
            pbF.directory(new File("C:\\Users\\user\\IdeaProjects\\Multiprocessing\\out\\production\\Multiprocessing"));
            processF = pbF.start();
            ProcessBuilder pbG = new ProcessBuilder("java", "FuncG");
            pbG.directory(new File("C:\\Users\\user\\IdeaProjects\\Multiprocessing\\out\\production\\Multiprocessing"));
            processG = pbG.start();

            Socket socketF = manager.accept();
            Socket socketG = manager.accept();
            DataOutputStream outputF = new DataOutputStream(socketF.getOutputStream());
            outputF.writeUTF(Integer.toString(test));
            DataOutputStream outputG = new DataOutputStream(socketG.getOutputStream());
            outputG.writeUTF(Integer.toString(test));

            DataInputStream inputF = new DataInputStream(socketF.getInputStream());
            DataInputStream inputG = new DataInputStream(socketG.getInputStream());;

            int resultOfF = -1;
            int resultOfG = -1;

            while(true) {
                if (inputF.available() > 0 && resultOfF == -1) {
                    resultOfF = inputF.readByte();
                    listener.f_is = resultOfF;
                    if (resultOfF == 0) {
                        resultsInZero("F");
                        break;
                    }
                    System.out.println("F is done");
                }

                if (inputG.available() > 0 && resultOfG == -1) {
                    resultOfG = inputG.readByte();
                    listener.g_is = resultOfG;
                    if (resultOfG == 0) {
                        resultsInZero("G");
                        break;
                    }
                    System.out.println("G is done");
                }

                if (resultOfF > 0 && resultOfG >0) break;
            }
            System.out.print("\nResult: \n" + ("F: " + resultOfF + "\nG: " + resultOfG) + "\n" );
         //   System.out.println("Conjunction: " + (conj(resultOfF, resultOfG)));
          //  System.out.println("Disjunction: " + (dis(resultOfF, resultOfG)));

            inputF.close();
            inputG.close();
            terminate();
            socketF.close();
            socketG.close();
            manager.close();
            GlobalScreen.unregisterNativeHook();
        } catch (IOException e) {
            System.out.println(e);
        } catch (NativeHookException e) {
            e.printStackTrace();
        }
    }
}
