@echo off

if not exist doc (
	echo  *** Criando Diretorio doc ***
	mkdir doc
)

echo  *** Documentando projeto ***
javadoc -author src\*.java -d doc