angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080/app';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/all')
            .then(function (response) {
                console.log(response);
            $scope.ProductsList = response.data;
        });
    };

    $scope.deleteProduct = function (productId) {
        $http.get(contextPath + '/products/delete/' + productId)
            .then(function (response) {
                alert('Deleted');
                $scope.loadProducts();  /* перегружаем страницу со списком студентов */
            });
    }

    $scope.changeCost = function (productId, delta) {
        /*Форма для создания шаблона get запроса с @RequestParam*/
        $http({
            url: contextPath + '/products/change_score',
            method: 'GET',
            params: {
                productId: productId,
                delta: delta
            }
        }).then(function (response) {
            $scope.loadProducts();
        })
    }

    $scope.addProduct = function (productTitle, productCost) {
        $http({
            url: contextPath + '/products/add_new',
            method: 'GET',
            params: {
                productTitle: productTitle,
                productCost: productCost
            }
        }).then(function (response) {
                $scope.loadProducts();
        })
    }

    $scope.loadProducts();
});