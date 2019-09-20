package Offer;

public class IntegerPower {
    public double Power(double base, int exponent) {
        if (exponent == 0)
            return 1;
        double p = Power(base, exponent / 2);
        if (exponent % 2 == 0) {
            return p * p;
        } else {
            if (exponent < 0)
                return p * p * (1 / base);
            else if (exponent > 0)
                return p * p * base;
        }
        return 0;
    }
}
