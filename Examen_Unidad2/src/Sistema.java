import java.util.*;
public class Sistema {
    /*private List<Empleado> empleados;
    private List<Animal> animales;
    private List<Visitante> visitantes;
    private List<Mantenimiento> mantenimientos;
    private List<Visita> visitas;


    public Sistema(List<Empleado> empleados, List<Animal> animales, List<Visitante> visitantes, List<Mantenimiento> mantenimientos, List<Visita> visitas) {
        this.empleados = empleados;
        this.animales = animales;
        this.visitantes = visitantes;
        this.mantenimientos = mantenimientos;
        this.visitas = visitas;
    }

    public void registrarEmpleado(Empleado empleado) {
        this.empleados.add(empleado);
    }

    public void modificarEmpleado(int indice, Empleado empleado) {
        this.empleados.set(indice, empleado);
    }

    public void eliminarEmpleado(int indice) {
        this.empleados.remove(indice);
    }

    public Empleado consultarEmpleado(int indice) {
        return this.empleados.get(indice);
    }

    public void registrarAnimal(Animal animal) {
        this.animales.add(animal);
    }

    public void modificarAnimal(int indice, Animal animal) {
        this.animales.set(indice, animal);
    }

    public void eliminarAnimal(int indice) {
        this.animales.remove(indice);
    }

    public Animal consultarAnimal(int indice) {
        return this.animales.get(indice);
    }

    public void registrarVisitante(Visitante visitante) {
        this.visitantes.add(visitante);
    }

    public void modificarVisitante(int indice, Visitante visitante) {
        this.visitantes.set(indice, visitante);
    }

    public void eliminarVisitante(int indice) {
        this.visitantes.remove(indice);
    }

    public Visitante consultarVisitante(int indice) {
        return this.visitantes.get(indice);
    }

    public void registrarMantenimiento(Mantenimiento mantenimiento) {
        this.mantenimientos.add(mantenimiento);
    }

    public Mantenimiento consultarMantenimiento(int indice) {
        return this.mantenimientos.get(indice);
    }

    public void registrarVisita(Visita visita) {
        this.visitas.add(visita);
    }

    public Visita consultarVisita(int indice) {
        return this.visitas.get(indice);
    }
}*/
    private List<Empleado> empleados;
    private List<Visitante> visitantes;
    private List<Visita> visitas;
    private List<Animal> animales;
    private List<Mantenimiento> mantenimientos;
    private static int counter = 1;

    public Sistema() {
        empleados = new ArrayList<>();
        visitantes = new ArrayList<>();
        visitas = new ArrayList<>();
        animales = new ArrayList<>();
        mantenimientos = new ArrayList<>();
    }

    public void registrarEmpleado() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del empleado:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el apellido del empleado:");
        String apellidos = scanner.nextLine();
        System.out.println("Ingrese la fecha de nacimiento del empleado (yyyy-MM-dd):");
        String fechaNacimiento = scanner.nextLine();
        System.out.println("Ingrese el CURP del empleado:");
        String curp = scanner.nextLine();
        System.out.println("Ingrese el cargo del empleado:");
        String cargo = scanner.nextLine();
        System.out.println("Ingrese el salario del empleado:");
        double salario = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer de entrada

        Empleado empleado = new Empleado(nombre, apellidos, fechaNacimiento, curp, cargo, salario);
        empleados.add(empleado);

        System.out.println("Empleado registrado con éxito.");
    }

    public void registrarVisitante() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del visitante:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese los apellidos del visitante:");
        String apellidos = scanner.nextLine();
        System.out.println("Ingrese la fecha de nacimiento del visitante (yyyy-MM-dd):");
        String fechaNacimiento = scanner.nextLine();
        System.out.println("Ingrese el CURP del visitante:");
        String curp = scanner.nextLine();

        Visitante visitante = new Visitante(nombre, apellidos, fechaNacimiento, curp);
        visitantes.add(visitante);

        System.out.println("Visitante registrado con éxito.");
    }

    public void registrarVisita() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del guía de la visita:");
        String guia = scanner.nextLine();
        System.out.println("Ingrese la fecha de la visita (yyyy-MM-dd):");
        String fechaVisita = scanner.nextLine();
        System.out.println("Ingrese la cantidad de niños:");
        int cantidadNinos = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada
        System.out.println("Ingrese la cantidad de adultos:");
        int cantidadAdultos = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada

        // Seleccionar los visitantes que forman parte de esta visita
        List<Visitante> visitantesEnVisita = new ArrayList<>();
        System.out.println("Ingrese el número de visitantes para esta visita:");
        int numVisitantes = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada
        for (int i = 0; i < numVisitantes; i++) {
            System.out.println("Ingrese el CURP del visitante " + (i + 1) + ":");
            String curp = scanner.nextLine();
            for (Visitante visitante : visitantes) {
                if (visitante.getCurp().equals(curp)) {
                    visitantesEnVisita.add(visitante);
                    break;
                }
            }
        }

        // Calcular costo total de la visita
        double costoTotal = (cantidadNinos * 50) + (cantidadAdultos * 100);

        Visita visita = new Visita(guia, visitantesEnVisita, costoTotal, fechaVisita, cantidadNinos, cantidadAdultos);
        visitas.add(visita);

        System.out.println("Visita registrada con éxito.");
    }

    public void registrarAnimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el tipo de animal:");
        String tipoAnimal = scanner.nextLine();
        System.out.println("Ingrese la fecha de nacimiento del animal (yyyy-MM-dd):");
        String fechaNacimiento = scanner.nextLine();
        System.out.println("Ingrese la fecha de llegada al zoológico (yyyy-MM-dd):");
        String fechaLlegada = scanner.nextLine();
        System.out.println("Ingrese el peso del animal:");
        double peso = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer de entrada
        System.out.println("¿El animal tiene enfermedades? (S/N):");
        String respuestaEnfermedades = scanner.nextLine();
        List<String> enfermedades = new ArrayList<>();
        if (respuestaEnfermedades.equalsIgnoreCase("S")) {
            System.out.println("Ingrese las enfermedades del animal (separadas por comas):");
            String[] enfermedadesArray = scanner.nextLine().split(",");
            for (String enfermedad : enfermedadesArray) {
                enfermedades.add(enfermedad.trim());
            }
        }
        System.out.println("Ingrese la frecuencia de alimentación del animal:");
        String frecuenciaAlimentacion = scanner.nextLine();
        System.out.println("Ingrese el tipo de alimentación del animal:");
        String tipoAlimentacion = scanner.nextLine();
        System.out.println("¿El animal cuenta con vacunas? (S/N):");
        boolean vacunas = scanner.nextLine().equalsIgnoreCase("S");

        Animal animal = new Animal("A" + counter++, tipoAnimal, fechaNacimiento, fechaLlegada, peso, enfermedades,
                frecuenciaAlimentacion, tipoAlimentacion, vacunas);
        animales.add(animal);

        System.out.println("Animal registrado con éxito. ID: " + animal.getId());
    }

    public void registrarMantenimiento() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el ID del animal al que se le realizó el mantenimiento:");
        String idAnimal = scanner.nextLine();
        System.out.println("Ingrese el nombre del empleado encargado:");
        String empleadoEncargado = scanner.nextLine();
        System.out.println("Ingrese el proceso realizado (Mantenimiento, limpieza, alimentación, etc.):");
        String procesoRealizado = scanner.nextLine();
        System.out.println("Ingrese la fecha del mantenimiento (yyyy-MM-dd):");
        String fechaMantenimiento = scanner.nextLine();
        System.out.println("Ingrese observaciones adicionales:");
        String observaciones = scanner.nextLine();

        Mantenimiento mantenimiento = new Mantenimiento(idAnimal, empleadoEncargado, procesoRealizado, fechaMantenimiento, observaciones);
        mantenimientos.add(mantenimiento);

        System.out.println("Mantenimiento registrado con éxito.");
    }

    public void modificarRegistro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione qué tipo de registro desea modificar:");
        System.out.println("1. Empleado");
        System.out.println("2. Visitante");
        System.out.println("3. Animal");
        int opcionModificar = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada

        switch (opcionModificar) {
            case 1:
                modificarEmpleado();
                break;
            case 2:
                modificarVisitante();
                break;
            case 3:
                modificarAnimal();
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    private void modificarEmpleado() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el CURP del empleado a modificar:");
        String curpEmpleado = scanner.nextLine();
        for (Empleado empleado : empleados) {
            if (empleado.getCurp().equals(curpEmpleado)) {
                System.out.println("Ingrese el nuevo nombre del empleado:");
                String nuevoNombre = scanner.nextLine();
                System.out.println("Ingrese el nuevo apellido del empleado:");
                String nuevoApellido = scanner.nextLine();
                System.out.println("Ingrese la nueva fecha de nacimiento del empleado (yyyy-MM-dd):");
                String nuevaFechaNacimiento = scanner.nextLine();
                System.out.println("Ingrese el nuevo CURP del empleado:");
                String nuevoCurp = scanner.nextLine();
                System.out.println("Ingrese el nuevo cargo del empleado:");
                String nuevoCargo = scanner.nextLine();
                System.out.println("Ingrese el nuevo salario del empleado:");
                double nuevoSalario = scanner.nextDouble();
                scanner.nextLine(); // Limpiar el buffer de entrada

                empleado.setNombre(nuevoNombre);
                empleado.setApellidos(nuevoApellido);
                empleado.setFechaNacimiento(nuevaFechaNacimiento);
                empleado.setCurp(nuevoCurp);
                empleado.setCargo(nuevoCargo);
                empleado.setSalario(nuevoSalario);

                System.out.println("Empleado modificado con éxito.");
                return;
            }
        }
        System.out.println("Empleado con CURP " + curpEmpleado + " no encontrado.");
    }

    private void modificarVisitante() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el CURP del visitante a modificar:");
        String curpVisitante = scanner.nextLine();
        for (Visitante visitante : visitantes) {
            if (visitante.getCurp().equals(curpVisitante)) {
                System.out.println("Ingrese el nuevo nombre del visitante:");
                String nuevoNombre = scanner.nextLine();
                System.out.println("Ingrese el nuevo apellido del visitante:");
                String nuevoApellido = scanner.nextLine();
                System.out.println("Ingrese la nueva fecha de nacimiento del visitante (yyyy-MM-dd):");
                String nuevaFechaNacimiento = scanner.nextLine();
                System.out.println("Ingrese el nuevo CURP del visitante:");
                String nuevoCurp = scanner.nextLine();

                visitante.setNombre(nuevoNombre);
                visitante.setApellidos(nuevoApellido);
                visitante.setFechaNacimiento(nuevaFechaNacimiento);
                visitante.setCurp(nuevoCurp);

                System.out.println("Visitante modificado con éxito.");
                return;
            }
        }
        System.out.println("Visitante con CURP " + curpVisitante + " no encontrado.");
    }

    private void modificarAnimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el ID del animal a modificar:");
        String idAnimal = scanner.nextLine();
        for (Animal animal : animales) {
            if (animal.getId().equals(idAnimal)) {
                System.out.println("Ingrese el nuevo tipo de animal:");
                String nuevoTipoAnimal = scanner.nextLine();
                System.out.println("Ingrese la nueva fecha de nacimiento del animal (yyyy-MM-dd):");
                String nuevaFechaNacimiento = scanner.nextLine();
                System.out.println("Ingrese la nueva fecha de llegada al zoológico (yyyy-MM-dd):");
                String nuevaFechaLlegada = scanner.nextLine();
                System.out.println("Ingrese el nuevo peso del animal:");
                double nuevoPeso = scanner.nextDouble();
                scanner.nextLine(); // Limpiar el buffer de entrada
                System.out.println("¿El animal tiene nuevas enfermedades? (S/N):");
                String respuestaEnfermedades = scanner.nextLine();
                List<String> nuevasEnfermedades = new ArrayList<>();
                if (respuestaEnfermedades.equalsIgnoreCase("S")) {
                    System.out.println("Ingrese las nuevas enfermedades del animal (separadas por comas):");
                    String[] enfermedadesArray = scanner.nextLine().split(",");
                    for (String enfermedad : enfermedadesArray) {
                        nuevasEnfermedades.add(enfermedad.trim());
                    }
                }
                System.out.println("Ingrese la nueva frecuencia de alimentación del animal:");
                String nuevaFrecuenciaAlimentacion = scanner.nextLine();
                System.out.println("Ingrese el nuevo tipo de alimentación del animal:");
                String nuevoTipoAlimentacion = scanner.nextLine();
                System.out.println("¿El animal cuenta con nuevas vacunas? (S/N):");
                boolean nuevasVacunas = scanner.nextLine().equalsIgnoreCase("S");

                animal.setTipoAnimal(nuevoTipoAnimal);
                animal.setFechaNacimiento(nuevaFechaNacimiento);
                animal.setFechaLlegada(nuevaFechaLlegada);
                animal.setPeso(nuevoPeso);
                animal.setEnfermedades(nuevasEnfermedades);
                animal.setFrecuenciaAlimentacion(nuevaFrecuenciaAlimentacion);
                animal.setTipoAlimentacion(nuevoTipoAlimentacion);
                animal.setVacunas(nuevasVacunas);

                System.out.println("Animal modificado con éxito.");
                return;
            }
        }
        System.out.println("Animal con ID " + idAnimal + " no encontrado.");
    }

    public void eliminarRegistro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione qué tipo de registro desea eliminar:");
        System.out.println("1. Empleado");
        System.out.println("2. Visitante");
        System.out.println("3. Animal");
        int opcionEliminar = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada

        switch (opcionEliminar) {
            case 1:
                eliminarEmpleado();
                break;
            case 2:
                eliminarVisitante();
                break;
            case 3:
                eliminarAnimal();
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    private void eliminarEmpleado() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el CURP del empleado a eliminar:");
        String curpEmpleado = scanner.nextLine();
        for (Empleado empleado : empleados) {
            if (empleado.getCurp().equals(curpEmpleado)) {
                empleados.remove(empleado);
                System.out.println("Empleado eliminado con éxito.");
                return;
            }
        }
        System.out.println("Empleado con CURP " + curpEmpleado + " no encontrado.");
    }

    private void eliminarVisitante() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el CURP del visitante a eliminar:");
        String curpVisitante = scanner.nextLine();
        for (Visitante visitante : visitantes) {
            if (visitante.getCurp().equals(curpVisitante)) {
                visitantes.remove(visitante);
                System.out.println("Visitante eliminado con éxito.");
                return;
            }
        }
        System.out.println("Visitante con CURP " + curpVisitante + " no encontrado.");
    }

    private void eliminarAnimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el ID del animal a eliminar:");
        String idAnimal = scanner.nextLine();
        for (Animal animal : animales) {
            if (animal.getId().equals(idAnimal)) {
                animales.remove(animal);
                System.out.println("Animal eliminado con éxito.");
                return;
            }
        }
        System.out.println("Animal con ID " + idAnimal + " no encontrado.");
    }

    public void consultarRegistros() {
        System.out.println("---------- Empleados ----------");
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            for (Empleado empleado : empleados) {
                System.out.println(empleado);
            }
        }

        System.out.println("\n---------- Visitantes ----------");
        if (visitantes.isEmpty()) {
            System.out.println("No hay visitantes registrados.");
        } else {
            for (Visitante visitante : visitantes) {
                System.out.println(visitante);
            }
        }

        System.out.println("\n---------- Visitas ----------");
        if (visitas.isEmpty()) {
            System.out.println("No hay visitas registradas.");
        } else {
            for (Visita visita : visitas) {
                System.out.println(visita);
            }
        }

        System.out.println("\n---------- Animales ----------");
        if (animales.isEmpty()) {
            System.out.println("No hay animales registrados.");
        } else {
            for (Animal animal : animales) {
                System.out.println(animal);
            }
        }

        System.out.println("\n---------- Mantenimientos ----------");
        if (mantenimientos.isEmpty()) {
            System.out.println("No hay mantenimientos registrados.");
        } else {
            for (Mantenimiento mantenimiento : mantenimientos) {
                System.out.println(mantenimiento);
            }
        }
    }
}