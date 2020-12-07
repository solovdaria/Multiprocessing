//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class Configurations {
    public Configurations() {
    }

    public static <R> Optional<R> flatGenericFunc(R var0, long var1, TimeUnit var3) {
        try {
            var3.sleep(var1);
        } catch (InterruptedException var5) {
            return Optional.empty();
        }

        return Optional.of(var0);
    }

    public static <R> Optional<R> flatGenericFunc(ComputationAttrs<R> var0) {
        return flatGenericFunc(var0.result, var0.delay, var0.timeUnit);
    }

    public static <R> R genericFunc(Optional<ComputationAttrs<R>> var0) throws InterruptedException {
        return Optional.ofNullable(var0.orElseGet(() -> {
            try {
                Thread.currentThread().join();
            } catch (InterruptedException var1) {
            }

            return null;
        })).flatMap(Configurations::flatGenericFunc).orElseThrow(() -> {
            return new InterruptedException();
        });
    }
}
