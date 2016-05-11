/**
 * Created by tancw on 2016/5/11.
 */
var app = angular.module('myApp', []);

app.controller('MyController',function($scope){
  console.info($scope);
    var updateClock = function(){
        $scope.clock = new Date();
    }
    var timer = setInterval(function(){
        $scope.$apply(updateClock);
    },1000);
});


app.controller('DemoController',function($scope){
    $scope.counter = 0;
    $scope.add = function(num){ $scope.counter += num;}
    $scope.substract = function(num){ $scope.counter -= num;}
})