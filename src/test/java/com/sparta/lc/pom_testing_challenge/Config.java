package com.sparta.lc.pom_testing_challenge;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final Properties properties = new Properties();


    static {
        try (InputStream inputStream = Config.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new IOException("Unable to find config.properties");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getLoginURL(){
        return properties.getProperty("login_URL");
    }

    public static String getProductsURL(){
        return properties.getProperty("products_URL");
    }

    public static String getCartURL(){
        return properties.getProperty("cart_URL");
    }

    public static String getCheckoutStepOneURL(){
        return properties.getProperty("checkout_step_one_URL");
    }

    public static String getCheckoutStepTwoURL(){
        return properties.getProperty("checkout_step_two_URL");
    }

    public static String getCheckoutFinalStepURL(){
        return properties.getProperty("checkout_final_step_URL");
    }

    public static String getIndividualProductBaseURL(){
        return properties.getProperty("individual_product_Base_URL");
    }

    public static String getStandardUser(){
        return properties.getProperty("standard_user");
    }

    public static String getLockedOutUser(){
        return properties.getProperty("locked_out_user");
    }

    public static String getProblemUSer(){
        return properties.getProperty("problem_user");
    }

    public static String getPerformanceGlitchUser(){
        return properties.getProperty("performance_glitch_user");
    }

    public static String getMasterPassword(){
        return properties.getProperty("master_password");
    }
}
