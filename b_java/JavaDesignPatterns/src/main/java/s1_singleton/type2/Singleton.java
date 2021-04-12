package s1_singleton.type2;

/**
 * 饿汉式 - 静态变量块
 */
public class Singleton {


    // 1. 构造器私有化，外部能new
    private Singleton() {
    }

    // 2. 本列内部创建对象实例
    private static final Singleton instance;

    static {
        // 在静态状态块中， 创建单例对象
        instance = new Singleton();
    }


    // 3. 提供一个共有的静态方法 ，返回实例对象
    public static Singleton getInstance() {
        return instance;
    }

}

