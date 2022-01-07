package co.com.sofka.utils;

public enum Title {
    MR(1),
    MRS(2);

    private final int value;

    public int getValue() {
        return value;
    }

    Title(int value) {
        this.value = value;
    }

}
