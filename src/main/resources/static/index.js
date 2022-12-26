angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080/store';

    $scope.MySimpleData='Data';

    $scope.loadStudents = function () {
        $http.get(contextPath + '/students')
            .then(function (response) {
                console.log(response);
            $scope.StudentsList = response.data;
        });
    };
    /* Чтобы функцию созданну в js можно было использовать в html, её нужно положить в scope*/
    $scope.deleteStudent = function (studentId) {
       /* alert(studentId); /* выведем в алерте переданный studentId */
        $http.get(contextPath + '/students/delete/' + studentId)
            .then(function (response) {
                alert('Deleted');
                $scope.loadStudents();  /* перегружаем страницу со списком студентов */
            });
    }

    $scope.changeScore = function (studentId, delta) {
        /*Форма для создания шаблона get запроса с @RequestParam*/
        $http({
            url: contextPath + '/students/change_score',
            method: 'GET',
            params: {
                studentId: studentId,
                delta: delta
            }
        }).then(function (response) {
            $scope.loadStudents();
        })
    }

    $scope.loadStudents();
});