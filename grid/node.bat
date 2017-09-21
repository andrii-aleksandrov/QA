@ECHO off
cd D:\grid
java -jar selenium-server-standalone-2.44.0.jar -role node -nodeConfig nodeconfig.json -Dwebdriver.chrome.driver="D:\grid\drivers\chromedriver.exe" -Dwebdriver.ie.driver="D:\grid\drivers\IEDriverServer.exe"
pause