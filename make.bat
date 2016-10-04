rem javac -sourcepath .\tiger -classpath .\bin -d .\bin tiger\*.java

call %~dp0jflex.bat
call %~dp0cup.bat

dir /s /B *.java > sources.txt
javac -classpath .\bin -d .\bin @sources.txt