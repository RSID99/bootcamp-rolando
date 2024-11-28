select t.descripcion_tipo
from tipos_articulos t;

select a.codigo_articulo, a.stock, s.nombre_sucursal
from articulos_sucursal a 
join sucursales s 
on s.codigo_sucursal = a.codigo_sucursal
where s.codigo_sucursal = 1;

select a.descripcion 
from articulos a
join articulos_sucursal ars
on ars.codigo_articulo = a.codigo_articulo
where ars.stock = 0 and ars.codigo_sucursal = 2 and a.codigo_tipo=1;

select e.cedula, e.nombres||' '||e.apellidos as empleado
from empleados e
where apellidos = 'MESSI';

select c.nombre
from clientes c
where c.nombre not like '%GONZALEZ%';

