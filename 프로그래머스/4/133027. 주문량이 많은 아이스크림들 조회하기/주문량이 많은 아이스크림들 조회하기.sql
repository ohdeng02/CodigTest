-- 코드를 입력하세요
with total as (
select *
from FIRST_HALF 
union 
select *
from july 
)

select flavor
from total 
group by flavor 
order by SUM(total_order) desc
limit 3
;
    
