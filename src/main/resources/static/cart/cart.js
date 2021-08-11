 angular.module('appMarket', ['ngStorage']).controller('cartController', function($scope, $http, $localStorage){
     const basePath = 'http://localhost:8181/market';

   $scope.showCart = function(){
        $http({
            url: basePath + "/api/v1/cart",
            metod: 'GET'
        }).then(function(response){
            $scope.cart = response.data;
            $scope.cartPrice = response.data.price;
            console.log(response);
        });
   };

         $scope.addToCart = function(productId){
              $http({
                  url: basePath + "/api/v1/cart/add/" + productId,
                  metod: 'GET'
              }).then(function(response){
                  $scope.showCart();
              });
         };

      $scope.clearCart = function(){
                 $http({
                     url: basePath + "/api/v1/cart/clear",
                     metod: 'GET'
                 }).then(function(response){
                     $scope.cart = null;
                     $scope.cartPrice = 0;
                 });
            };

      $scope.deleteFromCart = function(productTItle){
            $http({
            url: basePath + "/api/v1/cart/delete/" + productTItle,
            metod: 'GET'
            }).then(function(response){
                $scope.showCart();
               });
              };
        $scope.deletePiece = function(productId){
            $http({
            url: basePath + "/api/v1/cart/deletePiece/" + productId,
            metod: 'GET'
            }).then(function(response){
                $scope.showCart();
               });
              };
        $scope.addPiece = function(productTItle){
                $http({
                url: basePath + "/api/v1/cart/addPiece/" + productTItle,
                metod: 'GET'
                }).then(function(response){
                    $scope.showCart();
                   });
                  };

      $scope.showCart();

});