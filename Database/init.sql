-- create database films;
-- drop database films;
create database AppDatabase;


drop table catalogue;

create table catalogue
(
    id          serial primary key,
    uuid        text     not null,
    name        text     not null,
    year        smallint not null,
    genre       text     not null,
    description text     not null,
    director    text     not null,
    actors      text     not null
);

drop table if exists comments;
drop table if exists comment;
create table comment
(
    id           serial primary key,
    catalogue_id integer not null references catalogue (id),
    comment      text
);

create table rating
(
    id serial primary key,
    catalogue_id integer not null references catalogue (id),
    rating numeric
);

drop table rating;



insert into catalogue(uuid, name, year, genre, description, director, actors)
values ('7d06dff4-aa68-4a78-817a-16d2dee204f2',
        'The Matrix',
        1999,
        'Sci-Fi',
        'Set in the 22nd century, The Matrix tells the story of a computer hacker who joins a group of underground insurgents fighting the vast and powerful computers who now rule the earth.',
        'Lilly Wachowski',
        'Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss'),
       ('f2cfd271-8245-4fbb-be22-c8d7d084073e',
        'The Matrix Reloaded',
        2003,
        'Sci-Fi',
        'Six months after the events depicted in The Matrix, Neo has proved to be a good omen for the free humans, as more and more humans are being freed from the matrix and brought to Zion, the one and only stronghold of the Resistance. Neo himself has discovered his superpowers including super speed, ability to see the codes of the things inside the matrix and a certain degree of pre-cognition. But a nasty piece of news hits the human resistance: 250,000 machine sentinels are digging to Zion and would reach them in 72 hours. As Zion prepares for the ultimate war, Neo, Morpheus and Trinity are advised by the Oracle to find the Keymaker who would help them reach the Source. Meanwhile Neo''s recurrent dreams depicting Trinity''s death have got him worried and as if it was not enough, Agent Smith has somehow escaped deletion, has become more powerful than before and has fixed Neo as his next target.',
        'Lilly Wachowski',
        'Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss'),
       ('7bd28eb4-f128-4ffd-bf9e-2dfed08911d2',
        'The Matrix Revolutions',
        2003,
        'Sci-Fi',
        'The human city of Zion defends itself against the massive invasion of the machines as Neo fights to end the war at another front while also opposing the rogue Agent Smith.',
        'Lilly Wachowski',
        'Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss'),
       ('8082ed08-1e79-4d96-9e38-2154ab80f898',
        'The Internship',
        2013,
        'Comedy',
        'Two recently laid-off men in their 40s try to make it as interns at a successful Internet company where their managers are in their 20s.',
        'Shawn Levy',
        'Vince Vaughn, Owen Wilson, Rose Byrne'),
       ('cdade04f-c2e7-4379-bfba-20ccafc37457',
        'Steve Jobs',
        2015,
        'Biography',
        'Steve Jobs takes us behind the scenes of the digital revolution, to paint a portrait of the man at its epicenter. The story unfolds backstage at three iconic product launches, ending in 1998 with the unveiling of the iMac.',
        'Danny Boyle',
        'Michael Fassbender, Kate Winslet, Seth Rogen, Jeff Daniels'),
       ('eecd0f15-9263-40f1-9351-8aabf179bb50',
        'The Social Network',
        2010,
        'Drama',
        'The tale of a new breed of cultural insurgent: a punk genius who sparked a revolution and changed the face of human interaction for a generation, and perhaps forever.',
        'David Fincher',
        'Jesse Eisenberg, Andrew Garfield, Justin Timberlake'),
       ('ce3a18e4-b15a-4f74-9402-3c8b0814db5c',
        'The Imitation Game',
        2014,
        'History',
        'Based on the real life story of legendary cryptanalyst Alan Turing, the film portrays the nail-biting race against time by Turing and his brilliant team of code-breakers at Britain''s top-secret Government Code and Cypher School at Bletchley Park, during the darkest days of World War II.',
        'Morten Tyldum',
        'Benedict Cumberbatch, Keira Knightley, Matthew Goode'),
       ('20976a0a-172a-45bf-90a1-0ad88396cfac',
        'Snowden',
        2016,
        'History',
        'CIA employee Edward Snowden leaks thousands of classified documents to the press.',
        'Oliver Stone',
        'Joseph Gordon-Levitt, Shailene Woodley, Melissa Leo'),
       ('831d1722-c350-48b0-b06d-65fe0150e662',
        'Hackers',
        1995,
        'Action',
        'Along with his new friends, a teenager who was arrested by the US Secret Service and banned from using a computer for writing a computer virus discovers a plot by a nefarious hacker, but they must use their computer skills to find the evidence while being pursued by the Secret Service and the evil computer genius behind the virus.',
        'Iain Softley',
        'Jonny Lee Miller, Angelina Jolie, Jesse Bradford');

insert into catalogue(uuid, name, year, genre, description, director, actors)
values ('c749e9de-c511-4db8-94b3-01d09ebdd70b',
        'A.I.: Artificial Intelligence',
        2001,
        'Drama',
        'A highly advanced robotic boy longs to become "real" so that he can regain the love of his human mother.',
        'Steven Spielberg',
        'Haley Joel Osment, Jude Law, Frances O''Connor'),
       ('8d3520b9-3d4c-4954-85ed-f2cc0838b514',
        'Source Code',
        2011,
        'Action',
        'A soldier wakes up in someone else''s body and discovers he''s part of an experimental government program to find the bomber of a commuter train within 8 minutes.',
        'Duncan Jones',
        'Jake Gyllenhaal, Michelle Monaghan, Vera Farmiga'),
       ('9f256e36-2b33-46ae-a5dc-1c4ca1f7c60f',
        'Ex Machina',
        2014,
        'Sci-Fi',
        'A young programmer is selected to participate in a ground-breaking experiment in synthetic intelligence by evaluating the human qualities of a highly advanced humanoid A.I.',
        'Alex Garland',
        'Alicia Vikander, Domhnall Gleeson, Oscar Isaac'),
       ('fe24e5b8-b3b7-4c53-b68d-079548389e17',
        'We Are Legion: The Story of the Hacktivists',
        2012,
        'Documentary',
        'A documentary on the workings and beliefs of the self-described "hacktivist" collective, Anonymous.',
        'Brian Knappenberger',
        'Anon2World, Anonyops, Julian Assange'),
       ('3e60a153-be50-443c-bf02-4d0a15f32b6e',
        'Pirates of Silicon Valley',
        1999,
        'Biography',
        'History of Apple and Microsoft',
        'Martyn Burke',
        'Anthony Michael Hall, Noah Wyle, Joey Slotnick'),
       ('ca720012-ac64-4aa5-b29e-c1f8634e88df',
        'Morgan',
        2016,
        'Horror',
        'A corporate risk-management consultant must decide whether or not to terminate an artificially created humanoid being.',
        'Luke Scott',
        'Kate Mara, Anya Taylor-Joy, Rose Leslie'),
       ('01d586d5-bfb5-4ce1-8ca5-65156f04cfab',
        'Who Am I',
        2014,
        'Crime',
        'Benjamin, a young German computer whiz, is invited to join a subversive hacker group that wants to be noticed on the world''s stage.',
        'Baran bo Odar',
        'Tom Schilling, Elyas M''Barek, Wotan Wilke Möhring');

select *
from catalogue;

select *
from comment;

select *
from rating;



select AVG(rating)::numeric(10,2)
from rating;

select round(avg(rating), 2) as average_rating
from rating
where catalogue_id = ?;


select * from comment where catalogue_id = 7;

update catalogue
set description = 'Freedom fighters Neo, Trinity and Morpheus continue to lead the revolt against the Machine Army, unleashing their arsenal of extraordinary skills and weaponry against the systematic forces of repression and exploitation.'
where name = 'The Matrix Reloaded';

create table userdata
(
    id serial primary key,
    useremail text not null unique,
    userpassword text not null,
    useremailverified boolean default false,
    usernickname text
);

drop table userdata;