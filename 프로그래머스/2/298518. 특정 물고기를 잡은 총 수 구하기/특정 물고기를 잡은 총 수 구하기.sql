-- 코드를 작성해주세요
select COUNT(*) as FISH_COUNT
from FISH_INFO f JOIN FISH_NAME_INFO n ON f.fish_type = n.fish_type 
where fish_name IN('BASS', 'SNAPPER');
