from Limpieza import Producto  # Suponiendo que Producto es una clase existente en otro archivo llamado producto.py

class Limpieza(Producto):
    def __init__(self, nombre, precio, fecha_importacion, numero_serie, tipo, stock):
        super().__init__(nombre, precio, fecha_importacion, numero_serie, stock)
        self.tipo = tipo

    def get_tipo(self):
        return self.tipo

    def set_tipo(self, tipo):
        self.tipo = tipo
