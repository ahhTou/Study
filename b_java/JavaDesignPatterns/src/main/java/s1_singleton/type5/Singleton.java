package s1_singleton.type5;

/**
 * 懒汉式 - 同步代码块
 */
public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    // 提供一个静态的公用方法 当使用到该方法时才去创建instance
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                instance = new Singleton();
            }
        }
        return instance;
    }

}
