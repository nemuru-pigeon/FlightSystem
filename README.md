# FlightSystem
Description:
---
This is a repository for the group project in EBU6304 - SOFTWARE ENGINEERING.  

This is a flight check-in system based on EBC(Entity-Boundary-Control) pattern.

Start-up:
---
IDE:  
To use this method, you need to download the IDEA. After downloading the IDEA 
(or suppose you already have one), Download the latest version of the code from 
branch _main_ and run Main.

JAR:  
In this method, you need to download the latest version of the code in branch 
_Final_version_jar_. Then, in the "FlightSystem" dictionary, run _java -jar 
FlightSystem.jar_ in the command line. Note that your jdk version needs to be 
17.0.2 and above.  

___For teaching assistants: As you have received a zip file of all the codes, 
please use the second method.___

Testing:
---
###Functionality testing:  

__Login:__  

To test whether the system could work as expected, you can use the passenger data 
in _src\main\resources\com\example\flight_system\data\passenger.json_ to login. 
For your convenience, I also list two passenger messages that best represent and 
test the entire system as follows:
1. id: 109201200101011111, surname: Si
2. id: 307204200111012911, surname: Rui

Besides, you can use data in _src\main\resources\com\example\flight_system\data\
order.json_ to login. In this way, you need to use the value of _booking_no_.
Similarly, for your convenience, you can use the following data:
1. 0101011111
2. 3072042001

Additionally, the system modify the scan of ID card by reading the txt file in 
_src\main\resources\com\example\flight_system\input_files_ whose name is _id.txt_. 
However, if we read it in the system, the system will flash by quickly on the 
login page. Thus, we just test it to make sure that it work as expected. The 
testing code can be seen in _src\test\java\com\example\flight_system\control\
InputControlTest_. What's more, login by scanning ID card has to use method 
_loginById()_ in _MainControl_. This method has already been used in _loginBy
BookingNo_ for reusing, which suggests the method could work as expected.

___Notice: You may find that when you log in using some data mentioned above, 
no choice appear in the system in the next page. This is because that we have 
added some redundant data to test system. When the check-in status of the order 
is true, the system would not display it.___

---

__Change of data:__

After check-in, you can verify whether the system has recorded the data in the 
above files (all in path _src\main\resources\
com\example\flight_system\data_):
1. order.json (here you can see that the check-in status has been modified which 
suggests that the check-in status has been sent to the back-end system)
2. payment.json
3. shift.json

---

__Output files:__

The system simulate printer and the process of sending bank card information to 
other system by product txt files in path _src\main\resources\com\example\
flight_system\output_files_. After finishing the check-in process, you can verify 
whether the system has worked correctly by looking at the txt files in above path. 
The result should include files like the following example:
1. 3072912810_pass.txt
2. 3072912810_ticket1.txt
3. 3072912810_ticket2.txt
4. 1111111111111_202205310144.txt

___Notice:  
The above example is not the exact result due to different passenger, 
selected meal, etc. However, the content in the txt file is readable by which you 
can verify whether the system is running correctly. In the above example, "ticket1" 
and "ticket2" suggests that there are two tickets. The amount of the files will 
be different due to the reason I have mentioned. Besides, the test.txt is just for 
test. Please ignore it.  
Additionally, a passenger can't check in twice. If you want to retest the same 
passenger, you have to delete the files produced in 
"src\main\resources\com\example\flight_system\output_files"
, and copy the files in appendix (this is a directory at the same level as 
FlightSystem) and overwrite the files in 
"src\main\resources\com\example\flight_system\data".___

---

###Testing code:

As we are using IDEA and Maven, please run your test code in an IDE environment. 
Below is a screenshot of a sample test of our code:

<img src="https://github.com/nemuru-pigeon/FlightSystem/tree/master/src/main/resources/com/example/flight_system/images/test_result.png" alt="figure 1: Testing result">

---

This is the end of the file. The rest of the tests you can do with the guidance 
of GUI. Thank you for your patience in verifying.
