package elementsoffashion.demo.models;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Bottoms {


    @Id
    @GeneratedValue
    private Long id;
    private String bottomType;
    private String color;
    private String size;
    @Lob
    private String bottomImg;
    @ElementCollection
    private Collection<String> weather;


    public Long getId() {
        return id;
    }

    public String getBottomType() {
        return bottomType;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public String getBottomImg() {
        return bottomImg;
    }

    public Collection<String> getWeather() {
        return weather;
    }

    public void setBottomType(String bottomType) {
        this.bottomType = bottomType;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setBottomImg(String bottomImg) {
        this.bottomImg = bottomImg;
    }

    public void setWeather(Collection<String> weather) {
        this.weather = weather;
    }

    public Bottoms() {
    }

    public Bottoms(String bottomType, String color, String size, String bottomImg, String... weather) {
        this.bottomType = bottomType;
        this.bottomImg = bottomImg;
        this.color = color;
        this.size = size;
        this.weather = new ArrayList<>(Arrays.asList(weather));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bottoms bottoms = (Bottoms) o;
        return Objects.equals(id, bottoms.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
