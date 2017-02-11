rem javac -sourcepath .\tiger -classpath .\bin -d .\bin tiger\*.java

call %~dp0jflexSimple.bat
call %~dp0cupSimple.bat

REM dir /s /B *.java > sources.txt
call python findSimpleFiles.py %~dp0 sources.txt
javac -classpath .\bin -d .\bin @sources.txt