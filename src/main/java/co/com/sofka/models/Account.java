package co.com.sofka.models;

import co.com.sofka.utils.ChoiseOption;
import co.com.sofka.utils.Title;
import com.github.javafaker.Faker;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static co.com.sofka.utils.ChoiseOption.choiseOption;
import static co.com.sofka.utils.ToolsNumber.generateNumberString;

public class Account {
    private Title title;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate dateBirth;
    private String company;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String postalCode;
    private String aditionalInformation;
    private String homePhone;
    private String mobilePhone;
    private String addressAlias;

    private static final int  MIN_PASSWORD_LENGHT = 8;
    private static final int MAX_PASSWORD_LENGHT = 15;

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAditionalInformation() {
        return aditionalInformation;
    }

    public void setAditionalInformation(String aditionalInformation) {
        this.aditionalInformation = aditionalInformation;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getAddressAlias() {
        return addressAlias;
    }

    public void setAddressAlias(String addressAlias) {
        this.addressAlias = addressAlias;
    }

    public static Account cretedFullAccount(){
        Faker faker = new Faker();
        Account account = new Account();

        ChoiseOption optionTitle =  choiseOption(new Title[]{Title.MR, Title.MRS});
        account.setTitle((Title) optionTitle.selectOptionRandon());

        account.setFirstName(faker.name().firstName());
        account.setLastName(faker.name().lastName());

        account.setCompany(faker.company().name());

        account.setEmail(faker.internet().emailAddress());
        account.setPassword(faker.internet().password(MIN_PASSWORD_LENGHT, MAX_PASSWORD_LENGHT));

        Date dateBirth = faker.date().birthday();
        LocalDate localDateBirth = dateBirth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        account.setDateBirth(localDateBirth);

        account.setAddress(faker.address().streetAddress());

        account.setAddress2(faker.address().secondaryAddress());

        account.setCity(faker.address().cityName());

        account.setState(faker.address().state());

        account.setAditionalInformation(faker.lorem().paragraph());

        account.setHomePhone(faker.phoneNumber().phoneNumber());

        account.setMobilePhone(faker.phoneNumber().cellPhone());

        account.setPostalCode(generateNumberString(5));

        account.setAddressAlias(faker.funnyName().name());

        return account;
    }

    @Override
    public String toString() {
        return "Account{" +
                "title=" + title +"\n"+
                ", firstName='" + firstName + "\n" +
                ", LastName='" + lastName + "\n" +
                ", email='" + email + "\n" +
                ", password='" + password + "\n" +
                ", DateBirth=" + dateBirth + "\n" +
                ", company='" + company + "\n" +
                ", address='" + address + "\n" +
                ", Address2='" + address2 + "\n" +
                ", city='" + city + "\n" +
                ", state='" + state + "\n" +
                ", postalCode='" + postalCode + "\n" +
                ", aditionalInformation='" + aditionalInformation + "\n" +
                ", homePhone='" + homePhone + "\n" +
                ", mobilePhone='" + mobilePhone + "\n" +
                ", addressAlias='" + addressAlias + "\n" +
                ", MIN_PASSWORD_LENGHT=" + MIN_PASSWORD_LENGHT +
                ", MAX_PASSWORD_LENGHT=" + MAX_PASSWORD_LENGHT +
                '}';
    }
}
