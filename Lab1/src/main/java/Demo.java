import gcd.extendedeuclidean.ExtendedEuclidean;
import gcd.extendedeuclidean.ExtendedEuclideanResult;

import java.math.BigInteger;

public class Demo {
    public static void main(String[] args) {
        ExtendedEuclideanResult res=ExtendedEuclidean.compute(new BigInteger("21"),new BigInteger("17"));
        System.out.println(res.getBezoutX() );
        System.out.println(res.getBezoutY() );
        System.out.println(res.getGcd() );
    }
}
