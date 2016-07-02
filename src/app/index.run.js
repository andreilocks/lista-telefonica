(function() {
  'use strict';

  angular
    .module('listaTelefonica')
    .run(runBlock);

  /** @ngInject */
  function runBlock($log) {

    $log.debug('runBlock end');
  }

})();
