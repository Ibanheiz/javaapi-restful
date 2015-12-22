angular.module('appJava').service('ClienteService', ['$http', ClienteService]);

function ClienteService($http) {
	this.findAll = function() {
		return $http.get("http://localhost:8080/java-angular/api/clientes");
	};
	
	this.save = function(cliente) {
		return $http.post("http://localhost:8080/java-angular/api/clientes", cliente);
	};
	
	this.update = function(cliente) {
		return $http.put("http://localhost:8080/java-angular/api/clientes/" + cliente.id, cliente);
	};
	
	this.remove = function(cliente) {
		return $http.delete("http://localhost:8080/java-angular/api/clientes/" + cliente.id);
	};
}