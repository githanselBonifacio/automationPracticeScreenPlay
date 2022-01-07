package co.com.sofka.utils;

import co.com.sofka.models.Account;
import co.com.sofka.models.Credential;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static co.com.sofka.utils.PathFile.ACCESS_CREDENTIALS_LOGIN;
import static co.com.sofka.utils.UtilFile.*;

public class AdminCredential {

    public static final Logger logger = LogManager.getLogger(AdminCredential.class);

    private AdminCredential() {
    }

    public static String uptateAccessCredentialUser(Account account){
        String json = readJson(ACCESS_CREDENTIALS_LOGIN.getValue());

        DocumentContext context = JsonPath.parse(json, config);
        context.set("$.email",account.getEmail());
        context.set("$.password", account.getPassword());
        context.set("$.firstName", account.getFirstName());
        context.set("$.lastName", account.getLastName());

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ACCESS_CREDENTIALS_LOGIN.getValue()))) {
            bw.write(context.jsonString());
            logger.info("credentials have been updated");
        } catch (IOException ex) {
            Logger.getLogger(UtilFile.class.getName());
        }

        return context.jsonString();
    }

    public static Map<String,String> readAccessCredentialUser(){
        Map<String,String> map = new HashMap<>();
        String json = readJson(ACCESS_CREDENTIALS_LOGIN.getValue());

        DocumentContext context = JsonPath.parse(json, config);
        map.put("email",context.read("$.email").toString());
        map.put("password",context.read("$.password").toString());
        map.put("firstName",context.read("$.firstName").toString());
        map.put("lastName",context.read("$.lastName").toString());

        return map;
    }
    public static Credential getCredential(){
        Map<String,String> mapCredential = readAccessCredentialUser();

        return new Credential(cleanString(mapCredential.get("firstName")),
                              cleanString(mapCredential.get("lastName")),
                              cleanString(mapCredential.get("email")),
                              cleanString(mapCredential.get("password")));
    }
}
