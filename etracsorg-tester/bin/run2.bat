@echo off
rem This will be the run directory
set RUN_DIR=%cd%
rem Move up...
cd ..
rem This will be the base directory
set BASE_DIR=%cd%

set JAVA_OPT="-Dosiris.run.dir=%RUN_DIR% -Dosiris.base.dir=%BASE_DIR%"

java "%JAVA_OPT%" -jar %BASE_DIR%\rameses-main-bootloader.jar 
pause
