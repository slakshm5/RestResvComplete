(function(){
	angular.module('dashboard',[]);
	
	angular.module('dashboard').controller('ReservationsController', ReservationsControllerFn);
	
	function ReservationsController(){
		var rsvnVm = this;
		
		rsvnVm.addRsvn = function() {
			rsvnVm.newCustomer.ID = rsvnVm.customers.length + 1;
			rsvnVm.customers.push(rsvnVm.newCustomer);
			rsvnVm.newCustomer = null;
		};
		
		rsvnVm.deleteRsvn = function(i) {
			rsvnVm.customers.splice(i, 1);
		};
		rsvnVm.saveFn = function () {
			
		};
		rsvnVm.customers = [{
			
		}];
		
		function init(){
			$http({
				method: 'GET',
				url: 'http://jsonplaceholder.typicode.com/users'
			})
			.success(function(data){
				rsvnVm.customers = data;
			})
			.error(function(err){
				console.log(err);
			})
		
		}
	}
	
})();