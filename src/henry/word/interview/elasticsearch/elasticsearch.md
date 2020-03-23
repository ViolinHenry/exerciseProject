# elasticsearch

[TOC]

## ES基础

### 1.ES定义
ES = elaticsearch简写， Elasticsearch是**一个开源的高扩展的分布式全文检索引擎**，它可以近乎实时的存储、检索数据；本身扩展性很好，可以扩展到上百台服务器，处理PB级别的数据。 
Elasticsearch也使用Java开发并使用Lucene作为其核心来实现所有索引和搜索的功能，但是它的目的是通过简单的RESTful API来隐藏Lucene的复杂性，从而让全文搜索变得简单。

### 2.Lucene与ES关系
1）Lucene只是一个库。想要使用它，你必须使用Java来作为开发语言并将其直接集成到你的应用中，更糟糕的是，Lucene非常复杂，你需要深入了解检索的相关知识来理解它是如何工作的。

2）Elasticsearch也使用Java开发并使用Lucene作为其核心来实现所有索引和搜索的功能，但是它的目的是通过简单的RESTful API来隐藏Lucene的复杂性，从而让全文搜索变得简单。


### 3.ES主要解决问题
1）检索相关数据； 

2）返回统计结果； 

3）速度要快。


### 4.ES工作原理
当ElasticSearch的节点启动后，它会利用多播(multicast)(或者单播，如果用户更改了配置)寻找集群中的其它节点，并与之建立连接。这个过程如下图所示： 

![](ES_pic/871aebe7.png)

### 5.ES核心概念

#### 1）Cluster：集群

ES可以作为一个独立的单个搜索服务器。不过，为了处理大型数据集，实现容错和高可用性，ES可以运行在许多互相合作的服务器上。这些服务器的集合称为集群。

#### 2）Node：节点

形成集群的每个服务器称为节点。

#### 3）Shard：分片

当有大量的文档时，由于内存的限制、磁盘处理能力不足、无法足够快的响应客户端的请求等，一个节点可能不够。这种情况下，数据可以分为较小的分片。每个分片放到不同的服务器上。 

当你查询的索引分布在多个分片上时，ES会把查询发送给每个相关的分片，并将结果组合在一起，而应用程序并不知道分片的存在。即：这个过程对用户来说是透明的。

#### 4）Replica：副本
为提高查询吞吐量或实现高可用性，可以使用分片副本。 

副本是一个分片的精确复制，每个分片可以有零个或多个副本。ES中可以有许多相同的分片，其中之一被选择更改索引操作，这种特殊的分片称为主分片。 

每个shard的replica一般情况下会分布在不同的主机中。

当主分片丢失时，如：该分片所在的数据不可用时，集群将副本提升为新的主分片。

#### 5）全文检索

全文检索就是对一篇文章进行索引，可以根据关键字搜索，类似于mysql里的like语句。 

全文索引就是把内容根据词的意义进行分词，然后分别创建索引，例如”你们的激情是因为什么事情来的” 可能会被分词成：“你们“，”激情“，“什么事情“，”来“ 等token，这样当你搜索“你们” 或者 “激情” 都会把这句搜出来。


### 6.ES数据架构的主要概念（与关系数据库Mysql对比）

![](ES_pic/18f3c549.png)

* （1）关系型数据库中的数据库（DataBase），等价于ES中的索引（Index），**Index是ES存储数据的基本单位**。

* （2）一个数据库下面有N张表（Table），等价于1个索引Index下面有N多类型（Type）。

* （3）一个数据库表（Table）下的数据由多行（ROW）多列（column，属性）组成，等价于1个Type由多个文档（Document）和多Field组成。 

* （4）在一个关系型数据库里面，schema定义了表、每个表的字段，还有表和字段之间的关系。 与之对应的，在ES中：Mapping定义索引下的Type的字段处理规则，即索引如何建立、索引类型、是否保存原始索引JSON文档、是否压缩原始JSON文档、是否需要分词处理、如何进行分词处理等。 

* （5）在数据库中的增insert、删delete、改update、查search操作等价于ES中的增PUT/POST、删Delete、改Update、查GET。


### 7.ELK是什么

ELK=elasticsearch+Logstash+kibana 

elasticsearch：后台分布式存储以及全文检索 

logstash: 日志加工、“搬运工” 

kibana：数据可视化展示。 

ELK架构为数据分布式存储、可视化查询和日志解析创建了一个功能强大的管理链。 三者相互配合，取长补短，共同完成分布式大数据处理工作。

### 8.ES特点和优势

1）分布式实时文件存储，可将每一个字段存入索引，使其可以被检索到。 

2）实时分析的分布式搜索引擎。 
分布式：索引分拆成多个分片，每个分片可有零个或多个副本。集群中的每个数据节点都可承载一个或多个分片，并且协调和处理各种操作； 
负载再平衡和路由在大多数情况下自动完成。 

3）可以扩展到上百台服务器，处理PB级别的结构化或非结构化数据。也可以运行在单台PC上（已测试） 

4）支持插件机制，分词插件、同步插件、Hadoop插件、可视化插件等。



## elasticsearch分布式架构原理

### 1.倒排索引

倒排索引（Inverted Index）也叫反向索引，有反向索引必有正向索引。通俗地来讲，正向索引是通过key找value，反向索引则是通过value找key。

其实就是直接PUT一个JSON的对象，这个对象有多个字段，在插入这些数据到索引的同时，Elasticsearch还为这些字段建立索引——倒排索引，因为Elasticsearch最核心功能是搜索。

那么，倒排索引是个什么样子呢？

![](ES_pic/c5902e1e.png)

首先，来搞清楚几个概念，为此，举个例子：

假设有个user索引，它有四个字段：分别是name，gender，age，address。画出来的话，大概是下面这个样子，跟关系型数据库一样

![](ES_pic/2b5838aa.png)

**Term（单词）**：一段文本经过分析器分析以后就会输出一串单词，这一个一个的就叫做Term（直译为：单词）

**Term Dictionary（单词字典）**：顾名思义，它里面维护的是Term，可以理解为Term的集合

**Term Index（单词索引）**：为了更快的找到某个单词，我们为单词建立索引

**Posting List（倒排列表）**：倒排列表记录了出现过某个单词的所有文档的文档列表及单词在该文档中出现的位置信息，每条记录称为一个倒排项(Posting)。根据倒排列表，即可获知哪些文档包含某个单词。（PS：实际的倒排列表中并不只是存了文档ID这么简单，还有一些其它的信息，比如：词频（Term出现的次数）、偏移量（offset）等，可以想象成是Python中的元组，或者Java中的对象）

（PS：如果类比现代汉语词典的话，那么Term就相当于词语，Term Dictionary相当于汉语词典本身，Term Index相当于词典的目录索引）

我们知道，每个文档都有一个ID，如果插入的时候没有指定的话，Elasticsearch会自动生成一个，因此ID字段就不多说了

上面的例子，Elasticsearch建立的索引大致如下：

name字段：

![](ES_pic/6176ba88.png)

age字段：

![](ES_pic/79f5fe9e.png)

gender字段：

![](ES_pic/c7e194ff.png)

address字段：

![](ES_pic/bd4ff29d.png)

Elasticsearch分别为每个字段都建立了一个倒排索引。比如，在上面“张三”、“北京市”、22 这些都是Term，而[1，3]就是Posting List。Posting list就是一个数组，存储了所有符合某个Term的文档ID。

只要知道文档ID，就能快速找到文档。可是，要怎样通过我们给定的关键词快速找到这个Term呢？

当然是建索引了，为Terms建立索引，最好的就是B-Tree索引（PS：MySQL就是B树索引最好的例子）。

首先，让我们来回忆一下MyISAM存储引擎中的索引是什么样的：

![](ES_pic/8e6da260.png)

![](ES_pic/3542cf27.png)

我们查找Term的过程跟在MyISAM中记录ID的过程大致是一样的

MyISAM中，索引和数据是分开，通过索引可以找到记录的地址，进而可以找到这条记录

在倒排索引中，通过Term索引可以找到Term在Term Dictionary中的位置，进而找到Posting List，有了倒排列表就可以根据ID找到文档了

（PS：可以这样理解，类比MyISAM的话，Term Index相当于索引文件，Term Dictionary相当于数据文件）

（PS：其实，前面我们分了三步，我们可以把Term Index和Term Dictionary看成一步，就是找Term。因此，可以这样理解倒排索引：通过单词找到对应的倒排列表，根据倒排列表中的倒排项进而可以找到文档记录）

为了更进一步理解，下面从网上摘了两张图来具现化这一过程：

![](ES_pic/a4aae7d3.png)

![](ES_pic/5eec24b1.png)



### 3.ES写入原理

 1）先写入buffer，在buffer里的时候数据是搜索不到的，同时将数据写入translog日志文件。
 
 2）如果buffer快满了，或者到一定时间，就会将buffer数据refresh到一个新的segment file中，但是此时数据不能直接进入segment file的磁盘文件，而是先进入os cache。
    
   默认是每隔1秒refresh一次，所以es是准实时的，因为写入的数据1秒之后才能被看到。可以手动refresh，就是手动将buffer数据刷入os cache中，让数据可以被搜索到。
     
   只要数据被输入os cache中，buffer就会被清空，因为不需要保留buffer，数据在translog里已经持久化到磁盘去了。
 
 3）只要数据进入os cache，此时就可以让这个segment file的数据对外提供搜索了。
 
 4）重复1~3步骤，新的数据不断进入buffer和translog，不断将buffer数据写入一个又一个新的segment file中，每次refresh完成，buffer清空，translog保留。随着这个过程推进，translog会变得越来越大。当translog达到一定长度时，就会触发commit操作。

 5）commit操作发生第一步，将buffer中现有数据refresh到os cache中去，清空buffer。
 
 6）将一个commit point写入磁盘文件，里面标识这个commit point对应的所有segment file。
 
 7）强行将os cache中目前所有的数据都fsync（强刷）到磁盘中去。
 
 8）将现有的translog清空，然后重新启用一个translog，此时commit操作完成。默认每隔30分钟会自动执行一次commit，但是如果translog过大，也会触发commit。整个commit的过程叫做flush操作。我们可以手动执行flush操作，就是将所有os cache数据刷到磁盘文件中。

 9）translog其实也是先写入os cache的，默认每隔5秒刷一次到磁盘中去，所以默认情况下，可能有5秒的数据会仅仅提留在buffer或translog文件的os cache中，如果此时机器宕机了，会丢失5秒钟的数据。但是这样性能比较好，最多丢5秒的数据。也可以将translog设置成每次写操作必须是直接fsync到磁盘，但这样性能就会差很多。
 
 10）如果是删除操作，commit的时候会生成一个.del文件，里面讲某个doc标识为deleted状态，那么搜索的时候根据.del文件就知道这个doc被删除了。
 
 11）如果是更新操作，就是原来的doc标识为deleted状态，然后写入一条数据。
 
 12）buffer每一次refresh一次，就会产生一个segment file，所以默认情况下是1秒钟一个segment file，segment file会越来越多，此时会定期执行merge。
 
 13）每次merge的时候，会将多个segment file合并成一个，同时这里会将标识为deleted的doc给物理删除，然后将新的segment file写入磁盘，这里会写一个commit point，标识所有新的segment file，然后打开segment file供搜索使用，同时删除就的segment file。


### 2.ES写入过程

 1） 客户端选择一个node发送请求，这个node就是coordinating node（协调节点）。
 
 2） coordinating node对document进行路由，将请求转发给对应的node（有primary shard）。
 
 3） primary shard处理node的请求，然后将数据同步到replica node。
 
 4） coordinating node发现primary node和所有replica node都完成之后，就返回响应结果给客户端。




### 3.ES读取过程
 1） 客户端选择任意一个node成为coordinating node（协调节点）。
 
 2） coordinating node对document进行路由，将请求转发给对应的node，此时会使用round-robin随机轮询算法，在primary shard及其所有的replica中随机选择一个，让读请求负载均衡。

 3） 接受请求的node返回document给coordinating node。
 
 4） coordinating node返回document给客户端。
 
### 4.ES搜索过程

 1） 客户端发送请求到一个coordinating node。
 
 2） 协调节点将搜索请求转发到所有的shard对应的primary shard或replica shard。
  
 3） query phase：每个shard将自己的搜索结果（其实就是一些doc id），返回给协调节点，由协调节点进行数据的合并、排序和分页等操作，产出最终结果。
 
 4） fetch phase：接着由协调节点根据doc id去各个节点上拉取实际的document数据，最终返回给客户端。


### 5.如何优化es查询性能

#### 1）性能优化的杀手锏--filesystem cache

es的搜索引擎严重依赖于底层filesystem cache，如果给filesystem cache更多的内存，尽量让内存可以容纳所有的index segment file索引数据文件，那么你的搜索的时候基本都是走内存的，性能会非常高。

es减少数据量，仅用来存放用于搜索的相关关键字段即可，尽量写入es的数据量跟es机器的filesystem cache是差不多的就可以了；其他不用来检索的数据放hbase里，或者mysql。


#### 2）缓存预热

对于一些经常使用和访问的数据，可以通过一个专门的缓存预热子系统，就是对热数据，每隔一段时间，系统会去搜索一下热数据，刷到filesystem cache里，后面的用户实际上来查看这个数据的时候，就是直接从内存里来搜索的。



#### 3）冷热分离

将大量不搜索的字段，拆分到别的存储在中，这个就是类似mysql分库分表的垂直拆分。

es可以做类似于mysql的水平拆分，将大量访问很少，频率很低的数据，单独写一个索引，然后将访问很频繁的热数据单独写一个索引。


#### 4）document模型设计

document模型设计是非常重要的，很多操作，不要在搜索的时候才想去执行各种复杂的乱七八糟的操作。es能支持的操作就是那么多，不要考虑用es做一些不好操作的事情。如果真的有那种操作，尽量在document模型设计的时候，写入的时候完成。另外对于一些太复杂的操作，如join，nested，parent-child搜索都要尽量避免。


#### 5）分页性能优化

* 不允许深度分页

* 针对这个问题，你可以考虑用scroll来进行处理，scroll的原理实际上是保留一个数据快照，然后在一定时间内，你如果不断的滑动往后翻页的时候，类似于你现在在浏览微博，不断往下刷新翻页。那么就用scroll不断通过游标获取下一页数据，这个性能是很高的，比es实际翻页要好的多的多。
但是唯一的一点就是，这个适合于那种类似微博下拉翻页的，不能随意跳到任何一页的场景。同时这个scroll是要保留一段时间内的数据快照的，你需要确保用户不会持续不断翻页翻几个小时。


### 6.es的部署

（1）es生产集群我们部署了5台机器，每台机器是6核64G的，集群总内存是320G

（2）我们es集群的日增量数据大概是2000万条，每天日增量数据大概是500MB，每月增量数据大概是6亿，15G。目前系统已经运行了几个月，现在es集群里数据总量大概是100G左右。

（3）目前线上有5个索引（这个结合你们自己业务来，看看自己有哪些数据可以放es的），每个索引的数据量大概是20G，所以这个数据量之内，我们每个索引分配的是8个shard，比默认的5个shard多了3个shard。





