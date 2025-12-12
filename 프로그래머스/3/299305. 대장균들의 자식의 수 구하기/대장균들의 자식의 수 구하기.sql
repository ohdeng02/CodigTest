-- 코드를 작성해주세요
select a.id, COUNT(b.parent_id) as child_count 
from ECOLI_DATA a LEFT JOIN ECOLI_DATA b ON a.id = b.parent_id 
group by a.id
;