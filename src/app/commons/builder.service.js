(function() {

    angular.module('listaTelefonica')
        .service('ServiceBuilder', ServiceBuilder);

    ServiceBuilder.$injector = ['Restangular'];

    function ServiceBuilder(Restangular) {

        return {
            create: create
        };

        function create() {
            return new Builder(Restangular);
        }

        function Builder(Restangular) {

            var self = this;
            self.restangular = Restangular;
            self.enum = addEnum;
            self.path = addPath;
            self.build = build;

            var enumNames = [],
                pathNames = [],
                restangular = Restangular;

            function addEnum() {
                angular.forEach(arguments || [], function(enumName) {
                    enumNames.push(enumName);
                });
                return self;
            }

            function addPath() {
                angular.forEach(arguments || [], function(pathName) {
                    pathNames.push(pathName);
                });
                return self;
            }

            function build() {
                var service = new Service(restangular, pathNames);
                angular.forEach(enumNames, function(enumName) {
                    service['get' + enumName] = service.getEnumFunction(enumName);
                });

                return service;
            }

        }

        function Service(restangular, paths) {

            var self = this;

            var metadataPromise;

            self.getDefaultRepresentation = getDefaultRepresentation;
            self.getEnumFunction = getEnumFunction;

            var url = paths.join('/');

            function getMetadata() {
                if (!metadataPromise) {
                    metadataPromise = restangular
                        .all(url)
                        .options();
                }
                return metadataPromise;
            }

            function getEnumFunction(name) {
                return function() {
                    return getEnumByName(name);
                };
            }

            function getEnumByName(name) {
                return getMetadata().then(function(metadata) {
                    return metadata.enums[name];
                });
            }

            function getDefaultRepresentation() {
                return getMetadata().then(function(data) {
                    return data.representation.default;
                });
            }

        }
    }
})();
