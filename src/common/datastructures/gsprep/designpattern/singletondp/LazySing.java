package common.datastructures.gsprep.designpattern.singletondp;

public class LazySing {
    private static LazySing lazySing;

    private LazySing() {
    }

    public LazySing getLazySing() {
        if (lazySing == null) {
            synchronized (LazySing.class) {
                return new LazySing();
            }
        }
        return lazySing;
    }
}
