package coms.java.lambda.main;

import coms.java.lambda.interfc.AreaInterFace;

public class Area {

    public static void main(String[] args) {

        AreaInterFace i1= (a -> {
            return ((22*a*a)/7);
        });
        System.out.println(i1.areaOfCircle(3));

        AreaInterFace i2= AreaInterFace::areaOfSquare;
        double v = i2.areaOfCircle(9);
        System.out.println(v);

    }
}
