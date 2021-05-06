package elementsoffashion.demo.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Shoes {

    @Id
    @GeneratedValue
    private Long id;
    private String shoeMake;
    private String shoeModel;
    private String color;
    private String size;
    @ElementCollection
    private Collection<String> weather;
    @Lob
    private String shoeImg;

    public Shoes( String shoeMake, String shoeModel, String color, String size, String shoeImg, String... weather) {
        this.shoeMake = shoeMake;
        this.shoeModel = shoeModel;
        this.color = color;
        this.size = size;
        this.shoeImg = shoeImg;
        this.weather= new ArrayList<>(Arrays.asList(weather));
    }

    public Shoes() {
    }

    public Long getId() {
        return id;
    }

    public String getShoeMake(){
        return shoeMake;
    }

    public String getShoeModel(){
        return shoeModel;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public String getShoeImg() {
        return shoeImg;
    }

    public void setShoeMake(String shoeMake) {
        this.shoeMake = shoeMake;
    }

    public void setShoeModel(String shoeModel) {
        this.shoeModel = shoeModel;
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

    public void setShoeImg(String shoeImg) {
        this.shoeImg = shoeImg;
    }
}
