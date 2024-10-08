select p.product_name,  sum(o.unit) as unit

from products as p
join orders as o
on p.product_id =o.product_id
WHERE o.order_date >= '2020-02-01' 
  AND o.order_date <= '2020-02-29'
group by o.product_id
having unit >=100
