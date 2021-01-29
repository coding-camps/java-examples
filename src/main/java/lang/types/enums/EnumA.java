package lang.types.enums;

public enum EnumA {
    // t1
    T1,
    // t2
    T2;

    public void doSth() {
        System.out.println(this.name() + ": do something. -> " + this.ordinal());
    }

    public static void doStaticSth() {
        System.out.println(EnumA.class.getName() + ": do static something.");
    }

}
