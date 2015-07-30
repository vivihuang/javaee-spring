'use strict';

gymApp.controller('UserController',function($scope,$http,$route){
    $http.get('/web/angular/user').success(function(userList) {
        $scope.userList = userList;
    });

    $scope.deleteUser = function(id){
        $http({
            method: 'DELETE',
            url: '/web/angular/user',
            params: {'id': id}
        }).success(function(){
            $route.reload();
        });
    };

    $scope.updateUser = function(event){
        var target = $(event.target);
        var tr = target.parent().parent();
        tr.find("td.update").hide();
        tr.find("td.confirmUpdate").show();
    };

    $scope.confirmUpdateUser = function(event,id) {
        var target = $(event.target);
        var tr = target.parent().parent();
        tr.find("td.update").show();
        tr.find("td.confirmUpdate").hide();

        $http({
            method: 'PUT',
            url: '/web/angular/user',
            params: {
                'id': id,
                'name': $scope.name,
                'role': $scope.role
            }
        }).success(function(){
            $route.reload();
        });
    };
});

gymApp.controller('AddUserController', function($http,$scope,$location){
    $http.get('/web/angular/user').success(function(userList) {
        $scope.userList = userList;
    });

    $scope.addUser = function() {
        $http({
            method: 'POST',
            url: '/web/angular/user',
            params: {
                'name': $scope.name,
                'password': $scope.password,
                'role': $scope.role
            }
        }).success(function(){
            $location.path('/user')
        });
    };

});

gymApp.controller('DeleteUserController', function($http,$scope,$location){
    $http.get('/web/angular/user').success(function(userList){
        $scope.userList = userList;
    });

    $http({
        method: 'DELETE',
        url: '/web/angular/user',
        params: {'id': $scope.id}
    }).success(function() {
        $location.path('/user')
    });
});