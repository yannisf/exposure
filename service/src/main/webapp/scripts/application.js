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

exposureModule.factory('Equivalent', function($http) {
    var exposure = {};
    exposure.iso = function($scope) {
        var initialIndex = $scope.isoSet.index + "/" + $scope.apertureSet.index + "/" + $scope.shutterSet.index + "/";
        return $http.get("api/expose/" + initialIndex + "?toIso=5").then(function (response) {
                return response.data;
            }
        );
    }

    return exposure;
});


exposureModule.controller('InitializeController',

    function($scope, Iso, Aperture, Shutter, Equivalent) {
        $scope.initial = {};

        $scope.equivalent = {
            loader: {
                show: false
            },
            reset: {
                perform: function($scope) {
                    console.log('Performing reset');
                    copyInitialExposure();
                    this.show = false;
                },
                show: true
            }
        };

        function copyInitialExposure() {
            $scope.toIso = $scope.isoSet;
            $scope.toAperture = $scope.apertureSet;
            $scope.toShutter = $scope.shutterSet;
        }

        $scope.lock = function() {
            $scope.initial.set = false;
            $scope.initial.reset = true;
            $scope.initial.iso = true;
            $scope.initial.aperture = true;
            $scope.initial.shutter = true;
            $scope.equivalent.iso = false;
            $scope.equivalent.aperture = false;
            $scope.equivalent.shutter = false;
            copyInitialExposure();

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

        function equivalentControls(disable) {
            $scope.equivalent.iso = disable;
            $scope.equivalent.aperture = disable;
            $scope.equivalent.shutter = disable;
        }

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

        $scope.updateIso = function() {
            console.log('Updating ISO');
            equivalentControls(true);
            $scope.equivalent.loader.show = true;

            Equivalent.iso($scope).then(function(data) {
                console.log(data, ":", $scope.apertures[data+1])
                $scope.toAperture = $scope.apertures[data+1];
            });

        }

        $scope.updateAperture = function() {
            console.log('Updating aperture');
            equivalentControls(true);
            $scope.equivalent.loader.show = true;
        }

        $scope.updateShutter = function() {
            console.log('Updating shutter');
            equivalentControls(true);
            $scope.equivalent.loader.show = true;
        }

});
