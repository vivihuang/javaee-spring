'use strict';

gymApp.controller('UserController',function($scope,$http){
    $http.get('/web/angular/user').success(function(userList) {
        $scope.userList = userList;
    });

    $scope.hide=[];

    $scope.deleteUser = function(index,id){
        $http({
            method: 'DELETE',
            url: '/web/angular/user',
            params: {'id': id}
        }).success(function(){
            $scope.userList.splice(index,1);
        });
    };

    $scope.updateUser = function($index){
        $scope.hide[$index]=true;
    };

    $scope.confirmUpdateUser = function($index,$this) {
        $scope.hide[$index]=false;
        $http({
            method: 'PUT',
            url: '/web/angular/user',
            params: {
                'id': this.user.id,
                'name': this.user.name,
                'role': this.user.employee.role
            }
        });
    };

    $scope.addUser = function() {
        console.log($scope.name);
        $http({
            method: 'POST',
            url: '/web/angular/user',
            params: {
                'name': $scope.name,
                'password': $scope.password,
                'role': $scope.role
            }
        }).success(function(user){
            $scope.userList.push(user);
            $scope.name=null;
            $scope.password=null;
            $scope.role=null;
        });
    };
});

gymApp.controller('AddUserController', function($http,$scope,$location){

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

gymApp.controller('EmployeeController', function ($http,$scope) {
    $http.get('/web/angular/user/employee').success(function(employeeList) {
        $scope.employeeList = employeeList;
    });
});