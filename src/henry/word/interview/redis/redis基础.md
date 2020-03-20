## redis 基础

### 一、resid是什么

​		Redis本质上是一个Key-Value类型的内存数据库，很像memcached，整个数据库统统加载在内存当中进行操作，定期通过异步操作把数据库数据flush到硬盘上进行保存。因为是纯内存操作，Redis的性能非常出色，每秒可以处理超过 10万次读写操作，是已知性能最快的Key-Value DB。

​		Redis的主要缺点是数据库容量受到物理内存的限制，不能用作海量数据的高性能读写，因此Redis适合的场景主要局限在较小数据量的高性能操作和运算上。

### 二、redis 数据类型

#### key的常用操作

```lu
   1、keys *   查询所有数据

　　2、exists key名   判断key名是否存在

　　3、move key名  数据库号（0-15）  移动数据key名到相应的数据库

　　4、expire key名 秒  过多少秒key名失效（删除）

　　5、ttl key名 查询key名还有多久过期  -1永不过期  -2已过期（或不存在）

　　6、type key名  判断key名是什么类型
```

#### String

​	是基本的 Key-Value 结构，Key 是某个数据在 Redis 中的唯一标识，Value 是具体的数据。Value最大为512MB

<font color = 'red'>注意：redis中的Key和Value时区分大小写的，命令不区分大小写， redis是单线程 不适合存储大容量的数据</font>

1、set （添加）、 get （获取值）、del（删除） 、append（追加） 、strlen （获取长度）

2、incr （增加1）、decr（减少1） 、incrby（按多少增加） 、decrby （按多少减少）

3、 setrang（添加范围）、getrange（获取范围值） 

```lua
// 存储数据
set key value;
// 获取数据
get key
```

#### Hash

类型很像一个关系型数据库的数据表，hash 的 Key 是一个唯一值，Value 部分是一个 hashmap 的结构。

```lua
#所有的命令以h开头
#获取hash key对应的field的value  (hget user:1:info age) 获取id为1的用户信息的年龄
hget key field

#设置hash key 对应的field的value (hset user:1:info age 23) 设置用户id为1的信息年龄是23
hset key field value

#删除hash key 对应field的value  (hdel user:1:info age) 删除id为1的用户信息年龄属性
hdel key field

#判断hash key是否有field (hexists user:1:info age) 如果age属性存在则返回1 否则返回0
hexists key field

#获取hash key field的数量  (hlen user:1:info) 返回info中的field的数量
hlen key

#设置hash key对应field的value（如果field已经存在，则失败）
hsetnx key field value

#hash key 对应的field的value自增intCounter
hincrby key field intCounter

#hincrby 浮点数版
hincrbyfloat key field floatCounter

#以上命令的时间复杂度为O(1)

#批量获取hash key的一批field对应的值
hmget key field1 field2 ... fieldN

#批量设置hash key的一批field value
hmset key field1 value1 ... fieldN valueN

#返回hash key 对应所有的field和value （小心使用）
hgetall key

#返回hash key对应所有field的value
hvals key

#返回hash key 对应所有field
hkeys key

#以上命令的时间复杂度为O(n)
```

#### List

list 是按照插入顺序排序的字符串链表，可以在头部和尾部插入新的元素（双向链表实现，两端添加元素的时间复杂度为 O(1)）。插入元素时，如果 key 不存在，redis 会为该 key 创建一个新的链表，如果链表中所有的元素都被移除，该 key 也会从 redis 中移除。

1、lpush （队列左先入栈）、 rpush（队列右先入栈） 、Larange

2、lpop（左出）、rpop（右出）注意：这里和开始进入的有关系，即：lpush 、rpush

3、lindex（按照索引下标元素获取值。从上到下）

4、llen（求长度，长度）

5、lrem key  n  key值（删除可以对应的几个key值）

6、ltrim key 开始index 结束index （截取 开始index ----- 结束index 然后复制给 key）从上到下

7、rpoplpush key 

8、lset key index value 

9、linsert key before/after 值1 值2

#### Set

set 数据类型是一个集合（没有排序，不重复），可以对 set 类型的数据进行添加、删除、判断是否存在等操作（时间复杂度是 O(1) ）
set 集合不允许数据重复，如果添加的数据在 set 中已经存在，将只保留一份。
set 类型提供了多个 set 之间的聚合运算，如求交集、并集、补集，这些操作在 redis 内部完成，效率很高。

1、 sadd、smembers key 

2、sismember key value （存在为1，不存在为0）

3、scard key （统计集合里面个数）

4、srem key value（删除里面有的元素）

5、srandmember key 随机数个数（在set中寻找随机数个数）

6、spop key （随机出栈）

7、smove key1  key2  key1中有的值 （将key1中的值移到key2）

8、数学集合 sdiff（差集）、sinter（交集）、sunion（并集）

#### Zset

在 set 的基础上给集合中每个元素关联了一个分数，往有序集合中插入数据时会自动根据这个分数排序。

1、zset key 、zrange key  0 -1 、zset key  0 -1 withscores

2、zrangebyscore key 起始分数 终止分数   ------- （ 不包括

　　　　　　　　　　　　　　　　　　　　　　------ limit 作用返回限制 

　　（1）查找分数在  起始分数 ------ 》 终止分数  的  value（值）

　　（2）查找分数在  起始分数 ------ 》 终止分数 （不包括  分数 （分数   的value（值）

　　（3）查找分数在   起始分数 ------ 》 终止分数  limit  起始下标  截取几位 的value（值）

3、zrem key 删除

4、zcard key (求个数)

5、zcount key 起始分数  终止分数（统计个数）

6、zrank key key（value） ：求下标  zscore key  value ：求key（value）

7、zrevrank key  key（value） ：逆序获取下标

8、zrevange key key（value）：逆序打印







