Developer Documentation
Department Architecture: 

views/departments.scala.html the interface of the department page 
controller/DepartmentController This controller handles department display information.
routes- GET         /departments                                                                         controllers.DepartmentController.departmentList()
This will set the route to the department page 
How to run:
Open sbt shell
Wait until initilization is done 
Type "run" in prompt 
It will then display a local web server address if it runs successfully 
On your web browser, go to the web address that was shown on the sbt shell 

How to compile: 
Open sbt shell
run "sbt clean compile"
Will restart server and compile code. 
