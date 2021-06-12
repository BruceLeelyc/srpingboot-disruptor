mybatis多数据源配置:
<br/>1.添加配置bean,通过@MapperScan扫描不同的dao包:
<br/>&nbsp;&nbsp;&nbsp;&nbsp; basePackages指向具体的包地址
<br/>&nbsp;&nbsp;&nbsp;&nbsp; sqlSessionFactoryRef引用bean中sessionFactory
<br/>&nbsp;&nbsp;&nbsp;&nbsp; 事例:@MapperScan(basePackages = {"com.lixl.mybatis.demo.dao.sys"}, sqlSessionFactoryRef = "sysSqlSessionFactory")
<br/>2.根目录添加mybatis.xml配置文件

<br/>3.Spring boot 整合disruptor
<br/>https://tech.meituan.com/2016/11/18/disruptor.html
<br/>3.1>引入jar包:<dependency>
<br/>&nbsp;&nbsp;&nbsp;&nbsp; <groupId>com.lmax</groupId>
<br/>&nbsp;&nbsp;&nbsp;&nbsp; <artifactId>disruptor</artifactId>
<br/>&nbsp;&nbsp;&nbsp;&nbsp; <version>3.4.2</version>
<br/></dependency>
<br/>3.2>声明一个Event来包含需要传递的数据
<br/>3.3>让Disruptor为我们创建事件，声明EventFactory来实例化Event对象
<br/>3.4>创建事件消费者
<br/>3.5>创建事件生产者
