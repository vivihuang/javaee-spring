'use strict';

var gymApp = angular.module('gymApp', ['ngRoute']);

gymApp.config(['$routeProvider',function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: '/web/angular/view/home.html',
            controller: 'IndexPageController'
        })
        .when('/user', {
            templateUrl: '/web/angular/view/user.html',
            controller: 'UserController'
        })
        .when('/user/add', {
            templateUrl: '/web/angular/view/addUser.html',
            controller: 'AddUserController'
        })
        .when('/user/employee', {
            templateUrl: '/web/angular/view/employee.html',
            controller: 'EmployeeController'
        })
        .when('/courseArrangement', {
            templateUrl: '/web/angular/view/courseArrangement.html',
            controller: 'CourseArrangementController'
        })
        .otherwise({
            redirectTo: '/'
        });
}]);