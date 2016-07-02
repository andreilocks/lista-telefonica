(function(){
	angular.module('listaTelefonica')
		.config(AppStates);

	AppStates.$injector = [];

	function AppStates($urlRouterProvider) {
		$urlRouterProvider.otherwise('contatos');
	}

})();
