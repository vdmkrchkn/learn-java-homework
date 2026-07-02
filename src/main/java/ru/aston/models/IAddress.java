package ru.aston.models;

public interface IAddress extends Cloneable {
    String getCity();
    void setCity(String city);
    IAddress clone();
}
