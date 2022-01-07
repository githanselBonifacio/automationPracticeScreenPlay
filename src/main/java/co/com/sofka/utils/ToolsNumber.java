package co.com.sofka.utils;

import java.util.Random;

public class ToolsNumber {

    private ToolsNumber() {
    }

    public static int chooseRamdon(int max) {
        return new Random().nextInt(max);  // Valor entre Min y Max, ambos incluidos.
    }

    public static String generateNumberString(int lenght){
        StringBuilder str = new StringBuilder();
        for(int i=0;i<lenght;i++){
            str.append(chooseRamdon(9));
        }
        return str.toString();
    }
}
