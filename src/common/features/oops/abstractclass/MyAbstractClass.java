package common.features.oops.abstractclass;

// Q. Noting down why we need Abstract classes if we have Default functions in interface?
public abstract class MyAbstractClass {
    int x = 0; // These are not by-default final static like interface
    final static int y = 0;

    public abstract void displayValue();

    public void myFunction() {
    }

    public MyAbstractClass(String val) {
    }

//    Can have public, private & protected functions
    private void abstractPrivateFunction() {
        System.out.println("Abstract private function");
    }

    protected void abstractProtectedFunction() {
        System.out.println("Abstract protected function");
    }
}
