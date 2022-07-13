# tireRestTest
***
Тестовое задание:
REST сервис обрабатывающий входяще CSV файлы содержащие списки шин, с последующим добавлением их в базу PostgreSQL.  
 Сервис имеет View на http://localhost:8080 , с помощью которого можно загрузить тестовые файлы.   
***
Примеры CSV содержатся в папке resources/testcases   
***

Запустить приложение можно через класс Application, указав переменные окружения по схеме:  
(для тестов переменные нужно вносить отдельно)  

DB_CONN_URL=    
DB_CONN_USERNAME=    
DB_CONN_PASSWORD=  
***

Можно собрать Docker контейнер, набрав в терминале:   
sudo docker build -t tirerest .  
и затем:  
sudo docker run --net=host -e DB_CONN_URL=* -e DB_CONN_USERNAME=* -e DB_CONN_PASSWORD=* tirerest    
подставив соответственно вместо звёздочек свои креды подключения к базе
***
В случае, если liquibase не соберёт базу (что маловероятно), по пути resources/db/changelog/DB/DDL/create_table.sql  
есть SQL скрипт.  
***



