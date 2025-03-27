package common.features.innerclasses;

public class NonStaticInnerMain {
    int i = 0;
    static int j = 0;

    NonStaticInner nonStaticInner = new NonStaticInner();

    public NonStaticInnerMain() {
    }

    public void outclassStringPrint() {
        System.out.println("Outer Class here!");
        NonStaticInner nonStaticTest = new NonStaticInner();
        nonStaticTest.printNonStaticInnerClassDetails();
        nonStaticInner.printNonStaticInnerClassDetails();
    }

    public static void main(String[] args) {
        NonStaticInnerMain nonStaticInnerMain = new NonStaticInnerMain();
        nonStaticInnerMain.outclassStringPrint();
        // Below scenario is not possible, compilation error
        // NonStaticTest nonStaticTest = new nonStaticInnerMain();
    }

    class NonStaticInner {
        public NonStaticInner() {
        }

        void printNonStaticInnerClassDetails() {
            System.out.println("Non Static Inner class");
            System.out.println(j);
            System.out.println(i);
        }
    }
}
