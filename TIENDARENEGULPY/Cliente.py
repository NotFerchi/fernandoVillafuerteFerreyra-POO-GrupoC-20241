class Cliente:
    def __init__(self, nombre, telefono):
        self.nombre = nombre
        self.telefono = telefono
        self.productos_comprados = []

    def get_nombre(self):
        return self.nombre

    def set_nombre(self, nombre):
        self.nombre = nombre

    def get_telefono(self):
        return self.telefono

    def set_telefono(self, telefono):
        self.telefono = telefono

    def get_productos_comprados(self):
        return self.productos_comprados

    def comprar(self, producto):
        self.productos_comprados.append(producto)
        print(self.nombre + " ha comprado:", producto.get_nombre())
