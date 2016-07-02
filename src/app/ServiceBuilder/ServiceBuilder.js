// 'use strict';

//     angular.module('generic-service')
//         .factory('ServiceBuilder', ServiceBuilder);

//     ServiceBuilder.$inject = ['Restangular', 'MetadataCache', 'EventEmitter'];

//     function ServiceBuilder(DefaultRestangular, MetadataCache, EventEmitter) {

//         return {
//             create: create
//         };

//         function create() {
//             return new Builder(DefaultRestangular);
//         }

//         function Builder(defaultRestangular) {
//             var self = this;
//             var restangular = defaultRestangular;
//             var paths = [];
//             var enumNames = [];
//             var isPageable = true;

//             self.restangular = setRestangular;
//             self.path = addPath;
//             self.enum = addEnum;
//             self.build = build;
//             self.pageable = pageable;

//             function setRestangular(custom) {
//                 restangular = custom;
//                 return self;
//             }

//             function addPath() {
//                 _.forEach(arguments || [], function (path) {
//                     paths.push(path);
//                 });
//                 return self;
//             }

//             function addEnum() {
//                 _.forEach(arguments || [], function (enumName) {
//                     enumNames.push(enumName);
//                 });
//                 return self;
//             }

//             function pageable(pageable) {
//                 isPageable = pageable;
//                 return self;
//             }

//             function build() {
//                 var service = new Service(restangular, paths, isPageable);
//                 angular.forEach(enumNames, function (enumName) {
//                     service['get' + enumName] = service.metadata.enumProxyFunction(enumName);
//                 });
//                 return service;
//             }
//         }

//         function Service(restangular, paths, isPageable, pathResolvers) {
//             var self = this;
//             var dynamicUrl = !_.isEmpty(pathResolvers);
//             var emiter = new EventEmitter();
//             _.extend(self, emiter);

//             pathResolvers = pathResolvers || {};

//             this.restangular = restangular;
//             this.staticUrl = paths.join('/');

//             this.putPathResolver = putPathResolver;
//             this.getEndpoint = getEndpoint;

//             this.metadata = MetadataCache.create(getEndpoint);
//             this.getEnum = this.metadata.getEnum;
//             this.getMetadataEnums = this.metadata.getMetadataEnums;

//             this.getDefaultRepresentation = this.metadata.getDefaultRepresentation;

//             this.get = get;
//             this.list = list;
//             this.listByParams = listByParams;
//             this.listCompleteByParams = listCompleteByParams;
//             this.save = save;
//             this.remove = remove;

//             function putPathResolver(path, resolveFunction) {
//                 var newResolvers = _.clone(pathResolvers);
//                 newResolvers[path] = resolveFunction;
//                 return new Service(restangular, paths, isPageable, newResolvers);
//             }

//             function getEndpoint() {
//                 var url = resolveUrl();

//                 return url ? self.restangular.allUrl(url) : self.restangular;
//             }

//             function resolveUrl() {
//                 return dynamicUrl ? _.reduce(paths, accumulator) : self.staticUrl;
//             }

//             function accumulator(url, path) {
//                 var resolver = pathResolvers[path];
//                 url += '/';
//                 url += resolver ? resolver() : path;
//                 return url;
//             }

//             function get(id) {
//                 return getEndpoint().get(id);
//             }

//             function list(filter, offset, limit, sort) {
//                 var params = {
//                     filter: filter,
//                     offset: offset,
//                     limit: limit,
//                     sort: sort
//                 };

//                 return listByParams(params);
//             }

//             function listByParams(params) {
//                 if (isPageable) {
//                     return getEndpoint().get('', params);
//                 } else {
//                     return getEndpoint().getList(params);
//                 }
//             }

//             function listCompleteByParams(params) {
//                 if (isPageable) {
//                     return getEndpoint().get('completos', params);
//                 } else {
//                     return getEndpoint().all('completos').getList(params);
//                 }
//             }

//             function save(entity) {
//                 var endpoint = getEndpoint();
//                 var id = entity.id;
//                 return id ? endpoint.customPUT(entity, id).then(emitDirty) : endpoint.post(entity).then(emitDirty);
//             }

//             function remove(entity) {
//                 return getEndpoint().customDELETE(entity.id.toString()).then(emitDirty);
//             }

//             function emitDirty(data) {
//                 emiter.emit('dirty');
//                 return data;
//             }
//         }
//     }
// })();