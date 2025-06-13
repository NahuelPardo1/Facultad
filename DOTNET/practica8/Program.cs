Empleado[] empleados = [
   new Empleado("Juan",79),
   new Empleado("Adriana",123),
   new Empleado("Diego",23)
];
Array.Sort(empleados);
foreach (Empleado e in empleados)
{
   e.Imprimir();
}