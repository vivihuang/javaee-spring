'use strict';

gymApp.controller('CourseArrangementController',function($scope,$http){
    $http.get('/web/angular/courseArrangement').success(function(courseArrangementList) {
        $scope.courseArrangementList = courseArrangementList;
        $http({
            method: 'GET',
            url: '/web/angular/course'
        }).success(function (courseList) {
            $scope.courseList = courseList;
            $http({
                method: 'GET',
                url: '/web/angular/customer'
            }).success(function (customerList) {
                $scope.customerList = customerList;
            });
        });
    });

    $scope.hide=[];
    $scope.updateDate=[];
    $scope.updateCourse=[];
    $scope.updatecoach=[];
    $scope.updateCustomer=[];

    $scope.deleteCourseArrangement = function($index){
        $http({
            method: 'DELETE',
            url: '/web/angular/courseArrangement',
            params: {'id': this.item.id}
        }).success(function(){
            $scope.courseArrangementList.splice($index,1);
        }).error(function(){
            alert("删除操作失败，请重试。")
        });
    };

    $scope.updateCourseArrangement = function($index){
        $scope.hide[$index]=true;
        $scope.updateCourse[$index] = this.item.course;
        $scope.updateCustomer[$index] = this.item.customer;
        $scope.updateDate[$index] = new Date(this.item.date);
    };

    $scope.confirmUpdateCourseArrangement = function($index){
        var courseArrangement = this.item;
        $http({
            method:'PUT',
            url:'/web/angular/courseArrangement',
            params:{
                'id':courseArrangement.id,
                'date': $scope.updateDate[$index],
                'courseId': $scope.updateCourse[$index].id,
                'customerId': $scope.updateCustomer[$index].id
            }
        }).success(function(courseArrangement){
            $scope.courseArrangementList[$index] = courseArrangement;
            $scope.hide[$index]=false;
        }).error(function(){
            alert("更新操作失败，请重试。");
        });
    };

    $scope.addCourseArrangement = function(){
        var newCustomerId = null;
        if ($scope.newCustomer != null) {newCustomerId = $scope.newCustomer.id;}
        console.log($scope.newCourse.id);
        $http({
            method: 'POST',
            url: '/web/angular/courseArrangement',
            params: {
                'date': $scope.newDate,
                'courseId': $scope.newCourse.id,
                'customerId': newCustomerId
            }
        }).success(function(courseArrangement){
            console.log(courseArrangement);
            $scope.courseArrangementList.push(courseArrangement);
            $scope.newDate=null;
            $scope.newCourse=null;
            $scope.newCustomer=null;
        }).error(function(){
            alert("增加操作失败，请重试。");
        });
    };
});