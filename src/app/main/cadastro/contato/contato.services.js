(function(){

	angular.module('listaTelefonica')
	.service('cadastro.ContatoService', service);

	service.$injector = ['Restangular'];

	function service(Restangular) {

		return {
			getDefaultRepresentation: getDefaultRepresentation
		};

		function options() {
			return Restangular.all('contatos').options();
		}

		function getDefaultRepresentation() {
			return options().then(representation);
		}

		function representation(data) {
			return data.representation.default;
		}
	}

})();
