(function() {
    angular.module('listaTelefonica')
        .config(CadastroStates);

    CadastroStates.$injector = ['$stateProvider'];

    function CadastroStates($stateProvider) {

        $stateProvider
            .state('contatos', {
                url: '/contatos',
                templateUrl: 'app/main/cadastro/contato/contato-list.html',
                controller: 'cadastro.ListContatoController as vm'
            });
    }

})();
