# Java Enumeration接口

***

###### Enumeration接口中定义了一些方法，通过这些方法可以枚举（一次获得一个）对象集合中的元素。

###### 这种传统接口已被迭代器取代，虽然Enumeration 还未被遗弃，但在现代代码中已经被很少使用了。尽管如此，它还是使用在诸如Vector和Properties这些传统类所定义的方法中，除此之外，还用在一些API类，并且在应用程序中也广泛被使用。 下表总结了一些Enumeration声明的方法：

| 序号 | 方法描述 | 
|:----------:|:------:|
| 1 | boolean hasMoreElements()测试此枚举是否包含更多的元素。 | 
| 2 | Object nextElement() 如果此枚举对象至少还有一个可提供的元素，则返回此枚举的下一个元素。 | 
	
***

## 实例

> 以下实例演示了 Enumeration 的使用：

```markdown
    
    package com.dao.datastructure.enumeration;
    
    import java.util.ArrayList;
    import java.util.Enumeration;
    import java.util.List;
    import java.util.Vector;
    
    /**
     * 枚举案例
     *
     * @author 阿导
     * @version 1.0
     * @fileName com.dao.datastructure.enumeration.EnumerationDemo.java
     * @CopyRright (c) 2018-万物皆导
     * @created 2018-04-08 17:28:00
     */
    public class EnumerationDemo {
    
        public static void main(String[] args){
            Enumeration<String> season;
            Vector<String> seasonNames = new Vector<>();
            seasonNames.add("Spring");
            seasonNames.add("Summer");
            seasonNames.add("Autumn");
            seasonNames.add("Winter");
            season = seasonNames.elements();
            while (season.hasMoreElements()){
                System.out.println(season.nextElement());
            }
        }
    }

```

> 以上实例编译运行结果如下：

```markdown
    
    Spring
    Summer
    Autumn
    Winter
    
```

# Java Bitset类

###### 一个Bitset类创建一种特殊类型的数组来保存位值。BitSet中数组大小会随需要增加。这和位向量（vector of bits）比较类似。

###### 这是一个传统的类，但它在Java 2中被完全重新设计。

###### BitSet定义了两个构造方法。

###### 第一个构造方法创建一个默认的对象：BitSet()

###### 第二个方法允许用户指定初始大小。所有位初始化为0。BitSet(int size)

###### BitSet中实现了Cloneable接口中定义的方法如下表所列：

| 序号 | 方法描述 | 
|:----------:|:------:|
|  1  | void and(BitSet set)：对此目标位 set 和参数位 set 执行逻辑与操作。 | 
|  2  | void andNot(BitSet set)：清除此 BitSet 中所有的位，其相应的位在指定的 BitSet 中已设置。 | 	
|  3  | int cardinality()：返回此 BitSet 中设置为 true 的位数。|
|  4  | void clear()：将此 BitSet 中的所有位设置为 false。|
|  5  | void clear(int index)：将索引指定处的位设置为 false。|
|  6  | void clear(int startIndex, int endIndex)：将指定的 fromIndex（包括）到指定的 toIndex（不包括）范围内的位设置为 false。|
|  7  | Object clone()：复制此 BitSet，生成一个与之相等的新 BitSet。|
|  8  | boolean equals(Object bitSet)：将此对象与指定的对象进行比较。|
|  9  | void flip(int index)：将指定索引处的位设置为其当前值的补码。|
|  10 | void flip(int startIndex, int endIndex)：将指定的 fromIndex（包括）到指定的 toIndex（不包括）范围内的每个位设置为其当前值的补码。|
|  11 |	boolean get(int index)：返回指定索引处的位值。|
|  12 |	BitSet get(int startIndex, int endIndex)：返回一个新的 BitSet，它由此 BitSet 中从 fromIndex（包括）到 toIndex（不包括）范围内的位组成。|
|  13 |	int hashCode()：返回此位 set 的哈希码值。|
|  14 |	boolean intersects(BitSet bitSet)：如果指定的 BitSet 中有设置为 true 的位，并且在此 BitSet 中也将其设置为 true，则返回 ture。|
|  15 |	boolean isEmpty()：如果此 BitSet 中没有包含任何设置为 true 的位，则返回 ture。|
|  16 |	int length()：返回此 BitSet 的"逻辑大小"：BitSet 中最高设置位的索引加 1。|
|  17 | int nextClearBit(int startIndex)：返回第一个设置为 false 的位的索引，这发生在指定的起始索引或之后的索引上。|
|  18 |	int nextSetBit(int startIndex)：返回第一个设置为 true 的位的索引，这发生在指定的起始索引或之后的索引上。|
|  19 |	void or(BitSet bitSet)：对此位 set 和位 set 参数执行逻辑或操作。|
|  20 |	void set(int index)：将指定索引处的位设置为 true。|
|  21 |	void set(int index, boolean v)：将指定索引处的位设置为指定的值。|
|  22 |	void set(int startIndex, int endIndex)：将指定的 fromIndex（包括）到指定的 toIndex（不包括）范围内的位设置为 true。|
|  23 |	void set(int startIndex, int endIndex, boolean v)：将指定的 fromIndex（包括）到指定的 toIndex（不包括）范围内的位设置为指定的值。|
|  24 |	int size()：返回此 BitSet 表示位值时实际使用空间的位数。|
|  25 |	String toString()：返回此位 set 的字符串表示形式。|
|  26 |	void xor(BitSet bitSet)：对此位 set 和位 set 参数执行逻辑异或操作。|

***

## 实例

> 下面的程序说明这个数据结构支持的几个方法：

```markdown
    
    package com.dao.datastructure.bitset;
    
    import java.util.BitSet;
    
    /**
     * 位集合
     *
     * @author 阿导
     * @version 1.0
     * @fileName com.dao.datastructure.bitset.BitSetDemo.java
     * @CopyRright (c) 2018-万物皆导
     * @created 2018-04-08 18:40:00
     */
    public class BitSetDemo {
    
        public static void main(String[] args){
            BitSet bits1 = new BitSet(16);
            BitSet bits2 = new BitSet(16);
            BitSet bits3 = new BitSet(16);
    
            //添加一些位集合
            for(int i=0; i<1<<5; i++) {
                if((i%2) == 0){ bits1.set(i);}
                if((i%5) != 0){ bits2.set(i);}
                if((i%3) != 0){ bits3.set(i);}
            }
            System.out.println("bits1 初始化：");
            System.out.println(bits1);
            System.out.println("bits2 初始化：");
            System.out.println(bits2);
    
            //逻辑与
            bits2.and(bits1);
            System.out.println("bits2 与 bits1： ");
            System.out.println(bits2);
    
            // 逻辑或
            bits2.or(bits1);
            System.out.println("bits2 或 bits1: ");
            System.out.println(bits2);
    
            // 逻辑异或
            bits2.xor(bits3);
            System.out.println("bits2 异或 bits3: ");
            System.out.println(bits3);
    
    
        }
    }

```

###### 以上实例编译运行结果如下：

```markdown
    
    bits1 初始化：
    {0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30}
    bits2 初始化：
    {1, 2, 3, 4, 6, 7, 8, 9, 11, 12, 13, 14, 16, 17, 18, 19, 21, 22, 23, 24, 26, 27, 28, 29, 31}
    bits2 与 bits1： 
    {2, 4, 6, 8, 12, 14, 16, 18, 22, 24, 26, 28}
    bits2 或 bits1: 
    {0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30}
    bits2 异或 bits3: 
    {1, 2, 4, 5, 7, 8, 10, 11, 13, 14, 16, 17, 19, 20, 22, 23, 25, 26, 28, 29, 31}
    
```

***


# Java Vector 类

***

###### Vector类实现了一个动态数组。和ArrayList和相似，但是两者是不同的：

- Vector是同步访问的。

- Vector包含了许多传统的方法，这些方法不属于集合框架。

###### Vector主要用在事先不知道数组的大小，或者只是需要一个可以改变大小的数组的情况。

###### Vector类支持4种构造方法。

- 第一种构造方法创建一个默认的向量，默认大小为10：Vector()

- 第二种构造方法创建指定大小的向量：Vector(int size)

- 第三种构造方法创建指定大小的向量，并且增量用incr指定. 增量表示向量每次增加的元素数目：Vector(int size,int incr)

- 第四种构造方法创建一个包含集合c元素的向量：Vector(Collection c)

###### 除了从父类继承的方法外Vector还定义了以下方法：

| 序号 | 方法描述 | 
|:----------:|:------:|
|  1  |	void add(int index, Object element)：在此向量的指定位置插入指定的元素。|
|  2  | boolean add(Object o)：将指定元素添加到此向量的末尾。|
|  3  | boolean addAll(Collection c)：将指定 Collection 中的所有元素添加到此向量的末尾，按照指定 collection 的迭代器所返回的顺序添加这些元素。|
|  4  |	boolean addAll(int index, Collection c)：在指定位置将指定 Collection 中的所有元素插入到此向量中。|
|  5  |	void addElement(Object obj)：将指定的组件添加到此向量的末尾，将其大小增加 1。|
|  6  |	int capacity()：返回此向量的当前容量。|
|  7  |	void clear()：从此向量中移除所有元素。|
|  8  |	Object clone()：返回向量的一个副本。|
|  9  |	boolean contains(Object elem)：如果此向量包含指定的元素，则返回 true。|
|  10 |	boolean containsAll(Collection c)：如果此向量包含指定 Collection 中的所有元素，则返回 true。|
|  11 |	void copyInto(Object[] anArray)：将此向量的组件复制到指定的数组中。|
|  12 |	Object elementAt(int index)：返回指定索引处的组件。|
|  13 |	Enumeration elements()：返回此向量的组件的枚举。|
|  14 |	void ensureCapacity(int minCapacity)：增加此向量的容量（如有必要），以确保其至少能够保存最小容量参数指定的组件数。|
|  15 |	boolean equals(Object o)：比较指定对象与此向量的相等性。|
|  16 |	Object firstElement()：返回此向量的第一个组件（位于索引 0) 处的项）。|
|  17 |	Object get(int index)：返回向量中指定位置的元素。|
|  18 |	int hashCode()：返回此向量的哈希码值。|
|  19 |	int indexOf(Object elem)：返回此向量中第一次出现的指定元素的索引，如果此向量不包含该元素，则返回 -1。|
|  20 |	int indexOf(Object elem, int index)：返回此向量中第一次出现的指定元素的索引，从 index 处正向搜索，如果未找到该元素，则返回 -1。|
|  21 |	void insertElementAt(Object obj, int index)：将指定对象作为此向量中的组件插入到指定的 index 处。
|  22 |	boolean isEmpty()：测试此向量是否不包含组件。|
|  23 |	Object lastElement()：返回此向量的最后一个组件。|
|  24 |	int lastIndexOf(Object elem)：返回此向量中最后一次出现的指定元素的索引；如果此向量不包含该元素，则返回 -1。|
|  25 |	int lastIndexOf(Object elem, int index)：返回此向量中最后一次出现的指定元素的索引，从 index 处逆向搜索，如果未找到该元素，则返回 -1。|
|  26 |	Object remove(int index)：移除此向量中指定位置的元素。|
|  27 |	boolean remove(Object o)：移除此向量中指定元素的第一个匹配项，如果向量不包含该元素，则元素保持不变。|
|  28 |	boolean removeAll(Collection c)：从此向量中移除包含在指定 Collection 中的所有元素。
|  29 |	void removeAllElements()：从此向量中移除全部组件，并将其大小设置为零。|
|  30 |	boolean removeElement(Object obj)：从此向量中移除变量的第一个（索引最小的）匹配项。|
|  31 |	void removeElementAt(int index)：删除指定索引处的组件。|
|  32 |	protected void removeRange(int fromIndex, int toIndex)：从此 List 中移除其索引位于 fromIndex（包括）与 toIndex（不包括）之间的所有元素。|
|  33 |	boolean retainAll(Collection c)：在此向量中仅保留包含在指定 Collection 中的元素。|
|  34 |	Object set(int index, Object element)：用指定的元素替换此向量中指定位置处的元素。|
|  35 |	void setElementAt(Object obj, int index)：将此向量指定 index 处的组件设置为指定的对象。
|  36 |	void setSize(int newSize)：设置此向量的大小。|
|  37 |	int size()：返回此向量中的组件数。|
|  38 |	List subList(int fromIndex, int toIndex)：返回此 List 的部分视图，元素范围为从 fromIndex（包括）到 toIndex（不包括）。|
|  39 |	Object[] toArray()：返回一个数组，包含此向量中以恰当顺序存放的所有元素。|
|  40 |	Object[] toArray(Object[] a)：返回一个数组，包含此向量中以恰当顺序存放的所有元素；返回数组的运行时类型为指定数组的类型。|
|  41 |	String toString()：返回此向量的字符串表示形式，其中包含每个元素的 String 表示形式。|
|  42 |	void trimToSize() 对此向量的容量进行微调，使其等于向量的当前大小。|

## 实例

> 下面的程序说明这个集合所支持的几种方法：

```markdown
    
    package com.dao.datastructure.vector;
    
    import java.util.Enumeration;
    import java.util.Vector;
    
    /**
     * 向量
     *
     * @author 阿导
     * @version 1.0
     * @fileName com.dao.datastructure.vector.VectorDemo.java
     * @CopyRright (c) 2018-万物皆导
     * @created 2018-04-08 18:52:00
     */
    public class VectorDemo {
    
        public static void main(String[] args){
            // 初始化增量为2，大小为4
            Vector v = new Vector(4, 2);
            System.out.println("当前向量数目: " + v.size());
            System.out.println("当前向量的容量: " +
                    v.capacity());
            v.addElement(new Integer(10));
            v.addElement(new Integer(24));
            v.addElement(new Integer(37));
            v.addElement(new Integer(43));
            v.addElement(new Integer(52));
            //因为增量是2，所以向量的容量应该为4+2=6
            System.out.println("增加五个向量后的容量: " +v.capacity());
            //再添加一个向量
            v.addElement(new Double(3.37));
            //此时，向量里面应该是6个元素，其容量依然为6
            System.out.println("添加3.37后的容量: " +v.capacity());
            //在添加一个元素，容量加2，元素个数加1
            v.addElement(new Integer(7));
            System.out.println("添加7后的容量: " +v.capacity());
            System.out.println("添加7后的元素个数: " +v.size());
    
            System.out.println("第一个元素: " +v.firstElement());
            System.out.println("最后一个元素: " +v.lastElement());
    
            if(v.contains(new Double(3.37))) {
                System.out.println("\nVector 包含 3.37。");
            }
            // 对向量里面元素进行遍历
            Enumeration vEnum = v.elements();
            System.out.println("\n以下是向量里面的元素：");
            while(vEnum.hasMoreElements()) {
                System.out.print(vEnum.nextElement() + " ");
            }
            System.out.println();
        }
    }

```

> 以上实例编译运行结果如下：

```markdown
    
    当前向量数目: 0
    当前向量的容量: 4
    增加五个向量后的容量: 6
    添加3.37后的容量: 6
    添加7后的容量: 8
    添加7后的元素个数: 7
    第一个元素: 10
    最后一个元素: 7
    
    Vector 包含 3.37。
    
    以下是向量里面的元素：
    10 24 37 43 52 3.37 7 
    
```

> ArrayList和Vector的区别.jpg

| 序号 | 比较点 | ArrayList  | Vector  | 
|:----------:|:------:|:------:|:------:|
| 1 | 推出时间 | JDK 1.2之后推出的，属于新的操作类  | JDK 1.0时推出，属于旧的操作类  | 
| 2 | 性能 | 采用异步处理方式，性能比较高  | 采用同步的处理方式，性能比较低  | 
| 3 | 线程安全 | 属于非线程安全的操作类 | 属于线程安全的操作类 | 
| 4 | 输出元素 | 只能用迭代器（Iterator）和增强循环（foreach）输出元素  | 可以使用迭代器（Iterator）和增强循环（foreach）以及 Enumeration 输出元素 | 

***

# Java Stack 类

***

###### 栈是Vector的一个子类，它实现了一个标准的后进先出的栈。
###### 堆栈只定义了默认构造函数，用来创建一个空栈。 堆栈除了包括由 Vector 定义的所有方法，也定义了自己的一些方法。

```markdown
    
    Stack()

```

###### 除了由 Vector 定义的所有方法，自己也定义了一些方法：

| 序号 | 方法描述 | 
|:----------:|:------:|
|  1  |	boolean empty()：测试堆栈是否为空。|
|  2  |	Object peek()：查看堆栈顶部的对象，但不从堆栈中移除它。|
|  3  |	Object pop()：移除堆栈顶部的对象，并作为此函数的值返回该对象。|
|  4  |	Object push(Object element)：把项压入堆栈顶部。|
|  5  |	int search(Object element)：返回对象在堆栈中的位置，以 1 为基数。|

## 实例

> 下面的程序说明这个集合所支持的几种方法

```markdown
    
    package com.dao.datastructure.stack;
    
    import java.util.Stack;
    
    /**
     * 栈示例代码
     *
     * @author 阿导
     * @version 1.0
     * @fileName com.dao.datastructure.stack.StackDemo.java
     * @CopyRright (c) 2018-万物皆导
     * @created 2018-04-09 19:34:00
     */
    public class StackDemo {
    
        public static void main(String[] args){
    
            Stack<Integer> stack = new Stack<Integer>();
    
            //进栈
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);
    
            System.out.println(stack);
            //出栈
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.peek());
        }
    }


```

> 以上实例编译运行结果如下：

```markdown

    [1, 2, 3, 4]
    4
    3
    2
    
    
```

***


# Java Dictionary 类

***

###### Dictionary 类是一个抽象类，用来存储键/值对，作用和Map类相似。

###### 给出键和值，你就可以将值存储在Dictionary对象中。一旦该值被存储，就可以通过它的键来获取它。所以和Map一样， Dictionary 也可以作为一个键/值对列表。

###### Dictionary 定义的抽象方法如下表所示：

| 序号 | 方法描述 | 
|:----------:|:------:|
|  1  |	Enumeration elements()：返回此 dictionary 中值的枚举。|
|  2  |	Object get(Object key)：返回此 dictionary 中该键所映射到的值。|
|  3  |	boolean isEmpty()：测试此 dictionary 是否不存在从键到值的映射。|
|  4  |	Enumeration keys()：返回此 dictionary 中的键的枚举。|
|  5  |	Object put(Object key, Object value)：将指定 key 映射到此 dictionary 中指定 value。|
|  6  |	Object remove(Object key)：从此 dictionary 中移除 key （及其相应的 value）。|
|  7  |	int size()：返回此 dictionary 中条目（不同键）的数量。|

###### Dictionary 类已经过时了。在实际开发中，你可以实现 Map 接口来获取键/值的存储功能。

## 实例

> 代码

```markdown
    
    package com.dao.datastructure.dictionary;
    
    import java.util.Dictionary;
    import java.util.Hashtable;
    
    /**
     * 字典
     *
     * @author 阿导
     * @version 1.0
     * @fileName com.dao.datastructure.dictionary.DictionaryDemo.java
     * @CopyRright (c) 2018-万物皆导
     * @created 2018-04-09 20:02:00
     */
    public class DictionaryDemo {
    
    
        public static void main(String[] args){
            Dictionary<String,String>  dictionary=new Hashtable();
    
            dictionary.put("A","a");
            dictionary.put("B","b");
            dictionary.put("C","c");
    
            System.out.println("所有字典项:"+dictionary);
            System.out.println("C："+dictionary.get("C"));
        }
    }

```

> 输出结果

```markdown
    
   所有字典项:{A=a, C=c, B=b}
   C：c 
   
   
```

