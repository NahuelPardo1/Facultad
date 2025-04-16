
//Ejercicio 1
// using practica4;

// List<Persona> personas = new List<Persona>();
// string entrada;
// Console.WriteLine("Ingrese los datos en el formato: Nombre Edad DNI (o presione enter para finalizar)");
// while(true){
//     entrada= Console.ReadLine();
//     if(string.IsNullOrWhiteSpace(entrada))
//     {
//         break;
//     }

//     string[] datos = entrada.Split(' ');
//     if(datos.Length<3){
//         Console.WriteLine("Formato incorrecto, Intente nuevamente");
//         continue;
//     }

//     string nombre = datos[0]+ " " + datos[1];
//     int edad;
//     string dni= datos[3];
//     if(!int.TryParse(datos[2],out edad)){
//         Console.WriteLine("La edad debe ser un numero. Intente nuevamente");
//         continue;
//     }
//     Persona persona = new Persona(nombre, edad, dni);
//     personas.Add(persona);
// }
// Console.WriteLine("\nListado de personas");
// for(int i=0; i<personas.Count; i++){
//     Console.WriteLine($"{i+1}) {personas[i].Nombre} {personas[i].Edad} {personas[i].DNI}");
// }

// Ejercicio 2
// Hora t1 = new Hora(23, 30, 15);
//         Console.WriteLine(t1.Imprimir());  
//         // Salida: 23 horas, 30 minutos y 15 segundos

//         Hora t2 = new Hora(14.43);
//         Console.WriteLine(t2.Imprimir());

Console.WriteLine("Ingrese los coeficientes de la ecuación cuadrática (ax^2 + bx + c = 0):");

        try
        {
            // Solicitar el coeficiente 'a'
            Console.Write("a: ");
            double a = double.Parse(Console.ReadLine());

            // Validar que 'a' no sea 0
            if (a == 0)
            {
                Console.WriteLine("El coeficiente 'a' no puede ser 0 en una ecuación cuadrática.");
                return;
            }

            // Solicitar el coeficiente 'b'
            Console.Write("b: ");
            double b = double.Parse(Console.ReadLine());

            // Solicitar el coeficiente 'c'
            Console.Write("c: ");
            double c = double.Parse(Console.ReadLine());

            // Crear una instancia de la clase Ecuacion2
            Ecuacion2 ecuacion = new Ecuacion2(a, b, c);

            // Mostrar el discriminante
            Console.WriteLine($"\nDiscriminante: {ecuacion.GetDiscriminante()}");

            // Mostrar la cantidad de raíces
            int cantidadRaices = ecuacion.GetCantidadDeRaices();
            Console.WriteLine($"Cantidad de raíces reales: {cantidadRaices}");

            // Imprimir las raíces
            ecuacion.ImprimirRaices();
        }
        catch (FormatException)
        {
            Console.WriteLine("Error: Debe ingresar un número válido.");
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Error: {ex.Message}");
        }
