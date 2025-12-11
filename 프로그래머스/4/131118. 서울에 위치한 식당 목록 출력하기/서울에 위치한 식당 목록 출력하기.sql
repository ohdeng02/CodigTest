-- 코드를 입력하세요
SELECT i.REST_ID, REST_NAME, FOOD_TYPE, FAVORITES, ADDRESS, round(AVG(review_score), 2) as SCORE
from REST_INFO i JOIN REST_REVIEW r 
ON i.rest_id = r.rest_id 
where address like '서울%' 
group by REST_ID 
order by SCORE desc, FAVORITES desc;

