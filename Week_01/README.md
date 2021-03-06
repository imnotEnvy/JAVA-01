学习笔记


# 作业

## 2.（必做）自定义一个 Classloader，加载一个 Hello.xlass 文件，执行 hello 方法，此文件内容是一个 Hello.class 文件所有字节（x=255-x）处理后的文件。文件群里提供。

```bash
cd homework
javac CustomClassLoader.java
java CustomClassLoader

(base) ➜  homework git:(main) ✗ java CustomClassLoader
Hello, classLoader!
```


## 3.（必做）画一张图，展示 Xmx、Xms、Xmn、Meta、DirectMemory、Xss 这些内存参数的关系。


Java内存模型


```plaintext
┌───────────────────────────────────────────────────────────────────────────────────────────┐   ┌───────────────────────────────┐
│                                                                                           │   │                               │
│      ┌────────────────────────┐   ┌──────────────────────────┐                            │   │       OFF-HEAP                │
│      │                        │   │                          │                            │   │                               │
│      │    STACK               │   │     STACK                │                            │   │   -XX: MaxDirectMemorySize=size
│      │                        │   │                          │                            │   │                               │
│      │    -Xss                │   │                          │                            │   │                               │
│      │                        │   │                          │                            │   │                               │
│      │                        │   │                          │                            │   │                               │
│      └────────────────────────┘   └──────────────────────────┘                            │   │                               │
│                                                                                           │   │                               │
│                                                                                           │   │                               │
│      ┌────────────────────────────────────────────────────────────────────────────┐       │   │                               │
│      │                                                                            │       │   │                               │
│      │ ┌───────────────────────────────────┐ ┌───────────────────────────────────┐│       │   │                               │
│      │ │   HEAP      -Xmx                  │ │   NON-HEAP                        ││       │   │                               │
│      │ │             -Xms                  │ │                                   ││       │   │                               │
│      │ │                                   │ │     -XX: MaxMetaspaceSize=size    ││       │   │                               │
│      │ │  ┌───────────┐     ┌───────────┐  │ │                                   ││       │   │                               │
│      │ │  │ YOUNG-GEN │     │           │  │ │                                   ││       │   │                               │
│      │ │  │           │     │           │  │ │                                   ││       │   │                               │
│      │ │  │  -Xmn     │     │           │  │ │                                   ││       │   │                               │
│      │ │  │           │     │           │  │ │                                   ││       │   │                               │
│      │ │  │           │     │           │  │ │                                   ││       │   │                               │
│      │ │  └───────────┘     └───────────┘  │ │                                   ││       │   │                               │
│      │ │                                   │ │                                   ││       │   │                               │
│      │ └───────────────────────────────────┘ └───────────────────────────────────┘│       │   │                               │
│      └────────────────────────────────────────────────────────────────────────────┘       │   │                               │
│                                                                                           │   │                               │
└───────────────────────────────────────────────────────────────────────────────────────────┘   └───────────────────────────────┘
```

Stack：
    -Xss: 指定每个线程栈的字节数

HEAP:
    -Xmx: 指定最大堆内存
    -Xms: 指定堆内存的初始大小
    -Xmn: 年轻代内存大小

NON-HEAP:
    -XX: MaxMetaspaceSize, 设置Metaspace区内存大小，(JDK8+)一般不设置

OFF-HAEP:
    -XX: MaxDirectMemorySize, 设置最大堆外内存