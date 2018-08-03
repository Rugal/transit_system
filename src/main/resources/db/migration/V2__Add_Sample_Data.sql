SET search_path TO transit_system;

COPY "user" (uid, name, email, admin, password, city, modified_at, created_at) FROM stdin;
1	Rugal	test@mail.com	f	123	\N	\N	\N
\.


COPY station (sid, name, modified_at, created_at) FROM stdin;
1	Union	\N	\N
2	King	\N	\N
3	Queue	\N	\N
4	College	\N	\N
5	Dundas	\N	\N
\.


COPY edge (eid, start, stop, distance, modified_at, created_at) FROM stdin;
1	1	2	2	\N	\N
2	2	3	5	\N	\N
3	3	4	8	\N	\N
4	4	5	5	\N	\N
\.

SELECT pg_catalog.setval('user_uid_seq', 1, true);
SELECT pg_catalog.setval('station_sid_seq', 5, true);
SELECT pg_catalog.setval('edge_eid_seq', 4, true);
