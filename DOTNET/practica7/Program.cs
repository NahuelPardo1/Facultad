// object[] vector = [
//        new Moto("Zanella"),
//        new Empleado("Juan"),
//        new Moto("Gilera")
//    ];

// foreach (IImprimible i in vector)
// {
//     i.Imprimir();
// }

// object[] vector = [
//        new Moto("Zanella"),
//        new Empleado("Juan"),
//        new Moto("Gilera")
//    ];

// for(int i=0; i<vector.Length; i++){
//     (vector[i] as IImprimible)?.Imprimir();
// }

    IImprimible[] vector = [
    new Moto("Zanella"),
    new Empleado("Juan"),
    new Moto("Gilera")
    ];

    for (int i = 0; i < vector.Length; i++)
    {
    vector[i].Imprimir();
    }

    