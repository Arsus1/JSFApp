package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "points")
public class Point implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "x")
    private Double x = 0.0;

    @Column(name = "y")
    private Double y;

    @Column(name = "r")
    private Double r;

    @Column(name = "hit")
    private Boolean hit;

    @Column(name = "time")
    private Double time;


    public Point(){}

    public Point(double x, double y, double r){
        this.x = x;
        this.y = y;
        this.r = r;

        long startTime = System.nanoTime();
        this.hit = checkArea(this.x, this.y, this.r);
        long endTime = System.nanoTime();

        this.time = ((double) (endTime - startTime) / 10000000);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getR() {
        return r;
    }

    public void setR(Double r) {
        this.r = r;
    }

    public Boolean getHit() {
        return hit;
    }

    public void setHit(Boolean hit) {
        this.hit = hit;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }



    private boolean checkArea(double x, double y, double r){
        // Checks triangle area
        if (x <= 0 && y <= 0 && x/2+ y >= -r/2) {
            return true;
        }
        // Checks rectangle area
        if (x >= 0 && y <= 0 && y >= - r/2   && x<= r) {
            return true;
        }
        // Checks circle area
        if (x >= 0 && y >= 0 && x * x + y *y <= (r/2) *( r/2)) {
            return true;
        }
        return false;
    }

    public void calculateArea(){
        long startTime = System.nanoTime();
        this.hit = checkArea(this.x, this.y, this.r);
        long endTime = System.nanoTime();

        this.time = ((double) (endTime - startTime) / 10000000);
    }
}