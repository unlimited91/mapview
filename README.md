# mapview
This repository contains the source code for the rendering of locations on a map using google map api.

front-end: The front end has been designed and developed using HTML, CSS, Javascript.

back-end:  The appplication server has been designed and developed using Springboot.

database: The application uses a mysql db.

Instructions to set up dev environment:

1> Install apache web server, mysql db

2> git clone https://github.com/unlimited91/mapview.git

3> sudo cp -R {PATH}/mapview/front-end/mapview /var/www/html/mapview

4> cd {PATH}/mapview/back-end/

5>  mvn clean install

5> nohup java -jar com.loginext-0.0.1-SNAPSHOT.jar &

6> Start using

