(function ($localStorage) {
    'use strict';

    angular
        .module('appMarket', ['ngRoute', 'ngStorage'])
        .config(config)
        .run(run);

    function config($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'access/access.html',
                controller: 'accessController'
            })
            .when('/products', {
                templateUrl: 'products/products.html',
                controller: 'productsController'
            })
            .when('/cart', {
                templateUrl: 'cart/cart.html',
                controller: 'cartController'
            })
            .when('/orders', {
                templateUrl: 'orders/orders.html',
                controller: 'ordersController'
            })
            .otherwise({
                redirectTo: '/'
            });
    }

    function run($rootScope, $http, $localStorage) {
        if ($localStorage.cur_user) {
            $http.defaults.headers.common.Authorization = 'Bearer ' + $localStorage.cur_user.token;
        }
    }
})();


angular.module('appMarket').controller('indexController', function($rootScope, $scope, $http, $localStorage){
    const basePath = 'http://localhost:8181/market';

        $scope.tryToAuth = function(){
            $http.post(basePath + '/api/v1/auth', $scope.user)
                .then(function successCallback(response){
                    if(response.data.token){
                        $http.defaults.headers.common.Authorization = 'Bearer ' + response.data.token;
                        $localStorage.cur_user = {username: $scope.user.username, token: response.data.token};

                        $scope.user.username = null;
                        $scope.user.password = null;
                    }
                }, function errorCallback(response){
                });
        };

        $scope.clearUser = function(){
            delete $localStorage.cur_user;
            $http.defaults.headers.common.Authorization = '';
        };

        $scope.tryToLogout = function(){
            $scope.clearUser();
            if($scope.user){
                if($scope.user.username){
                    $scope.user.username = null;
                }
                if($scope.user.password){
                    $scope.user.password = null;
                }
            }
        };

//        if($localStorage.cur_user){
//            $http.defaults.headers.common.Authorization = 'Bearer ' + $localStorage.cur_user.token;
//            $scope.loadOrders();
//        }

        $rootScope.isUserLoggedIn = function(){
            if($localStorage.cur_user){
                return true;
            } else {
                return false;
            }
        };

});