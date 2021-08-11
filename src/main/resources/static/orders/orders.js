angular.module('appMarket').controller('ordersController', function($scope, $http, $localStorage){
    const basePath = 'http://localhost:8181/market';

       $scope.loadOrders = function(){
//            if(!$scope.isUserLoggedIn()){
//                return;
//            }
            $http({
                url: basePath + '/api/v1/orders',
                method: 'GET'
            }).then(function(response){
                $scope.orders = response.data;
            });
        };

//        $scope.createOrder = function(){
//            $http({
//                url: basePath + '/api/v1/orders',
//                method: 'POST'
//            }).then(function(response){
//                alert('Заказ создан');
//                //$scope.showCart();
//                $scope.loadOrders();
//            });
//        };

    $scope.loadOrders();

});