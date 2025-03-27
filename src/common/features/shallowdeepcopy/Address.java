package common.features.shallowdeepcopy;

public class Address implements Cloneable {
    int id;

    @Override
    public Address clone() {
        try {
            return (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
