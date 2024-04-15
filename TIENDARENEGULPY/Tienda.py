from TIENDARENEGUL.Alimento import Alimento
from TIENDARENEGUL.Belleza import Belleza
from TIENDARENEGUL.Cliente import Cliente
from TIENDARENEGUL.Electrodomestico import Electrodomestico
from TIENDARENEGUL.Limpieza import Limpieza


class Tienda:
    def __init__(self):
        self.password = "flacou"
        self.stock_productos = []
        self.clientes = []
        self.productos_vendidos = []
       # self.scanner = scanner()

    def ejecutar_programa(self):
        contrasena_valida = False

        while not contrasena_valida:
            print("INICIA SESIÓN")
            contrasena = input("Ingresa la contraseña: ")

            if contrasena == self.password:
                contrasena_valida = True
                self.ejecutar_menu_sistema()
            else:
                print("\nContraseña incorrecta, intenta de nuevo.\n")

    def ejecutar_menu_sistema(self):
        opcion = 0

        while opcion != 9:
            print("\n** BIENVENIDO AL SISTEMA DE ABARROTES JOHN CENA **")
            print("1. Registrar Producto")
            print("2. Registrar Cliente")
            print("3. Mostrar Productos")
            print("4. Mostrar Clientes")
            print("5. Eliminar Producto")
            print("6. Eliminar Cliente")
            print("7. Realizar compra")
            print("8. Ver productos vendidos")
            print("9. Salir")
            opcion = int(input("Selecciona una opción: "))

            if opcion == 1:
                self.registrar_producto()
            elif opcion == 2:
                self.registrar_cliente()
            elif opcion == 3:
                self.mostrar_productos()
            elif opcion == 4:
                self.mostrar_clientes()
            elif opcion == 5:
                self.eliminar_producto()
            elif opcion == 6:
                self.eliminar_cliente()
            elif opcion == 7:
                self.realizar_compra()
            elif opcion == 8:
                self.mostrar_productos_vendidos()
            elif opcion == 9:
                print("Saliendo del sistema...")
            else:
                print("Opción no válida.")

    def registrar_producto(self):
        print("Ingrese el tipo de producto a registrar:")
        print("1. Electrodomestico")
        print("2. Limpieza")
        print("3. Belleza")
        print("4. Alimento")
        print("5. Regresar al menú principal")
        opcion_tipo = int(input())

        nombre = input("Ingrese el nombre del producto: ")
        precio = float(input("Ingrese el precio del producto: "))
        fecha_importacion = input("Ingrese la fecha de importación (MM/DD/YYYY): ")
        numero_serie = input("Ingrese el número de serie: ")
        stock = int(input("Ingrese el stock del producto: "))

        if opcion_tipo == 1:
            marca = input("Ingrese la marca del electrodomestico: ")
            tiene_garantia = input("Ingrese si tiene garantia el electrodomestico: ")
            electrodomestico = Electrodomestico(nombre, precio, fecha_importacion, numero_serie, marca, tiene_garantia, stock)
            self.stock_productos.append(electrodomestico)
            print("Producto electrodomestico registrado.")
        elif opcion_tipo == 2:
            tipo = input("Ingrese el tipo de limpieza: ")
            limpieza = Limpieza(nombre, precio, fecha_importacion, numero_serie, tipo, stock)
            self.stock_productos.append(limpieza)
            print("Producto de limpieza registrado.")
        elif opcion_tipo == 3:
            es_organico = input("Ingrese el tipo de producto de belleza (organico o no organico): ")
            belleza = Belleza(nombre, precio, fecha_importacion, numero_serie, es_organico, stock)
            self.stock_productos.append(belleza)
            print("Producto de belleza registrado.")
        elif opcion_tipo == 4:
            fecha_caducidad = input("Ingrese la fecha de caducidad (MM/DD/YYYY): ")
            calorias = int(input("Ingrese las calorias del alimento: "))
            alimento = Alimento(nombre, precio, fecha_importacion, numero_serie, fecha_caducidad, calorias, stock)
            self.stock_productos.append(alimento)
            print("Alimento registrado con éxito.")
        elif opcion_tipo == 5:
            print("Regresando al menú principal...")
            self.ejecutar_menu_sistema()
        else:
            print("Opción no válida")

    def registrar_cliente(self):
        nombre = input("Ingrese el nombre del cliente: ")
        telefono = input("Ingrese el teléfono del cliente: ")
        cliente = Cliente(nombre, telefono)
        self.clientes.append(cliente)
        print("Cliente registrado.")

    def mostrar_productos(self):
        if not self.stock_productos:
            print("No hay productos en stock.")
        else:
            print("\nProductos en stock:")
            for producto in self.stock_productos:
                print(f"{producto.nombre} - Precio: {producto.precio} - Stock: {producto.stock}")

    def mostrar_clientes(self):
        if not self.clientes:
            print("No hay clientes registrados.")
        else:
            print("\nClientes registrados:")
            for cliente in self.clientes:
                print(f"Nombre: {cliente.nombre} - Teléfono: {cliente.telefono}")

    def eliminar_producto(self):
        nombre = input("Ingrese el nombre del producto a eliminar: ")
        encontrado = False
        for producto in self.stock_productos:
            if producto.nombre.lower() == nombre.lower():
                self.stock_productos.remove(producto)
                encontrado = True
                print("Producto eliminado con éxito.")
                break
        if not encontrado:
            print("Producto no encontrado en stock.")

    def eliminar_cliente(self):
        nombre = input("Ingrese el nombre del cliente a eliminar: ")
        encontrado = False
        for cliente in self.clientes:
            if cliente.nombre.lower() == nombre.lower():
                self.clientes.remove(cliente)
                encontrado = True
                print("Cliente eliminado con éxito.")
                break
        if not encontrado:
            print("Cliente no encontrado.")

    def realizar_compra(self):
        if not self.stock_productos:
            print("No hay productos registrados. Por favor, registre productos primero.")
            return

        nombre_producto = input("Ingrese el nombre del producto que desea comprar: ")
        nombre_cliente = input("Ingrese el nombre del cliente que realiza la compra: ")

        producto_encontrado = False
        for producto in self.stock_productos:
            if producto.nombre.lower() == nombre_producto.lower() and producto.stock > 0:
                producto_encontrado = True
                precio_producto = producto.precio
                producto.eliminar_stock(1)
                self.productos_vendidos.append(producto)

                print(f"Producto: {nombre_producto} - Precio: {precio_producto}")
                print(f"Precio total de la compra: {precio_producto}")
                print(f"Producto '{nombre_producto}' comprado por '{nombre_cliente}'.")
                break

        if not producto_encontrado:
            print("Producto no encontrado o sin stock disponible.")

    def mostrar_productos_vendidos(self):
        if not self.productos_vendidos:
            print("No hay productos vendidos.")
        else:
            print("\nProductos vendidos:")
            for producto in self.productos_vendidos:
                print(f"{producto.nombre} - Precio: {producto.precio}")