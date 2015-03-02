package com.cyberplays.sobermonitor;

public class Person {

    String name;
    int mult;

    public Person(String n, int m) {
        name = n;

        if (m<1)
            mult = 1;
        else
            mult = m;
    }

    protected void setName(String n) {
        name = n;
    }
    String getName() {
        return name;
    }

    protected void setMult(int m){
        mult = m;
    }
    int getMult() {
        return mult;
    }
}
