# 单例模式的分类
## 主要特性：线程安全性、性能、懒加载、实例唯一性

### 1.恶汉模式

    /**
     * 饿汉模式   安全，但是无法实现懒加载
     */
    public class HungerSingleton {
    
        // 加载中就产生实例对象
        private static HungerSingleton hungerSingleton = new HungerSingleton();
    
        public static HungerSingleton getInstance(){
            return hungerSingleton;
        }
    }
 
 ### 2.懒汉模式
    /**
     * 懒汉单例 ，多线程会出现多个实例，需要优化
     * 能够实现懒加载
     */
    public class LazyManSingleton {
    
        public static LazyManSingleton lazyManSingleton;
    
        private LazyManSingleton(){
        }
    
        public static LazyManSingleton getInstance(){
            if (lazyManSingleton == null) {
                lazyManSingleton = new LazyManSingleton();
            }
            return lazyManSingleton;
        }
    }
    
### 3.Double-Check-Locking  双重检查锁（DCL）

    /**
     * Double-Check-Locking   双重检查锁单例
     * 这个写法貌似很完美，但是如果构造方法中存在指令重排的情况，会出现null指针
     * 解决方案：加上一个volatile,可以实现有序性，防止出现指令重排
     * Volatile+Double-check
     * 懒加载，线程安全，比较完美的单例模式
     */
    public class DCL {
    
    //    private  static DCL instance;
        private volatile static DCL instance;
    
        private DCL(){
    
        }
        public static DCL getInstance(){
            if (instance == null){
                synchronized (DCL.class){
                    if (instance == null){
                        instance = new DCL();
                    }
                }
            }
            return instance;
        }    
    }
### 4.Holder 静态内部类实现单例
    /**
     * 静态内部类单例模式（主要利用静态内部类的懒加载机制）
     * 应用比较广泛  安全  也可以实现懒加载
     */
    public class HolderDemo {
    
        private HolderDemo(){
    
        }
    
        private static class Holder{
            private static HolderDemo instance = new HolderDemo();
            // 测试懒加载
            static {
                System.out.println("加载了");
            }
        }
    
        public static HolderDemo getInstance(){
            return Holder.instance;
        }
    }
    
### 5.枚举实现单例模式

    /**
     * 改良版，即可实现懒加载和线程安全
     * 运用较为广泛
     */
    public class EnumSingletonDemo {
        private EnumSingletonDemo(){
    
        }
        //延迟加载 (类似静态内部类）
        private enum EnumHolder{
            INSTANCE;
            private EnumSingletonDemo instance = null;
    
            EnumHolder(){
                instance = new EnumSingletonDemo();
            }
        }
    
        public static EnumSingletonDemo getInstance(){
            return EnumHolder.INSTANCE.instance;
        }
    }
 


