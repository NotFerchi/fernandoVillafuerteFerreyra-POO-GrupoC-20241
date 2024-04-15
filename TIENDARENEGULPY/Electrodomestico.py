from Electrodomestico import Producto  # Suponiendo que Producto es una clase existente en otro archivo llamado producto.py

class Electrodomestico(Producto):
    def __init__(self, nombre, precio, fecha_importacion, numero_serie, marca, tiene_garantia, stock):
        super().__init__(nombre, precio, fecha_importacion, numero_serie, stock)
        self.marca = marca
        self.tiene_garantia = tiene_garantia

    def get_marca(self):
        return self.marca

    def set_marca(self, marca):
        self.marca = marca

    def get_tiene_garantia(self):
        return self.tiene_garantia

    def set_tiene_garantia(self, tiene_garantia):
        self.tiene_garantia = tiene_garantia

    # Método específico para Electrodomestico
    def realizar_mantenimiento(self):
        # Implementación para realizar mantenimiento
        print("Se realizó el mantenimiento del electrodoméstico:", self.nombre)
