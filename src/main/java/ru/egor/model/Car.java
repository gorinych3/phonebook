package ru.egor.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Car {

    @Column(name = "moderCar")
    private String moderCar;

    @Column(name = "typeCar")
    private String typeCar;

    @Column(name = "colorCar")
    private String colorCar;

    public String getModerCar() {
        return moderCar;
    }

    public void setModerCar(String moderCar) {
        this.moderCar = moderCar;
    }

    public String getTypeCar() {
        return typeCar;
    }

    public void setTypeCar(String typeCar) {
        this.typeCar = typeCar;
    }

    public String getColorCar() {
        return colorCar;
    }

    public void setColorCar(String colorCar) {
        this.colorCar = colorCar;
    }

    @Override
    public String toString() {
        return "(" +
                "moder - '" + moderCar + '\'' +
                ", type - '" + typeCar + '\'' +
                ", color - '" + colorCar + '\'' +
                ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(moderCar, car.moderCar) &&
                Objects.equals(typeCar, car.typeCar) &&
                Objects.equals(colorCar, car.colorCar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moderCar, typeCar, colorCar);
    }
}
