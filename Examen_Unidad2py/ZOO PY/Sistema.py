class Sistema:
  counter = 1

  def __init__(self):
      self.empleados = []
      self.visitantes = []
      self.visitas = []
      self.animales = []
      self.mantenimientos = []

  def registrar_empleado(self):
      nombre = input("Ingrese el nombre del empleado: ")
      apellidos = input("Ingrese el apellido del empleado: ")
      fecha_nacimiento = input("Ingrese la fecha de nacimiento del empleado (yyyy-MM-dd): ")
      curp = input("Ingrese el CURP del empleado: ")
      cargo = input("Ingrese el cargo del empleado: ")
      salario = float(input("Ingrese el salario del empleado: "))

      empleado = Empleado(nombre, apellidos, fecha_nacimiento, curp, cargo, salario)
      self.empleados.append(empleado)

      print("Empleado registrado con éxito.")

  def registrar_visitante(self):
      nombre = input("Ingrese el nombre del visitante: ")
      apellidos = input("Ingrese los apellidos del visitante: ")
      fecha_nacimiento = input("Ingrese la fecha de nacimiento del visitante (yyyy-MM-dd): ")
      curp = input("Ingrese el CURP del visitante: ")

      visitante = Visitante(nombre, apellidos, fecha_nacimiento, curp)
      self.visitantes.append(visitante)

      print("Visitante registrado con éxito.")

  def registrar_visita(self):
      guia = input("Ingrese el nombre del guía de la visita: ")
      fecha_visita = input("Ingrese la fecha de la visita (yyyy-MM-dd): ")
      cantidad_ninos = int(input("Ingrese la cantidad de niños: "))
      cantidad_adultos = int(input("Ingrese la cantidad de adultos: "))

      visitantes_en_visita = []
      num_visitantes = int(input("Ingrese el número de visitantes para esta visita: "))
      for i in range(num_visitantes):
          curp = input("Ingrese el CURP del visitante {}: ".format(i + 1))
          for visitante in self.visitantes:
              if visitante.get_curp() == curp:
                  visitantes_en_visita.append(visitante)
                  break

      costo_total = (cantidad_ninos * 50) + (cantidad_adultos * 100)

      visita = Visita(guia, visitantes_en_visita, costo_total, fecha_visita, cantidad_ninos, cantidad_adultos)
      self.visitas.append(visita)

      print("Visita registrada con éxito.")

  def registrar_animal(self):
      tipo_animal = input("Ingrese el tipo de animal: ")
      fecha_nacimiento = input("Ingrese la fecha de nacimiento del animal (yyyy-MM-dd): ")
      fecha_llegada = input("Ingrese la fecha de llegada al zoológico (yyyy-MM-dd): ")
      peso = float(input("Ingrese el peso del animal: "))
      respuesta_enfermedades = input("¿El animal tiene enfermedades? (S/N): ")
      enfermedades = []
      if respuesta_enfermedades.upper() == "S":
          enfermedades = input("Ingrese las enfermedades del animal (separadas por comas): ").split(",")
      frecuencia_alimentacion = input("Ingrese la frecuencia de alimentación del animal: ")
      tipo_alimentacion = input("Ingrese el tipo de alimentación del animal: ")
      vacunas = input("¿El animal cuenta con vacunas? (S/N): ").upper() == "S"

      animal = Animal("A" + str(Sistema.counter), tipo_animal, fecha_nacimiento, fecha_llegada, peso,
                      enfermedades, frecuencia_alimentacion, tipo_alimentacion, vacunas)
      self.animales.append(animal)

      print("Animal registrado con éxito. ID:", animal.get_id())

  def registrar_mantenimiento(self):
      id_animal = input("Ingrese el ID del animal al que se le realizó el mantenimiento: ")
      empleado_encargado = input("Ingrese el nombre del empleado encargado: ")
      proceso_realizado = input("Ingrese el proceso realizado (Mantenimiento, limpieza, alimentación, etc.): ")
      fecha_mantenimiento = input("Ingrese la fecha del mantenimiento (yyyy-MM-dd): ")
      observaciones = input("Ingrese observaciones adicionales: ")

      mantenimiento = Mantenimiento(id_animal, empleado_encargado, proceso_realizado, fecha_mantenimiento, observaciones)
      self.mantenimientos.append(mantenimiento)

      print("Mantenimiento registrado con éxito.")

  def modificar_registro(self):
      opcion_modificar = int(input("Seleccione qué tipo de registro desea modificar:\n"
                                   "1. Empleado\n"
                                   "2. Visitante\n"
                                   "3. Animal\n"))

      if opcion_modificar == 1:
          self.modificar_empleado()
      elif opcion_modificar == 2:
          self.modificar_visitante()
      elif opcion_modificar == 3:
          self.modificar_animal()
      else:
          print("Opción no válida")

  def modificar_empleado(self):
      curp_empleado = input("Ingrese el CURP del empleado a modificar: ")
      for empleado in self.empleados:
          if empleado.get_curp() == curp_empleado:
              nuevo_nombre = input("Ingrese el nuevo nombre del empleado: ")
              nuevo_apellido = input("Ingrese el nuevo apellido del empleado: ")
              nueva_fecha_nacimiento = input("Ingrese la nueva fecha de nacimiento del empleado (yyyy-MM-dd): ")
              nuevo_curp = input("Ingrese el nuevo CURP del empleado: ")
              nuevo_cargo = input("Ingrese el nuevo cargo del empleado: ")
              nuevo_salario = float(input("Ingrese el nuevo salario del empleado: "))

              empleado.set_nombre(nuevo_nombre)
              empleado.set_apellidos(nuevo_apellido)
              empleado.set_fecha_nacimiento(nueva_fecha_nacimiento)
              empleado.set_curp(nuevo_curp)
              empleado.set_cargo(nuevo_cargo)
              empleado.set_salario(nuevo_salario)

              print("Empleado modificado con éxito.")
              return
      print("Empleado con CURP", curp_empleado, "no encontrado.")

  def modificar_visitante(self):
      curp_visitante = input("Ingrese el CURP del visitante a modificar: ")
      for visitante in self.visitantes:
          if visitante.get_curp() == curp_visitante:
              nuevo_nombre = input("Ingrese el nuevo nombre del visitante: ")
              nuevo_apellido = input("Ingrese el nuevo apellido del visitante: ")
              nueva_fecha_nacimiento = input("Ingrese la nueva fecha de nacimiento del visitante (yyyy-MM-dd): ")
              nuevo_curp = input("Ingrese el nuevo CURP del visitante: ")

              visitante.set_nombre(nuevo_nombre)
              visitante.set_apellidos(nuevo_apellido)
              visitante.set_fecha_nacimiento(nueva_fecha_nacimiento)
              visitante.set_curp(nuevo_curp)

              print("Visitante modificado con éxito.")
              return
      print("Visitante con CURP", curp_visitante, "no encontrado.")

  def modificar_animal(self):
      id_animal = input("Ingrese el ID del animal a modificar: ")
      for animal in self.animales:
          if animal.get_id() == id_animal:
              nuevo_tipo_animal = input("Ingrese el nuevo tipo de animal: ")
              nueva_fecha_nacimiento = input("Ingrese la nueva fecha de nacimiento del animal (yyyy-MM-dd): ")
              nueva_fecha_llegada = input("Ingrese la nueva fecha de llegada al zoológico (yyyy-MM-dd): ")
              nuevo_peso = float(input("Ingrese el nuevo peso del animal: "))
              respuesta_enfermedades = input("¿El animal tiene nuevas enfermedades? (S/N): ")
              nuevas_enfermedades = []
              if respuesta_enfermedades.upper() == "S":
                  nuevas_enfermedades = input("Ingrese las nuevas enfermedades del animal (separadas por comas): ").split(",")
              nueva_frecuencia_alimentacion = input("Ingrese la nueva frecuencia de alimentación del animal: ")
              nuevo_tipo_alimentacion = input("Ingrese el nuevo tipo de alimentación del animal: ")
              nuevas_vacunas = input("¿El animal cuenta con nuevas vacunas? (S/N): ").upper() == "S"

              animal.set_tipo_animal(nuevo_tipo_animal)
              animal.set_fecha_nacimiento(nueva_fecha_nacimiento)
              animal.set_fecha_llegada(nueva_fecha_llegada)
              animal.set_peso(nuevo_peso)
              animal.set_enfermedades(nuevas_enfermedades)
              animal.set_frecuencia_alimentacion(nueva_frecuencia_alimentacion)
              animal.set_tipo_alimentacion(nuevo_tipo_alimentacion)
              animal.set_vacunas(nuevas_vacunas)

              print("Animal modificado con éxito.")
              return
      print("Animal con ID", id_animal, "no encontrado.")

  def eliminar_registro(self):
      opcion_eliminar = int(input("Seleccione qué tipo de registro desea eliminar:\n"
                                   "1. Empleado\n"
                                   "2. Visitante\n"
                                   "3. Animal\n"))

      if opcion_eliminar == 1:
          self.eliminar_empleado()
      elif opcion_eliminar == 2:
          self.eliminar_visitante()
      elif opcion_eliminar == 3:
          self.eliminar_animal()
      else:
          print("Opción no válida")

  def eliminar_empleado(self):
      curp_empleado = input("Ingrese el CURP del empleado a eliminar: ")
      for empleado in self.empleados:
          if empleado.get_curp() == curp_empleado:
              self.empleados.remove(empleado)
              print("Empleado eliminado con éxito.")
              return
      print("Empleado con CURP", curp_empleado, "no encontrado.")

  def eliminar_visitante(self):
      curp_visitante = input("Ingrese el CURP del visitante a eliminar: ")
      for visitante in self.visitantes:
          if visitante.get_curp() == curp_visitante:
              self.visitantes.remove(visitante)
              print("Visitante eliminado con éxito.")
              return
      print("Visitante con CURP", curp_visitante, "no encontrado.")

  def eliminar_animal(self):
      id_animal = input("Ingrese el ID del animal a eliminar: ")
      for animal in self.animales:
          if animal.get_id() == id_animal:
              self.animales.remove(animal)
              print("Animal eliminado con éxito.")
              return
      print("Animal con ID", id_animal, "no encontrado.")

  def consultar_registros(self):
      print("---------- Empleados ----------")
      if not self.empleados:
          print("No hay empleados registrados.")
      else:
          for empleado in self.empleados:
              print(empleado)

      print("\n---------- Visitantes ----------")
      if not self.visitantes:
          print("No hay visitantes registrados.")
      else:
          for visitante in self.visitantes:
              print(visitante)

      print("\n---------- Visitas ----------")
      if not self.visitas:
          print("No hay visitas registradas.")
      else:
          for visita in self.visitas:
              print(visita)

      print("\n---------- Animales ----------")
      if not self.animales:
          print("No hay animales registrados.")
      else:
          for animal in self.animales:
              print(animal)

      print("\n---------- Mantenimientos ----------")
      if not self.mantenimientos:
          print("No hay mantenimientos registrados.")
      else:
          for mantenimiento in self.mantenimientos:
              print(mantenimiento)
