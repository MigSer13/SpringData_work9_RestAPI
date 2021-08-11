<div>

$scope.numberOfPage = 1;

//    $scope.listProducts = function(){
//        $http({
//            url: basePath + '/products',
//            metod: 'GET',
//            params: {}
//        }).then(function(response){
////            $scope.pageNumbers = $scope.generatePagesNumbers(1, response.totalPages);
//            $scope.totalPages = response.data.totalPages;
//            $scope.productsPage = response.data;
//            console.log(response);
//            });
//    };

//        $scope.generatePagesNumbers = function (startPage, endPage) {
//            let arr = [];
//            for (let i = startPage; i < endPage + 1; i++) {
//                arr.push(i);
//            }
//            return arr;
//        }

    $scope.showPageOfProducts = function(numberOfPage){
        $http({
            url: basePath + '/products/page/' + numberOfPage,
            metod: 'GET',
            params: {}
            }).then(function(response){
                $scope.totalPages = response.data.totalPages;
                $scope.productsPage = response.data;
                console.log(response);
            });
    };
  //
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
                $scope.showPageOfProducts($scope.numberOfPage);
                });
    };

    $scope.previusPage = function(){
        if($scope.numberOfPage <= 1) {
            $scope.numberOfPage = 1;
        }else{
            $scope.numberOfPage -= 1;
        };
        $scope.showPageOfProducts($scope.numberOfPage);
    };

   $scope.nextPage = function(){
         if($scope.numberOfPage = $scope.totalPages) {
              $scope.numberOfPage = $scope.totalPages;
         }else{
              $scope.numberOfPage += 1;
         };
         $scope.showPageOfProducts($scope.numberOfPage);
   };



</div>