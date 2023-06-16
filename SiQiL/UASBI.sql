-- This is the setup
use master

go

drop database if exists anime;

go

create database anime

go

use anime
go

create table anime 
(
	anime_id bigInt,
	anime_name NVARCHAR (300),
	anime_genre NVARCHAR (300),
	anime_type NVARCHAR (300),
	total_episode Ntext,
	rating float,
	member integer
);

create table rating
(
	id_user NVarchar (20),
	anime_id bigInt,
	rating_user float
)




-- Views untuk menghitung average rating user tanpa join tabel utama

CREATE VIEW NewAverageRatings AS
SELECT anime_id, AVG(rating_user) AS rata_rata_rating
FROM dbo.rating
GROUP BY anime_id
HAVING AVG(rating_user) > 0;

--Views untuk menampilkan rating beserta keterangannya

create view averageRating as
select 
N.anime_id,
anime_name,
anime_genre,
anime_type,
total_episode,
ROUND(N.rata_rata_rating,3) as rating,
member from dbo.anime a
inner join dbo.NewAverageRatings N on N.anime_id=a.anime_id

--views untuk menghitung total reviewer 

create view countByReviewers as
SELECT anime_id, COUNT(id_user) AS reviewer
FROM dbo.rating
GROUP BY anime_id
HAVING AVG(rating_user) > 0

-- views untuk menampilkan total viewer beserta keterangannya

create view totalReviewer as
select c.anime_id,
anime_name,
anime_genre,
anime_type,
total_episode,
c.reviewer
from dbo.anime a
inner join dbo.countByReviewers c
on c.anime_id=a.anime_id


update averageRating 
set anime_genre = REPLACE(anime_genre, '"','')

-- membuat table baru untuk menyimpan nilai dengan multi value
create table newAnimeRatings 
(
	anime_id bigInt,
	anime_name NVARCHAR (300),
	anime_genre NVARCHAR (300),
	anime_type NVARCHAR (300),
	total_episode Ntext,
	rating float,
	member integer
);

insert into newAnimeRatings 
(
	anime_id,
	anime_name,
	anime_genre,
	anime_type,
	total_episode,
	rating,
	member
)
select anime_id,anime_name,trim(value) as anime_genre,anime_type,total_episode,rating,member from averageRating
cross apply string_split(anime_genre,',')

-- views untuk membuat ranking berdasarkan genre

create view rankBasedOnGenre as
	select 
	anime_id,
	anime_name,
	anime_genre,
	anime_type,
	total_episode,
	rating,
	member,
	ROW_NUMBER()over(PARTITION BY anime_genre ORDER BY rating DESC) as ranking
	from newAnimeRatings


create view LowestRankBasedOnGenre as
	select 
	anime_id,
	anime_name,
	anime_genre,
	anime_type,
	total_episode,
	rating,
	member,
	ROW_NUMBER()over(PARTITION BY anime_genre ORDER BY rating desc) as ranking
	from newAnimeRatings

create view forExport as
	select
	a.anime_id ,
	a.anime_name,
	a.anime_genre ,
	a.anime_type,
	a.total_episode,
	a.rating,
	t.reviewer,
	member
	from averageRating a
	inner join totalReviewer t on t.anime_id=a.anime_id

select * from forExport
select * from rankBasedOnGenre where ranking <=3
select * from LowestRankBasedOnGenre where ranking <=3 

-- bagian select select taru disini


select * from newAnimeRatings order by rating desc

select top 10 * from totalReviewer order by reviewer asc, anime_id asc;

select * from NewAverageRatings order by (anime_id)

sl

use anime 
select top 10 * from averageRating order by member desc

select * from dbo.rating where anime_id=5834

select * from countByReviewers order by reviewer desc;