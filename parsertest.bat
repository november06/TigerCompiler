pushd bin

REM C:\Users\Shane\Downloads\Tiger\tiger_runnable\cuptest.txt will throw exception
xcopy C:\Users\Shane\Downloads\Tiger\Testcases\Official\Good\test1.tig .\cuptest.txt /Y

java tiger.parse.CupTest

pause

popd