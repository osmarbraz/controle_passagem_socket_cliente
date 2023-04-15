@echo off

if exist target\classes (
	echo  *** Executando projeto ***
	java -cp target\classes Principal
)