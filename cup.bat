REM call %~dp0SetupJava.bat
set CUP_HOME=C:\trash\workspace\cup
set CLPATH=%JAVA_HOME%\lib\classes.zip;%CUP_HOME%
@echo on
REM %JAVA_HOME%\bin\java -classpath %CLPATH% java_cup.Main -expect 2 -debug .\cup\tiger.cup 
REM there is also a dump option for cup
%JAVA_HOME%\bin\java -classpath %CLPATH% java_cup.Main -expect 1 .\cup\tiger.cup 
move .\parser.java .\tiger\parse
move .\sym.java .\tiger\parse
rem xcopy ..\cup\java_cup\runtime\*.java .\java_cup\runtime\ /Y