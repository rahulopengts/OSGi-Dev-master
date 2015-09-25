mvn -o clean install
copy D:\Home_Auto\raspberry\Latest\Apache-Felix\apache-ibm\OSGi-Dev-master\com.webproject\target\com.webproject-0.0.1-SNAPSHOT.jar D:\Home_Auto\raspberry\Latest\Apache-Felix\apache-ibm\OSGi-Dev-master\launcher\target\bundles
copy D:\Home_Auto\raspberry\Latest\Apache-Felix\apache-ibm\OSGi-Dev-master\myosgi\target\myosgi-0.0.1-SNAPSHOT.jar D:\Home_Auto\raspberry\Latest\Apache-Felix\apache-ibm\OSGi-Dev-master\launcher\target\bundles
cd launcher
java -jar target/osgi-fw-launcher-0.0.1-SNAPSHOT.jar
