package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("Client avviato");

        // Creo una socket con la porta a cui collegarmi
        Socket s = new Socket("localhost", 3000);
        System.out.println("Client connesso");

        // creo le due istruzioni in/out
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        //implemento un ciclo do while per far si che il client inserisca la stringa,
        //il serve risponde, il client decide se continuare ad inserire o uscire.
        do{
            System.out.println("Inserisci la stringa: ");

        // INPUT  -- Scanner scan = new Scanner(System.in);
        // lettura stringa String stringaDigitata = scan.nextLine();
          Scanner scan = new Scanner(System.in);
          String stringDigitata = scan.nextLine();

        //faccio un if in modo che il client possa scegliere quando uscire digitando una parola
        if ( stringDigitata.equals("exit")){
            System.out.println("Uscita dal server");

            //out.writeBytes("!\n") per "comunicare" al server che il client sta terminando
            out.writeBytes("!\n");
            break;
        }

        out.writeBytes(stringDigitata + "\n");
        String stringRicevuta = in.readLine();
        System.out.println("Il server ha risposto: " + stringRicevuta); 


        //true per avere un ciclo infinito   
        }while (true);  



    }
}