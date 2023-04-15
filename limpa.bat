@echo off 

if exist target (
	echo  *** Apagando Diretorio target ***
	rmdir target /s /q
) else (
	echo  *** Diretorio target nao existe ***
)

if exist doc (
	echo  *** Apagando Diretorio doc ***
	rmdir doc /s /q
) else (
	echo  *** Diretorio doc nao existe ***
)