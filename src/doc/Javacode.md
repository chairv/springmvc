### Class构成
| 类型 | 名称 | 数量|备注|
|:---------:|:---------|:------|---------:|
|u4|magic|1|
|u2|minor_version|1|
|u2|constant_pool_count|1|
|cp_info|constant_pool|constant_pool_count-1|
|u2|access_flag|1|
|u2|this_class|1|
|u2|super_class|1|
|u2|interfaces_count|1|
|u2|interfaces|interfaces_count|
|u2|fields_count|1|
|field_info|fields|fields_count|
|u2|methods_count|1|
|method_info|methods|methods_count|
|u2|attributes_count|1|
|attribute_info|attributes|attributes_count|

