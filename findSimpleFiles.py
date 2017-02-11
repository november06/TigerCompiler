# dir walker for testcases
import os
import sys

if len(sys.argv) < 3: 
    print "expect the current directory and outfile name" 

sourceFileRoot = os.path.join(sys.argv[1], ".\\")
output_file_path = os.path.join(sys.argv[1], ".\\" + sys.argv[2])

if os.path.isfile(output_file_path):
    os.remove(output_file_path)
else :
    print "please specify the output file name."
    
output_file = open(output_file_path, "w")

# traverse root directory, and list directories as dirs and files as files
for root, dirs, files in os.walk(sourceFileRoot):
    for f in files:
        currentPath = os.path.join(root, f)
        filename, file_extension = os.path.splitext(currentPath)
        if file_extension.lower() == ".java" and (not filename.lower().endswith("lexertest")) :
            currentPath = os.path.abspath(currentPath)
            output_file.write(currentPath)
            output_file.write("\r\n")
            
            
output_file.close()

os.system("type " + output_file_path)