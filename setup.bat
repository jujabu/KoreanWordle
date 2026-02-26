@echo off
:: Sets the terminsl to UTF-8 modus
chcp 65001 > nul

:: Compiles files
javac Main.java

:: Runs program
java Main

:: Keeps the program open to see the result
pause