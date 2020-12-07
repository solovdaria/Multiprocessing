import java.util.concurrent.TimeUnit;

class ComputationAttrs<R> {
    R result;
    long delay;
    TimeUnit timeUnit;

    public ComputationAttrs(R var1, long var2, TimeUnit var4) {
        this.delay = var2;
        this.timeUnit = var4;
        this.result = var1;
    }
}