package ir.otragh.core.domain.shared.valueobjects;

public record Money(int amount) {

    public static int zero = 0;

    public Money{
        if (amount < 0)
            throw new IllegalArgumentException("Money cannot be negative");
    }

    public static Money sum(Money first, Money second){
        return new Money(first.amount() + second.amount());
    }

    public boolean isZero(){
        return amount == zero;
    }
}
