var app = angular.module('appJava', ['ngAnimate']);

function _buscaClientes($scope, $http) {
	var promisse = $http.get("http://localhost:8080/java-angular/api/clientes");
	promisse.success(function (data) {
		$scope.pessoas = data.cliente;
	});
	promisse.error(function (err) {
		console.log(err);
	});
}

angular.module('appJava').controller('headController', function($scope){
	$scope.titulo = "Angular com Java";
});

app.controller('appController', function ($scope) {
	var quantidadeMensagemNotificacao = 75;
	$scope.name = "Angular Java";
	$scope.quantidadeMensagemNotificacao = quantidadeMensagemNotificacao;
});

app.controller('listaController', function($scope, $http) {
	_buscaClientes($scope, $http);
	
	function criarPessoa(nome, sexo, idade, email) {
		var pessoa = {};
		pessoa.nome = nome;
		pessoa.sexo = sexo;
		pessoa.idade = idade;
		pessoa.email = email;
		
		return pessoa;
	};
	
	$scope.adicionarPessoa = function (pessoa) {
		if (pessoa) {
			$http.post("http://localhost:8080/java-angular/api/clientes", pessoa).then(function(response){
				$scope.pessoas.push(pessoa);
				delete $scope.pessoa;
				console.log(response);
			});
		}
	};
	
	$scope.selecionarPessoa = function(pessoa) {
		$scope.pessoa = pessoa;
	}
	
	$scope.excluirPessoa = function(index) {
		console.log(index);
		$scope.pessoas.splice(index, 1);
	}
});