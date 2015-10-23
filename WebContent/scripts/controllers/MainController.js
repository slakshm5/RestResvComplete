(function(){
	'use strict';
	
	angular.module('restResv').controller('MainController', MainControllerFn);
	
	MainCotrollerFn.$inject =['http'];
	function MainControllerFn($http){
		var self = this;
		
		
		self.getAllCustomers = function(){
			$http({
				mathod:'GET',
				url: '/api/customer/all'
			}).success(function(data){
				
			}).error(function(error){
				
			});
		};
		
	}
	
})();