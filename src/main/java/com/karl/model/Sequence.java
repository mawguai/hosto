package com.karl.model;

public class Sequence {

    private String name;
    private String sequence;

    public Sequence(String name, String sequence) {
        this.name = name;
        this.sequence = sequence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    @Override
    public String toString() {
        return "Sequence{" +
                "name='" + name + '\'' +
                ", sequence='" + sequence + '\'' +
                '}';
    }
}
