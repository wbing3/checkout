@echo off
REM ##########################################
REM #
REM # Script: run_sales_tax_tests.bat
REM #
REM #
REM #############################################
cls
set spaces=#
echo #####  Running Test One ###############################
echo Test One Input: 
type shopping_cart_1.txt
echo %spaces%
echo Test One Output:
java -jar  target\checkout-0.0.1-SNAPSHOT.jar shopping_cart_1.txt
echo  %spaces%
echo #####  Running Test Two ###############################
echo Test Two Input: 
type shopping_cart_1.txt
echo  %spaces%
echo Test Two Output:
java -jar  target\checkout-0.0.1-SNAPSHOT.jar shopping_cart_2.txt
echo  %spaces%
echo #####  Running Test Three ###############################
echo Test Three Input: 
type shopping_cart_1.txt
echo  %spaces%
echo Test Three Output:
java -jar  target\checkout-0.0.1-SNAPSHOT.jar shopping_cart_3.txt
echo  %spaces%
echo All Test are Completed!!!
REM end
