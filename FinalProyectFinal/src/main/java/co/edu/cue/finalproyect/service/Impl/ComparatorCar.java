package co.edu.cue.finalproyect.service.Impl;

import co.edu.cue.finalproyect.model.Car;

import java.util.Comparator;

public class ComparatorCar implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        String type1=o1.getType();
        String type2=o2.getType();
        return  type1.compareTo(type2);
    }

}
