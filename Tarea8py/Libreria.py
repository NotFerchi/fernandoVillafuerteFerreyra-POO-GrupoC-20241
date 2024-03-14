class Libro:
    def __init__(self, titulo):
        self.titulo = titulo
        self.rentado = False

class Usuario:
    def __init__(self, nombre):
        self.nombre = nombre

class Libreria:
    def __init__(self):
        self.libros = []
        self.usuarios = []

    def registrar_usuario(self, nombre):
        self.usuarios.append(Usuario(nombre))
        print("Usuario registrado.")

    def registrar_libro(self, titulo):
        self.libros.append(Libro(titulo))
        print("Libro registrado.")

    def rentar_libro(self, titulo, nombre_usuario):
        for libro in self.libros:
            if libro.titulo == titulo:
                if not libro.rentado:
                    libro.rentado = True
                    print("Libro rentado.")
                else:
                    print("El libro ya está rentado.")
                return
        print("Libro no ha sido encontrado.")

    def listar_usuarios(self):
        print("Usuarios registrados:")
        for usuario in self.usuarios:
            print(usuario.nombre)

    def listar_libros(self):
        print("Libros registrados:")
        for libro in self.libros:
            print(libro.titulo)

    def listar_usuarios_con_libros(self):
        print("Usuarios que han rentado al menos un libro:")
        for usuario in self.usuarios:
            for libro in self.libros:
                if libro.rentado:
                    print(usuario.nombre)
                    break

    def listar_libros_no_rentados(self):
        print("Libros sin rentados:")
        for libro in self.libros:
            if not libro.rentado:
                print(libro.titulo)

    def listar_libros_rentados(self):
        print("Libros rentados:")
        for libro in self.libros:
            if libro.rentado:
                print(libro.titulo)

libreria = Libreria()

while True:
    print("\nMenú:")
    print("1-- Registrar usuario")
    print("2-- Registrar libro")
    print("3-- Rentar libro")
    print("4-- Lista de usuarios")
    print("5-- Lista de libros")
    print("6-- Lista de usuarios con libros rentados")
    print("7--- Lista de libros sin rentar")
    print("8-- Lista de libros rentados")
    print("9-- Salir")

    opcion = input("Selecciona una opción: ")

    if opcion == '1':
        nombre = input("Ingrese el nombre del usuario: ")
        libreria.registrar_usuario(nombre)
    elif opcion == '2':
        titulo = input("Ingrese el título del libro: ")
        libreria.registrar_libro(titulo)
    elif opcion == '3':
        titulo = input("Ingrese el título del libro a rentar: ")
        nombre_usuario = input("Ingrese el nombre del usuario que rentará el libro: ")
        libreria.rentar_libro(titulo, nombre_usuario)
    elif opcion == '4':
        libreria.listar_usuarios()
    elif opcion == '5':
        libreria.listar_libros()
    elif opcion == '6':
        libreria.listar_usuarios_con_libros()
    elif opcion == '7':
        libreria.listar_libros_no_rentados()
    elif opcion == '8':
        libreria.listar_libros_rentados()
    elif opcion == '9':
        print("Usted ha salido del programa.")
        break
    else:
        print("Opción inválida. Ingrese nuevamente.")
1