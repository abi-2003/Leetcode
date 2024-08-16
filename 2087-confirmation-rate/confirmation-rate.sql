SELECT 
    signups.user_id, 
    ROUND(
        AVG(
            IF(Confirmations.action = 'confirmed', 1, 0)
        ), 
        2
    ) AS confirmation_rate
FROM 
    signups 
LEFT JOIN 
    confirmations 
ON 
    signups.user_id = confirmations.user_id
GROUP BY 
    signups.user_id;
