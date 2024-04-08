class Sistema:
  def registrarEmpleado(self):
      pass

  def registrarVisitante(self):
      pass

  def registrarVisita(self):
      pass

  def registrarAnimal(self):
      pass

  def registrarMantenimiento(self):
      pass

  def modificarRegistro(self):
      pass

  def eliminarRegistro(self):
      pass

  def consultarRegistros(self):
      pass

if __name__ == "__main__":
  sistema = Sistema()
  password = ""

  print("----- BIENVENIDOS AL ZOOLOGICO DE MORELIA -----")
  while password != "123456789@":
      password = input("Ingrese la contraseña:")

  opcion = 0
  while opcion != 9:
      print("Por favor, selecciona una opción:")
      print("1. Registrar Empleado")
      print("2. Registrar Visitante")
      print("3. Registrar Visita")
      print("4. Registrar Animal")
      print("5. Registrar Mantenimiento")
      print("6. Modificar Registro (Empleado, Visitante, Animal)")
      print("7. Eliminar Registro (Empleado, Visitante, Animal)")
      print("8. Consultar Registros")
      print("9. Salir")
      print("Seleccione una opción:")

      opcion = int(input())
      if opcion == 1:
          sistema.registrarEmpleado()
      elif opcion == 2:
          sistema.registrarVisitante()
      elif opcion == 3:
          sistema.registrarVisita()
      elif opcion == 4:
          sistema.registrarAnimal()
      elif opcion == 5:
          sistema.registrarMantenimiento()
      elif opcion == 6:
          sistema.modificarRegistro()
      elif opcion == 7:
          sistema.eliminarRegistro()
      elif opcion == 8:
          sistema.consultarRegistros()
      elif opcion == 9:
          print("Saliendo del sistema...")
      else:
          print("Opción no válida. Por favor, intenta de nuevo.")