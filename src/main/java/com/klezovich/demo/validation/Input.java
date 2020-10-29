package com.klezovich.demo.validation;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.List;

public class Input {

    @Min(1)
    @Max(10)
    private int numberBetweenOneAndTen=5;

    @Pattern(regexp = "^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$")
    private String ipAddress="1.1.1.1";

    @AssertTrue
    private boolean isValid=true;

    @Email
    private String email="abc@yandex.ru";

    @AllListElementsAreTenConstraint
    private List<Integer> myInts = List.of(10);

    public Input() {}

    public Input(
        int numberBetweenOneAndTen,
        String ipAddress
    ) {
        this.numberBetweenOneAndTen = numberBetweenOneAndTen;
        this.ipAddress = ipAddress;
    }

    public int getNumberBetweenOneAndTen() {
        return numberBetweenOneAndTen;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Integer> getMyInts() {
        return myInts;
    }

    public void setMyInts(List<Integer> myInts) {
        this.myInts = myInts;
    }
}
