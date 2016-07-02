(function() {

	angular.module('listaTelefonica')
	.config(RestangularConfig);

	RestangularConfig.$inject = ['RestangularProvider'];

	function RestangularConfig(RestangularProvider) {

		RestangularProvider.setBaseUrl('http://localhost:8080/lista-telefonica/rest/');

		RestangularProvider.addResponseInterceptor(function(data) {
			return data;
		});
	}

})();
