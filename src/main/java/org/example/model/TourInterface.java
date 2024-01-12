package org.example.model;

import java.io.Closeable;

public interface TourInterface extends Closeable {
    String getName();
    int getDays();
    int getCost();
}
