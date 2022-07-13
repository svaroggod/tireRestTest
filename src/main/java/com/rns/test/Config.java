package com.rns.test;

public interface Config {

    String DB_CONN_URL = System.getenv("DB_CONN_URL");
    String DB_CONN_USERNAME =System.getenv("DB_CONN_USERNAME");
    String DB_CONN_PASSWORD = System.getenv("DB_CONN_PASSWORD");

}
