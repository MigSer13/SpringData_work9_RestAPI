angular.module('appMarket', []).controller('angularController', function($scope, $http){
    const basePath = 'http://localhost:8180/market/api/v1';

    $scope.numberOfPage = 1;
    $scope.listProducts = function(){
        $http({
            url: basePath + '/products',
            metod: 'GET',
            params: {}
        }).then(function(response){
            $scope.products = response.data;
            $scope.pageNumbers = $scope.generatePagesNumbers(1, response.totalPages);
            console.log(response.data);
            });
    };

        $scope.generatePagesNumbers = function (startPage, endPage) {
            let arr = [];
            for (let i = startPage; i < endPage + 1; i++) {
                arr.push(i);
            }
            return arr;
        }

    $scope.infoOfProduct = function(idProduct){
         $http({
            url: basePath + '/products/' + idProduct,
            metod: 'GET',
            params: {}
            }).then(function(response){
                alert(response.data.id + " - " + response.data.title + " - " + response.data.price);
                });
    };

    $scope.deleteOfProduct = function(idProduct){
         $http({
            url: basePath + '/products/delete/' + idProduct,
            metod: 'GET',
            params: {}
            }).then(function(response){
                $scope.listProducts();
                });
        };

    $scope.showPageOfProducts = function(numberOfPage){
        $http({
            url: basePath + '/products/page/' + numberOfPage,
            metod: 'GET',
            params: {}
            }).then(function(response){
                $scope.products = response.data;
                });
    };

    $scope.previusPage = function(){
        if($scope.numberOfPage <= 0) {
            $scope.numberOfPage = 1;
        }else{
            $scope.numberOfPage -= 1;
        }
        $scope.showPageOfProducts($scope.numberOfPage);
    }

   $scope.nextPage = function(){
            if($scope.numberOfPage <= 0) {
                $scope.numberOfPage = 1;
            }else{
                $scope.numberOfPage += 1;
            }
            $scope.showPageOfProducts($scope.numberOfPage);
        }

    $scope.listProducts();
});