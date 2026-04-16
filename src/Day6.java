import java.util.HashMap;

public class Day6 {

    static HashMap<Long, Long> cache= new HashMap<>();

    public static int factorial(int num){
        if(num <= 1)
            return 1;
        return num* factorial(num -1);
    }
    public static Long findFibonacciNumber(Long fibonacciNumber){

        if(fibonacciNumber == 0 || fibonacciNumber == 1 )
            return fibonacciNumber;
        return (findFibonacciNumber(fibonacciNumber -1) + findFibonacciNumber(fibonacciNumber -2));
    }

    public static Long findFibonacciNumberOptimised(Long fibonacciNumber){
        if(cache.containsKey(fibonacciNumber))
            return cache.get(fibonacciNumber);
        if(fibonacciNumber == 0 || fibonacciNumber == 1 )
            return fibonacciNumber;
        Long fib = (findFibonacciNumberOptimised(fibonacciNumber -1) + findFibonacciNumberOptimised(fibonacciNumber -2));
        cache.put(fibonacciNumber, fib);
        return fib;
    }

    public static  void main(String[] args){
        int num = 4;
        System.out.println("Factorial of " + num + " is " + factorial(num));
        long fibonacciNumber = 50;
//        System.out.println("Fibonacci at " + fibonacciNumber + " is " + findFibonacciNumber(fibonacciNumber));
        System.out.println("Fibonacci at " + fibonacciNumber + " is " + findFibonacciNumberOptimised(fibonacciNumber));
    }
}
