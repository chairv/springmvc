```
 u1: 1个字节
 u2: 2个字节
 u4: 4个字节
 u8: 8个字节
```
### Class构成
| 类型 | 名称 | 数量|备注|
|:---------:|:---------|:------|---------:|
|u4|magic|1|魔数|
|u2|minor_version|1|次版本号|
|u2|major_version|1|主版本号|
|u2|constant_pool_count|1|常量池大小[1-21]|
|cp_info|constant_pool|constant_pool_count-1|常量池表|
|u2|access_flag|1|访问标志|
|u2|this_class|1|类索引|
|u2|super_class|1|父类索引|
|u2|interfaces_count|1|接口计数器|
|u2|interfaces|interfaces_count|接口索引集合|
|u2|fields_count|1|字段计数器|
|field_info|fields|fields_count|字段表集合|
|u2|methods_count|1|方法计数器|
|method_info|methods|methods_count|方法表集合|
|u2|attributes_count|1|属性表计数器|
|attribute_info|attributes|attributes_count|属性表集合|

