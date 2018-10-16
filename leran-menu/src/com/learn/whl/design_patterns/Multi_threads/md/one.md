```
public class MultiThreads {
   
       //CountDownLatch
       public static void countDownLatchTest(){
           CountDownLatch countDownLatch = new CountDownLatch(2);
           new Thread(()->{
               System.out.println("countDownLatchTest child thread start->"+Thread.currentThread().getName());
               try {
                   Thread.sleep(3000);
                   System.out.println("countDownLatchTest child thread end ->"+Thread.currentThread().getName());
                   countDownLatch.countDown();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }).start();
           new Thread(()->{
               System.out.println("the ending child thread start->"+Thread.currentThread().getName());
               try {
                   Thread.sleep(3000);
                   System.out.println("countDownLatchTest child thread  end->"+Thread.currentThread().getName());
                   countDownLatch.countDown();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }).start();
           System.out.println("countDownLatchTest main thread waiting");
           try {
               countDownLatch.await();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println("countDownLatchTest the two threads end");
           System.out.println("countDownLatchTest continue the main thread");
       }
   
       /**
        * CyclicBarrier
        */
       public static void cyclicBarrierTest() {
           CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> {
               System.out.println("cyclicBarrierTest the last thing.....................");
           });
           new Thread(() -> {
               System.out.println("cyclicBarrierTest child thread start->" + Thread.currentThread().getName());
               try {
                   Thread.sleep(3000);
                   cyclicBarrier.await();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               } catch (BrokenBarrierException e) {
                   e.printStackTrace();
               }
           }).start();
           new Thread(() -> {
               System.out.println("cyclicBarrierTest child thread start->" + Thread.currentThread().getName());
               try {
                   Thread.sleep(3000);
                   cyclicBarrier.await();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               } catch (BrokenBarrierException e) {
                   e.printStackTrace();
               }
           }).start();
   
       }
   
       static class SemaphoreClass extends Thread{
           private int person;
           private Semaphore semaphore;
   
           public SemaphoreClass(Semaphore semaphore,int person){
               this.semaphore=semaphore;
               this.person=person;
           }
   
           @Override
           public void run() {
               try {
                   semaphore.acquire();
                   System.out.println("start person num:"+person+" buy ticket at window "+Thread.currentThread().getName());
                   Thread.sleep(3000);
                   System.out.println("end person num:"+person+" buy ticket at window "+Thread.currentThread().getName());
                   semaphore.release();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       }
   
       public static void semaphoreTest(){
           //10 persons
           int persons=10;
           //5 ticket windows
           Semaphore semaphore=new Semaphore(5);
           for(int i=0;i<persons;i++){
               new SemaphoreClass(semaphore,i).start();
           }
       }
       public static void main(String[] args) {
           countDownLatchTest();
           cyclicBarrierTest();
           semaphoreTest();
       }
   }
```