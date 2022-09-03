Release R1_V1.0.0
=================
In this first release, I've implemented all the features concerning the management of the DataBases and the bestiary in each DB.
This is the list of the features implemented:
- Creation of a new DB
- Creation / Edition and Deletion of a field in the bestiary
- Can add options to a field, for now :
    - Required (the field is required for the monster. You can't create it without this field)
    - Unique (the field must be unique, only one monster can have this value. You can't create a monster with the same value)
    - Counter (the field is a counter, it can be incremented or decremented. Exemple : the health of a monster)
    - Checkbox (the field is a checkbox, it can be checked or unchecked. Exemple : if the entity is a PNJ or a monster)
    - Time to reload (the field have a time to realod, so it cannot be used until the time is over. Exemple : the time to reload a skill)
    - Editable (the value of the field can be change when the monster is used)
- Add / Edit / Delete a monster / PNJ in the bestiary