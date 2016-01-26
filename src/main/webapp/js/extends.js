/**
 * Created by tancw on 2016/1/6.
 * prototy: js类式继承的实现依靠原型链,什么是原型链,js对象有个属性propoty,这个属性返回对象类型的引用,用于提供的类的一组基本功能
 * new: 创建一个隐藏连接到该函数的prototype成员的新对象，同时this将被绑定到那个新对象上
 */

var Person = function (name) {
    this.name = name;
}

Person.prototype = {
    getName: function () {
        return this.name;
    }
}

var Chinese = function (name, nation) {
    this.nation = nation;
}

Chinese.prototype = new Person();

Chinese.prototype.getNation = function(){
    return this.nation;
}


function Foo(y){
    debugger;
  this.y = y;
}

Foo.prototype.x = 10;
Foo.prototype.calculate = function(z){
    return this.x + this.y + z;
}


