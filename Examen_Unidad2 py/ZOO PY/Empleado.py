class Empleado:
      #metodo con parametros
      def __init__(self, nombre, apellidos, fechaNacimiento, curp, cargo, salario):
          self.nombre = nombre
          self.apellidos = apellidos
          self.fechaNacimiento = fechaNacimiento              #CONSTRUCTOR CON INSTANCIA SELF
          self.curp = curp
          self.cargo = cargo
          self.salario = salario
      #Metodo getter de Curp
      def getCurp(self):
          return self.curp
      #Metodo setter de Curp
      def setCurp(self, curp):
          self.curp = curp
      #Metodo getter de Cargo
      def getCargo(self):
          return self.cargo
      #Metodo setter de Cargo
      def setCargo(self, cargo):
          self.cargo = cargo
      #Metodo getter de Salario
      def getSalario(self):
          return self.salario
      #Metodo setter de Salario
      def setSalario(self, salario):
          self.salario = salario

      def __str__(self):
          return f"Empleado: Nombre: '{self.nombre}', Apellidos: '{self.apellidos}', Fecha Nacimiento: '{self.fechaNacimiento}', Curp: '{self.curp}', Cargo: '{self.cargo}', Salario: {self.salario}"

      def setNombre(self, nombre):
          self.nombre = nombre

      def getNombre(self):
          return self.nombre

      def setFechaNacimiento(self, fechaNacimiento):
          self.fechaNacimiento = fechaNacimiento

      def getFechaNacimiento(self):
          return self.fechaNacimiento

      def setApellidos(self, apellidos):
          self.apellidos = apellidos

    # Ejemplo de uso
    # if __name__ == "__main__":
    #    empleado1 = Empleado("Juan", "Pérez", "01/01/1990", "CURP1234567890", "Gerente", 50000)
    #    print(empleado1)
