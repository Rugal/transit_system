SET search_path TO transit_system;

COPY "user" (uid, name, email, admin, password, city, modified_at, created_at) FROM stdin;
1	Rugal	test@mail.com	f	123	\N	\N	\N
\.

COPY route (rid, name, modified_at, created_at) FROM stdin;
1	Line 1	\N	\N
\.

COPY station (sid, point, name, rid, modified_at, created_at) FROM stdin;
1	1	Union	1	\N	\N
2	2	King	1	\N	\N
3	3	Queue	1	\N	\N
4	4	College	1	\N	\N
5	5	Dundas	1	\N	\N
6	6	Wellesley	1	\N	\N
7	7	Bloor	1	\N	\N
8	8	Rosedale	1	\N	\N
9	9	Summerhill	1	\N	\N
10	10	Stclair	1	\N	\N
11	11	Davisdale	1	\N	\N
12	12	Eglinton	1	\N	\N
13	13	Lawrance	1	\N	\N
14	14	Yorkmills	1	\N	\N
15	15	Sheppard	1	\N	\N
16	16	North York Center	1	\N	\N
17	17	Finch	1	\N	\N
\.

SELECT pg_catalog.setval('user_uid_seq', 1, true);
SELECT pg_catalog.setval('station_sid_seq', 17, true);
SELECT pg_catalog.setval('route_rid_seq', 1, true);
