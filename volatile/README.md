# **Volatile关键字实现原理**

## 1、Volatile关键字的语义分析

volatile作用：让其他线程能够马上感知到某一线程多某个变量的修改

### （1）保证可见性

对共享变量的修改，其他的线程马上能感知到

不能保证原子性  读、写、（i++）

### （2）保证有序性

重排序（编译阶段、指令优化阶段）

输入程序的代码顺序并不是实际执行的顺序

重排序后对单线程没有影响，对多线程有影响

Volatile

Happens-before

volatile规则：

对于volatile修饰的变量：

（1）volatile之前的代码不能调整到他的后面

（2）volatile之后的代码不能调整到他的前面（as if seria）

（3）霸道（位置不变化）

### （3）volatile的原理和实现机制(锁、轻量级)  

 对于volatile变量，当对volatile变量进行写操作的时候，JVM会向处理器发送一条lock前缀的指令，将这个缓存中的变量回写到系统主存中。

## 2、Volatile的使用场景

### （1）状态标志（开关模式）

public class ShutDowsnDemmo extends Thread{

​    private volatile boolean started=false;

 

​    @Override

​    public void run() {

​        while(started){

​            dowork();

​        }

​    }

​    public void shutdown(){

​        started=false;

​    }

}

### （2）双重检查锁定（double-checked-locking）

DCL（7）

public class Singleton {

​    private volatile static Singleton instance;

​    public static Singleton getInstance(){

​        if(instance==null){

​            synchronized (Singleton.class){

​                instance=new Singleton();

​            }

​        }

​        return instance;

​    }

}

### （3）需要利用顺序性



## 3、volatile与synchronized的区别

### （1）使用上的区别

Volatile只能修饰变量，synchronized只能修饰方法和语句块

### （2）对原子性的保证

synchronized可以保证原子性，Volatile不能保证原子性

### （3）对可见性的保证

都可以保证可见性，但实现原理不同

Volatile对变量加了lock，synchronized使用monitorEnter和monitorexit  monitor  JVM

### （4）对有序性的保证

Volatile能保证有序，synchronized可以保证有序性，但是代价（重量级）并发退化到串行

### （5）其他

synchronized引起阻塞

Volatile不会引起阻塞



## 4.实现流程

对于volatile变量，当对volatile变量进行写操作的时候，JVM会向处理器发送一条lock前缀的指令，将这个缓存中的变量回写到系统主存中。

但是就算写回到内存，如果其他处理器缓存的值还是旧的，再执行计算操作就会有问题，所以在多处理器下，为了保证各个处理器的缓存是一致的，就会实现缓存一致性协议

缓存一致性协议：每个处理器通过嗅探在总线上传播的数据来检查自己缓存的值是不是过期了，当处理器发现自己缓存行对应的内存地址被修改，就会将当前处理器的缓存行设置成无效状态，当处理器要对这个数据进行修改操作的时候，会强制重新从系统内存里把数据读到处理器缓存里。

