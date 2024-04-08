class Director:
  CONTRASENA_DIRECTOR = "123456789@" #contraseña asignada

  @staticmethod #declarar un método estático dentro de una clase
  #metodo
  def autenticarDirector():
      print("Ingrese la contraseña del director:")
      input_password = input()
      return input_password == Director.CONTRASENA_DIRECTOR

# Ejemplo
# if __name__ == "__main__":
#    if Director.autenticarDirector():
#        print("Contraseña correcta. Acceso concedido.")
#    else:
#       print("Contraseña incorrecta. Acceso denegado.")