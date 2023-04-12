-- Ejercicio 2 Guia 12

-- 1. 
SELECT nombre FROM producto;

-- 2. 
SELECT nombre, precio FROM producto;

-- 3. 
SELECT * FROM producto;

-- 4.
SELECT nombre, ROUND(precio) FROM producto;

-- 5.
SELECT codigo_fabricante FROM producto;

-- 6. 
SELECT DISTINCT(codigo_fabricante) FROM producto;

-- 7. 
SELECT nombre FROM fabricante ORDER BY nombre ASC;

-- 8. 
SELECT nombre, precio FROM producto ORDER BY nombre ASC, precio DESC;

-- 9. 
SELECT * FROM fabricante LIMIT 5;

-- 10. 
SELECT nombre, precio FROM producto ORDER BY precio ASC LIMIT 1;

-- 11. 
SELECT nombre, precio FROM producto ORDER BY precio DESC LIMIT 1;

-- 12. 
SELECT nombre, precio FROM producto WHERE precio <= 120;

-- 13. 
SELECT nombre, precio FROM producto WHERE precio BETWEEN 60 AND 200;

-- 14. 
SELECT * FROM producto WHERE codigo_fabricante IN (1,3,5);

-- 15.
SELECT * FROM producto WHERE nombre LIKE '%Portatil%';

-- Consultas Multitabla

-- 1. Devuelve una lista con el código del producto, nombre del producto, código del fabricante 
--    y nombre del fabricante, de todos los productos de la base de datos.

SELECT producto.codigo, producto.nombre, codigo_fabricante, fabricante.nombre FROM fabricante INNER JOIN producto
ON fabricante.codigo = producto.codigo_fabricante; 

-- 2. Devuelve una lista con el nombre del producto, precio y nombre de fabricante de todos los productos de la 
--    base de datos. Ordene el resultado por el nombre del fabricante, por orden alfabético.

SELECT producto.nombre, precio, fabricante.nombre FROM fabricante INNER JOIN producto 
ON fabricante.codigo = producto.codigo_fabricante ORDER BY fabricante.nombre ASC; 

-- 3. Devuelve el nombre del producto, su precio y el nombre de su fabricante, del producto más barato. 

SELECT precio, producto.nombre AS producto, fabricante.nombre AS fabricante FROM fabricante INNER JOIN producto 
ON fabricante.codigo = producto.codigo_fabricante ORDER BY precio LIMIT 1;

-- 4. Devuelve una lista de todos los productos del fabricante Lenovo.

SELECT * FROM fabricante INNER JOIN producto ON fabricante.codigo = producto.codigo_fabricante
WHERE fabricante.nombre LIKE '%Lenovo%';

-- 5. Devuelve una lista de todos los productos del fabricante Crucial que tengan un precio mayor que $200.

SELECT producto.nombre AS producto, precio, fabricante.nombre AS fabricante FROM fabricante 
INNER JOIN producto ON fabricante.codigo = producto.codigo_fabricante
WHERE fabricante.nombre = 'Crucial' AND precio > 200;

-- 6. Devuelve un listado con todos los productos de los fabricantes Asus, Hewlett-Packard. Utilizando el operador IN.

SELECT * FROM fabricante INNER JOIN producto ON fabricante.codigo = producto.codigo_fabricante
WHERE fabricante.nombre IN ('Asus', 'Hewlett-Packard');

-- 7. Devuelve un listado con el nombre de producto, precio y nombre de fabricante, de todos los productos que tengan 
--    un precio mayor o igual a $180. Ordene el resultado en primer lugar por el precio (en orden descendente) y en
--    segundo lugar por el nombre (en orden ascendente).

SELECT producto.nombre, precio, fabricante.nombre FROM fabricante INNER JOIN producto ON fabricante.codigo = producto.codigo_fabricante
WHERE precio >= 180 ORDER BY precio DESC, producto.nombre ASC;

-- Consultas Multitabla 
-- Resuelva todas las consultas utilizando las cláusulas LEFT JOIN y RIGHT JOIN

-- 1. Devuelve un listado de todos los fabricantes que existen en la base de datos, junto con los productos que tiene 
-- cada uno de ellos. El listado deberá mostrar también aquellos fabricantes que no tienen productos asociados.

SELECT * FROM fabricante LEFT JOIN producto ON fabricante.codigo = producto.codigo_fabricante;

-- 2. Devuelve un listado donde sólo aparezcan aquellos fabricantes que no tienen ningún producto asociado.

SELECT * FROM fabricante LEFT JOIN producto ON fabricante.codigo = producto.codigo_fabricante WHERE producto.codigo IS NULL;

-- Subconsultas (En la cláusula WHERE)
-- Con operadores básicos de comparación

-- 1. Devuelve todos los productos del fabricante Lenovo. (Sin utilizar INNER JOIN).

SELECT * FROM producto WHERE codigo_fabricante IN (SELECT codigo FROM fabricante WHERE nombre = 'Lenovo');

-- 2. Devuelve todos los datos de los productos que tienen el mismo precio que el producto más caro del fabricante Lenovo.
-- (Sin utilizar INNER JOIN).

SELECT * FROM producto WHERE precio = (SELECT MAX(precio) FROM producto WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = 'Lenovo')); 

-- 3. Lista el nombre del producto más caro del fabricante Lenovo.

SELECT nombre, precio FROM producto WHERE precio = (SELECT MAX(precio) FROM producto WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = 'Lenovo'));

-- 4. Lista todos los productos del fabricante Asus que tienen un precio superior al precio medio de todos sus productos.

SELECT * FROM producto WHERE precio > (SELECT AVG(precio) FROM producto WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = 'Asus'))
AND codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = 'Asus');

-- Subconsultas con IN y NOT IN

-- 1. Devuelve los nombres de los fabricantes que tienen productos asociados. (Utilizando IN o NOT IN).

SELECT fabricante.nombre FROM fabricante WHERE codigo IN (SELECT codigo_fabricante FROM producto);

-- 2. Devuelve los nombres de los fabricantes que no tienen productos asociados. (Utilizando IN o NOT IN).

SELECT fabricante.nombre FROM fabricante WHERE codigo NOT IN (SELECT codigo_fabricante FROM producto);

-- Subconsultas (En la cláusula HAVING)

-- 1. Devuelve un listado con todos los nombres de los fabricantes que tienen el mismo número de productos que el fabricante Lenovo.

SELECT fabricante.nombre, COUNT(codigo_fabricante) AS cantidad_productos FROM fabricante INNER JOIN producto ON fabricante.codigo = producto.codigo_fabricante
GROUP BY codigo_fabricante HAVING COUNT(codigo_fabricante) = (SELECT COUNT(codigo_fabricante) FROM producto WHERE codigo_fabricante = 
(SELECT codigo FROM fabricante WHERE nombre = 'Lenovo')); 
