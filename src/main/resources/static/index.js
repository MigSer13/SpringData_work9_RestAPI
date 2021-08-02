angular.module('appMarket', ['ngStorage']).controller('angularController', function($scope, $http, $LocalStorage){
    const basePath = 'http://localhost:8181/market/api/v1';

    $scope.numberOfPage = 1;
    $scope.listProducts = function(){
        $http({
            url: basePath + '/products',
            metod: 'GET',
            params: {}
        }).then(function(response){
//            $scope.pageNumbers = $scope.generatePagesNumbers(1, response.totalPages);
            $scope.totalPages = response.data.totalPages;
            $scope.productsPage = response.data;
            console.log(response);
            });
    };

//        $scope.generatePagesNumbers = function (startPage, endPage) {
//            let arr = [];
//            for (let i = startPage; i < endPage + 1; i++) {
//                arr.push(i);
//            }
//            return arr;
//        }

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
                $scope.productsPage = response.data;
                });
    };

    $scope.previusPage = function(){
        if($scope.numberOfPage <= 1) {
            $scope.numberOfPage = 1;
        }else{
            $scope.numberOfPage -= 1;
        }
        $scope.showPageOfProducts($scope.numberOfPage);
    }

   $scope.nextPage = function(){
         if($scope.numberOfPage = $scope.totalPages) {
              $scope.numberOfPage = $scope.totalPages;
         }else{
              $scope.numberOfPage += 1;
         }
         $scope.showPageOfProducts($scope.numberOfPage);
   }

   $scope.showCart = function(){
        $http({
            url: basePath + "/cart",
            metod: 'GET'
        }).then(function(response){
            $scope.cart = response.data;
            $scope.cartPrice = response.data.price;
            console.log(response);
        });
   }

      $scope.addToCart = function(productId){
           $http({
               url: basePath + "/cart/add/" + productId,
               metod: 'GET'
           }).then(function(response){
               $scope.showCart();
           });
      }

      $scope.clearCart = function(){
                 $http({
                     url: basePath + "/cart/clear",
                     metod: 'GET'
                 }).then(function(response){
                     $scope.showCart();
                 });
            }

      $scope.deleteFromCart = function(productTItle){
            $http({
            url: basePath + "/cart/delete/" + productTItle,
            metod: 'GET'
            }).then(function(response){
                $scope.showCart();
               });
              }
        $scope.deletePiece = function(productTItle){
            $http({
            url: basePath + "/cart/deletePiece/" + productTItle,
            metod: 'GET'
            }).then(function(response){
                $scope.showCart();
               });
              }
        $scope.addPiece = function(productTItle){
                $http({
                url: basePath + "/cart/addPiece/" + productTItle,
                metod: 'GET'
                }).then(function(response){
                    $scope.showCart();
                   });
                  }

        $scope.loadOrders = function(){
            if(!isUserLoggedIn){
                return;
            }
            $http({
                url: basePath + "/orders",
                metod: "GET"
            }).then (function(response){
                $scope.orders = response.data;
            })
        }

        $scope.createOrders = function(){
            $http({
                url: basePath + "/orders",
                metod: "POST"
            }).then (function(response){
                alert('Заказ создан');
                $scope.showCart();
                $scope.loadOrders();
            })
        }

        $scope.tryToAuth = function(){
            $http.post(basePath + '/auth', $scope.user)
                .then(function successCallback(response){
                    if(response.data.token){
                        $http.default.headers.common.Authorization = 'Bearer ' + response.data.token;
                        $LocalStorage.marketUser = {$username: $scope.user.username, token: response.data.token};

                        $scope.user.username = null;
                        $scope.user.password = null;

                        $scope.loadOrders();
                    }
                }, function errorCallback(response){
                });
        };

        $scope.clearUser() = function(){
            delete $LocalStorage.marketUser;
            $http.default.headers.common.Authorization = '';
        };

        $scope.tryToLogout = function(){
            $scope.clearUser();
            if($scope.user.username){
                $scope.user.username = null;
            }
            if($scope.user.password){
                $scope.user.password = null;
            }
        };

        $scope.isUserLoggedIn = function(){
            if($LocalStorage.marketUser){
                return true;
            } else {
                return false;
            }
        }

        if($LocalStorage.marketUser){
            $http.default.headers.common.Authorization = 'Bearer ' + response.data.token;
            $scope.loadOrders();
        }

    $scope.listProducts();
    $scope.showCart();
});