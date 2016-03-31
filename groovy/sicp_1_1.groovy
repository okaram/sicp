
double square(double x) {return x*x;}
double average(double x, double y) {return (x+y)/2;}
boolean isGoodEnough(double guess, double x) { 
    return Math.abs(x-square(guess))<=0.001;
}
double improveGuess(double guess, double x) {return average(guess, x/guess);}

@groovy.transform.TailRecursive
double sqrtIter(double guess, double x) {
    if(isGoodEnough(guess,x))
        return guess;
    else
        return sqrtIter( improveGuess(guess,x), x);
}

double sqrt(double x) { 
    return sqrtIter(1,x);
}

double sqrt2(double xx) {
    def square          = { double x -> x*x}
    def average         = { double x, double y -> (x+y)/2}
    def isGoodEnough    = { double guess, double x -> Math.abs(x-square(guess))<=0.001}
    def improveGuess    = { double guess, double x -> average(guess, x/guess) }
    def sqrtIter // needed for recursion
    sqrtIter        = { double guess, double x -> isGoodEnough(guess,x) ? guess : sqrtIter( improveGuess(guess,x), x)}.trampoline()
    
    sqrtIter(1,xx);
}

double cubicRoot(double xx) {
    def square          = { double x -> x*x }
    def cube            = {double x -> x*x*x }
    def average         = { double x, double y -> (x+y)/2}
    def isGoodEnough    = { double guess, double x -> Math.abs(x-cube(guess))<=0.001}
    def improveGuess    = { double guess, double x -> (x/square(guess)+2*guess)/3 }
    def sqrtIter // needed for recursion
    sqrtIter        = {  guess,  x -> isGoodEnough(guess,x) ? guess : sqrtIter( improveGuess(guess,x), x)}.trampoline()
    
    sqrtIter(1.0,xx);
}

double arg=Double.parseDouble(args[0])
//println(sqrt2(arg))
println(cubicRoot(arg))