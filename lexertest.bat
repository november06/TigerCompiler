pushd bin

xcopy C:\Users\Shane\Downloads\Tiger\tiger_runnable\lextest.txt . /Y

java tiger.parse.LexerTest

pause

popd