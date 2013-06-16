var exposureModule = angular.module('exposure', []);

exposureModule.controller('LoadApertures',
    function($scope) {
        var apertures = [{index:0, label:"f/1.0"}, {index:1, label:"f/2.0"}];
        $scope.apertures = apertures;
});

exposureModule.controller('LoadIsos',
    function($scope) {
        var isos  = [{index:0, label:"100"}, {index:1, label:"200"}];
        $scope.isos = isos;
});

exposureModule.controller('LoadShutters',
    function($scope) {
        var shutters = [{index:0, label:"1/1000"}, {index:1, label:"1/500"}];
        $scope.shutters = shutters;
});

