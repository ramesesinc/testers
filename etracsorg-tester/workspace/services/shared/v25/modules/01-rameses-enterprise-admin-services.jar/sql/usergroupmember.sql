[getList]
SELECT 
	u.objid, 
	u.lastname, 
	u.firstname, 
	u.middlename, 
	u.jobtitle, 
	u.jobtitle AS title, 
	ug.role,
	ugm.objid as usergroupmemberid, 
	ugm.usergroup_objid  
FROM sys_usergroup_member ugm 
INNER JOIN sys_user u ON ugm.user_objid=u.objid 
INNER JOIN sys_usergroup ug ON ug.objid=ugm.usergroup_objid 
WHERE ug.role IN (${roles})  
AND u.lastname LIKE $P{searchtext}
ORDER BY u.lastname 

[findMember]
SELECT 
ug.* 
FROM sys_usergroup_member ugm
INNER JOIN sys_usergroup ug ON ug.objid=ugm.usergroup_objid 
WHERE ug.role=$P{usergroupid} and ugm.user_objid=$P{userid}  
