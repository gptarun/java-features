package common.features.oops.abstractclass;

public class TestClass extends MyAbstractClass implements MyInterface {

    public TestClass(String val) {
        super(val);
    }

    @Override
    public void displayValue() {
        System.out.println("Yo! + " + MyInterface.p);
    }
}
