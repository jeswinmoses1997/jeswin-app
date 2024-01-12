package org.example.model;

import java.io.Closeable;
import java.io.IOException;

public class Accessories implements Purchase, Closeable {
   String name;
   int claim;
    @Override
    public String getProductName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public int claim() {
        return claim;
    }
    public void setClaim(int claim) {
        this.claim = claim;
    }

    @Override
    public void close() throws IOException {
        System.out.println("from close accessories");
    }
}
