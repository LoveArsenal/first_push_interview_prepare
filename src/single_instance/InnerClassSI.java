package single_instance;

/**
 * @author Chang
 * @description
 *  懒汉式：延迟加载、线程安全
 *  内部类的方式
 * @create 2021-07-11 15:19
 */
public class InnerClassSI {
/*
    static class SingleInstance {

        static SingleInstance singleIns = null;

        int field1;

        private SingleInstance() {
            field1 = 1;
            System.out.println("单例对象初始化了");
        }

        public static SingleInstance getInstance() {
            if (singleIns == null)
                singleIns = new SingleInstance();
            return singleIns;
        }

    }*/

    // 静态内部类不会随着累加载而加载，只有调用时才加载，达到了“延迟加载”的效果
    private static class SingleTon{

        private static final InnerClassSI instance = new InnerClassSI();
    }

    public static InnerClassSI getInstance(){

        return SingleTon.instance;
    }

    private InnerClassSI(){

        System.out.println("单例对象初始化了");
    }

    public static void main(String[] args) {

        while (true)
            new Thread(()->InnerClassSI.getInstance(), Thread.currentThread().getName()).start();
    }
}

