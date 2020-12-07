import java.util.Optional;

class Case<T> {
    Optional<ComputationAttrs<T>> fAttrs;
    Optional<ComputationAttrs<T>> gAttrs;

    public Case(ComputationAttrs<T> var1, ComputationAttrs<T> var2) {
        this.fAttrs = Optional.ofNullable(var1);
        this.gAttrs = Optional.ofNullable(var2);
    }
}