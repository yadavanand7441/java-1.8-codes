package coms.java.lambda.interfc;
@FunctionalInterface
public interface AreaInterFace {

     double areaOfCircle(double a);
     public static double areaOfSquare(double a)
     {
          a=5;
          double areaOfSquare= a*a;
          return areaOfSquare;
     }

}
