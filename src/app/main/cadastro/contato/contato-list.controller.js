(function() {
  'use strict';
  angular.module('listaTelefonica')
    .controller('cadastro.ListContatoController', ListContatoController);

  ListContatoController.$inject = ['cadastro.ContatoService','$uibModal'];

  function ListContatoController(ContatoService,$uibModal) {

    var vm = this,
      id = 0;

    vm.open = open;
    vm.remove = remove;
    vm.adicionar = adicionar;

    ContatoService.getDefaultRepresentation().then(function(data) {
      vm.felipe = data;
    });



    vm.contatos = [
      {
        "id": id++,
        "nome": 'André',
        "email": 'andre.sidera@gmail.com',
        "telefones": [
          {
            "id": id++,
            "telefone": "8899-1010"
          },
          {
            "id": id++,
            "telefone": "3441-1010"
          }
        ]
      },
      {
        "id": id++,
        "nome": 'Luana',
        "email": 'luana.araujo@gmail.com',
        "telefones":[
          {
            "id": id++,
            "telefone": "8811-1010"
          },
          {
            "id": id++,
            "telefone": "3312-1010"
          }
        ]
      }
    ];


    function remove($index) {
      vm.contatos.splice($index, 1);
    }

    function adicionar() {
      vm.contatos.push({
        id: id++,
        telefones: [{}]
      });
    }

    function open(index) {
      var modalInstance = $uibModal.open({
        animation: vm.animationsEnabled,
        templateUrl: 'app/main/cadastro/contato/contato-cad.html',
        controller: 'cadastro.ListContatoControllerCad',
        controllerAs: 'vm',
        size: 'lg',
        resolve: {
          contatos: function() {
            return vm.contatos;
          },
          contato: function() {
            if (index == undefined) {
              return {
                id: id++,
                telefones: [{}]
              };
            }
            return vm.contatos[index];
          }
        }
      });

      modalInstance.result.then(function(selectedItem) {
        vm.selected = selectedItem;
      }, function() {
        // $log.info('Modal dismissed at: ' + new Date());
      });
    }
  }

})();
