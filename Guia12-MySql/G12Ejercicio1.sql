-- Ejercicio 1 Guia 12 --

-- 1. 
SELECT * FROM empleado;

-- 2.
SELECT * FROM departamento;

-- 3.
SELECT DISTINCT(nombre_depto) FROM departamento;

-- 4. 
SELECT nombre, salario FROM empleado;

-- 5.
SELECT comision FROM empleado;

-- 6.
SELECT * FROM empleado WHERE cargo = 'Secretaria';

-- 7.
SELECT * FROM empleado WHERE cargo = 'Vendedor' ORDER BY nombre ASC;

-- 8. 
SELECT nombre, cargo, salario FROM empleado ORDER BY salario ASC;

-- 9.
SELECT nombre AS Nombre, cargo AS Cargo FROM empleado;

-- 10.
SELECT nombre, salario, comision, id_depto FROM empleado WHERE id_depto = 2000 ORDER BY comision ASC;

-- 11. 
SELECT nombre, (salario+comision+500), id_depto FROM empleado WHERE id_depto = 3000 ORDER BY nombre ASC;

-- 12. 
SELECT nombre FROM empleado WHERE nombre LIKE 'J%';

-- 13. 
SELECT nombre, comision, salario, (salario+comision) AS total FROM empleado WHERE comision > 1000;

-- 14. 
SELECT nombre, comision, salario, (salario+comision) AS total FROM empleado WHERE comision = 0 OR comision = NULL;

-- 15. 
SELECT nombre, salario, comision FROM empleado WHERE comision > salario;

-- 16. 
SELECT nombre, salario, comision FROM empleado WHERE comision <= salario*0.30;

-- 17. 
SELECT nombre FROM empleado WHERE nombre NOT LIKE '%ma%';

-- 18. 
SELECT DISTINCT(nombre_depto) FROM departamento WHERE nombre_depto = 'Ventas' OR nombre_depto = 'Investigacion' OR nombre_depto = 'Mantenimiento';

-- 19. 
SELECT nombre_depto FROM departamento WHERE nombre_depto <> 'Ventas' AND nombre_depto <> 'Investigacion' AND nombre_depto <> 'Mantenimiento';

-- 20. 
SELECT MAX(salario) FROM empleado;

-- 21. 
SELECT MAX(nombre) FROM empleado ORDER BY nombre ASC;

-- 22. 
SELECT MAX(salario) AS MaximoSalario, MIN(salario) AS MinimoSalario, (MAX(salario)-MIN(salario)) AS DiferenciaSalarios FROM empleado;

-- 23. 
SELECT AVG(salario) AS Promedio_por_depto FROM empleado GROUP BY id_depto;

-- Consultas con Having 
-- 24. 
SELECT nombre_depto, COUNT(id_empleado) FROM empleado INNER JOIN departamento USING(id_depto) GROUP BY nombre_depto HAVING COUNT(id_empleado) > 3;

-- 25. 
SELECT cod_jefe, COUNT(id_empleado) FROM empleado GROUP BY cod_jefe HAVING COUNT(id_empleado) >= 2; 

-- 26. 
SELECT id_depto, COUNT(id_empleado) FROM empleado GROUP BY id_depto HAVING COUNT(id_empleado) = 0 OR COUNT(id_empleado) = NULL;

-- Consulta con Subconsulta
-- 27. 
SELECT nombre, salario, id_depto FROM empleado WHERE salario > (SELECT AVG(salario) FROM empleado) ORDER BY id_depto;
