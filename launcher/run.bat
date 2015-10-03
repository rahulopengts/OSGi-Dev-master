@echo off
set PROJ_HOME=D:\Home_Auto\raspberry\Latest\Apache-Felix\apache-ibm\OSGi-Dev-master
call cd..
call cd com.webproject
call mvn -o clean install
call cd..
call mvn -o clean install
call copy %PROJ_HOME%\myosgi\target\myosgi-0.0.1-SNAPSHOT.jar %PROJ_HOME%\launcher\target\bundles

call copy %PROJ_HOME%\com.webproject\target\com.webproject-0.0.1-SNAPSHOT.jar %PROJ_HOME%\launcher\target\bundles

call cd launcher

call java -DGATEWAYHOME=%PROJ_HOME%\appconfig -jar target/osgi-fw-launcher-0.0.1-SNAPSHOT.jar
