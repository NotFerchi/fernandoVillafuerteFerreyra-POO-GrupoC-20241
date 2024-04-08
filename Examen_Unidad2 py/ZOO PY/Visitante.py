class Visitante:
  counter = 1

  def __init__(self, nombre, apellidos, fechaNacimiento, curp):
      self.id = "V" + str(Visitante.counter)
      Visitante.counter += 1
      self.nombre = nombre
      self.apellidos = apellidos
      self.fechaNacimiento = fechaNacimiento
      self.curp = curp

  def getId(self):
      return self.id

  def getNombre(self):
      return self.nombre

  def setNombre(self, nombre):
      self.nombre = nombre

  def getApellidos(self):
      return self.apellidos

  def setApellidos(self, apellidos):
      self.apellidos = apellidos

  def getFechaNacimiento(self):
      return self.fechaNacimiento

  def setFechaNacimiento(self, fechaNacimiento):
      self.fechaNacimiento = fechaNacimiento

  def getCurp(self):
      return self.curp

  def setCurp(self, curp):
      self.curp = curp

  def __str__(self):
      return f"Visitante: Id: '{self.id}', Nombre: '{self.nombre}', Apellidos: '{self.apellidos}', Fecha Nacimiento: '{self.fechaNacimiento}', Curp: '{self.curp}'"
