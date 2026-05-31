-- 코드를 입력하세요

select book_id, author_name, published_date
from book
join author using (author_id)
where category = '경제'
order by published_date