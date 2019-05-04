package designpatterns.strategypattern;

public class StrategyPatternJava {
    public static void main(String[] args) {
        Context context = new Context(new Add());
        int sum = context.use(2, 3);

        Context context1 = new Context(new Multiply());
        int mul = context1.use(2, 3);
        System.out.print("Java Strategy" +
                sum + " " + mul);
    }
}

interface Strategy {
    int compute(int a, int b);
}

class Add implements Strategy {
    public int compute(int a, int b) {
        return a + b;
    }
}

class Multiply implements Strategy {
    public int compute(int a, int b) {
        return a * b;
    }
}

class Context {
    final Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int use(int a, int b) {
        return strategy.compute(a, b);
    }
}
