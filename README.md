{\rtf1\ansi\ansicpg1251\cocoartf2580
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fswiss\fcharset0 Helvetica;\f1\fnil\fcharset129 AppleSDGothicNeo-Regular;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\paperw11900\paperh16840\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f0\fs24 \cf0 # Spring web  travel agency project.\
\
![page-view](./src/main/webapp/resources/photo/start-page.jpg)\
\
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f1 \cf0 \'a4\'d4
\f0 Worked on creating a web application for a travel agency. The main requirements for the project were the use of Maven, Hibernate, Spring MVC (JSP + JSTL), Spring Security technologies, but without Spring Boot.\
Our program should have the following functionality:\
- Two roles (User and Manager) that have different access rights. User can search for hotels by country, check the availability of free rooms, and make hotel reservations for the relevant dates.\
  Manager has the same functionality as in User. It can also add new hotels and rooms. Manager can see all Users and view their orders.\
- We should have at least three pages Login, Home page, Management.\
\

\f1 \'a4\'d4
\f0 The MySQL database was used in the project. Spring Security Authority was implemented by granting certain rights to the corresponding role. When encoding passwords, BCryptPasswordEncoder is used. For convenience, two DataSources have been created, one with a thread pool setting for the application and another for the developer without a thread pool.\
\

\f1 \'a4\'d4
\f0 By scrolling to the bottom, you can see what the visual implementation of all requirements looks like. The following functionality was also added:\
- the possibility for the user to view all his orders and adjust them;\
- the manager deletes and updates data about the hotel and its rooms;\
- the manager can delete users or ban them;\
- registration function;\
\
##The login-logout page. After authorization, we can view all our orders.\
![login-view](./src/main/webapp/resources/photo/login-logout.gif)\
\
##After registration, we can go through authorization in our system by email.\
![registration-view](./src/main/webapp/resources/photo/registration.gif)\
\
##The home page on which we can search for hotels and check the availability of available rooms.\
![home-view](./src/main/webapp/resources/photo/home-page.gif)\
\
##Reservations can be made after authorization.\
![reserved-view](./src/main/webapp/resources/photo/reserved.gif)\
\
\
##The manager page where we can see all our hotels, rooms, users and their orders.\
![manager-view](./src/main/webapp/resources/photo/manager-page.gif)\
\
\
##We are adding new hotels. We have a check of the correctness of filling in the fields.\
![hotel-add-view](./src/main/webapp/resources/photo/manag-hotel-add.gif)\
\
##We look at the contents of a room in a specific hotel.\
![room-view](./src/main/webapp/resources/photo/manag-hotel-room.gif)\
\
##We are adding a new room to the hotel we need.\
![room-form-view](./src/main/webapp/resources/photo/room-form.gif)\
\
##We are updating the data about the room.\
![room-form-view](./src/main/webapp/resources/photo/update-room.gif)\
\
##The manager can manage users and view their orders.\
![user-form-view](./src/main/webapp/resources/photo/manag-user.gif)\
\
}