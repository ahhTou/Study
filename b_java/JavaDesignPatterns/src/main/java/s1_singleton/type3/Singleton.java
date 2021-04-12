package s1_singleton.type3;

/**
 * 懒汉式
 * 1. 线程 不安全
 */
public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    // 提供一个静态的公用方法 当使用到该方法时才去创建instance
    public static Singleton getInstance() {
        if (instance == null) return new Singleton();
        return instance;
    }

}
