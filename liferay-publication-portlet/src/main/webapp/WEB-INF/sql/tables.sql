create table publication (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	folderId LONG,
	title VARCHAR(75) null,
	urlTitle VARCHAR(75) null,
	description VARCHAR(75) null,
	content VARCHAR(75) null,
	structureId LONG,
	templateId LONG,
	status INTEGER
);