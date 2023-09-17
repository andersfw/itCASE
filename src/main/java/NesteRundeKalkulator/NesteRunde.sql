CREATE table  Beverage (
    name VARCHAR(40),
    price INTEGER NOT NULL,
    CONSTRAINT PK PRIMARY KEY (name));

CREATE table User (
    name VARCHAR(40) NOT NULL,
    balance INTEGER NOT NULL,
    CONSTRAINT PK PRIMARY KEY (name));

CREATE table UserInSession (
    user VARCHAR(40) NOT NULL,
    session VARCHAR(40) NOT NULL,
    CONSTRAINT PK PRIMARY KEY (user)),
    CONSTRAINT PK PRIMARY KEY (session));

CREATE table Session (
    name VARCHAR(40) NOT NULL,
    users INTEGER NOT NULL,
    CONSTRAINT PK PRIMARY KEY (name));

