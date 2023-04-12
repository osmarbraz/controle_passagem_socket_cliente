@echo off 

if exist bin (
	echo  *** Apagando Diretorio bin ***
	rmdir bin /s /q
) else (
	echo  *** Diretorio bin nao existe ***
)

if exist doc (
	echo  *** Apagando Diretorio doc ***
	rmdir doc /s /q
) else (
	echo  *** Diretorio doc nao existe ***
)

if exist jar (
	echo  *** Apagando Diretorio jar ***
	rmdir jar /s /q
) else (
	echo  *** Diretorio jar nao existe ***
)