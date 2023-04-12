-- Guia 12 EJercicio 1 EXTRA

-- 1. Mostrar el nombre de todos los jugadores ordenados alfabéticamente.
SELECT nombre FROM jugador ORDER BY nombre ASC;

-- 2. Mostrar el nombre de los jugadores que sean pivots (‘C’) y que pesen más de 200 libras, ordenados por nombre alfabéticamente.
SELECT * FROM jugador WHERE posicion = 'C' AND peso > 200;

-- 3. Mostrar el nombre de todos los equipos ordenados alfabéticamente.
SELECT * FROM equipo ORDER BY nombre ASC;

-- 4. Mostrar el nombre de los equipos del este (East).
SELECT * FROM equipo WHERE conferencia = 'East';

-- 5. Mostrar los equipos donde su ciudad empieza con la letra ‘c’, ordenados por nombre.
SELECT * FROM equipo WHERE ciudad LIKE 'c%' ORDER BY nombre ASC;

-- 6. Mostrar todos los jugadores y su equipo ordenados por nombre del equipo.
SELECT nombre, nombre_equipo FROM jugador ORDER BY nombre_equipo;

-- 7. Mostrar todos los jugadores del equipo “Raptors” ordenados por nombre.
SELECT nombre, nombre_equipo FROM jugador WHERE nombre_equipo = 'Raptors' ORDER BY nombre;

-- 8. Mostrar los puntos por partido del jugador ‘Pau Gasol’.
SELECT nombre, Puntos_por_partido FROM jugador INNER JOIN estadistica ON jugador.codigo = estadistica.jugador
WHERE nombre = 'Pau Gasol';

-- 9. Mostrar los puntos por partido del jugador ‘Pau Gasol’ en la temporada ’04/05′.
SELECT nombre, Puntos_por_partido, temporada FROM jugador INNER JOIN estadistica ON jugador.codigo = estadistica.jugador
WHERE nombre = 'Pau Gasol' AND temporada = '04/05';

-- 10. Mostrar el número de puntos de cada jugador en toda su carrera.
SELECT nombre, SUM(Puntos_por_partido) AS total_puntos FROM jugador INNER JOIN estadistica ON jugador.codigo = estadistica.jugador
GROUP BY nombre;

-- 11. Mostrar el número de jugadores de cada equipo.
SELECT nombre_equipo, COUNT(codigo) AS cantidad_jugadores FROM jugador GROUP BY nombre_equipo;

-- 12. Mostrar el jugador que más puntos ha realizado en toda su carrera.
SELECT nombre, SUM(Puntos_por_partido) AS total_puntos FROM jugador INNER JOIN estadistica ON jugador.codigo = estadistica.jugador
GROUP BY nombre ORDER BY total_puntos DESC LIMIT 1;

-- 13. Mostrar el nombre del equipo, conferencia y división del jugador más alto de la NBA.
SELECT nombre, conferencia, division FROM equipo WHERE nombre = (SELECT nombre_equipo FROM jugador WHERE altura = (SELECT MAX(altura) FROM jugador));
-- SELECT nombre, nombre_equipo FROM jugador WHERE altura = '7-6';

-- 14. Mostrar la media de puntos en partidos de los equipos de la división Pacific.
SELECT nombre, division, AVG(puntos_local) AS promedio_puntos_local, AVG(puntos_visitante) AS promedio_puntos_visitante 
FROM equipo INNER JOIN partido ON equipo.nombre = partido.equipo_local WHERE division = 'Pacific' GROUP BY nombre;

-- 15. Mostrar el partido o partidos (equipo_local, equipo_visitante y diferencia) con mayor diferencia de puntos.
-- No entiendo enunciado

-- 16. Mostrar la media de puntos en partidos de los equipos de la división Pacific.
-- Es la misma que la 14.

-- 17. Mostrar los puntos de cada equipo en los partidos, tanto de local como de visitante.
SELECT equipo_local, puntos_local, equipo_visitante, puntos_visitante FROM partido;
 
-- 18. Mostrar quien gana en cada partido (codigo, equipo_local, equipo_visitante, equipo_ganador), en caso de empate sera null.
