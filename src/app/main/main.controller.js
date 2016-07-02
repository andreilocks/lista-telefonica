(function() {
    'use strict';

    angular
        .module('listaTelefonica')
        .controller('MainController', MainController);
    MainController.$inject = ['$scope'];
    /** @ngInject */
    function MainController($scope) {
        $scope.list_of_string = ['tag1', 'tag2'];

        $scope.select2Options = {
            'multiple': true,
            'simple_tags': true,
            'tags': ['tag1', 'tag2', 'tag3', 'tag4'] // Can be empty list.
        };

    }
})();
