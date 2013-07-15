var exposureModule = angular.module('perfect-exposure', []);

exposureModule.config(function($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'welcome.html'})
        .when('/equivalent', {
            controller: 'EquivalentExposureController',
            templateUrl: 'equivalent.html'})
        .when('/filter', {
            controller: 'FilteredExposureController',
            templateUrl: 'filter.html'})
        .when('/dof', {
            controller: 'DofController',
            templateUrl: 'dof.html'})
        .otherwise({
            redirectTo: '/'
        });
    }
);

exposureModule.factory('Fetch', function($http) {
    return {
        iso: function() {
            return $http.get("api/iso", {cache: true}).then(function (response) {
                return response.data;
            });
        },
        aperture: function() {
            return $http.get("api/aperture", {cache: true}).then(function (response) {
                return response.data;
            });
        },
        shutter: function() {
            return $http.get("api/shutter", {cache: true}).then(function (response) {
                return response.data;
            });
        },
        filter: function() {
            return $http.get("api/filter", {cache: true}).then(function (response) {
                return response.data;
            });
        }
    }
});

exposureModule.factory('Equivalent', function($http) {
    return {
        iso: function($scope) {
            var resource = $scope.initial.construct();
            return $http.get("api/expose/" + resource + "?toIso=" + $scope.equivalent.iso.value.index).then(
                function (response) {
                    return response.data;
                });
        },
        aperture: function($scope) {
            var resource = $scope.initial.construct();
            return $http.get("api/expose/" + resource + "?toAperture=" + $scope.equivalent.aperture.value.index).then(
                function (response) {
                    return response.data;
                });
        },
        shutter: function($scope) {
            var resource = $scope.initial.construct();
            return $http.get("api/expose/" + resource + "?toShutter=" + $scope.equivalent.shutter.value.index).then(
                function (response) {
                    return response.data;
                });
        }
    };
});

exposureModule.factory('Filter', function($http) {
    return {
        shutter: function($scope, stops, shutter) {
            return $http.get("api/filter/" + stops + "?shutter=" + shutter).then(
                function (response) {
                    return response.data;
                });
        }
    };
});

exposureModule.controller('NavController',
    function($scope) {
        $scope.nav = {
            welcome: {
                active: true,
                activate: function() {
                    $scope.nav.welcome.active = true;
                    $scope.nav.equivalent.active = false;
                    $scope.nav.filter.active = false;
                }
            },
            equivalent: {
                active: false,
                activate: function() {
                    $scope.nav.welcome.active = false;
                    $scope.nav.equivalent.active = true;
                    $scope.nav.filter.active = false;
                }
            },
            filter: {
                active: false,
                activate: function() {
                    $scope.nav.welcome.active = false;
                    $scope.nav.equivalent.active = false;
                    $scope.nav.filter.active = true;
                }
            }
        }
});

exposureModule.controller('EquivalentExposureController',
    function($scope, Fetch, Equivalent) {
        $scope.initial = {
            iso: {
                disabled: false,
                value: null,
                loader: {
                    show: true
                }
            },
            aperture: {
                disabled: false,
                value: null,
                loader: {
                    show: true
                }
            },
            shutter: {
                disabled: false,
                value: null,
                loader: {
                    show: true
                }
            },
            disable: function() {
                $scope.initial.iso.disabled = true;
                $scope.initial.aperture.disabled = true;
                $scope.initial.shutter.disabled = true;
            },
            enable: function() {
                $scope.initial.iso.disabled = false;
                $scope.initial.aperture.disabled = false;
                $scope.initial.shutter.disabled = false;
            },
            lock: {
                show: true,
                perform: function() {
                    $scope.initial.lock.show = false;
                    $scope.initial.unlock.show = true;
                    $scope.initial.disable();
                    $scope.equivalent.enable();
                    $scope.equivalent.initialize();
                }
            },
            unlock: {
                show: false,
                perform: function() {
                    $scope.initial.lock.show = true;
                    $scope.initial.unlock.show = false;
                    $scope.initial.enable();
                    $scope.equivalent.reset.show = false;
                    $scope.equivalent.clear();
                    $scope.equivalent.clear();
                    $scope.equivalent.closeInfo();
                }
            },
            construct: function() {
                return $scope.initial.iso.value.index + "/"
                    + $scope.initial.aperture.value.index + "/"
                    + $scope.initial.shutter.value.index + "/";
            }
        };

        $scope.equivalent = {
            iso: {
                disabled: true,
                value: null,
            },
            aperture: {
                disabled: true,
                value: null,
            },
            shutter: {
                disabled: true,
                value: null,
            },
            loader: {
                show: false
            },
            reset: {
                perform: function() {
                    $scope.equivalent.initialize();
                    $scope.equivalent.enable();
                    $scope.equivalent.reset.show = false;
                    //TODO: See if a this.loader.show construct would do
                    $scope.equivalent.loader.show = false;
                    $scope.equivalent.closeInfo();
                },
                show: false
            },
            enable: function() {
                $scope.equivalent.iso.disabled = false;
                $scope.equivalent.aperture.disabled = false;
                $scope.equivalent.shutter.disabled = false;
            },
            disable: function() {
                $scope.equivalent.iso.disabled = true;
                $scope.equivalent.aperture.disabled = true;
                $scope.equivalent.shutter.disabled = true;
            },
            initialize: function() {
                $scope.equivalent.iso.value = $scope.initial.iso.value;
                $scope.equivalent.aperture.value = $scope.initial.aperture.value;
                $scope.equivalent.shutter.value = $scope.initial.shutter.value;
            },
            clear: function() {
                $scope.equivalent.iso.value = null;
                $scope.equivalent.aperture.value = null;
                $scope.equivalent.shutter.value = null;
            },
            preUpdate: function() {
                $scope.equivalent.disable();
                $scope.equivalent.loader.show = true;
                $scope.equivalent.reset.show = true;
            },
            info_show: false,
            success_show: false,
            closeInfo: function() {
                this.info_show = false;
                this.success_show = false;
            }
        };

        Fetch.iso().then(function(data) {
            $scope.isos = data;
            $scope.initial.iso.value = $scope.isos[9];
            $scope.initial.iso.loader.show = false;
        });

        Fetch.aperture().then(function(data) {
            $scope.apertures = data;
            $scope.initial.aperture.value = $scope.apertures[9];
            $scope.initial.aperture.loader.show = false;
        });

        Fetch.shutter().then(function(data) {
            $scope.shutters = data;
            $scope.initial.shutter.value = $scope.shutters[19];
            $scope.initial.shutter.loader.show = false;
        });

        $scope.updateIso = function() {
            $scope.equivalent.preUpdate();
            Equivalent.iso($scope).then(function(data) {
                $scope.equivalent.loader.show = false;
                var updatedIndex = Number(data);
                if (updatedIndex == -1) {
                    $scope.equivalent.info_show = true;
                } else {
                    $scope.equivalent.shutter.value = $scope.shutters[updatedIndex];
                    $scope.equivalent.success_show = true;
                }
            });
        }

        $scope.updateAperture = function() {
            $scope.equivalent.preUpdate();
            Equivalent.aperture($scope).then(function(data) {
                $scope.equivalent.loader.show = false;
                var updatedIndex = Number(data);
                if (updatedIndex == -1) {
                    $scope.equivalent.info_show = true;
                } else {
                    $scope.equivalent.shutter.value = $scope.shutters[updatedIndex];
                    $scope.equivalent.success_show = true;
                }
            });
        }

        $scope.updateShutter = function() {
            $scope.equivalent.preUpdate();
            Equivalent.shutter($scope).then(function(data) {
                $scope.equivalent.loader.show = false;
                var updatedIndex = Number(data);
                if (updatedIndex == -1) {
                    $scope.equivalent.info_show = true;
                } else {
                    $scope.equivalent.aperture.value = $scope.apertures[updatedIndex];
                    $scope.equivalent.success_show = true;
                }
            });
        }

    }
);

exposureModule.controller('FilteredExposureController',
    function($scope, Fetch, Filter) {
        $scope.initial = {
            shutter: null,
            shutters: null,
            shuttersLoaderShow: true,
            filter: null,
            filters: null,
            filtersLoaderShow: true,
            adjust_show: false,
            initialize: function() {
                Fetch.shutter().then(function(data) {
                    $scope.initial.shutters = data;
                    $scope.initial.shutter = $scope.initial.shutters[19];
                    $scope.initial.shuttersLoaderShow = false;
                });
                Fetch.filter().then(function(data) {
                    $scope.initial.filters  = data;
                    $scope.initial.filter = $scope.initial.filters[4];
                    $scope.initial.filtersLoaderShow = false;
                });
            },
            updateShutter: function() {
                this.adjust_show = true;
                $scope.filtered.hideAlerts();
            },
            stackFilter: function() {
                this.adjust_show = true;
                $scope.filtered.hideAlerts();
                $scope.filtered.filters.push($scope.initial.filter);
            },
            adjust: function() {
                this.adjust_show = false;
                $scope.filtered.info_show = true;
                $scope.filtered.success_show = true;
                Filter.shutter($scope,
                        $scope.filtered.totalStrength(),
                        $scope.initial.shutter.value).then(function(data) {
                    console.log('Filtered: ', data);
                    $scope.filtered.shutter = $scope.initial.shutters[Number(data.index)];
                });
            },
            reset: function() {
                this.adjust_show = false;
                $scope.initial.shutter = $scope.initial.shutters[19];
                $scope.initial.filter = $scope.initial.filters[4];
                $scope.filtered.hideAlerts();
                $scope.filtered.filters = [];
            }
        };

        $scope.filtered = {
            info_show: false,
            success_show: false,
            filters: [],
            shutter: null,
            hideAlerts: function() {
                this.info_show = false;
                this.success_show = false;
            },
            table_show: function() {
                return (this.filters.length > 0);
            },
            remove: function(index) {
                console.log('Removing index', index)
                $scope.initial.adjust_show = true;
                $scope.filtered.info_show = false;
                $scope.filtered.success_show = false;
                this.filters.splice(index, 1);
            },
            totalStrength: function() {
                var sum = 0;
                for (var i = 0; i < $scope.filtered.filters.length; i++) {
                    sum += Number(eval($scope.filtered.filters[i].label))
                }
                return sum.toFixed(2);
            }
        }

        $scope.initial.initialize();

    }
);

