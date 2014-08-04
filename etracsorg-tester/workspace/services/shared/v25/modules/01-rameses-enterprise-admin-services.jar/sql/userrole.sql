[getUsers]
SELECT 
u.objid as objid, 
u.username as username, 
u.lastname as lastname,
u.firstname as firstname,
ug.role as role,
ugm.org_name,
u.jobtitle as title,
ugm.usertxncode
FROM sys_usergroup_member ugm
INNER JOIN sys_usergroup ug ON ug.objid=ugm.usergroup_objid
INNER JOIN sys_user u ON u.objid=ugm.user_objid 
WHERE u.lastname LIKE '%'
AND ug.role IN (${roles})

[getRolesByUser]
SELECT ug.domain,ug.role,
ugm.exclude AS custom_exclude, 
sg.exclude AS security_exclude
FROM sys_usergroup_member ugm
INNER JOIN sys_usergroup ug ON ugm.usergroup_objid=ug.objid
LEFT JOIN sys_securitygroup sg ON sg.objid=ugm.securitygroup_objid 
WHERE ugm.user_objid=$P{userid} 
${filter}
