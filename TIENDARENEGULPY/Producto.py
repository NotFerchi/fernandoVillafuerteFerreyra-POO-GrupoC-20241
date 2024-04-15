class Producto:
    def __init__(self, nombre, precio, fecha_importacion, numero_serie, stock):
        self.nombre = nombre
        self.precio = precio
        self.fecha_importacion = fecha_importacion
        self.numero_serie = numero_serie
        self.stock = stock

    def get_nombre(self):
        return self.nombre

    def set_nombre(self, nombre):
        self.nombre = nombre

    def get_precio(self):
        return self.precio

    def set_precio(self, precio):
        self.precio = precio

    def get_fecha_importacion(self):
        return self.fecha_importacion

    def set_fecha_importacion(self, fecha_importacion):
        self.fecha_importacion = fecha_importacion

    def get_numero_serie(self):
        return self.numero_serie

    def set_numero_serie(self, numero_serie):
        self.numero_serie = numero_serie

    def get_stock(self):
        return self.stock

    def set_stock(self, stock):
        self.stock = stock

    def agregar_stock(self, cantidad):
        if cantidad > 0:
            self.stock += cantidad
            print(str(cantidad) + " " + self.nombre + " agregadas al stock.")
        else:
            print("La cantidad debe ser mayor que cero.")

    def eliminar_stock(self, cantidad):
        if 0 < cantidad <= self.stock:
            self.stock -= cantidad
            print(str(cantidad) + " " + self.nombre + " eliminadas del stock.")
        else:
            print("La cantidad no es válida.")
