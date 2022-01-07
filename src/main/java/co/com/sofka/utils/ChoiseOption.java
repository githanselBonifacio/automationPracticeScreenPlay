package co.com.sofka.utils;


import java.util.Random;

public class ChoiseOption {
    private final Object [] option;

    public ChoiseOption(Object [] option) {
        this.option = option;
    }

    public Object selectOptionRandon(){
        Random random = new Random();
        return option[random.nextInt(option.length)];
    }
    public static ChoiseOption choiseOption(Object [] option){
        return new ChoiseOption(option);
    }
}
