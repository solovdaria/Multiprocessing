//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import java.util.concurrent.TimeUnit;

public class Conjunction {
    static Case<?>[] cases;

    public Conjunction() {
    }

    public static boolean funcF(int var0) throws InterruptedException {
        Case var1 = cases[var0];
        return (Boolean)Configurations.genericFunc(var1.fAttrs);
    }

    public static boolean funcG(int var0) throws InterruptedException {
        Case var1 = cases[var0];
        return (Boolean)Configurations.genericFunc(var1.gAttrs);
    }

    static {
        cases = new Case[]{new Case(new ComputationAttrs(true, 1L, TimeUnit.SECONDS), new ComputationAttrs(true, 3L, TimeUnit.SECONDS)), new Case(new ComputationAttrs(true, 3L, TimeUnit.SECONDS), new ComputationAttrs(true, 1L, TimeUnit.SECONDS)), new Case(new ComputationAttrs(false, 3L, TimeUnit.SECONDS), (ComputationAttrs)null), new Case((ComputationAttrs)null, new ComputationAttrs(false, 3L, TimeUnit.SECONDS)), new Case(new ComputationAttrs(true, 1L, TimeUnit.SECONDS), (ComputationAttrs)null), new Case((ComputationAttrs)null, new ComputationAttrs(true, 1L, TimeUnit.SECONDS))};
    }
}
