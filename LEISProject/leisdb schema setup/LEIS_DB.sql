CREATE TABLE MANUFACTURER (MF_ID INT AUTO_INCREMENT, MF_NAME VARCHAR(40) NOT NULL, PRIMARY KEY (MF_ID));
CREATE TABLE EQUIPMENT_TYPE (TYPE_CODE VARCHAR(2), TYPE_NAME VARCHAR(15) NOT NULL, PRIMARY KEY (TYPE_CODE));
CREATE TABLE FUNDING_SOURCE (FS_ID INT AUTO_INCREMENT, FS_AGENCY_NAME VARCHAR(40) NOT NULL, FS_PROGRAM VARCHAR(40), PRIMARY KEY (FS_ID));
CREATE TABLE LOCATION (ROOM_ID INT AUTO_INCREMENT, ROOM_NO INT NOT NULL, PRIMARY KEY (ROOM_ID));
CREATE TABLE PLATFORM_TYPE (PLATFORM_CODE VARCHAR(2), PLATFORM_NAME VARCHAR(15) NOT NULL, PRIMARY KEY(PLATFORM_CODE));
CREATE TABLE MODEL (MD_CODE VARCHAR(2), MD_NAME VARCHAR(15) NOT NULL, PRIMARY KEY(MD_CODE));
CREATE TABLE STATUS (STATUS_CODE VARCHAR(2), STATUS_NAME VARCHAR(30));

CREATE TABLE EQUIPMENT (
EQUIPMENT_ID INT AUTO_INCREMENT,
MF_ID INT NOT NULL,
TYPE_CODE VARCHAR(2) NOT NULL,
MD_CODE VARCHAR(2) NOT NULL,
SERIAL_NO VARCHAR(50),
UCM_INV_NO VARCHAR(50),
CIS_INV_NO VARCHAR(50),
DATE_INSTALLED DATE,
STATUS_CODE VARCHAR(2),
FS_ID INT NOT NULL,
DATE_FUNDED DATE,
DATE_WARRANTY_EXPIRY DATE,
DATE_REMOVED DATE,
DATE_CHECKED_OUT DATE,
DATE_OF_RETURN DATE,
CURRENT_OWNER VARCHAR(30),
ROOM_ID INT NOT NULL,
PURPOSE VARCHAR(50), 
ADDN_COMP VARCHAR(50),
NOTES VARCHAR(150),
PRIMARY KEY (EQUIPMENT_ID), 

CONSTRAINT FK_MANUFACTURER
    FOREIGN KEY (MF_ID)
    REFERENCES MANUFACTURER(MF_ID),
    
    
CONSTRAINT FK_EQUIPMENT_TYPE
    FOREIGN KEY (TYPE_CODE)
    REFERENCES EQUIPMENT_TYPE(TYPE_CODE),
    
    
CONSTRAINT FK_MODEL
    FOREIGN KEY (MD_CODE)
    REFERENCES MODEL(MD_CODE),
    
     
CONSTRAINT FK_FUNDING_SOURCE
    FOREIGN KEY (FS_ID)
    REFERENCES FUNDING_SOURCE(FS_ID),   
  
CONSTRAINT FK_LOCATION
    FOREIGN KEY (ROOM_ID)
    REFERENCES LOCATION(ROOM_ID)
    );
    
    
    
    