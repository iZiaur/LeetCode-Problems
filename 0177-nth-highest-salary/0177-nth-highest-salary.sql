CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
        SELECT salary FROM(
            SELECT salary,
            DENSE_RANK() OVER(ORDER BY salary DESC) AS rnk  FROM Employee
        )As t
        WHERE rnk=N
        LIMIT 1
  );
END