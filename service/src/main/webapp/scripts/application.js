var exposureModule = angular.module('exposure', []);

exposureModule.factory('Iso', function($http) {
    var isos = {};
    isos.query = function() {
        return $http.get("api/iso").then(function (response) {
                return response.data;
            }
        );
    }

    return isos;
});

exposureModule.factory('Aperture', function($http) {
    var apertures = {};
    apertures.query = function() {
        return $http.get("api/aperture").then(function (response) {
                return response.data;
            }
        );
    }

    return apertures;
});

exposureModule.factory('Shutter', function($http) {
    var shutters = {};
    shutters.query = function() {
        return $http.get("api/shutter").then(function (response) {
                return response.data;
            }
        );
    }

    return shutters;
});

exposureModule.controller('InitializeController',

    function($scope, Iso, Aperture, Shutter) {
        Iso.query().then(function(data) {
            $scope.isos = data;
            $scope.isoSet = $scope.isos[0];
        });

        Aperture.query().then(function(data) {
            $scope.apertures = data;
            $scope.apertureSet = $scope.apertures[0];
        });

        Shutter.query().then(function(data) {
            $scope.shutters = data;
            $scope.shutterSet = $scope.shutters[0];
        });

});
