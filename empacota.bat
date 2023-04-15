@echo off

if not exist target\classes (
	call compila.bat
)

echo  *** Empacotando projeto ***
jar cvfe .\target\Projeto.jar Principal -C target\classes\ .
