package co.com.sofka.utils;

public enum PathFile {
    ACCESS_CREDENTIALS_LOGIN(System.getProperty("user.dir")+
            "\\src\\test\\resources\\files\\users\\accessCredentialsLogin.Json");

    private final String value;


    PathFile(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
