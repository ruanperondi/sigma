# sigma

O presente projeto tem como principal funcionalidade a distribuição de processos entre varas.

# Tecnologias
	JavaEE7 (JPA + EJB + CDI + BeansValidation + JaxRS)
	Hibernate 5
	Rest (Resteasy + Jackson)
	Hibernate Envers
	Arquillian + Jacoco (Testes + Cobertura de Código)
	Maven

# Bibliotecas Adicionais
	Apache Commons Lang
	Apache Commons Collections
	Reflections

 # Problemáticas do Desenvolvimento
	Boa parte do desenvolvimento, acredito que 70%, foi gasto em esforço na tentativa de gerar Testes Unitários e Cobertura de Código utilizando Jacoco + Arquillian. Não consegui fazer com que tal "suite" funcionasse de maneira adequada.
	
# Estrutura Organizacional
	base:
		Contem dados que são comuns e genericos a todos os recursos do sistema, tais como business, config, dto, filter, persistence, repository, service, validate e web.
	features:
		Onde são lançadas as versões das novas realeases de features
	util: 
		Classes utilitárias para o Projeto

# Padrões de Projeto utilizados:
	Repository
	DTO
	IoC
	Singleton
	Factory
	Strategy

# Estrutura das Features:
	Em geral, cada uma das features contem uma série de interfaces para injeção.
	Tal caracteristica torna-se importante por que podemos trocar as regras de business com Stereotypes do CDI.
	As principais interfaces são:
		Service (normalmente extende GenericService)
		Business (normalmente extende GenericBusiness)
		Validacao (normalmente extende GenericValidation)
		Repository (normalmente extende GenericRepository)
	
	De uma maneira geral, efetuamos a completa abstração da camada Service para a camada Business em forma de DTOs, evitando, assim, a exposição exarcebada do nosso modelo de dados.
	Sendo assim, cada feature possui seus converters de Entidade para DTO e DTO para Entidade.
	Ainda nesse aspecto, cada um dos serviços pode receber um parametro Filter, que por sua vez possuem filtros para serem aplicados nas consultas.
	Se um field estiver anotado com @RepresentColumn, o mesmo irá fazer um bind direto para a entidade destino, filtrando com base naquele campo.
		ex.: Se temos um Filtro da Entidade Marca com um campo nome e o mesmo estiver anotado com @RepresentColumn, então na busca iremos utilizar esse binding para associar a  origem e destino
	Se possuirmos, ainda um valor dentro da anotação, esse biding pode ser propagado entre os JPQLs.
		Ex: Se possuirmos um filtro de id do estado no municipio, e esta entidade tiver uma associação do tipo ManyToOne entre Municipio e Estado, então o select será feito no campo municipio.estado.id se o valor da Anotação estiver usando "estado.id"
	Assim, possuimos mais algumas classes concretas:
		Filtro
		DTO
		DTOConverter
		Entidade (Representação do banco de dados em forma de JPA)

	Para que possamos finalizar a feature, precisamos criar as classes concretas das interfaces citadas acima.
		ServiceImpl
		BusinessImpl
		ValidacaoImpl
		RepositoryImpl (aqui definimos que iremos utilizar JPA como default, porém a arquitetura nos deixa livre para implementar um outro tipo e usar os Stereotypes para a injeção do tipo desejado)

# Base de Dados.
	Ao executar a aplicação, se não houver cadastros e tabelas o sistema irá criar de forma automatica
	Atualmente existem dois DataSources (persistence[Postgre-SQL] e persistence_hsqldb) na pasta META-INF
		Para a utilização do primeiro é necessário que exista um DataSource com o nome de java:/SigmaDS
	Caso queira fazer uma demonstração simples, sem a necessidade de um banco especifico, basta que exista um DataSource java:jboss/datasources/ExampleDS utilizando hqsldb (padrão nos standalones do Wildfly)
	O Default é persistence.xml (postgre)
	O banco é gerado utilizando a estratégia CamelCaseImproveStrategy, que por sua vez converte valores camel case separados por underscore (nomeMarca -> nome_marca)
	Cada entidade possui, no minimo, ID, data de inclusão, data de alteração, e são gerados logs de Auditoria de cada tabela, criado no schema auditoria.
	A validação de valores unicos é feita de forma automatica com base no atributo unique da anotação @column, sendo assim, não existe a necessidade de validar se o campo já foi cadastrado no banco, sendo que o uso em Strings torna-se case-insensitive.
	Na primeira vez que o sistema sobe, o mesmo analisa se existem cadastro, e caso não exista, é gerado uma base randomica de:
		1) Classe Processual
		2) Comarca
		3) Competência
		4) Vara
		5) Associação entre Vara e Competencia

# Camada REST
	A utilização da camada Rest segue as principais convenções.
	Não foi criado endpoit para exclusão de informações.

# Endpoints Criados:
	A base do projeto para acesso ao endpoint é: /distribuicao/api

	Classes processuais: /classes 
		filtro: GET ?nome={nome}&limit={limit}&offSet={offSet} retorna um FilterResponse com uma Lista de DTOs convertidos
		id: GET /{id}
		salvar: POST
			{
				"nome": {nome}
			}
		editar: PUT
			{
				"id": id,
				"nome": {nome}
			}
	
	Comarcas: /comarcas 
		filtro: GET ?nome={nome}&limit={limit}&offSet={offSet} retorna um FilterResponse com uma Lista de DTOs convertidos
		id: GET /{id}
		salvar: POST
			{
				"nome": {nome}
			}
		editar: PUT
			{
				"id": id,
				"nome": {nome}
			}
		recuperar competencias de uma comarca: GET /{id}/competencias

		
	Competencias: /competencias 
		filtro: GET ?nome={nome}&idClasseProcessual={idClasseProcessual}&limit={limit}&offSet={offSet} retorna um FilterResponse com uma Lista de DTOs convertidos
		id: GET /classe/{idClasseProcessual}/competencia/{nomeCompetencia}
		salvar: POST
			{
				"nome": {nome},
				"idClasseProcessual": {idClasseProcessual}
			}
		editar: Não habilitado

	Competencias: /varas 
		filtro: GET ?nome={nome}&idComarca={idComarca}&limit={limit}&offSet={offSet} retorna um FilterResponse com uma Lista de DTOs convertidos
		id: GET /comarca/{idComarca}/vara/{nomeVara}
		salvar: POST
			{
				"nome": {nome},
				"idComarca": {idComarca}
			}
		editar: Não habilitado
		recuperar competencias de uma vara: GET /{idComarca}/vara/{nomeVara}/competencias

	Processo: /processos
		Enviar Processo: POST
			{
				"numeroProcesso"="{numeroProcesso}",
				"idComarca"="{idComarca}",
				"nomeComarca"="{nomeComarca}",
				"idClasseProcessual"="{idClasseProcessual}",
				"classeProcessual"="{classeProcessual}",
				"nomeVara"="{nomeVara}",
				"competencia"="{competencia}"
			}

		Recuperar um processo: GET /{idNumeroProcesso}


# Como faço para testar?
	1) Faça o clone do projeto
	2) Mude para a Branch develop
	3.1) Eclipse:
		3.1.1: Importe como um Projeto Maven e Aguarde o download das features.
		3.1.2: Escolha seu persistence.xml que queira trabalhar (pasta META-INF)
			3.1.2.1: Se for utilizar o default (PostgreSQL) garanta que exista um DataSource com o nome java:/SigmaDS utilizando o PostGresql
			3.1.2.2: Se for utilizar o HSQLDB, renomeie o persistence atual (persistence.xml -> persistence-pgsql.xml e persistence_hsqldb.xml -> persistence.xml) garanta que exista um DataSource com o nome java:jboss/datasources/ExampleDS utilizando o HSQLDB (normalmente o Wildfly vem com este datasource padrão).
		3.1.3: Rode em seu servidor de escolha
	3.2) Maven
		3.2.1: Execute o comando mvn install
			3.2.2: Escolha seu persistence.xml que queira trabalhar (pasta META-INF)
			3.2.2.1: Se for utilizar o default (PostgreSQL) garanta que exista um DataSource com o nome java:/SigmaDS utilizando o PostGresql
			3.2.2.2: Se for utilizar o HSQLDB, renomeie o persistence atual (persistence.xml -> persistence-pgsql.xml e persistence_hsqldb.xml -> persistence.xml) garanta que exista um DataSource com o nome java:jboss/datasources/ExampleDS utilizando o HSQLDB (normalmente o Wildfly vem com tais informações.

# Considerações sobre a Documentação:
	Foi adotada o uso de Chaves Compostas para garantir unicidade e integridade.

# Para o futuro
  A ideia, se a delimitação do tempo fosse maior, era finalizar a parte de testes e cobertura em uma faixa acima de 90%, utilizar o Sonar para qualidade de código e Swagger para gerar a documentação dos endpoints.

Aproveite!
