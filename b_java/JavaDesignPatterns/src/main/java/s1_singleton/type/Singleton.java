package s1_singleton.type;

/**
 * 枚举 - 推荐使用
 */
public enum Singleton {
    INSTANCE;

    public void sayOK() {
        System.out.println("OK");
    }

    public static void main(String[] args) {
        Singleton instance = Singleton.INSTANCE;
        instance.sayOK();
    }
}
