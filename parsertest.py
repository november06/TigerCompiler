# dir walker for testcases
import os
import sys

if len(sys.argv) < 2: 
    print "expect the current directory" 

testCaseRoot = os.path.join(sys.argv[1], ".\\testcases")
workingDir = os.path.join(sys.argv[1], ".\\bin")
os.chdir(workingDir)
tempfile = os.path.join(sys.argv[1], ".\\testoutput")
resultfile = os.path.join(sys.argv[1], ".\\testresult.txt")
if os.path.isfile(resultfile):
    os.remove(resultfile)

totalCases = 0
exceptionalCases = 0

# traverse root directory, and list directories as dirs and files as files
for root, dirs, files in os.walk(testCaseRoot):
    for f in files:
        totalCases = totalCases + 1
        currentPath = os.path.join(root, f)
        print currentPath
        ret = os.system("java tiger.parse.CupTest " + currentPath + " >" + tempfile + " 2>&1" )

        os.system("echo --------------------------------------- >>" + resultfile)
        os.system("echo " + currentPath +" >>" + resultfile)
        os.system("echo --------------------------------------- >>" + resultfile)
        os.system("type " + currentPath  + " >>" + resultfile)
        os.system("echo --------------------------------------- >>" + resultfile)
        os.system("type " + tempfile + " >>" + resultfile)
        os.system("echo --------------------------------------- >>" + resultfile)
        exceptionalCases = exceptionalCases + 1
            
os.system("echo " + str(exceptionalCases) + " / " + str(totalCases) + " >> " + resultfile)


os.remove(tempfile)
os.chdir(sys.argv[1])