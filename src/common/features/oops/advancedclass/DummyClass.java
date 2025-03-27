package common.features.oops.advancedclass;

public class DummyClass implements Cloneable {
    public void displayNothing() {
        System.out.println("Nothing");
    }

    @Override
    public DummyClass clone() {
        try {
            return (DummyClass) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
