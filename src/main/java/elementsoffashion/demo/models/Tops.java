package elementsoffashion.demo.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Tops {

    @Id
    @GeneratedValue
    private Long id;
    private String topType;
    private String color;
    private String size;
    @Lob
    private String topImg;
    @ElementCollection
    private Collection<String> weather;

    public Long getId() {
        return id;
    }

    public String getTopType() {
        return topType;
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

    public String getTopImg() {
        return topImg;
    }

    public void setTopType(String topType) {
        this.topType = topType;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setTopImg(String topImg) {
        this.topImg = topImg;
    }

    public void setWeather(Collection<String> weather) {
        this.weather = weather;
    }

    public Tops(){
    }

    public Tops(String topType,  String color, String size, String topImg, String ...weather) {
        this.topType = topType;
        this.color = color;
        this.size = size;
        this.topImg = topImg;
        this.weather= new ArrayList<>(Arrays.asList(weather));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tops tops = (Tops) o;
        return Objects.equals(id, tops.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

