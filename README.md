Recipe application:
------------------
Frontend : Angular Js 1.6.9, html , css
Backend : Java8, spring boot 2.2.1 , Jpa, H2 database.

How to run :
-----------
from Eclipse : open RecipeappApplication.java and run as java application 
from command : java -jar recipeapp-0.0.1-SNAPSHOT.jar

Its a Single page angularJs application :
-----------------------------------------
* Onload it loads some recipe which are available in dropdown, upon selecting a recipe its details will be displayed.
* On clicking add button the all fields on right side get cleard and add button will be enabled , once entered all the values and click on add Recipe button , it calls post method and persist the data on H2 database.
* On clicking Update recipe button update button on right side is enabled and you can start updating the values and on clicking onupdate button , it saves the updated value by calling put method is backed.
* on calling delete recipe button right side delete button is enabled and on clicking on delete button it deletes the selected recipe from drop down by calling delete method on rest.
* Search recipe button click leads to enable the search bar and search button , once you type and click on search it goes to backed runs query and gets the matching recipe details on right side.



