angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8989/realbuilder/api/v1';

    $scope.fillTable = function () {
        $http.get(contextPath + '/students')
            .then(function (response) {
                $scope.StudentsList = response.data;
            });
    };

    $scope.deleteStudentById = function (id) {
        $http.delete(contextPath + '/students/' + id)
            .then(function (response) {
                $scope.fillTable()
            });
    };

    $scope.createNewStudent = function () {
        $http.post(contextPath + '/students', $scope.newStudent)
            .then(function (response) {
                $scope.newStudent = null;
                $scope.fillTable();
            });
    };

    $scope.fillTable();

});