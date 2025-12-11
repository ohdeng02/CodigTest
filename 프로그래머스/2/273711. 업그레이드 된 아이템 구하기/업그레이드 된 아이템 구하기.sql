-- 코드를 작성해주세요
with children_item as (
    select it.item_id, it.parent_item_id, ii.item_name, ii.rarity as child_rarity 
    from ITEM_TREE it JOIN ITEM_INFO ii ON it.item_id = ii.item_id 
)

select t.item_id, t.item_name, child_rarity as rarity
from ITEM_INFO i JOIN children_item t ON t.parent_item_id = i.item_id 
where rarity = 'RARE' 
order by t.item_id desc;