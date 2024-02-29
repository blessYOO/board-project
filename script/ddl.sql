
/* 게시글 테이블 */
create table board(
	boardSeq bigint not null auto_increment,
	boardType int,
	boardTitle varchar(100),
	boardWriter int,
	boardContent blob,
	secretYn char(2),
	boardPass int,
	boardAuth int,
	boardCnt int,
	fileCnt int,
	regdate timestamp default now(),
	upddate date,
	useYn char(2),
	primary key(boardSeq)
);

/* 사용자 테이블 */
create table member(
	memSeq bigint not null auto_increment,
	memId varchar(30),
	memPass varchar(30),
	memName varchar(30),
	memAuth int,
	useYn char(2),
	primary key(memSeq)
);

/* 게시판 테이블 */
create table boardType(
	boardType int,
	boardTypeName varchar(30),
	authId int,
	useYn char(2),
	primary key(boardType)
);

/* 권한 테이블 */
create table auth(
	authId int,
	authName varchar(30),
	useYn char(2),
	primary key(authId)
);


/* 게시글 답변 테이블 */
create table boardcomment(
	commentSeq bigint not null auto_increment,
	commentId varchar(30),
	commentContent varchar(500),
	targetId varchar(30),
	boardSeq bigint,
	boardType int,
	commentGroup int,
	secretYn char(2),
	boardAuth int,
	regdate timestamp default now(),
	upddate date,
	useYn char(2),
	primary key(commentSeq)
);
