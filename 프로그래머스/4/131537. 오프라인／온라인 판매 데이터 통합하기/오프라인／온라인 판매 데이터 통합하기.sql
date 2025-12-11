-- 코드를 입력하세요
SELECT date_format(SALES_DATE, '%Y-%m-%d') as SALES_DATE, product_id, user_id, sales_amount 
from ONLINE_SALE 
where YEAR(SALES_DATE) = 2022 and MONTH(SALES_DATE) = 3 
UNION ALL 
select date_format(SALES_DATE, '%Y-%m-%d') as SALES_DATE, product_id, NULL as user_id, sales_amount 
from offline_sale 
where YEAR(SALES_DATE) = 2022 and MONTH(SALES_DATE) = 3 
order by SALES_DATE, product_id, user_id;