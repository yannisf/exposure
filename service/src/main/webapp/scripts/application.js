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
        var resource = $scope.isoSet.index + "/" + $scope.apertureSet.index + "/" + $scope.shutterSet.index + "/";
        return $http.get("api/expose/" + initialIndex + "?toIso=" + $scope.toIso.index).then(function (response) {
                return response.data;
            }
        );
    }

    exposure.aperture = function($scope) {
        var initialIndex = $scope.isoSet.index + "/" + $scope.apertureSet.index + "/" + $scope.shutterSet.index + "/";
        return $http.get("api/expose/" + initialIndex + "?toAperture=" + $scope.toAperture.index).then(function (response) {
                return response.data;
            }
        );
    }

    exposure.shutter = function($scope) {
        var initialIndex = $scope.isoSet.index + "/" + $scope.apertureSet.index + "/" + $scope.shutterSet.index + "/";
        return $http.get("api/expose/" + initialIndex + "?toShutter=" + $scope.toShutter.index).then(function (response) {
                return response.data;
            }
        );
    }

    return exposure;
});


exposureModule.controller('InitializeController',

    function($scope, Iso, Aperture, Shutter, Equivalent) {

        $scope.initial = {
            "_iso": {
                "loader": {
                    "show": true
                }
            },
            "_aperture": {
                "loader": {
                    "show": true
                }
            },
            "_shutter": {
                "loader": {
                    show: true
                }
            }
        };

        $scope.equivalent = {
            loader: {
                show: false
            },
            reset: {
                perform: function() {
                    copyInitialExposure();
                    enableEquivalentExposure();
                    this.show = false;
                    //TODO: See if a this.loader.show construct would do
                    $scope.equivalent.loader.show = false;
                },
                show: true
            }
        };

        function copyInitialExposure() {
            $scope.toIso = $scope.isoSet;
            $scope.toAperture = $scope.apertureSet;
            $scope.toShutter = $scope.shutterSet;
        }

        function enableEquivalentExposure() {
            $scope.equivalent.iso = false;
            $scope.equivalent.aperture = false;
            $scope.equivalent.shutter = false;

        }

        $scope.lock = function() {
            $scope.initial.lock = false;
            $scope.initial.unlock = true;
            $scope.initial.iso = true;
            $scope.initial.aperture = true;
            $scope.initial.shutter = true;
            $scope.equivalent.iso = false;
            $scope.equivalent.aperture = false;
            $scope.equivalent.shutter = false;
            $scope.equivalent.reset.show = false;
            copyInitialExposure();

        }

        $scope.unlock = function() {
            $scope.initial.lock = true;
            $scope.initial.unlock = false;
            $scope.initial.iso = false;
            $scope.initial.aperture = false;
            $scope.initial.shutter = false;
            $scope.toIso = null;
            $scope.toAperture = null;
            $scope.toShutter = null;
            $scope.equivalent.iso = true;
            $scope.equivalent.aperture = true;
            $scope.equivalent.shutter = true;
            $scope.equivalent.reset.show = false;
        }

        $scope.unlock();

        function equivalentControlsDisable(disable) {
            $scope.equivalent.iso = disable;
            $scope.equivalent.aperture = disable;
            $scope.equivalent.shutter = disable;
        }

        Iso.query().then(function(data) {
            $scope.isos = data;
            $scope.isoSet = $scope.isos[9];
            $scope.initial._iso.loader.show = false;
        });

        Aperture.query().then(function(data) {
            $scope.apertures = data;
            $scope.apertureSet = $scope.apertures[9];
            $scope.initial._aperture.loader.show = false;
        });

        Shutter.query().then(function(data) {
            $scope.shutters = data;
            $scope.shutterSet = $scope.shutters[19];
            $scope.initial._shutter.loader.show = false;
        });

        $scope.updateIso = function() {
            equivalentControlsDisable(true);
            $scope.equivalent.loader.show = true;
            $scope.equivalent.reset.show = true;

            Equivalent.iso($scope).then(function(data) {
                var index = Number(data);
                $scope.toShutter = $scope.shutters[index];
                $scope.equivalent.loader.show = false;
            });
        }

        $scope.updateAperture = function() {
            equivalentControlsDisable(true);
            $scope.equivalent.loader.show = true;
            $scope.equivalent.reset.show = true;

            Equivalent.aperture($scope).then(function(data) {
                var index = Number(data);
                $scope.toShutter = $scope.shutters[index];
                $scope.equivalent.loader.show = false;
            });
        }

        $scope.updateShutter = function() {
            equivalentControlsDisable(true);
            $scope.equivalent.loader.show = true;
            $scope.equivalent.reset.show = true;

            Equivalent.shutter($scope).then(function(data) {
                var index = Number(data);
                $scope.toAperture = $scope.apertures[index];
                $scope.equivalent.loader.show = false;
            });

        }

});
