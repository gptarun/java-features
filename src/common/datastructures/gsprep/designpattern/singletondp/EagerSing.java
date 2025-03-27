package common.datastructures.gsprep.designpattern.singletondp;

public class EagerSing {
    private static final EagerSing EAGER_SING = new EagerSing();

    private EagerSing() {
    }

    public EagerSing getEagerSing() {
        return EAGER_SING;
    }
}
