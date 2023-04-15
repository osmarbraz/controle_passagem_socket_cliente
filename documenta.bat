@echo off

if not exist doc (
	echo  *** Criando Diretorio doc ***
	mkdir doc
)

echo  *** Documentando projeto ***
javadoc -author src\main\java\*.java -d doc