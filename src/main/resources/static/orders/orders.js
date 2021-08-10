       $scope.loadOrders = function(){
            if(!$scope.isUserLoggedIn()){
                return;
            }
            $http({
                url: basePath + '/orders',
                method: 'GET'
            }).then(function(response){
                $scope.orders = response.data;
            });
        };

        $scope.createOrder = function(){
            $http({
                url: basePath + '/orders',
                method: 'POST'
            }).then(function(response){
                alert('Заказ создан');
                $scope.showCart();
                $scope.loadOrders();
            });
        };

    $scope.loadOrders();