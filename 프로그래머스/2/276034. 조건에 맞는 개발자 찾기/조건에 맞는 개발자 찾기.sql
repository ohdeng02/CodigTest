-- 코드를 작성해주세요
select distinct id, email, first_name, last_name 
from DEVELOPERS d JOIN SKILLCODES s 
ON d.skill_code & s.code > 0 
where s.name IN ('Python','C#') 
order by id;