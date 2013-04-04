# HeidiSQL Dump 
#
# --------------------------------------------------------
# Host:                 127.0.0.1
# Database:             lms_db
# Server version:       5.0.45-community-nt
# Server OS:            Win32
# Target-Compatibility: Same as source server (MySQL 5.0.45-community-nt)
# max_allowed_packet:   1048576
# HeidiSQL version:     3.1 RC1 Revision: 1064
# --------------------------------------------------------

/*!40100 SET CHARACTER SET latin1*/;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0*/;


#
# Database structure for database 'lms_db'
#

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `lms_db` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `lms_db`;


#
# Table structure for table 'appuser'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ `appuser` (
  `id` int(10) NOT NULL auto_increment,
  `guid` varchar(255) NOT NULL,
  `username` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  `question` varchar(255) default NULL,
  `answer` varchar(255) default NULL,
  `userrole` varchar(255) default NULL,
  `createdon` datetime default NULL,
  `createdby` int(10) default NULL,
  `modifiedon` datetime default NULL,
  `modifiedby` int(10) default NULL,
  `active` int(1) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 /*!40100 DEFAULT CHARSET=latin1*/;



#
# Dumping data for table 'appuser'
#

/*!40000 ALTER TABLE `appuser` DISABLE KEYS*/;
LOCK TABLES `appuser` WRITE;
REPLACE INTO `appuser` (`id`, `guid`, `username`, `password`, `question`, `answer`, `userrole`, `createdon`, `createdby`, `modifiedon`, `modifiedby`, `active`) VALUES
	(1,'e0b8ff16-0adc-4052-beca-e712dc47b97b','admin','admin','What was your childhood nickname?','siddu','admin','2013-03-27 17:21:05',1,'2013-03-27 17:21:05',1,NULL),
	(5,'fcc929f0-914b-4b07-8b0e-5a253abaa3ed','111','LMS204672013',NULL,NULL,'employee','2013-04-02 15:12:20',1,'2013-04-02 15:12:20',1,1),
	(6,'f178a467-db83-4c00-a78e-88ddacb9a34c','222','LMS118842013',NULL,NULL,'employee','2013-04-02 15:12:35',1,'2013-04-02 15:12:35',1,1),
	(7,'4657d95c-6bf5-4ffd-8b9b-43cb05d52657','333','LMS217602013',NULL,NULL,'employee','2013-04-02 15:12:54',1,'2013-04-02 15:12:54',1,1),
	(8,'95648b50-3855-477b-a551-1357bd153690','444','LMS103052013',NULL,NULL,'employee','2013-04-02 15:13:14',1,'2013-04-02 15:13:14',1,1),
	(9,'ab183b7a-ea2d-45e9-b480-18070afe0802','555','LMS224902013',NULL,NULL,'employee','2013-04-02 15:13:32',1,'2013-04-02 15:13:32',1,1),
	(10,'a050a5d2-d7cd-433d-af32-8c0325c47f18','666','LMS223522013',NULL,NULL,'employee','2013-04-02 15:15:13',1,'2013-04-02 15:15:13',1,1),
	(11,'d62a881a-e4df-42f4-9a9e-04578b84584a','777','LMS116082013',NULL,NULL,'employee','2013-04-02 15:17:07',1,'2013-04-02 15:17:07',1,1),
	(12,'b0f2ac6a-c164-4af8-913d-5ccd7cb494bf','1212','LMS234192013',NULL,NULL,'employee','2013-04-04 12:10:25',1,'2013-04-04 12:10:25',1,1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `appuser` ENABLE KEYS*/;


#
# Table structure for table 'department'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ `department` (
  `id` int(10) NOT NULL auto_increment,
  `guid` varchar(255) NOT NULL,
  `deptname` varchar(255) default NULL,
  `deptcode` varchar(255) default NULL,
  `createdon` datetime default NULL,
  `createdby` int(10) default NULL,
  `modifiedon` datetime default NULL,
  `modifiedby` int(10) default NULL,
  `active` int(10) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 /*!40100 DEFAULT CHARSET=latin1*/;



#
# Dumping data for table 'department'
#

/*!40000 ALTER TABLE `department` DISABLE KEYS*/;
LOCK TABLES `department` WRITE;
REPLACE INTO `department` (`id`, `guid`, `deptname`, `deptcode`, `createdon`, `createdby`, `modifiedon`, `modifiedby`, `active`) VALUES
	(1,'93d843ea-d7ad-478f-a3ce-1303b7ee760a','Computer Science Engineering','CSE',NULL,NULL,NULL,NULL,NULL),
	(2,'56aaf6be-97a0-471b-9146-1b4bfbd5182b','Master of Computer Applications','MCA',NULL,NULL,NULL,NULL,NULL),
	(3,'a645f218-af7b-4ff1-aa82-71581a2e151e','Ecectronics Engineering','ECE',NULL,NULL,NULL,NULL,NULL);
UNLOCK TABLES;
/*!40000 ALTER TABLE `department` ENABLE KEYS*/;


#
# Table structure for table 'leave'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ `leave` (
  `id` int(10) NOT NULL auto_increment,
  `guid` varchar(255) NOT NULL,
  `employeeId` varchar(255) default NULL,
  `fromDate` varchar(255) default NULL,
  `toDate` varchar(255) default NULL,
  `leaveType` varchar(255) default NULL,
  `reasonsForLeave` varchar(255) default NULL,
  `address` varchar(255) default NULL,
  `mobile` varchar(255) default NULL,
  `leaveCount` varchar(255) default NULL,
  `createdOn` datetime default NULL,
  `createdby` int(10) default NULL,
  `modifiedOn` datetime default NULL,
  `modifiedby` int(10) default NULL,
  `active` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB /*!40100 DEFAULT CHARSET=latin1*/;



#
# Dumping data for table 'leave'
#

# (No data found.)



#
# Table structure for table 'staff'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ `staff` (
  `id` int(10) NOT NULL auto_increment,
  `guid` varchar(255) NOT NULL,
  `employeeId` varchar(255) default NULL,
  `fullName` varchar(255) default NULL,
  `departmentName` varchar(255) default NULL,
  `dateOfBirth` varchar(255) default NULL,
  `gender` varchar(255) default NULL,
  `email` varchar(255) default NULL,
  `mobile` varchar(255) default NULL,
  `createdOn` datetime default NULL,
  `createdby` int(10) default NULL,
  `modifiedOn` datetime default NULL,
  `modifiedby` int(10) default NULL,
  `active` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 /*!40100 DEFAULT CHARSET=latin1*/;



#
# Dumping data for table 'staff'
#

/*!40000 ALTER TABLE `staff` DISABLE KEYS*/;
LOCK TABLES `staff` WRITE;
REPLACE INTO `staff` (`id`, `guid`, `employeeId`, `fullName`, `departmentName`, `dateOfBirth`, `gender`, `email`, `mobile`, `createdOn`, `createdby`, `modifiedOn`, `modifiedby`, `active`) VALUES
	(1,'db8b113a-08ef-42a6-9464-5c1df542d037','111','AAAA','Master of Computer Applications','14/08/1984','M','Test','Test','2013-04-02 15:12:20',1,'2013-04-02 15:12:20',1,1),
	(2,'23fff678-2e61-401f-8c9b-1d90485d3ed3','222','BBB','Master of Computer Applications','14/08/1984','F','TestTest','TestTest','2013-04-02 15:12:35',1,'2013-04-02 15:12:35',1,1),
	(3,'ba8f548c-4cbf-428b-bcdc-848881c531cf','333','CCC','Ecectronics Engineering','14/08/1984','M','TestTestTest','TestTestTest','2013-04-02 15:12:54',1,'2013-04-02 15:12:54',1,1),
	(4,'5bca26cc-6bbf-4725-98fb-2579a2f2a0f2','444','DDD','Ecectronics Engineering','14/08/1984','F','TestTestTestTest','TestTestTestTest','2013-04-02 15:13:14',1,'2013-04-02 15:13:14',1,1),
	(5,'80b4a22f-b7c9-450d-9b4d-aa36a0f1a840','555','EEE','Ecectronics Engineering','14/08/1984','M','TestTestTestTestTest','TestTestTestTestTest','2013-04-02 15:13:32',1,'2013-04-02 15:13:32',1,1),
	(6,'4dcc3a7f-0d3c-401e-8573-28f3260afa96','666','fff','Ecectronics Engineering','24/25/1987','M','TestTestTest','25478','2013-04-02 15:15:13',1,'2013-04-02 15:15:13',1,1),
	(7,'270e7705-aaac-4448-bb72-41cddedb0963','777','GGG','Ecectronics Engineering','25/25/1989','F','Test','123456789','2013-04-02 15:17:07',1,'2013-04-02 15:17:07',1,1),
	(8,'5bab88de-c51a-4cf2-a1e3-be42b666be8b','1212','sdfsfs','Ecectronics Engineering','14/08/1984','M','sdfgdgdfg','dfgdfgdfgdfg','2013-04-04 12:10:25',1,'2013-04-04 12:10:25',1,1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `staff` ENABLE KEYS*/;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS*/;
