angular.module('demo', [])
.controller('Image', function($scope, $http) {
    $http.get('http://localhost:8080/test').
        then(function(response) {
            $scope.test = response.data;
        });
});





