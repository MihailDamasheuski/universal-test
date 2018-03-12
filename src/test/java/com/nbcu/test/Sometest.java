package com.nbcu.test;

import com.google.inject.*;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Sometest {
    @Inject
    @Named("Adapter.Url")
    private String host;

    public String getHost() {
        return host;
    }

    public static void main(String[] args) {
    }
}
