var exposureModule = angular.module('exposure', []);

exposureModule.config( function($httpProvider) {
    delete $httpProvider.defaults.headers.common['X-Requested-With'];
});

exposureModule.controller('InitializeController',

    function($scope, $http) {
        $http.get("api/iso").success(
            function (data, status, headers, config) {
                $scope.isos = data;
                $scope.isoSet = data[0];
            }
        );

        $http.get("api/aperture").success(
            function (data, status, headers, config) {
                $scope.apertures = data;
                $scope.apertureSet = data[0];
            }
        );

        $http.get("api/shutter").success(
            function (data, status, headers, config) {
                $scope.shutters = data;
                $scope.shutterSet = data[0];
            }
        );

});
