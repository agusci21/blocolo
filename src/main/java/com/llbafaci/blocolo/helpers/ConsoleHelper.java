package com.llbafaci.blocolo.helpers;

import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    public void clearConsole() {
        System.out.print("\033[H\033[2J");
    }

    public void awaitForTap() {
        System.out.println("(Presione cualquier tecla para continuar)");
        try {
            new InputStreamReader(System.in, "UTF-8").read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
