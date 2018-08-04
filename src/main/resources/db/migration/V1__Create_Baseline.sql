--
-- PostgreSQL database dump
--

-- Dumped from database version 10.4
-- Dumped by pg_dump version 10.4

-- Started on 2018-07-27 18:32:56 EDT

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET default_with_oids = false;

CREATE SCHEMA IF NOT EXISTS transit_system;
SET search_path TO transit_system;

CREATE TABLE "user" (
    uid serial PRIMARY KEY,
    name character varying(50),
    email character varying(50),
    admin boolean DEFAULT false,
    password character varying(50),
    city character varying(50),
    modified_at bigint,
    created_at bigint
);

CREATE TABLE card (
    cid serial PRIMARY KEY,
    uid integer REFERENCES "user" (uid),
    active boolean DEFAULT true,
    balance double precision,
    modified_at bigint,
    created_at bigint
);

CREATE UNIQUE INDEX unique_user_email ON "user" (email);

CREATE TABLE route (
    rid serial PRIMARY KEY,
    name character varying(50),
    modified_at bigint,
    created_at bigint
);

CREATE TABLE station (
    sid serial PRIMARY KEY,
    point int,
    name character varying(50),
    rid integer REFERENCES route (rid),
    modified_at bigint,
    created_at bigint
);

CREATE UNIQUE INDEX unique_station_name ON station (name);


CREATE TABLE trip (
    tid serial PRIMARY KEY,
    uid integer REFERENCES "user" (uid),
    finish boolean DEFAULT false,
    modified_at bigint,
    created_at bigint
);

CREATE TABLE trip_segment (
    tsid serial PRIMARY KEY,
    tid integer REFERENCES "trip" (tid),
    cid integer REFERENCES card (cid),
    uid integer REFERENCES "user" (uid),
    "start" integer REFERENCES station (sid),
    "stop" integer REFERENCES station (sid),
    modified_at bigint,
    created_at bigint
);
