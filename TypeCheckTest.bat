@echo off
call python parsertest.py %~dp0. tiger.parse.TypeCheckerTest %1
@echo on