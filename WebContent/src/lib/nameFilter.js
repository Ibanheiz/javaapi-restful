angular.module('appJava').filter('name', function() {
	return function(input) {
		var nomes = input.split(" ");
		nomesFormatados = nomes.map(function (nome) {
			return nome.charAt(0).toUpperCase() + nome.substring(1);
		});
		console.log("Filter OKKKKK");
		return nomesFormatados.join(" ");
	};
});