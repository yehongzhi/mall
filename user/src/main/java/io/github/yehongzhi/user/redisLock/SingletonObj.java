package io.github.yehongzhi.user.redisLock;

public class SingletonObj {

    private enum SingletonEnum {
        INSTANCE;

        private SingletonObj singletonObj;

        SingletonEnum() {
            singletonObj = new SingletonObj();
        }

        private SingletonObj getSingletonObj() {
            return singletonObj;
        }
    }

    public static SingletonObj getInstance() {
        return SingletonEnum.INSTANCE.getSingletonObj();
    }

    public static void main(String[] args) {
        SingletonObj a = SingletonObj.getInstance();
        SingletonObj b = SingletonObj.getInstance();
        System.out.println(a == b);
    }
}
