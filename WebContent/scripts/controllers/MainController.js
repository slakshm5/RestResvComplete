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
		
		self.getCust = fumction(){
			if(self.Id){
				$http({
					method: 'GET',
					url: 'api/customer/get/'+ self.Id
				}).success(function(data){
					console.log(data);
				}).error(function(data){
					console.log(data)
				});
			}
		};
		
		self.addCust =function(){
			$http({
				method: 'POST',
				url: 'api/customer/add',
				data: self.newCust
			}).success(function(data){
				console.log(data);
			}).error(function(data){
					console.log(data)
			});
		};
		
		
	}
	
})();