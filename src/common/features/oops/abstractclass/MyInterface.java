package common.features.oops.abstractclass;

public interface MyInterface {
    int p = 0; // These are by default final static

    default int sum(int a, int b) {
        return a + b;
    }

//    Can't have constructors but Abstract classes can have
//    public MyInterface() {
//
//    }

//    Can have public, private but protected are not allowed functions
    private void interfacePrivateFunction() {
        System.out.println("interface private function");
    }

//    protected void interfaceProtectedFunction() { // NOT ALLOWED
//        System.out.println("interface protected function");
//    }
}
