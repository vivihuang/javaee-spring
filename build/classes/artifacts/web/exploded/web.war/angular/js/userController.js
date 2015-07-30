'use strict';

gymApp.controller('UserController',function($scope,$http,$route){
    $http.get('/web/angular/user').success(function(userList) {
        $scope.userList = userList;
    });

    $scope.deleteUser = function(event,id){
        var tr = $(event.target).parent().parent();
        $http({
            method: 'DELETE',
            url: '/web/angular/user',
            params: {'id': id}
        }).success(function(){
            tr.remove();
        });
    };

    $scope.updateUser = function(event){
        var tr = $(event.target).parent().parent();
        tr.find("td.update").hide();
        tr.find("td.confirmUpdate").show();
    };

    $scope.confirmUpdateUser = function($this,event) {
        var tr = $(event.target).parent().parent();
        tr.find("td.update").show();
        tr.find("td.confirmUpdate").hide();
        var user = this.user;

        $http({
            method: 'PUT',
            url: '/web/angular/user',
            params: {
                'id': user.id,
                'name': user.name,
                'role': user.employee.role
            }
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