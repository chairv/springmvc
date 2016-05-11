/**
 * Created by tancw on 2016/5/6.
 */
var app = angular.module('myApp', []);

app.run(function ($rootScope) {
    $rootScope.name = "Ari Lerner";
    $rootScope.person = {age: 12}
});

//app.controller('PlayerController', ['$scope', function ($scope) {
//
//}]);
//
//app.controller('RelateController', ['$scope', function ($scope) {
//
//}]);

//app.controller('MyController', function ($scope) {
//    $scope.person = {name: "Ari Lerner"};
//    var updateClock = function () {
//        $scope.clock = new Date();
//    };
//
//    var timer = setInterval(function () {
//        $scope.$apply(updateClock);
//    }, 1000);
//    updateClock();
//});