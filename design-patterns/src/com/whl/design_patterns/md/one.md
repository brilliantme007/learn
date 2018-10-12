###### 设计模式(Design Patterns)
* 创建型设计模式(Creatinal Design Patterns)
  + 单例(singleton):确保一个类只创建一个实例,并为该实例提供全局访问点
    >- 饥饿模式(Early SIngleton in java)
    ```
        public class Singleton {
        
            private static Singleton singleton=new Singleton();
        
            public static Singleton getInstance(){
                return singleton;
            }
            public void doSomething(){
                System.out.println(singleton);
            }
        }
    ```
    
