/**********************************/
/* Table Name: 상품분류 */
/**********************************/
CREATE TABLE category(
		cateno                        		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		catename                      		VARCHAR2(50)		 NOT NULL,
		categrpno                     		NUMBER(10)		 NULL 
);

COMMENT ON TABLE category is '상품분류';
COMMENT ON COLUMN category.cateno is '분류번호';
COMMENT ON COLUMN category.catename is '분류명';
COMMENT ON COLUMN category.categrpno is '상위번호';


/**********************************/
/* Table Name: 컨텐츠 */
/**********************************/
CREATE TABLE contents(
		contentsno                    		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		cateno                        		NUMBER(10)		 NULL ,
		pname                         		VARCHAR2(50)		 NOT NULL,
		price                         		NUMBER(10)		 NOT NULL,
		filename                      		VARCHAR2(100)		 NULL ,
		detail                        		CLOB		 NOT NULL,
		rdate                         		DATE		 NOT NULL,
		stock                         		NUMBER(10)		 DEFAULT 0		 NOT NULL,
  FOREIGN KEY (cateno) REFERENCES category (cateno)
);

COMMENT ON TABLE contents is '컨텐츠';
COMMENT ON COLUMN contents.contentsno is '상품번호';
COMMENT ON COLUMN contents.cateno is '분류번호';
COMMENT ON COLUMN contents.pname is '상품명';
COMMENT ON COLUMN contents.price is '가격';
COMMENT ON COLUMN contents.filename is '상품이미지';
COMMENT ON COLUMN contents.detail is '상세내용';
COMMENT ON COLUMN contents.rdate is '등록일';
COMMENT ON COLUMN contents.stock is '재고량';


/**********************************/
/* Table Name: 회원 */
/**********************************/
CREATE TABLE member(
		ID                            		VARCHAR2(10)		 NOT NULL		 PRIMARY KEY,
		passwd                        		VARCHAR2(20)		 NOT NULL,
		mname                         		VARCHAR2(20)		 NOT NULL,
		tel                           		VARCHAR2(14)		 NULL ,
		email                         		VARCHAR2(50)		 NOT NULL,
		zipcode                       		VARCHAR2(7)		 NULL ,
		address1                      		VARCHAR2(150)		 NULL ,
		address2                      		VARCHAR2(50)		 NULL ,
		job                           		VARCHAR2(20)		 NOT NULL,
		mdate                         		DATE		 NOT NULL,
		fname                         		VARCHAR2(50)		 DEFAULT 'member.jpg'		 NOT NULL,
		grade                         		VARCHAR2(1)		 DEFAULT 'H'		 NOT NULL
);

COMMENT ON TABLE member is '회원';
COMMENT ON COLUMN member.ID is '아이디';
COMMENT ON COLUMN member.passwd is '비밀번호';
COMMENT ON COLUMN member.mname is '성명';
COMMENT ON COLUMN member.tel is '전화번호';
COMMENT ON COLUMN member.email is '이메일';
COMMENT ON COLUMN member.zipcode is '우편번호';
COMMENT ON COLUMN member.address1 is '주소';
COMMENT ON COLUMN member.address2 is '상세주소';
COMMENT ON COLUMN member.job is '직업';
COMMENT ON COLUMN member.mdate is '가입일';
COMMENT ON COLUMN member.fname is '회원사진';
COMMENT ON COLUMN member.grade is '회원등급';


/**********************************/
/* Table Name: 장바구니 */
/**********************************/
CREATE TABLE cart(
		cartno                        		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		ID                            		VARCHAR2(10)		 NULL ,
  FOREIGN KEY (ID) REFERENCES member (ID)
);

COMMENT ON TABLE cart is '장바구니';
COMMENT ON COLUMN cart.cartno is '장바구니번호';
COMMENT ON COLUMN cart.ID is '아이디';


/**********************************/
/* Table Name: 주문 */
/**********************************/
CREATE TABLE orders(
		orderno                       		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		id                            		VARCHAR2(10)		 NOT NULL,
		contentsno                    		NUMBER(10)		 NULL ,
		cartno                        		NUMBER(10)		 NULL ,
		odate                         		DATE		 NOT NULL,
		quantity                      		NUMBER(10)		 NOT NULL,
		total                         		NUMBER(10)		 NOT NULL,
		payment                       		VARCHAR2(10)		 NOT NULL,
		mname                         		VARCHAR2(20)		 NOT NULL,
		pname                         		VARCHAR2(50)		 NOT NULL,
  FOREIGN KEY (contentsno) REFERENCES contents (contentsno),
  FOREIGN KEY (cartno) REFERENCES cart (cartno)
);

COMMENT ON TABLE order is '주문';
COMMENT ON COLUMN order.orderno is '주문번호';
COMMENT ON COLUMN order.id is '아이디';
COMMENT ON COLUMN order.contentsno is '상품번호';
COMMENT ON COLUMN order.cartno is '장바구니번호';
COMMENT ON COLUMN order.odate is '주문날짜';
COMMENT ON COLUMN order.quantity is '주문수량';
COMMENT ON COLUMN order.total is '주문합계';
COMMENT ON COLUMN order.payment is '결제정보';
COMMENT ON COLUMN order.mname is '주문자';
COMMENT ON COLUMN order.pname is '상품이름';


/**********************************/
/* Table Name: 리뷰 */
/**********************************/
CREATE TABLE review(
		bbsno                         		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		contentsno                    		NUMBER(10)		 NULL ,
  FOREIGN KEY (contentsno) REFERENCES contents (contentsno)
);

COMMENT ON TABLE review is '리뷰';
COMMENT ON COLUMN review.bbsno is '글번호';
COMMENT ON COLUMN review.contentsno is '상품번호';


/**********************************/
/* Table Name: 댓글 */
/**********************************/
CREATE TABLE sreply(
		replyno                       		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		bbsno                         		NUMBER(10)		 NULL ,
  FOREIGN KEY (bbsno) REFERENCES review (bbsno)
);

COMMENT ON TABLE sreply is '댓글';
COMMENT ON COLUMN sreply.replyno is '댓글번호';
COMMENT ON COLUMN sreply.bbsno is '글번호';


/**********************************/
/* Table Name: Table8 */
/**********************************/
CREATE TABLE TABLE_8(

);

COMMENT ON TABLE TABLE_8 is 'Table8';


