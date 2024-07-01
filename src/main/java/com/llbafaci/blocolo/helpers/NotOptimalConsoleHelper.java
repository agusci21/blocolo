package com.llbafaci.blocolo.helpers;

public class NotOptimalConsoleHelper extends ConsoleHelper {
    @Override
    public void clearConsole(){
        for(int i = 0; i < 100; i++){
            System.out.println();
        }
    }
}
