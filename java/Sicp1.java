import java.util.function.*;

class Sicp1_x {
    public static double square(double x) {return x*x;}
    
    public static double average(double x, double y) {return (x+y)/2;}
    
    public static boolean isGoodEnough(double guess, double x) { 
        return Math.abs(x-square(guess))<=0.001;
    }
    public static double improveGuess(double guess, double x) {return average(guess, x/guess);}

    public static double sqrtIter(double guess, double x) {
        if(isGoodEnough(guess,x))
            return guess;
        else
            return sqrtIter( improveGuess(guess,x), x);
    }

    public static double sqrt(double x) { 
        return sqrtIter(1,x);
    }
}

class CubicRoot {
    // java does not support recursive lambdas :( so we have to cheat
    static BiFunction<Double,Double,Double> sqrtIter;
    
    public static double cubicRoot(Double xx) {
        Function<Double,Double> square      = (x)->x*x;
        Function<Double,Double> cube        = (x) -> x*x*x ;
        BiFunction<Double,Double,Double> average         = (x, y) -> (x+y)/2;
        BiFunction<Double,Double,Boolean> isGoodEnough    = (guess, x) -> Math.abs(x-cube.apply(guess))<=0.001;
        BiFunction<Double,Double,Double> improveGuess    = (guess, x) -> (x/square.apply(guess)+2*guess)/3 ;
        
        sqrtIter = (guess,  x) -> isGoodEnough.apply(guess,x) ? guess : sqrtIter.apply( improveGuess.apply(guess,x), x);
        return sqrtIter.apply(1.0,xx);        
    }
}
public class Sicp1 {
    public static void main(String args[]) {
        double arg=Double.parseDouble(args[0]);
        System.out.println( Sicp1_x.sqrt(arg) );
        System.out.println( CubicRoot.cubicRoot(arg) );
    }
}