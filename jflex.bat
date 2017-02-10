
set JFLEX_HOME=C:\trash\workspace\jflex-1.4.1
REM call %~dp0SetupJava.bat

set CLPATH=%JAVA_HOME%\lib\classes.zip;%JFLEX_HOME%\lib\JFlex.jar
@echo on
%JAVA_HOME%\bin\java -classpath %CLPATH% JFlex.Main .\jflex\tiger.flex  -d .\tiger\parse

del .\tiger\parse\Yylex.java~