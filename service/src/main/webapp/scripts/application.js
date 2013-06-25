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
        $scope.initial = {};
        $scope.equivalent = {};

        $scope.lock = function() {
            $scope.initial.set = false;
            $scope.initial.reset = true;
            $scope.initial.iso = true;
            $scope.initial.aperture = true;
            $scope.initial.shutter = true;
            $scope.toIso = $scope.isoSet;
            $scope.toAperture = $scope.apertureSet;
            $scope.toShutter = $scope.shutterSet;
            $scope.equivalent.iso = false;
            $scope.equivalent.aperture = false;
            $scope.equivalent.shutter = false;

        }

        $scope.unlock = function() {
            $scope.initial.set = true;
            $scope.initial.reset = false;
            $scope.initial.iso = false;
            $scope.initial.aperture = false;
            $scope.initial.shutter = false;
            $scope.toIso = null;
            $scope.toAperture = null;
            $scope.toShutter = null;
            $scope.equivalent.iso = true;
            $scope.equivalent.aperture = true;
            $scope.equivalent.shutter = true;
        }

        $scope.unlock();

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
