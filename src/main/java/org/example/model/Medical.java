package org.example.model;

import java.io.Closeable;
import java.io.IOException;

public class Medical implements Purchase, Closeable {
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
    public void setClaim(int claim) throws InvalidClaimException {
        this.claim = claim;
        if (claim<100){
            throw new IllegalArgumentException();
        }
    }
    @Override
    public void close() throws IOException {
        System.out.println("from close medical");
    }
}
