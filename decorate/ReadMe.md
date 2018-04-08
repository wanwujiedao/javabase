# final，finally，finalize 区别

***

## final

###### final 用于修饰类、成员变量和成员方法。

> final 修饰类，该类不能被继承，如 JDK 里面的 String、StringBuilder、StringBuffer、Math，等，这里需要注意，final 和 abstract 作用相反，所以二者不能同时修饰一个类。

> final 修饰成员变量或局部变量，若是基本类型或者其包装类型的变量被 final 修饰，则其内容不能修改，当然若是数组，对象等引用类型，其内部的属性值是可以改变的，只是其对应的地址空间不改变。

**测试代码**

```markdown
    
     private static final Integer AA[]={1};
    
     /**
     * 成员属性被 final 修饰测试
     * @author 阿导
     * @time 2018/4/8
     * @CopyRight 万物皆导
     * @param
     * @return void
     */
     public static void finalTest(){
         System.out.println("查看改变值前的地址："+AA);
         System.out.println("查看改变值前的值："+AA[0]);
         AA[0]=2;
         System.out.println("查看改变值后的地址："+AA);
         System.out.println("查看改变值后的值："+AA[0]);
     }   

```

**输出结果**

```markdown
    
    查看改变值前的地址：[Ljava.lang.Integer;@1b6d3586
    查看改变值前的值：1
    查看改变值后的地址：[Ljava.lang.Integer;@1b6d3586
    查看改变值后的值：2
    
```

> final 修饰方法，该方法不能被重写，但是子类可以用父类中final修饰的方法。


## finally

###### finally 通常和 try catch 搭配使用，保证不管有没有发生异常，最终都会执行的内容，比如 IO 操作，为了保证资源的释放，finally 一般做关闭 IO 流操作，再比如数据库连接需要关闭连接操作。

**示例代码**

```markdown
    
       /**
         * finally 示例
         * 
         * @author 阿导
         * @time 2018/4/8
         * @CopyRight 万物皆导
         * @param
         * @return void
         */
        public static void finallyTest() throws IOException {
            FileInputStream fis=null;
            try {
                fis=new FileInputStream(new File("test.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }finally {
                fis.close();
            }
        }
            
```


## finalize

###### 是 Object 类中的一个方法，子类可以重写 finalize() 方法实现对资源的回收。垃圾回收只负责回收内存，并不负责资源的回收，资源回收要由程序员完成，java 虚拟机在垃圾回收之前会先调用垃圾对象的 finalize 方法用于使对象释放资源（如关闭连接、关闭文件），之后才进行垃圾回收，这个方法一般不会显示的调用，在垃圾回收时垃圾回收器会主动调用。

**Object.java**

```markdown
    
    protected void finalize() throws Throwable { }
    
```

**重写 Object.java 的 finalize 的方法**

```markdown

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.gc();
    }
    
```

***

# 静态块，构造块，构造方法

***

> 声明一个方法的时候，它们之间的执行顺序是怎么样的？

```markdown
    
    声明一个类的时候，首先会执行静态块，然后执行构造块，最后执行构造方法。
    
```

> 它们在什么时候执行？

```markdown

    静态块只会在第一次声明该类的时候调用，下一次声明不会再调用静态块，构造块和构造方法都会在声明该方法的时候调用.
    
```

> 只要实例化，三者都存在某个类里面，一定会被执行？

```markdown

    这种说法不完全正确，再一次程序运行期间，首先只要是第一次实例化，静态块肯定会被执行一次，下一次实例化就不会执行了，
    
    而构造块和构造方法在反序列化的时候不会被调用。

```

> 一些扩展

```markdown
    
    被 static 修饰的成员变量，所有实例化资源共享。
    
```

**示例代码**

```markdown

  /**
     * 静态常量
     */
    private static int staticcount;
    /**
     * 成员变量
     */
    private  int count;
    //构造块
    {
        System.out.println("然后执行->构造块["+(++count)+"]");
    }
    //静态块
    static {
        System.out.println("先执行->静态块["+(++staticcount)+"]");
    }
    //构造方法
    public User() {
        System.out.println("最后执行->构造方法，静态常量：["+(++staticcount)+"]，成员属性：["+(++count)+"]");
    }
    
```

***


# 重写与重载

***

> 重写

###### 是指子类对父类的方法重写，其返回类型和形参均相同。

**示例代码**

```markdown

    父类
        public void setCount(int count) {
            this.count = count;
        }
    子类
       @Override
        public void setCount(int count) {
            super.setCount(++count);
        }    
        
```

> 重载

###### 重载是指同一个类里面，其方法名相同，但其返回类型或者形参至少有一项不同。

**示例代码**

```markdown
    
      public void setCount(int count) {
         super.setCount(++count);
      }
      /**
      * 重载
      *
      * @author 阿导
      * @time 2018/4/8
      * @CopyRight 万物皆导
      * @param count
      * @param num
        * @return void
      */
      public void setCount(int count,int num) {
         super.setCount(count+num);
      }
        
```

***

# 抽象和接口:[原作者](https://blog.csdn.net/fenglibing/article/details/2745123)

***

###### 接口和抽象类的概念不一样。接口是对动作的抽象，抽象类是对根源的抽象。

###### 抽象类表示的是，这个对象是什么。接口表示的是，这个对象能做什么。比如，男人，女人，这两个类（如果是类的话……），他们的抽象类是人。说明，他们都是人。

###### 人可以吃东西，狗也可以吃东西，你可以把“吃东西”定义成一个接口，然后让这些类去实现它.

###### 所以，在高级语言上，一个类只能继承一个类（抽象类）(正如人不可能同时是生物和非生物)，但是可以实现多个接口(吃饭接口、走路接口)。

- 第一点． 接口是抽象类的变体，接口中所有的方法都是抽象的。而抽象类是声明方法的存在而不去实现它的类。

- 第二点． 接口可以多继承，抽象类不行

- 第三点． 接口定义方法，不能实现，而抽象类可以实现部分方法。

- 第四点． 接口中基本数据类型为static 而抽类象不是的。


###### 当你关注一个事物的本质的时候，用抽象类；当你关注一个操作的时候，用接口。


###### 抽象类的功能要远超过接口，但是，定义抽象类的代价高。因为高级语言来说（从实际设计上来说也是）每个类只能继承一个类。在这个类中，你必须继承或编写出其所有子类的

###### 所有共性。虽然接口在功能上会弱化许多，但是它只是针对一个动作的描述。而且你可以在一个类中同时实现多个接口。在设计阶段会降低难度的。

***

# JDBC 执行的顺序

***

####### 虽然我们在项目中都使用持久层的框架对 DB 进行操作，但是作为一个 java 程序员，对原生的 JDBC 操作要了解，总的来说 JDBC 一般分为六步。

> 加载驱动

```markdown
    
    方法1：
      语句：Class.forName(driver);
           其实这里面调用了Driver里面的静态块，原理与方法2一样
     
    方法2：
      语句：Driver driver = new oracle.jdbc.driver.OracleDriver();
           DriverManager.registerDriver(driver);
     
     
    备注：  driver:是数据库路径，Oracle一般是“oracle.jdbc.OracleDriver”或者“oracle.jdbc.driver.OracleDriver”
    
```

> 连接到数据库

```markdown
    
    语句：Connection connection=DriverManager.getConnection(url,username,password);
    
    备注：url为连接数据库位置，Oracle一般为jdbc:oracle:thin:@127.1.2.3:1521:ORCL前面格式固定，@后面是服务器地址及端口号           username为用户名；password为登录密码
           
```

> 预执行 SQL 语句

```markdown
    
    方法1：
    语句：Statement statement=connection.createStatement();
     
     
    方法2：
     
    语句： PreparedStatement pStatement=connection.prepareStatement(sql);
     
    备注：sql是SQL语句，connection是Connection类型
    
```

> 执行 SQL 

```markdown
    
    方法1：
    
    语句：ResultSet rs=statement.executeQuery(sql);
    
    备注：ResultSet是用来接收结果的，statement是Statement类型的
    
     
    
    方法2：
    
    语句：int count=pStatement.executeUpdate();
    
    备注：这个是执行插入，删除，更新操作的结果

```

> 对执行 SQL 后的一些操作

```markdown
    
    语句：
    
    while(rs.next){
    
        int age=rs.getInt("sage");
    
        String name=rs.getString("sname");
    
    }
    
    备注：rs是ResultSet类型的，用getInt等方法接收数据库number型，用getString方法接收数据库varchar2类型，sage与sname是数据库中表的列名

```

> 关闭操作

```markdown
    
    语句：rs.close();
         statement.close();
         pStatement.close();
         connection.close();
         
    备注：rs关闭ResultSet类型，
         statement关闭Statement类型，
         pStatement关闭preparedStatement类型
         connection关闭Connection类型
                 
```

***

# equals 和 == 的区别

***
> ==

```markdown
    
    比较的是变量(栈)内存中存放的对象的(堆)内存地址，用来判断两个对象的地址是否相同，即是否是指相同一个对象。比较的是真正意义上的指针操作。
    
    1、比较的是操作符两端的操作数是否是同一个对象。
    2、两边的操作数必须是同一类型的（可以是父子类之间）才能编译通过。
    3、比较的是地址，如果是具体的阿拉伯数字的比较，值相等则为true，如：int a=10 与 long b=10L 与 double c=10.0都是相同的（为true），因为他们都指向地址为10的堆。
    
```

> equals

```markdown
    
    equals用来比较的是两个对象的内容是否相等，由于所有的类都是继承自java.lang.Object类的，所以适用于所有对象，如果没有对该方法进行覆盖的话，调用的仍然是Object类中的方法，而Object中的equals方法返回的却是==的判断。
    
```
