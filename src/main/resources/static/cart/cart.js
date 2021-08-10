 $scope.showCart = function(){
        $http({
            url: basePath + "/cart",
            metod: 'GET'
        }).then(function(response){
            $scope.cart = response.data;
            $scope.cartPrice = response.data.price;
            console.log(response);
        });
   };



      $scope.clearCart = function(){
                 $http({
                     url: basePath + "/cart/clear",
                     metod: 'GET'
                 }).then(function(response){
                     $scope.cart = null;
                     $scope.cartPrice = 0;
                 });
            };

      $scope.deleteFromCart = function(productTItle){
            $http({
            url: basePath + "/cart/delete/" + productTItle,
            metod: 'GET'
            }).then(function(response){
                $scope.showCart();
               });
              };
        $scope.deletePiece = function(productId){
            $http({
            url: basePath + "/cart/deletePiece/" + productId,
            metod: 'GET'
            }).then(function(response){
                $scope.showCart();
               });
              };
        $scope.addPiece = function(productTItle){
                $http({
                url: basePath + "/cart/addPiece/" + productTItle,
                metod: 'GET'
                }).then(function(response){
                    $scope.showCart();
                   });
                  };

      $scope.showCart();