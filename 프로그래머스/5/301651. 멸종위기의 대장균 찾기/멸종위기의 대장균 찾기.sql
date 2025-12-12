-- 코드를 작성해주세요
with recursive tmp as(
    select id, parent_id, 1 as generation 
    from ECOLI_DATA 
    where parent_id is null
    union all
    select s.id, s.parent_id, tmp.generation + 1 
    from tmp join ECOLI_DATA s ON tmp.id = s.parent_id 
)

select count(*) as count, generation 
from tmp 
where id not in (
    select distinct parent_id 
    from tmp 
    where parent_id is not null
)
group by generation 
order by 2
;