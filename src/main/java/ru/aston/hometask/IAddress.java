package ru.aston.hometask;

public interface IAddress extends Cloneable {
    String getCity();
    void setCity(String city);
    IAddress clone();
}
