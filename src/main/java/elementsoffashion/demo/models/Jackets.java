package elementsoffashion.demo.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Jackets {

    @Id
    @GeneratedValue
    private Long id;
    private String jacketType;
    private String color;
    private String size;
    @ElementCollection
    private Collection<String> weather;
    @Lob
    private String jacketImg;

    public Jackets() {
    }

    public Jackets(String jacketType, String color, String size, String jacketImg, String... weather) {
        this.jacketType = jacketType;
        this.color = color;
        this.size = size;
        this.jacketImg = jacketImg;
        this.weather = new ArrayList<>(Arrays.asList(weather));
    }

    public void setJacketType(String jacketType) {
        this.jacketType = jacketType;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setWeather(Collection<String> weather) {
        this.weather = weather;
    }

    public void setJacketImg(String jacketImg) {
        this.jacketImg = jacketImg;
    }

    public Long getId() {
        return id;
    }

    public String getJacketType() {
        return jacketType;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public Collection<String> getWeather() {
        return weather;
    }

    public String getJacketImg() {
        return jacketImg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jackets jackets = (Jackets) o;
        return Objects.equals(id, jackets.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}