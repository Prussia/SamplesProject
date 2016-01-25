@echo off
echo [INFO] Archetype the project in target dir.

cd %~dp0
cd ..
call mvn clean archetype:create-from-project -Darchetype.properties=./archetype.properties -Darchetype.filteredExtentions=java,xml,jsp,properties,sql,tpl
cd bin
pause