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

### 常量池项目类型
|类型|标志|描述|
|:---------:|:--------:|:----------|
|CONSTANT_Utf8_info|1|UF-8编码字符串|
|CONTANT_Integer_info|3|整型字面量|
|CONSTANT_Float_info|3|浮点型字面量|
|CONSTANT_Long_info|5|长整型字面量|
|CONSTANT_Double_info|6|双精度浮点型字面量|
|CONSTANT_Class_info|7|类或接口符号引用|
|CONSTANT_String_info|8|字符串类型字面量|
|CONSTANT_Fieldref_info|9|字段的符号引用|
|CONSTANT_Methodref_Info|10|字段的方法引用|
|CONSTANT_InterfaceMethodref_info|11|接口中方法的符号引用|
|CONSTANT_NameAndType_info|12|字段或方法的部分符号引用|
|CONSTANT_MethodHandle_info|15|表示方法句柄|
|CONSTANT_MethodType_info|16|标识方法类型|
|CONSTANT_InvokeDynamic_info|18|表示一个动态方法调用点|