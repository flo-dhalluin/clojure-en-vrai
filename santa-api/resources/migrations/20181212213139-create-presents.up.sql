CREATE TABLE PRESENTS (id bigint PRIMARY KEY AUTO_INCREMENT,
       	     	       wishlistid bigint NOT NULL,
       	     	       name VARCHAR(256),
		       foreign key (wishlistid) references WISHLISTS(id))
		       
