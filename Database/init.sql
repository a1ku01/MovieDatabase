create database films;
drop database films;
create database AppDatabase;

create table catalogue
(
    id          serial primary key,
    name        text     not null,
    year        smallint not null,
    genre       text     not null,
    description text     not null,
    director    text     not null,
    actors      text     not null
);

insert into catalogue(name, year, genre, description, director, actors)
values ('The Matrix',
        1999,
        'Sci-Fi',
        'Set in the 22nd century, The Matrix tells the story of a computer hacker who joins a group of underground insurgents fighting the vast and powerful computers who now rule the earth.',
        'Lilly Wachowski',
        'Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss'),
       ('The Matrix Reloaded',
        2003,
        'Sci-Fi',
        'Six months after the events depicted in The Matrix, Neo has proved to be a good omen for the free humans, as more and more humans are being freed from the matrix and brought to Zion, the one and only stronghold of the Resistance. Neo himself has discovered his superpowers including super speed, ability to see the codes of the things inside the matrix and a certain degree of pre-cognition. But a nasty piece of news hits the human resistance: 250,000 machine sentinels are digging to Zion and would reach them in 72 hours. As Zion prepares for the ultimate war, Neo, Morpheus and Trinity are advised by the Oracle to find the Keymaker who would help them reach the Source. Meanwhile Neo''s recurrent dreams depicting Trinity''s death have got him worried and as if it was not enough, Agent Smith has somehow escaped deletion, has become more powerful than before and has fixed Neo as his next target.',
        'Lilly Wachowski',
        'Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss'),
       ('The Matrix Revolutions',
        2003,
        'Sci-Fi',
        'The human city of Zion defends itself against the massive invasion of the machines as Neo fights to end the war at another front while also opposing the rogue Agent Smith.',
        'Lilly Wachowski',
        'Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss'),
       ('The Internship',
        2013,
        'Comedy',
        'Two recently laid-off men in their 40s try to make it as interns at a successful Internet company where their managers are in their 20s.',
        'Shawn Levy',
        'Vince Vaughn, Owen Wilson, Rose Byrne'),
       ('Steve Jobs',
        2015,
        'Biography',
        'Steve Jobs takes us behind the scenes of the digital revolution, to paint a portrait of the man at its epicenter. The story unfolds backstage at three iconic product launches, ending in 1998 with the unveiling of the iMac.',
        'Danny Boyle',
        'Michael Fassbender, Kate Winslet, Seth Rogen, Jeff Daniels'),
       ('The Social Network',
        2010,
        'Drama',
        'The tale of a new breed of cultural insurgent: a punk genius who sparked a revolution and changed the face of human interaction for a generation, and perhaps forever.',
        'David Fincher',
        'Jesse Eisenberg, Andrew Garfield, Justin Timberlake'),
       ('The Imitation Game',
        2014,
        'History',
        'Based on the real life story of legendary cryptanalyst Alan Turing, the film portrays the nail-biting race against time by Turing and his brilliant team of code-breakers at Britain''s top-secret Government Code and Cypher School at Bletchley Park, during the darkest days of World War II.',
        'Morten Tyldum',
        'Benedict Cumberbatch, Keira Knightley, Matthew Goode'),
       ('Snowden',
        2016,
        'History',
        'CIA employee Edward Snowden leaks thousands of classified documents to the press.',
        'Oliver Stone',
        'Joseph Gordon-Levitt, Shailene Woodley, Melissa Leo'),
       ('Hackers',
        1995,
        'Action',
        'Along with his new friends, a teenager who was arrested by the US Secret Service and banned from using a computer for writing a computer virus discovers a plot by a nefarious hacker, but they must use their computer skills to find the evidence while being pursued by the Secret Service and the evil computer genius behind the virus.',
        'Iain Softley',
        'Jonny Lee Miller, Angelina Jolie, Jesse Bradford');


select * from catalogue;


