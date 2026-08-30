# Write your MySQL query statement below
SELECT e.unique_id,f.name FROM Employees f  LEFT JOIN EmployeeUNI e ON 
e.id=f.id;