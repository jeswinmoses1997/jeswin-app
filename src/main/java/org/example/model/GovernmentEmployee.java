package org.example.model;

public interface GovernmentEmployee {
    default int getBonusPercentage(){
        return 5;
    }
}
