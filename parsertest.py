# dir walker for testcases
import os
import sys
import shutil

def run_test_case(mainEntryPoint, currentPath, tempfile, resultfile):
    os.system("echo --------------------------------------- >>" + resultfile)
    os.system("echo " + currentPath +" >>" + resultfile + " >>" + resultfile)
    os.system("echo --------------------------------------- >>" + resultfile)
    os.system("type " + currentPath  + " >>" + resultfile)
    os.system("echo --------------------------------------- >>" + resultfile)
    ret = os.system("java " + mainEntryPoint + " " + currentPath + " >" + tempfile + " 2>&1" )
    os.system("type " + tempfile + " >>" + resultfile)
    os.system("echo --------------------------------------- >>" + resultfile)


if __name__ == '__main__':
    if len(sys.argv) < 2: 
        print "expect the current directory" 

    if len(sys.argv) < 3: 
        print "please add the main entry point"

    workingDir = os.path.join(sys.argv[1], ".\\bin")
    os.chdir(workingDir)
    tempfile = os.path.join(sys.argv[1], ".\\testoutput")
    mainEntryPoint = sys.argv[2]

    resultfile = os.path.join(sys.argv[1], ".\\testresult.txt")
    if os.path.isfile(resultfile):
        os.remove(resultfile)

    if len(sys.argv) < 4:
        # no test case specified, run all the test cases
        testCaseRoot = os.path.join(sys.argv[1], ".\\testcases")

        totalCases = 0
        exceptionalCases = 0

        # traverse root directory, and list directories as dirs and files as files
        for root, dirs, files in os.walk(testCaseRoot):
            for f in files:
                totalCases = totalCases + 1
                currentPath = os.path.join(root, f)
                print currentPath
                os.system("echo case number: " + str(totalCases) + " >> " + resultfile)
                run_test_case(mainEntryPoint, currentPath, tempfile, resultfile)      

                exceptionalCases = exceptionalCases + 1
                    
        os.system("echo " + str(exceptionalCases) + " / " + str(totalCases) + " >> " + resultfile)
    else : 
        # run single test case
        testCaseName = sys.argv[3]
        testCasePath  = os.path.join(sys.argv[1], testCaseName)
        run_test_case(mainEntryPoint, testCasePath, tempfile, resultfile) 
        with open(resultfile, "r") as f:
            shutil.copyfileobj(f, sys.stdout)

    os.remove(tempfile)
    os.chdir(sys.argv[1])