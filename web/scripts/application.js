var exposureModule = angular.module('exposure', []);

exposureModule.controller('InitializeController',

    function($scope) {
        var apertures = [{text:"f/1.0"}, {text:"f/2.0"}];
        $scope.apertures = apertures;
        $scope.apertureSet=apertures[0];

        var isos  = [{text:"100"}, {text:"200"}];
        $scope.isos = isos;
        $scope.isoSet=isos[0];

        var shutters = [{text:"1/1000"}, {text:"1/500"}];
        $scope.shutters = shutters;
        $scope.shutterSet=shutters[0];

});
