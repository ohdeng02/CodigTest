-- 코드를 작성해주세요
select id, 
(
    case
        when size_of_colony <= 100 then 'LOW'
        when size_of_colony > 100 and size_of_colony <= 1000 then 'MEDIUM'
        else 'HIGH' 
end) as size 
from ECOLI_DATA 
where size_of_colony
order by id
;