# 线程

***

## 实现线程的三种方式

> 继承 Thread 类创建线程

**步骤**

- 定义继承 Thread 的子类，并重写 run() 方法

- 创建继承 Thread 的子类实例，即创建了线程对象

- 调用 start() 方法启动线程

**示例代码**

- 继承 Thread 类->MyThread.java

```markdown
 
    package com.dao.thead.core;
    
    /**
     * 继承 Thread 类创建线程
     *
     * @author 阿导
     * @version 1.0
     * @fileName com.dao.thead.core.MyThead.java
     * @CopyRright (c) 2018-万物皆导
     * @created 2018-04-11 13:32:00
     */
    public class MyThread extends Thread {
    
        /**
         * 重写 run 方法
         *
         * @author 阿导
         * @time 2018/4/11
         * @CopyRight 万物皆导
         * @param
         * @return void
         */
        @Override
        public void run(){
            System.out.println("这是继承 Thread 类创建线程。");
        }
    }
    
    
```


- 调用

```markdown

    //启动继承 Thread  类的线程
    new MyThread().start();

```


> 实现 Runnable 接口创建线程

**步骤**

- 定义实现 Runnable 的子类，并重写实现 run() 方法

- 创建实现 Runnable 的子类实例，并用这个实例作为 Thread 的 target 来创建 Thread 对象，这个 Thread 对象才是真正的线程对象

- 调用 start() 方法启动线程

**示例代码**


- 实现 Runnable 类->MyRunnable.java

```markdown
 
    package com.dao.thead.core;
    
    /**
     * 实现 Runnable 接口创建线程
     *
     * @author 阿导
     * @version 1.0
     * @fileName com.dao.thead.core.MyRunnable.java
     * @CopyRright (c) 2018-万物皆导
     * @created 2018-04-11 13:32:00
     */
    public class MyRunnable implements Runnable {
    
        /**
         * 实现 run 方法
         *
         * @author 阿导
         * @time 2018/4/11
         * @CopyRight 万物皆导
         * @param
         * @return void
         */
        @Override
        public void run() {
            System.out.println("这里是实现 Runnable 接口创建线程。");
        }
    }

    
```


- 调用

```markdown

    //启动实现 Runnable 接口的线程
    new Thread(new MyRunnable()).start();

```


> 使用 Callable 和 Future 创建线程

###### 和 Runnable 接口不一样，Callable 接口提供了一个 call（）方法作为线程执行体，call() 方法比 run() 方法功能要强大。

**步骤**

- 定义实现 Callable 的子类，并实现 call() 方法

- 使用 FutureTask 类来包装实现 Callable 的子类，其包装的返回值(泛型)应和对应子类保持一致

- 将 FutureTask 对象作为 Thread 的 target 创建线程，并通过 start() 来启用线程

- 然后通过 get() 方法获取返回值，该阶段，线程会进入阻塞状态，直到所有线程结束。

**示例代码**

- 实现 Callable 类->MyCallable.java

```markdown
 
    package com.dao.thead.core;
    
    import java.util.concurrent.Callable;
    
    /**
     * 使用 Callable 和 Future 创建线程
     *
     * @author 阿导
     * @version 1.0
     * @fileName com.dao.thead.core.MyCallable.java
     * @CopyRright (c) 2018-万物皆导
     * @created 2018-04-11 13:33:00
     */
    public class MyCallable implements Callable<String> {
    
        /**
         * 实现 call() 方法
         * @author 阿导
         * @time 2018/4/11
         * @CopyRight 杭州微财科技有限公司
         * @param
         * @return java.lang.String
         */
        @Override
        public String call() throws Exception {
            System.out.println("这是使用 Callable 和 Future 创建线程。");
            return "万物皆导";
        }
    }


    
```


- 调用

```markdown

      //使用 FutureTask 获取实现 Callable 的线程
      FutureTask<String> task=new FutureTask<String>(new MyCallable());
      //将任务放入线程执行，实质上还是以 Callable 对象来创建并启动线程
      new Thread(task,"测试带返回值的线程").start();
      //查看线程返回值，get() 方法会阻塞，直到子线程执行结束才返回
      System.out.println("带回来的结果:"+task.get());

```

> 对比三种线程的实现方式


- 线程只是实现 Runnable 或实现 Callable 接口，还可以继承其他类。
  
- 这种方式下，多个线程可以共享一个 target 对象，非常适合多线程处理同一份资源的情形。
  
- 但是编程稍微复杂，如果需要访问当前线程，必须调用 Thread.currentThread() 方法。
  
- 继承 Thread 类的线程类不能再继承其他父类（Java 单继承决定）。
  
**注：一般推荐采用实现接口的方式来创建多线程**

## 线程池

> 为什么要用线程池？

- 在程序运行过程中，线程资源是稀缺的，为了减少线程创建和销毁，使得线程得以重复利用，所以使用线程池。

- 防止滥用线程，通过线程池，可以有效的控制工作中的线程数量，防止服务器 CPU 或者内存消耗过多导致崩溃，造成重大损失。

> 线程池的构造方法

```markdown

    public ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue) {
            this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,Executors.defaultThreadFactory(), defaultHandler);
    }
        
    public ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,
                              ThreadFactory threadFactory) {
                this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,threadFactory, defaultHandler);
    }
    
    public ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,
                              RejectedExecutionHandler handler) {
            this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,Executors.defaultThreadFactory(), handler);
    }
    
    public ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,
                              ThreadFactory threadFactory,
                              RejectedExecutionHandler handler) {
         if (corePoolSize < 0 ||
             maximumPoolSize <= 0 ||
             maximumPoolSize < corePoolSize ||
             keepAliveTime < 0)
             throw new IllegalArgumentException();
         if (workQueue == null || threadFactory == null || handler == null)
             throw new NullPointerException();
         this.corePoolSize = corePoolSize;
         this.maximumPoolSize = maximumPoolSize;
         this.workQueue = workQueue;
         this.keepAliveTime = unit.toNanos(keepAliveTime);
         this.threadFactory = threadFactory;
         this.handler = handler;
    }
    
    
```

##### 观察其构造方法，发现最终调的是参数最多的那个构造方法，只是根据经验，一些参数给了默认值，减少开发者传入参数过多带来的困扰，下面讲述一下各个参数代表的含义。

- corePoolSize：线程池核心线程数量

###### 核心池的大小，这个参数跟后面讲述的线程池的实现原理有非常大的关系。在创建了线程池后，默认情况下，线程池中并没有任何线程，而是等待有任务到来才创建线程去执行任务，除非调用了 prestartAllCoreThreads()或者 prestartCoreThread() 方法，从这2个方法的名字就可以看出，是预创建线程的意思，即在没有任务到来之前就创建corePoolSize 个线程或者一个线程。默认情况下，在创建了线程池后，线程池中的线程数为0，当有任务来之后，就会创建一个线程去执行任务，当线程池中的线程数目达到 corePoolSize 后，就会把到达的任务放到缓存队列当中


- maximumPoolSize：线程池最大线程数量

###### 线程池最大线程数，这个参数也是一个非常重要的参数，它表示在线程池中最多能创建多少个线程

- keepAliveTime：当活跃线程数大于核心线程数时，空闲的多余线程最大存活时间

###### 表示线程没有任务执行时最多保持多久时间会终止。默认情况下，只有当线程池中的线程数大于 corePoolSize 时，keepAliveTime 才会起作用，直到线程池中的线程数不大于 corePoolSize，即当线程池中的线程数大于 corePoolSize 时，如果一个线程空闲的时间达到 keepAliveTime，则会终止，直到线程池中的线程数不超过 corePoolSize。但是如果调用了 allowCoreThreadTimeOut(boolean)方法，在线程池中的线程数不大于 corePoolSize 时，keepAliveTime 参数也会起作用，直到线程池中的线程数为0

- unit：存活时间的单位

###### 参数 keepAliveTime 的时间单位，有7种取值，在 TimeUnit 类中有7种静态属性：

```markdown

           TimeUnit.DAYS;               //天
           TimeUnit.HOURS;             //小时
           TimeUnit.MINUTES;           //分钟
           TimeUnit.SECONDS;           //秒
           TimeUnit.MILLISECONDS;      //毫秒
           TimeUnit.MICROSECONDS;      //微妙
           TimeUnit.NANOSECONDS;       //纳秒

```

- workQueue：存放任务的队列

###### 一个阻塞队列，用来存储等待执行的任务，这个参数的选择也很重要，会对线程池的运行过程产生重大影响，一般来说，这里的阻塞队列有以下几种选择：

###### (1) <label style="color=#FF0923">ArrayBlockingQueue</label>
###### (2) <label style="color=#FF0923">LinkedBlockingQueue</label>
###### (3) <label style="color=#FF0923">SynchronousQueue</label>

###### ArrayBlockingQueue 和 PriorityBlockingQueue 使用较少，一般使用 LinkedBlockingQueue 和 Synchronous。线程池的排队策略与 BlockingQueue 有关。


- threadFactory：线程工厂，用来创建线程

- handler：超出线程范围和队列容量的任务的处理程序

###### 表示当拒绝处理任务时的策略，有以下四种取值：

###### (1) <label style="color=#FF0923">ThreadPoolExecutor.AbortPolicy</label>:丢弃任务并抛出RejectedExecutionException异常

###### (1) <label style="color=#FF0923">ThreadPoolExecutor.DiscardPolicy</label>：也是丢弃任务，但是不抛出异常

###### (1) <label style="color=#FF0923">ThreadPoolExecutor.DiscardOldestPolicy</label>：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）

###### (1) <label style="color=#FF0923">ThreadPoolExecutor.CallerRunsPolicy</label>：由调用线程处理该任务



> 线程实现原理

- 首先用户先提交线程任务

- 首先判断线程池核心线程是否都在执行任务，若没有（核心线程空闲或者还有核心线程没有被创建）则创建新的线程来执行任务，若核心线程都在执行任务，进入下一流程

- 然后判断线程池队列是否已经满了，若没有，则将新提交的任务放入线程队列中，若已满；进入下一流程

- 判断线程是否都处于工作状态，若没有，则新创建一个线程来执行任务，若已经满了，则交给饱和策略来处理这个任务

<div style="width:600px;height:350px;margin:auto">
    <img style="width:600px;" src="../img/threadpool_work_flow.png" title="线程池工作流程"/>
<div>


