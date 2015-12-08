var app = angular.module('appJava', []);

angular.module('appJava').controller('headController', function($scope){
	$scope.titulo = "Angular com Java";
});

app.controller('appController', function ($scope) {
	var quantidadeMensagemNotificacao = 75;
	$scope.name = "Angular Java";
	$scope.quantidadeMensagemNotificacao = quantidadeMensagemNotificacao;
});

app.controller('listaController', function($scope) {
	var pessoas = [];
	pessoas.push({
		nome: 'Joaquim Neto', 
		sexo: 'M', 
		idade: 21, 
		email: 'hello@joaquimsn.com'
	});
	
	pessoas.push(criarPessoa('José Carlos', 'M', 34, 'teste@example.com'));
	pessoas.push(criarPessoa('Antonio Santos', 'M', 23, 'teste@teste.com'));
	
	$scope.pessoas = pessoas;
	
	function criarPessoa(nome, sexo, idade, email) {
		var pessoa = {};
		pessoa.nome = nome;
		pessoa.sexo = sexo;
		pessoa.idade = idade;
		pessoa.email = email;
		
		return pessoa;
	};
});