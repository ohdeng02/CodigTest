-- 코드를 작성해주세요
select a.id
from ECOLI_DATA a JOIN ECOLI_DATA b ON a.parent_id = b.id
JOIN ECOLI_DATA c ON b.parent_id = c.id 
where c.parent_id is null
;