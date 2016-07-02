(function() {
    'use strict';

    angular.module('listaTelefonica').controller('cadastro.ListContatoControllerCad', Controller);

    Controller.$inject = ['$uibModalInstance', 'contatos','contato'];

    function Controller($uibModalInstance, contatos, contato) {
        var vm = this;
        vm.contatos = contatos;
        vm.contato = contato;
        vm.save = save;
        vm.cancel = cancel;

        function save() {
            if (vm.contatos) {
                vm.contatos.push(vm.contato);
            }
            $uibModalInstance.close();
        }

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }

    }

})();
