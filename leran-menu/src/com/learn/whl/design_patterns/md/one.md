###### 设计模式(Design Patterns)
* 创建型设计模式(Creatinal Design Patterns)
  + 单例(singleton):确保一个类只创建一个实例,并为该实例提供全局访问点
    - 什么时候使用?
      > ```当我们只需要一个实例的时候,例如:系统中只有一个窗口管理器```
    - 饿汉模式(Early Singleton in java),不管你要不要,都给你创建,类加载的时候该类的实例就已经存在了
       >```
      >    public class Singleton {
      >
      >          private static Singleton singleton=new Singleton();
      >      
      >        //提供私有构造函数,确保外部不能直接创建该类的实例
      >        private Singleton(){
      >        }
      >        //提供全局访问点
      >        public static Singleton getInstance(){
      >            return singleton;
      >       }
      >        public void doSomething(){
      >          System.out.println(singleton);
      >        }
      >     }
      >```
    - 懒汉模式(Lazy  Singleton in java),只有在你想要的时候才创建
       >```
       >public class Singleton {
       >
       >      private static Singleton singleton;
       >
       >      //提供私有构造函数,确保外部不能直接创建该类的实例
       >     private Singleton(){
       >     }
       >      //提供全局访问点,synchronized 同步,线程安全
       >      public static synchronized Singleton getInstance(){
       >          if(singleton==null){
       >              singleton=new Singleton();
       >          }
       >          return singleton;
       >      }
       >      public void doSomething(){
       >          System.out.println(singleton);
       >      }
       >}
       >```
        上面示例,不管是否已经存在实例,都会同步执行,会付出性能的代价,所以可以考虑,在实例不存在的时候再同步执行(双重锁机制)
        >```
       >public class Singleton {
       >
       >      private static Singleton singleton;
       >
       >      //提供私有构造函数,确保外部不能直接创建该类的实例
       >      private Singleton(){
       >      }
       >      //提供全局访问点,双重锁机制,确保线程安全的同时也考虑到性能问题
       >      public static Singleton getInstance(){
       >          if(singleton==null){
       >              synchronized (Singleton.class){
       >                  if(singleton==null){
       >                      singleton=new Singleton();
       >                  }
       >              }
       >          }
       >          return singleton;
       >      }
       >      public void doSomething(){
       >          System.out.println(singleton);
       >      }
       >}
       >```
