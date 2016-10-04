@echo off
REM configuration

set JAVA_HOME="C:\Program Files\Java\jdk1.8.0_91"


pushd %~dp0
REM Not good enough since we may add the directory many times
set PATH=%PATH%;%CD%;
popd