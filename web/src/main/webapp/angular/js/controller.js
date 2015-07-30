'use strict';

//gymApp.controller('WelcomeController',function($scope){
//    $scope.username = 'Conan_Z';
//});

gymApp.controller('IndexPageController',function($scope,$http){
    $http.get('/web/angular/home').success(function(courseList){
        $scope.courseList = courseList;
    });
});

