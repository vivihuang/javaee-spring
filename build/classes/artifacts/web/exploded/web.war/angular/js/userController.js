'use strict';

gymApp.controller('UserController',function($scope,$http){
    $http.get('/web/angular/user').success(function(userList) {
        $scope.userList = userList;
    });

    $scope.hide=[];
    $scope.updateName=[];
    $scope.updateRole=[];

    $scope.deleteUser = function($index,id){

        $http({
            method: 'DELETE',
            url: '/web/angular/user',
            params: {'id': id}
        }).success(function(){
            $scope.userList.splice($index,1);
        }).error(function(){
            alert("删除操作失败，请重试。")
        });
    };

    $scope.updateUser = function($index,$this){
        $scope.hide[$index]=true;
        $scope.updateName[$index]=this.user.name;
        $scope.updateRole[$index]=this.user.employee.role;
    };

    $scope.confirmUpdateUser = function($index,$this) {
        $scope.hide[$index]=false;
        $http({
            method: 'PUT',
            url: '/web/angular/user',
            params: {
                'id': this.user.id,
                'name': $scope.updateName[$index],
                'role': $scope.updateRole[$index]
            }
        }).success(function(user){
            $scope.userList[$index] = user;
        }).error(function(){
            alert("更新操作失败，请重试。");
        });
    };

    $scope.addUser = function() {
        $http({
            method: 'POST',
            url: '/web/angular/user',
            params: {
                'name': $scope.name,
                'password': $scope.password,
                'role': $scope.role
            }
        }).success(function(user){
            console.log(user);
            $scope.userList.push(user);
            $scope.name=null;
            $scope.password=null;
            $scope.role=null;
        }).error(function(){
            alert("增加操作失败，请重试。");
        });
    };
});

//gymApp.controller('AddUserController', function($http,$scope,$location){
//
//    $scope.addUser = function() {
//        $http({
//            method: 'POST',
//            url: '/web/angular/user',
//            params: {
//                'name': $scope.name,
//                'password': $scope.password,
//                'role': $scope.role
//            }
//        }).success(function(){
//            $location.path('/user')
//        });
//    };
//
//});

gymApp.controller('EmployeeController', function ($http,$scope) {
    $http.get('/web/angular/user/employee').success(function(employeeList) {
        $scope.employeeList = employeeList;
    });
});