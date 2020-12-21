package bean;

import model.Point;
import service.PointService;


import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;


@Named("controller")
@SessionScoped
public class ControllerBean implements Serializable {

    @Inject
    @Named("service.PointServiceJPA")
    private PointService pointService;

    private List<Point> items;
    private Point item;
private Double test;
    public ControllerBean() {}

    private final double[] rValues = {1, 2, 3, 4, 5};

    private boolean validate(double x, double y, double r) {
        boolean checkX =  x >= -2 && x <= 2;
        boolean checkY = y >= -5 && y <= 5;
        boolean checkR = java.util.Arrays.binarySearch(rValues, r) > -1;
        return checkX && checkY && checkR;
    }

    @PostConstruct
    public void init() {
        item = new Point();
    }


    public void addItem() {
        System.out.println(this.getTest());
        if (validate(this.item.getX(), this.item.getY(), this.item.getR())) {
            System.out.println(this.item.getX());
            this.item.calculateArea();
            this.pointService.create(this.item);
            this.item.setId(null);
        }
    }

    public List<Point> getItems() {
        List<Point> list = this.pointService.findAll();
        list.sort((left, right) -> (int) (left.getId() - right.getId()));
        Collections.reverse(list);
        return list;
    }

    public void deleteTable(){
        this.pointService.deleteAll();
    }


    public Point getItem() {
        return item;
    }

    public void setItem(Point item) {
        this.item = item;
    }

    public Double getTest() {
        return test;
    }

    public void setTest(Double test) {
        this.test = test;
    }
}
