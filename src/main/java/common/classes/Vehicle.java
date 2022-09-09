package common.classes;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Vehicle implements Serializable {
    private Integer id;
    private String name;
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer enginePower; //Поле не может быть null
    private Integer capacity; //Поле не может быть null
    private FuelType fuelType; //Поле может быть null

    public Integer getId() {
        return id;
    }
    public Float getCoordinateX() {
        return coordinates.getX();
    }
    public Long getCoordinateY(){return coordinates.getY();}
    public Integer getCapacity() {
        return capacity;
    }
    public Integer getEnginePower() {
        return enginePower;
    }
    public LocalDateTime getCreationDate() {
        return creationDate;
    }
    public String getName() {
        return name;
    }
    public FuelType getFuelType(){return fuelType;}

    public Vehicle(Integer id, String name, Coordinates coordinates, java.time.LocalDateTime creationDate, Integer enginePower, Integer capacity, FuelType type){
        this.capacity=capacity;
        this.name=name;
        this.coordinates=coordinates;
        this.id=id;
        this.creationDate=creationDate;
        this.enginePower=enginePower;
        this.fuelType=type;

    }

}